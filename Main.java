package com.example;

//Required Imports
import javafx.application.*;
import javafx.stage.*;

public class Main extends Application {

	//Gamestate variable helps keep different menus of the game distinct and helps avoid code jumbling up
	private static int gameState = 0;

	//Main stage to show content on
	private static Stage primaryStage;

	public static void main(String[] args) 
	{
		//Launches javafx program
		launch(args);
	}//Method:main end

	//Makes stage
	@Override
	public void start(@SuppressWarnings("exports") Stage stage) {
		//Sets stage
		primaryStage = stage;

		//Calls method update stage
		updateStage();
	}//Method:start end

	//Sets new gamestate
	public static void getGameState(int newGameState) {
		gameState = newGameState;
	}//Method:getGameState end
 
	//Shows content on stage
	public static void updateStage()
	{


		//Try for errors
		try 
		{
			//Chooses which content to display based on Gamestate variable
			switch (gameState) 
			{
				//Closes program
				case -1:
					System.exit(0);
				break;

				//Makes home page
				case 0:
					System.out.println("Entering case 0:");
					Home_Page homePage = new Home_Page();
					homePage.start(primaryStage);

					//System.out.println("Memory used="+(Runtime.getRuntime().totalMemory()-
					//Runtime.getRuntime().freeMemory())/(1000*1000)+"M");
				break;

				//Makes rule page
				case 1:
					System.out.println("Entering case 1:");
					Rules_Page rulesPage = new Rules_Page();
					rulesPage.start(primaryStage);

					//System.out.println("Memory used="+(Runtime.getRuntime().totalMemory()-
					//Runtime.getRuntime().freeMemory())/(1000*1000)+"M");
				break;

				//Makes page where you choose whether your 'x' or 'o'
				case 2:
					System.out.println("Entering case 2:");
					Decision_Page decisionPage = new Decision_Page();
					decisionPage.start(primaryStage);

					// System.out.println("Memory used="+(Runtime.getRuntime().totalMemory()-
					// Runtime.getRuntime().freeMemory())/(1000*1000)+"M");
				break;

				//Makes game page
				case 3:
					 System.out.println("Entering case 3:");
					 Game_Page gamePage = new Game_Page();
					 gamePage.start(primaryStage);

					//  System.out.println("Memory used="+(Runtime.getRuntime().totalMemory()-
					//  Runtime.getRuntime().freeMemory())/(1000*1000)+"M");
				break;

				case 4:
				break;

				//Makes page to let you select color options and board options
				case 5:
					 System.out.println("Entering case 5:");
					 Color_Page funnyPage = new Color_Page();
					 funnyPage.start(primaryStage);

					//  System.out.println("Memory used="+(Runtime.getRuntime().totalMemory()-
					//  Runtime.getRuntime().freeMemory())/(1000*1000)+"M");
				break;

		}	
		//Catch errors and print message
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Sir your computer has virus");
		}
		
	}//Method:updateStage end

}//Class:Main end
