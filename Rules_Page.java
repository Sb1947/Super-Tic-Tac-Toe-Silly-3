package com.example;

import javafx.application.*;
// import javafx.fxml.*;
// import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
// import java.io.*;

public class Rules_Page extends Application 
{
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception 
    {

        StackPane screen_Protector =  new StackPane();

        stage.setScene(new Scene(screen_Protector, screenBounds.getWidth(), screenBounds.getHeight()));

        TextArea rules = new TextArea(
                            "Gameplay rules\n\n" +

                            "\t Starting the Game:\n" +  
                            "\t\t• Player X goes first. Players then alternate turns.\n" + 
                            
                            "\n\t Placing Your Mark:\n" + 
                            "\t\t• On each turn, a player places their mark (either X or O) on one of the 81 squares in the 9x9 grid.\n" + 
                            "\t\t• A player must place their mark on the small board within the large grid that was determined by the opponent’s previous move.\n" + 
                            
                            "\n\t How to Determine the Next Move:\n" +  
                            "\t\t• The small board where the next player must play is determined by the position of the last mark placed.\n" + 
                            "\t\t• For example:\n" + 
                            "\t\t\t• If Player X places their mark in the top-left cell of a small board, Player O’s next move must be in the top-left small board of the large grid.\n" + 
                            "\t\t\t• If Player X places their mark in the center of a small board, Player O must play in the center small board.\n" + 
                            
                            "\n\t Winning a Small Board:\n" + 
                            "\t\t• A player wins a small board by getting three of their marks in a row, column, or diagonal within that board, just like in classic Tic Tac Toe.\n" + 
                            "\t\t• Once a small board is won, it is counted as \"closed\" for that player in the large grid.\n" + 
                            
                            "\n\t Free Move Rule:\n" + 
                            "\t\t• If a player's move sends the opponent to a closed or fully occupied small board, the opponent can then place their mark on any open square in any open \n\t\t  small board on the large grid.\n" + 
                            "\t\t• This rule also applies if a small board has already resulted in a draw and cannot be won by either player.\n" + 
                            
                            "\n\t Winning the Game:\n" + 
                            "\t\t• The game ends when a player achieves a winning line in the large grid by winning three small boards in a row, column, or diagonal.\n" + 
                            "\t\t• If all boards are filled without any player achieving this, the game is a draw.\n" +
                            
                            "\nAdditional Notes\n" +
                            
                            "\n\t Tie in a Small Board:\n" + 
                            "\t\t• If neither player wins a small board, it is considered a draw. This board is now effectively \"closed,\" and future moves directed to this board will allow the \n\t\t  next player to choose any available board.");

        Button toReturn = new Button("Return");

        rules.setWrapText(true); 
        rules.setEditable(false);
        rules.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        toReturn.setScaleX(2);
        toReturn.setScaleY(2);
        toReturn.setTranslateY(350);
        toReturn.setFocusTraversable(false);
        toReturn.setOnAction(event -> 
        {
            Main.getGameState(0);
            Main.updateStage();
        });

        screen_Protector.setFocusTraversable(false);

        screen_Protector.getChildren().add(rules);
        screen_Protector.getChildren().add(toReturn);

        System.out.println("How did we get here?");

        stage.show();
    }

}