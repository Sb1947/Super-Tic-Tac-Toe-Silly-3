package com.example;

import javafx.application.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class Color_Page extends Application {

    Rectangle2D screenBounds = Screen.getPrimary().getBounds();

    static String hex_X = "E22020";
    static String hex_O = "2066E2";
    static String hex_Line = "000000";
    static int player_Choice;

	@Override
    public void start(@SuppressWarnings("exports")Stage stage) throws Exception 
    {

        StackPane cellophane =  new StackPane();

        stage.setScene(new Scene(cellophane, screenBounds.getWidth(), screenBounds.getHeight()));

        Text colorPicker = new Text("What Color Would You Like 'X' And 'O' To Be?\n\t\tEnter Color In Hex Code");
        Text X = new Text("X:");
        Text O = new Text("O:");
        Text line = new Text("Line:");

        TextField XColorChooser = new TextField();
		TextField OColorChooser = new TextField();
        TextField lineColorChooser = new TextField();

        Button toReturn = new Button("Return");

        colorPicker.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        colorPicker.setTranslateY(-300);

        X.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        X.setTranslateX(-300);

        O.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        O.setTranslateX(300);

        line.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        XColorChooser.setTranslateX(-300);
        XColorChooser.setTranslateY(45);
        XColorChooser.setMaxSize(100.0, 30.0);
        XColorChooser.setOnAction(event -> 
		{
            hex_X = XColorChooser.getText();
  
            if(!hex_X.matches("^#?[a-fA-F0-9]{6}$"))
            {
                XColorChooser.clear();
                hex_X = "E22020";
            }
            
            if(hex_X.startsWith("#"))
            {
                hex_X.substring(1,7);
            }

            XColorChooser.clear();
            hex_X.toUpperCase();
            //System.out.println(hex_X);
        });

        OColorChooser.setTranslateX(300);
        OColorChooser.setTranslateY(45);
        OColorChooser.setMaxSize(100.0, 30.0);
        OColorChooser.setOnAction(event -> 
		{
            hex_O = OColorChooser.getText();
  
            if(!hex_O.matches("^#?[a-fA-F0-9]{6}$"))
            {
                OColorChooser.clear();
                hex_O = "2066E2";
            }
            
            if(hex_O.startsWith("#"))
            {
                hex_O.substring(1,7);
            }

            OColorChooser.clear();
            hex_O.toUpperCase();
            //System.out.println(hex_O);

        });

        lineColorChooser.setTranslateY(45);
        lineColorChooser.setMaxSize(100.0, 30.0);
        lineColorChooser.setOnAction(event -> 
		{
            hex_Line = lineColorChooser.getText();
  
            if(!hex_Line.matches("^#?[a-fA-F0-9]{6}$"))
            {
                lineColorChooser.clear();
                hex_Line = "2066E2";
            }
            
            if(hex_Line.startsWith("#"))
            {
                hex_Line.substring(1,7);
            }

            lineColorChooser.clear();
            hex_Line.toUpperCase();
            //System.out.println(hex_Line);
        
        });

        toReturn.setScaleX(2);
        toReturn.setScaleY(2);
        toReturn.setTranslateY(350);
        toReturn.setOnAction(event -> 
        {
            Main.getGameState(2);
            Main.updateStage();
        });

        cellophane.setFocusTraversable(false);

        cellophane.getChildren().add(colorPicker);
		cellophane.getChildren().add(X);
		cellophane.getChildren().add(O);
		cellophane.getChildren().add(line);
		cellophane.getChildren().add(XColorChooser);
		cellophane.getChildren().add(OColorChooser);
		cellophane.getChildren().add(lineColorChooser);
		cellophane.getChildren().add(toReturn);

		stage.show();
	}

    public static String returnHexX()
    {
        return hex_X;
    }

    public static String returnHexO()
    {
        return hex_O;
    }

    public static String returnHexLine()
    {
        return hex_Line;
    }


}
