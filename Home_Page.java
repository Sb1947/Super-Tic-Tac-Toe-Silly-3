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

public class Home_Page extends Application 
{
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception 
    {

        StackPane plexiglass =  new StackPane();

        stage.setScene(new Scene(plexiglass, screenBounds.getWidth(), screenBounds.getHeight()));

        Text introduction = new Text("  Welcome to Super Tic Tac Toe\n\nA Fun Twist on an Original Game\n\n");

        Button play = new Button("Play");
        Button rules = new Button("Rules");
        Button exit = new Button("Exit");


        introduction.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        introduction.setTextOrigin(VPos.TOP);
        introduction.setTranslateY(-175);

        play.setScaleX(2);
        play.setScaleY(2);
        play.setTranslateX(-250);
        play.setFocusTraversable(false);
        play.setOnAction(event -> 
        {
            Main.getGameState(2);
            Main.updateStage();
        });

        rules.setScaleX(1.7);
        rules.setScaleY(2);
        rules.setTranslateX(250);
        rules.setFocusTraversable(false);
        rules.setOnAction(event -> 
        {
            Main.getGameState(1);
            Main.updateStage();
        });

        exit.setScaleX(2);
        exit.setScaleY(2);
        exit.setTranslateY(225);
        exit.setFocusTraversable(false);
        exit.setOnAction(event -> 
        {
            Main.getGameState(1);
            Main.updateStage();
            stage.close();
        });

        play.setStyle(" -fx-focus-color: black; -fx-faint-focus-color: transparent; -fx-focus-traversable: false;");

        plexiglass.setFocusTraversable(false);

        plexiglass.getChildren().add(play);
        plexiglass.getChildren().add(rules);
        plexiglass.getChildren().add(exit);
        plexiglass.getChildren().add(introduction);

        System.out.println("We in");

        stage.show();
    }

}