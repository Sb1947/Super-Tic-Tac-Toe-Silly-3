package com.example;

import javafx.application.*;
import javafx.concurrent.Task;
import java.util.concurrent.*;


public class Game_Logic {

	private static boolean gameWon = false;

	//In regards to smaller board
	public static int lastRowPlayed;
	public static int lastColumnPlayed;

	//In regards to bigger board
	public static int nextRowPlayed;
	public static int nextColumnPlayed;

	private static Turn_Type currentTurn;

	private CompletableFuture<Void> turnFuture;

	private static int turn_Count = 0;

	private static SuperTicTacToeAI ai = new SuperTicTacToeAI(Tile.bigBoard, Tile.smallBoard);

	public void startGame() {
		turnFuture = new CompletableFuture<>();
		while(!gameWon && Decision_Page.player_Choice == 1)
		{
			playerTurn();
			computerTurn();

		}

	}
	
	private void playerTurn() {
		System.out.println("Player's turn started");
		currentTurn = Turn_Type.PLAYER;
		Tile.setTurnFutureInTile(turnFuture, currentTurn);
		turnFuture.whenComplete((aVoid, throwable) -> {
			if (throwable != null) {
				throwable.printStackTrace();
			} else {
				System.out.println("Player's turn completed");
				Tile.lockAllTilesExcept(nextColumnPlayed(lastColumnPlayed), nextRowPlayed(lastRowPlayed));
				currentTurn = Turn_Type.COMPUTER;
				Platform.runLater(this::computerTurn); // Schedule computerTurn on the JavaFX Application Thread
			}
		});
	}
	
	private void computerTurn() {
		System.out.println("Computer's turn started");
		currentTurn = Turn_Type.COMPUTER;
		//System.out.println("Chat are we in?");
		System.out.println("[" + lastColumnPlayed + "," + lastRowPlayed + "]");
		int startX = nextColumnPlayed(lastColumnPlayed);
		int startY = nextRowPlayed(lastRowPlayed);
		int endX = startX + 2;
		int endY = startY + 2;

		System.out.println("[" + startX + "," + startY + "] , " + "[" + endX + "," + endY + "]");

		int[] bestMove = ai.findBestMove(startX, startY, endX, endY);
		if (bestMove != null) {
			Tile.setValue(bestMove[0], bestMove[1]); // AI makes its move
			lastColumnPlayed = bestMove[0];
			lastRowPlayed = bestMove[1];
			Tile.lockAllTilesExcept(nextColumnPlayed(lastColumnPlayed), nextRowPlayed(lastRowPlayed));
			turn_Count++;
			System.out.println("Computer played: [" + bestMove[0] + ", " + bestMove[1] + "]");
		} else {
			System.out.println("AI could not find a valid move.");
		}
	
		// Switch back to player's turn
		currentTurn = Turn_Type.PLAYER;
		turnFuture = new CompletableFuture<>();
		playerTurn();
	}

	public static void setLastColumnPlayed(int x)
	{
		lastColumnPlayed = x;
	}

	public static void setLastRowPlayed(int y)
	{
		lastRowPlayed = y;
	}

	public static int nextColumnPlayed(int x)
	{
		System.out.println("Next Column Played: " + (((x - 1) % 3) + 1));
		return (((x - 1) % 3) + 1);
	}
	
	public static int nextRowPlayed(int y)
	{
		System.out.println("Next Row Played: " + (((y - 1) % 3) + 1));
		return (((y - 1) / 3) + 1);
	}
	/*
	static void smallBoardWinCheck()
     {
     /*if any 3 big boards are won, make run = false
     How to check for who is winning in a game
     Horizontal
     - run a for loop going through number of rows first and then second for loop in 1st one checking if value of each square added equals 3 or 6
     
	for(int r = 1; r<=9; r++)
	{
		 for(int c = 1; c<=7; c+= 3)
		 {
			  if((tile.smallBoard[r][c].getValue() == 1) && (tile.smallBoard[r][c+1].getValue() == 1) && (tile.smallBoard[r][c+2].getValue() == 1))
			  {
				 //  Call win for x
				   for(int r2 = (((r - 1) / 3) * 3)+ 1; r2 <= (((r - 1) / 3)* 3)+ 3; r2++)
				   {
						for(int c2 = c; c2 <= (c + 2); c2++) 
						{
							 tile.smallBoard[r2][c2].setValue = -1;
						}
				   }
				   bigBoard[(r - 1) / 3 + 1][(c - 1) / 3 + 1] = 1;
				   console2.println("You won horizontally!");
				   placementBigBoard(r, c, playerChoice);
				   console2.println("Press any button to continue");
				   console2.readLine();
				   break;
			  }
			  else if((tile.smallBoard[r][c].getValue() == 2) && (tile.smallBoard[r][c+1].getValue() == 2) && (tile.smallBoard[r][c+2].getValue() == 2))
			  {
				 //  Call win for o
				 for(int r2 = (((r - 1) / 3) * 3)+ 1; r2 <= (((r - 1) / 3) * 3)+ 3; r2++)
				 {
					  for(int c2 = c; c2 <= (c + 2); c2++) 
					  {
						 tile.smallBoard[r2][c2].setValue = -1;
					  }
				 }

				 tile.bigBoard[(r - 1) / 3 + 1][(c - 1) / 3 + 1].setValue (2);
				 console2.println("Computer won horizontally!");
				 placementBigBoard(r, c, computerChoice);
				 console2.println("Press any button to continue");
				 console2.readLine();
				 break;
			  }
		 }
	}
/* 
Vertical
- run a for loop going through number of Columns first and then second for loop in 1st one checking if value of each square added equals 3 or 6
ex.

	for( int r = 1; r<=7; r+=3)
	{
		 for(int c = 1; c<=9; c++)
		 {
			  if((tile.smallBoard[r][c].getValue() == 1) && (tile.smallBoard[r+1][c].getValue() == 1) && (tile.smallBoard[r+2][c].getValue() == 1))
			  {
				for(int r2 = r; r2 <= (r + 2); r2++)
				{
					for(int c2 = (((c - 1) / 3) * 3)+ 1; c2 <= (((c - 1) / 3) * 3)+ 3; c2++) 
					{
							tile.smallBoard[r2][c2].setValue = -1;
					}
				}

				tile.bigBoard[(r - 1) / 3 + 1][(c - 1) / 3 + 1].setValue(1);
				console2.println("You won vertically!");
				placementBigBoard(r, c, playerChoice);
				console2.println("Press any button to continue");
				console2.readLine();
				break;
			  }
			  else if((smallBoard[r][c].getValue() == 2) && (smallBoard[r+1][c].getValue() == 2) && (smallBoard[r+2][c].getValue() == 2))
			  {
				   for(int r2 = ((r + 2) / 3); r2 <= (((r + 2) / 3) + 2); r2++)
				   {
						for(int c2 = c; c2 <= (c+2); c2++) 
						{
							 tile.smallBoard[r2][c2].setValue(-1);
						}
				   }

				   bigBoard[(r - 1) / 3 + 1][(c - 1) / 3 + 1] = 2;
				   console2.println("Computer won vertically!");
				   placementBigBoard(r, c, computerChoice);
				   console2.println("Press any button to continue");
				   console2.readLine();
				   break;
			  }
		 }
	}

	/* 
	Diagonal
	ex.
	for(int r = 1; r<=7; r+=3)
	{
		 for(int c = 1; c <= 7; c += 3)
		 {
			  if((smallBoard[r][c].getValue() == 1) && (smallBoard[r+1][c+1].getValue() == 1) && (smallBoard[r+2][c+2].getValue() == 1))
			  {
			  //  Call win for x
			  for(int r2 = ((r + 2) / 3); r2 <= (((r + 2) / 3) + 2); r2++)
			  {
				   for(int c2 = c; c2 <= (c+2); c2++) 
				   {
						smallBoard[r2][c2].setValue(-1);
				   }
			  }

			  bigBoard[(r - 1) / 3 + 1][(c - 1) / 3 + 1] = 1;
			  console2.println("You won diagonally!");
			  placementBigBoard(r, c, playerChoice);
			  console2.println("Press any button to continue");
			  console2.readLine();
			  break;
			  }
			  else if((smallBoard[r][c].getValue() == 2) && (smallBoard[r+1][c+1].getValue() == 2) && (smallBoard[r+2][c+2].getValue() == 2))
			  {
			  // Call win for o
			  for(int r2 = ((r + 2) / 3); r2 <= (((r + 2) / 3) + 2); r2++)
			  {
				   for(int c2 = c; c2 <= (c+2); c2++) 
				   {
						smallBoard[r2][c2].setValue(-1);
				   }
			  }

			  bigBoard[(r - 1) / 3 + 1][(c - 1) / 3 + 1] = 2;
			  console2.println("Computer won diagonally!");
			  placementBigBoard(r, c, computerChoice);
			  console2.println("Press any button to continue");
			  console2.readLine();
			  break;
			  }
		 }
	}
	
	for(int r = 1; r<=7; r+=3)
	{
		 for(int c = 9; c >= 3; c-=3)
		 {
			  if((smallBoard[r][c].getValue() == 1) && (smallBoard[r+1][c-1].getValue() == 1) && (smallBoard[r+2][c-2].getValue() == 1))
			  {
			  for(int r2 = ((r - 1) / 3) * 3 + 1; r2 <= ((r - 1) / 3 + 1) * 3; r2++)
			  {
				   for(int c2 = ((c - 1) / 3) * 3 + 1; c2 <= ((c - 1) / 3 + 1) * 3; c2++) 
				   {
						smallBoard[r2][c2].setValue(-1);
				   }
			  }

			  bigBoard[(r - 1) / 3 + 1][(c - 1) / 3 + 1] = 1;
			  console2.println("You won diagonally!");
			  placementBigBoard(r, c, playerChoice);
			  console2.println("Press any button to continue");
			  console2.readLine();
			  break;
			  }
			  else if((smallBoard[r][c].getValue() == 2) && (smallBoard[r+1][c-1].getValue() == 2) && (smallBoard[r+2][c-2].getValue() == 2))
			  {
			  for(int r2 = ((r + 2) / 3); r2 <= ((r - 1) / 3 + 1) * 3; r2++)
			  {
				   for(int c2 = ((c - 1) / 3 + 1) * 3; c2 <= ((c - 1) / 3 + 1) * 3; c2++) 
				   {
						smallBoard[r2][c2].setValue(-1);
				   }
			  }

			  bigBoard[(r - 1) / 3 + 1][(c - 1) / 3 + 1] = 2;
			  console2.println("Computer won diagonally!");
			  placementBigBoard(r, c, computerChoice);
			  console2.println("Press any button to continue");
			  console2.readLine();
			  break;
			  }
		 }
	}
}
	
	
	
	public void bigBoardWinCheck()
     {
          //Checks for player wins
          for(int c1 = 1; c1 <= 3; c1++)
          {
               int r1 = 1;
               if((bigBoard[r1][c1] == 1) && (bigBoard[r1+1][c1] == 1) && (bigBoard[r1+2][c1] == 1))
               {
                    console2.println("Player won");
                    playerWins++;
                    System.out.println(playerWins + "#1");
                    test = 1;
                    moveRun = false;
                    
                    break;
               }
               else if((bigBoard[r1][c1] == 2) && (bigBoard[r1+1][c1] == 2) && (bigBoard[r1+2][c1] == 2))
               {
                    console2.println("Computer won");
                    computerWins++;
                    test = 2;
                    moveRun = false;
                    break;
               }
          }
          for(int r2 = 1; r2 <= 3; r2++)
          {
               int c2= 1;
               if((bigBoard[r2][c2] == 1) && (bigBoard[r2][c2+1] == 1) && (bigBoard[r2][c2+2] == 1))
               {
                    console2.println("Player won");
                    playerWins++;
                    test = 1;
                    moveRun = false;
                    break;
               }
               else if((bigBoard[r2][c2] == 2) && (bigBoard[r2][c2+1] == 2) && (bigBoard[r2][c2+2] == 2))
               {
                    console2.println("Computer won");
                    computerWins++;
                    test = 2;
                    moveRun = false;
                    break;
               }
          }

          int r3 = 1;
          int c3 = 1;
          if((bigBoard[r3][c3] == 1) && (bigBoard[r3+1][c3+1] == 1) && (bigBoard[r3+2][c3+2] == 1))
          {
               console2.println("Player won");
               System.out.println(playerWins + "#3");
               playerWins++;
               test = 1;
               moveRun = false;
          }
          else if((bigBoard[r3][c3] == 2) && (bigBoard[r3+1][c3+1] == 2) && (bigBoard[r3+2][c3+2] == 2))
          {
               console2.println("Computer won");
               computerWins++;
               test = 2;
               moveRun = false;
          }

          int r4 = 3;
          int c4 = 3;
          if((bigBoard[r4][c4] == 1) && (bigBoard[r4-1][c4-1] == 1) && (bigBoard[r4-1][c4-2] == 1))
          {
               console2.println("Player won");
               System.out.println(playerWins + "#4");
               playerWins++;
               test = 1;
               moveRun = false;
          }
          else if((bigBoard[r4][c4] == 2) && (bigBoard[r4-1][c4-1] == 2) && (bigBoard[r4-1][c4-2] == 2))
          {
               console2.println("Computer won");
               computerWins++;
               test = 2;
               moveRun = false;
          }

          if(test == 0) ties++;
     } */

}
