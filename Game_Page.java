package com.example;


import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.stage.*;
import java.util.*;


public class Game_Page extends Application implements Runnable {

	Rectangle2D screenBounds = Screen.getPrimary().getBounds();


	@SuppressWarnings("exports")
	public static Pane maximum_Payne =  new Pane();

	@Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception 
    {
        stage.setScene(new Scene(maximum_Payne, screenBounds.getWidth(), screenBounds.getHeight()));
		maximum_Payne.setFocusTraversable(false);
		stage.show();

		drawBoard();

		Thread draw = new Thread();

		draw.start();

		Game_Logic game = new Game_Logic();
		game.startGame();

	}

	@Override
	public void run()
	{
		drawBoard();
	}

	public void drawBoard()
	{
		//Make Big Tiles
		//Corner Boxes
		for(double x_Pos_1 = 249, count_x_1 = 1; x_Pos_1 <= 853 && count_x_1 <= 3; x_Pos_1 += 604, count_x_1 += 2)
		{
			for(double y_Pos_1 = 41.5, count_y_1 = 1; y_Pos_1 <= (575.5) && count_y_1 <= 3; y_Pos_1 += 534, count_y_1 += 2)
			{
				//System.out.println("[" + count_x_1 + "," + count_y_1 + "]");

				Tile tile = new Tile(x_Pos_1, y_Pos_1, 4);
				tile.addToArray((int)count_x_1, (int)count_y_1, tile);
 				maximum_Payne.getChildren().add(tile.getPane());
			}
		}

		//Right/Left Middle Boxes
		for(double x_Pos_1 = 249, count_x_1 = 1; x_Pos_1 <= 853 && count_x_1 <= 3; x_Pos_1 += 604, count_x_1 += 2)
		{
			for(double count_y_1 = 2; count_y_1 <= 2;count_y_1++)
			{
				//System.out.println("[" + count_x_1 + "," + count_y_1 + "]");

				Tile tile = new Tile(x_Pos_1, 310.5, 6);
				tile.addToArray((int)count_x_1, (int)count_y_1, tile);
 				maximum_Payne.getChildren().add(tile.getPane());
			}
		}

		//Top/Bottom Middle Boxes
		for(double count_x_1 = 2; count_x_1 <= 2;count_x_1++)
		{
			for(double y_Pos_1 = 41.5, count_y_1 = 1; y_Pos_1 <= (575.5) && count_y_1 <= 3; y_Pos_1 += 534, count_y_1 += 2)
			{
				//System.out.println("[" + count_x_1 + "," + count_y_1 + "]");

				Tile tile = new Tile(553, y_Pos_1, 5);
				tile.addToArray((int)count_x_1, (int)count_y_1, tile);
 				maximum_Payne.getChildren().add(tile.getPane());
			}
		}

		//Middle Box
		for(double count_x_1 = 2; count_x_1 <= 2;count_x_1++)
		{
			for(double count_y_1 = 2;count_y_1 <= 2;count_y_1++)
			{
				//System.out.println("[" + count_x_1 + "," + count_y_1 + "]");

				Tile tile = new Tile(553, 310.5, 7);
				tile.addToArray((int)count_x_1, (int)count_y_1, tile);
 				maximum_Payne.getChildren().add(tile.getPane());
			}
		}

		//Make Small Tiles
		//Corner Boxes
		for(double x_Pos_1 = 300, count_x_1 = 1; x_Pos_1 <= 900 && count_x_1 <= 7; x_Pos_1 += 300, count_x_1 += 3)
		{
			for(double y_Pos_1 = 75, count_y_1 = 1; y_Pos_1 <= 605 && count_y_1 <= 7; y_Pos_1 += 265, count_y_1 += 3)
			{
				for (double x_Pos_2 = x_Pos_1, count_x_2 = count_x_1; x_Pos_2 <= (x_Pos_1 + (134 + 1/3)) && count_x_2 <= (count_x_1 + 2); x_Pos_2 += (134 + 1/3), count_x_2 += 2) 
				{
					for (double y_Pos_2 = y_Pos_1, count_y_2 = count_y_1; y_Pos_2 <= (y_Pos_1 + (134 + 1/3)) && count_y_2 <= (count_y_1 + 2); y_Pos_2 += (134 + 1/3), count_y_2 += 2) 
					{
						//System.out.println("[" + count_x_2 + "," + count_y_2 + "]");

						Tile tile = new Tile(x_Pos_2, y_Pos_2, 0);
						tile.addToArray((int)count_x_2, (int)count_y_2, tile);
						maximum_Payne.getChildren().add(tile.getPane());
					}
				}
			}
		}

		//Right/Left Middle boxes
		for(double x_Pos_1 = 300, count_x_1 = 1; x_Pos_1 <= 900 && count_x_1 <= 7; x_Pos_1 += 300, count_x_1 += 3)
		{
			for(double y_Pos_1 = (143 + 2/3),count_y_1 = 2 ; y_Pos_1 <= (673 + 2/3) && count_y_1 <= 8 ; y_Pos_1 += 265, count_y_1 += 3)
			{
				for (double x_Pos_2 = x_Pos_1,  count_x_2 = count_x_1; x_Pos_2 <= (x_Pos_1 + (134 + 1/3)) && count_x_2 <= (count_x_1 + 2); x_Pos_2 += (134 + 1/3), count_x_2 += 2) 
				{
					//System.out.println("[" + count_x_2 + "," + count_y_1 + "]");

					Tile tile = new Tile(x_Pos_2, y_Pos_1, 1);
					tile.addToArray((int)count_x_2, (int)count_y_1, tile);
					maximum_Payne.getChildren().add(tile.getPane());
				}
			}
		}

		//Top/Bottom Middle Boxes
		for(double x_Pos_1 = (368 + 2/3), count_x_1 = 2; x_Pos_1 <= (968 + 2/3) && count_x_1 <= 8; x_Pos_1 += 300, count_x_1 += 3)
		{
			for(double y_Pos_1 = 75, count_y_1 = 1; y_Pos_1 <= 605 && count_y_1 <= 7; y_Pos_1 += 265, count_y_1 += 3)
			{
				for (double y_Pos_2 = y_Pos_1, count_y_2 = count_y_1; y_Pos_2 <= (y_Pos_1 + (134 + 1/3)) && count_y_2 <= (count_y_1 + 2); y_Pos_2 += (134 + 1/3), count_y_2 += 2) 
				{	
					//System.out.println("[" + count_x_1 + "," + count_y_2 + "]");

					Tile tile = new Tile(x_Pos_1, y_Pos_2, 2);
					tile.addToArray((int)count_x_1, (int)count_y_2, tile);
					maximum_Payne.getChildren().add(tile.getPane());
				}
			}
		}

		//Middle Boxes
		for(double x_Pos_1 = (368 + 2/3), count_x_1 = 2; x_Pos_1 <= (968 + 2/3) && count_x_1 <= 8; x_Pos_1 += 300, count_x_1 += 3)
		{
			for(double y_Pos_1 = (143 + 2/3), count_y_1 = 2; y_Pos_1 <= (673 + 2/3) && count_y_1 <= 8; y_Pos_1 += 265, count_y_1 += 3)
			{
				//System.out.println("[" + count_x_1 + "," + count_y_1 + "]");

				Tile tile = new Tile(x_Pos_1, y_Pos_1, 3);
				tile.addToArray((int)count_x_1, (int)count_y_1, tile);
				maximum_Payne.getChildren().add(tile.getPane());
			}
		}

		//Make Boards
		//Big Board
		//Big Vertical lines
		for (double x = 550; x <= 850; x += 300) 
		{
			maximum_Payne.getChildren().add(new Line(x, 42.5, x, 837.5) {{
				setStroke(Color.web("#"+Color_Page.returnHexLine()));
				setStrokeWidth(4);
			}});
		}
		//Big Horizontal lines
		for (double y = 307.5; y <= 572.5; y += 265) 
		{
			maximum_Payne.getChildren().add(new Line(250, y, 1150, y) {{
				setStroke(Color.web("#"+Color_Page.returnHexLine()));
				setStrokeWidth(4);
			}});
		}
		
		//Small board
		//Small Horizontal Lines
		for (double y = (141 + 2/3); y <= (671+2/3); y += 265) 
		{
			for (double x = 300; x <= 900; x += 300) 
			{
				maximum_Payne.getChildren().add(new Line(x, y, x + 198, y) {{
					setStroke(Color.web("#"+Color_Page.returnHexLine()));
					setStrokeWidth(2);
				}});
			}
		}
		for (double y = (141 + 2/3); y <= (671+2/3); y += 265) 
		{
			for (double x = 300; x <= 900; x += 300) 
			{
				maximum_Payne.getChildren().add(new Line(x, y + (66 + 2/3), x + 198, y + (66 + 2/3)) {{
					setStroke(Color.web("#"+Color_Page.returnHexLine()));
					setStrokeWidth(2);
				}});
			}
		}
		
		//Small Vertical lines
	 	for (double x = (366 + 2/3); x <= (966 + 2/3); x += 300) 
		{
			for (double y = 75; y <= 605; y += 265) 
			{ 
				maximum_Payne.getChildren().add(new Line(x, y, x, y + 198) {{
					setStroke(Color.web("#"+Color_Page.returnHexLine()));
					setStrokeWidth(2);
					}});
			}
		}	
		for (double x = (366 + 2/3); x <= (966 + 2/3); x += 300) 
		{
			for (double y = 75; y <= 605; y += 265) 
			{
				maximum_Payne.getChildren().add(new Line(x + (66 + 2/3), y, x + (66 + 2/3), y + 198) {{
					setStroke(Color.web("#"+Color_Page.returnHexLine()));
					setStrokeWidth(2);
				}});
			}
		}

	}
}