package com.example;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import java.util.concurrent.*;


public class Tile {

    private Pane pane;

    private double xPosition;
    private double yPosition;
    private double smallTilewidth = (66 + 2/3);
    private double smallTileheight = (66 + 2/3);
    private double bigTilewidth = (300);
    private double bigTileheight = (265);

    public int value = 0;
    public int rowNumber;
    public int columnNumber;
    private int nextRowPlayed;
    public int nextColumnPlayed;

    private static Turn_Type whoseTurn;

    public static Tile[][] bigBoard = new Tile[4][4];
	public static Tile[][] smallBoard = new Tile[10][10];

    private static CompletableFuture<Void> turnFuture;

    public Tile(double x_Pos, double y_Pos, int type) 
    {
        this.xPosition = (x_Pos - 1);
        this.yPosition = (y_Pos - 1);
        
        // Create the pane and set initial properties
        pane = new Pane();

        //Making tiles
        //Small tile
        //Corner tile
        if(type == 0)
        {
            pane.setPrefSize(smallTilewidth, smallTileheight);
        }
        //Right/Left Middle tile
        else if(type == 1)
        {
            pane.setPrefSize(smallTilewidth, (smallTileheight - 2));
        }
        //Top/Bottom Middle tile
        else if(type == 2)
        {
            pane.setPrefSize((smallTilewidth - 2), smallTileheight);
        }
        //Center tile
        else if(type == 3)
        {
            pane.setPrefSize((smallTilewidth - 2), (smallTileheight - 2));
        }

        //Big tile
        //Corner Box
        else if(type == 4)
        {
            pane.setPrefSize(bigTilewidth, bigTileheight);
            pane.setDisable(true);
        }
        //Top/Bottom Middle tile
        else if(type == 5)
        {
            pane.setPrefSize((bigTilewidth - 4), bigTileheight);
            pane.setDisable(true);
        }
        //Right/Left Middle tile
        else if(type == 6)
        {
            pane.setPrefSize(bigTilewidth, (bigTileheight - 4));
            pane.setDisable(true);
        }
        pane.setLayoutX(xPosition);
        pane.setLayoutY(yPosition);
        pane.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        pane.setOnMouseEntered(event -> 
        { 
            if(this.value != 0) pane.setStyle("-fx-background-color: transparent;");
            else pane.setStyle("-fx-background-color: #" + Color_Page.returnHexX() + "59;");

        });
        pane.setOnMouseExited(event -> pane.setStyle("-fx-background-color: transparent;")); 

        pane.setOnMouseClicked(event -> 
        {
            this.value = Decision_Page.player_Choice;
            Game_Logic.setLastColumnPlayed(this.columnNumber);
            Game_Logic.setLastRowPlayed(this.rowNumber);

            if(whoseTurn == Turn_Type.PLAYER && Decision_Page.getPlayerChoice() == 1) drawX();
            else if(whoseTurn == Turn_Type.PLAYER && Decision_Page.getPlayerChoice() == 2) drawO();

            //System.out.println("[" + this.returnColumnNumber() + "," + this.returnRowNumber() + "]" + " : Value - " + this.value);

            turnFuture.complete(null);
            //System.out.println(turnFuture.isDone());
        });
    }

    @SuppressWarnings("exports")
	public Pane getPane() 
    {
        return pane;
    }

    public static void setTurnFutureInTile(CompletableFuture<Void> future, Turn_Type turn) 
    {
        turnFuture = future;
        whoseTurn = turn;
    }

    public static void setValue(int row, int column) 
    {
        //System.out.println("Hellooooo??");
        System.out.println("Set Value Input is : [" + row + "," + column + "]");
        if(Decision_Page.computer_Choice == 2) {smallBoard[row][column].value = 2; smallBoard[row][column].drawO();}
        else if(Decision_Page.computer_Choice == 1) {smallBoard[row][column].value = 1;smallBoard[row][column].drawX();}
        smallBoard[row][column].value = Decision_Page.computer_Choice; 
        Game_Logic.setLastColumnPlayed(smallBoard[row][column].columnNumber);
        Game_Logic.setLastRowPlayed(smallBoard[row][column].rowNumber);
        turnFuture.complete(null);
    }

    public void addToArray(int x, int y, Tile tile)
    {
        this.columnNumber = x;
        this.rowNumber = y;
        smallBoard[x][y] = tile;
    }

    public static void lockAllTiles(boolean accessibility)
    {
        for(int x = 1; x <=9; x++)
        {
            for(int y = 1; y <= 9; y++)
            {
                smallBoard[x][y].getPane().setDisable(accessibility);
            }
        }
    }

    public static void lockAllTilesExcept(int c, int r)
    {
        int startX = (c - 1) * 3 + 1;
        int startY = (r - 1) * 3 + 1;
        System.out.println("In Method Lock All Tiles Except: [" + startX + "," + startY + "]");
        int endX = startX + 2;
        int endY = startY + 2;
        int emptyTiles = 0;

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (smallBoard[x][y].returnValue() == 0) emptyTiles++;
            }
        }
        boolean lockAll = emptyTiles >= 1;
        lockAllTiles(lockAll);

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
        smallBoard[x][y].getPane().setDisable(!lockAll);
            }
        }
    }
    
    private void drawX()
    {
        Game_Page.maximum_Payne.getChildren().add(new Line((this.xPosition + 11), (this.yPosition + 11), (this.xPosition + 55), (this.yPosition + 55)) 
        {{
            try
            {
                setStroke(Color.web("#"+Color_Page.returnHexX()));
                setStrokeWidth(3);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

		}});

        Game_Page.maximum_Payne.getChildren().add(new Line((this.xPosition + 55), (this.yPosition + 11), (this.xPosition + 11), (this.yPosition + 55)) 
        {{
			setStroke(Color.web("#"+Color_Page.returnHexX()));
			setStrokeWidth(3);
		}});
    }

    private void drawO()
    {
        Circle circle = new Circle();

        circle.setCenterX(this.xPosition + (33 + 1/3));
        circle.setCenterY(this.yPosition + (33 + 1/3));
        circle.setRadius(pane.getWidth() - (39 + 1/10)); 
        circle.setFill(Color.TRANSPARENT);
        
		circle.setStroke(Color.web("#"+Color_Page.returnHexO()));
		circle.setStrokeWidth(3);
            
        Game_Page.maximum_Payne.getChildren().add(circle);
    }

    public int returnValue() 
    {
        return this.value;
    }

    public int returnRowNumber() 
    {
        return this.rowNumber;
    }

    public int returnColumnNumber() 
    {
        return this.columnNumber;
    }

}