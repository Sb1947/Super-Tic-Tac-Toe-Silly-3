package com.example;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class Decision_Page extends Application {

	Rectangle2D screenBounds = Screen.getPrimary().getBounds();

	public static int player_Choice;
	public static int computer_Choice;

	@Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception 
    {
        StackPane two_Way_Mirror =  new StackPane();

        stage.setScene(new Scene(two_Way_Mirror, screenBounds.getWidth(), screenBounds.getHeight()));

		two_Way_Mirror.setFocusTraversable(false);

		Text introduction = new Text("Would You Like To Be 'X' or 'O' ?");

		introduction.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        introduction.setTextOrigin(VPos.TOP);
        introduction.setTranslateY(-300);

        Button option_X = new Button("X");
        Button option_O = new Button("O");
		Button color_Choice = new Button("   Color\nChoices");

		option_X.setScaleX(3);
		option_X.setScaleY(3);
		option_X.setTranslateX(-250);
		option_X.setTranslateY(-50);
        option_X.setFocusTraversable(false);
		option_X.setOnAction(event -> 
        {
			player_Choice = 1;
			computer_Choice = 2;
			Main.getGameState(3);
			Main.updateStage();
        });
		
		option_O.setScaleX(3);
		option_O.setScaleY(3);
		option_O.setTranslateX(250);
		option_O.setTranslateY(-50);
        option_O.setFocusTraversable(false);
		option_O.setOnAction(event -> 
        {
			player_Choice = 2;
			computer_Choice = 1;
			Main.getGameState(3);
			Main.updateStage();
        });

		color_Choice.setScaleX(2);
		color_Choice.setScaleY(2);
		color_Choice.setTranslateY(300);
        color_Choice.setFocusTraversable(false);
		color_Choice.setOnAction(event -> 
		{
			Main.getGameState(5);
			Main.updateStage();
		});

		two_Way_Mirror.getChildren().add(option_X);
		two_Way_Mirror.getChildren().add(option_O);
		two_Way_Mirror.getChildren().add(color_Choice);
		two_Way_Mirror.getChildren().add(introduction);

		stage.show();
	}

	public static int getPlayerChoice()
	{
		return player_Choice;
	}
}
