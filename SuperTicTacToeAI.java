package com.example;

public class SuperTicTacToeAI {
    private Tile[][] bigBoard;  // 4x4 board (Tiles)
    private Tile[][] smallBoard;  // 10x10 board (Tiles)

    public SuperTicTacToeAI(Tile[][] bigBoard, Tile[][] smallBoard) {
        this.bigBoard = bigBoard;
        this.smallBoard = smallBoard;
    }

    // Method to find the best move for the AI, limited to a specific area
    public int[] findBestMove(int startX, int startY, int endX, int endY) {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int i = startX; i <= endX; i++) { // Iterate only through the specified rows
            for (int j = startY; j <= endY; j++) { // Iterate only through the specified columns
                //System.out.println("[" + i + "," + j + "]");
                if (smallBoard[i][j].returnValue() == 0) { // Check if the tile is empty
                    // Simulate AI move
                    smallBoard[i][j].value = 2; // 2 represents AI ('O')
                    int score = minimax(0, false, startX, startY, endX, endY);
                    smallBoard[i][j].value = 0; // Undo the move

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[]{i, j};
                    }
                }
            }
        }

        return bestMove; // Return the best move coordinates
    }

    // Minimax algorithm with boundary restrictions
    private int minimax(int depth, boolean isMaximizing, int startX, int startY, int endX, int endY) {
        if (depth >= 1 || isGameOver()) { // Depth limit or game over
            return evaluateBoard();
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;

            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (smallBoard[i][j].returnValue() == 0) { // Check if the tile is empty
                        smallBoard[i][j].value = 2; // AI move
                        bestScore = Math.max(bestScore, minimax(depth + 1, false, startX, startY, endX, endY));
                        smallBoard[i][j].value = 0; // Undo the move
                    }
                }
            }

            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;

            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (smallBoard[i][j].returnValue() == 0) { // Check if the tile is empty
                        smallBoard[i][j].value = 1; // Player move
                        bestScore = Math.min(bestScore, minimax(depth + 1, true, startX, startY, endX, endY));
                        smallBoard[i][j].value = 0; // Undo the move
                    }
                }
            }

            return bestScore;
        }
    }

    // Board evaluation function
    private int evaluateBoard() {
        int score = 0;

        // Evaluate rows, columns, and diagonals of the entire smallBoard
        for (int i = 1; i <= 9; i++) { // Adjust loop to cover smallBoard size
            for (int j = 1; j <= 9; j++) {
                // Evaluate rows and columns
                if (j <= 7) score += evaluateLine(
                    smallBoard[i][j].returnValue(),
                    smallBoard[i][j + 1].returnValue(),
                    smallBoard[i][j + 2].returnValue()
                );
                if (i <= 7) score += evaluateLine(
                    smallBoard[i][j].returnValue(),
                    smallBoard[i + 1][j].returnValue(),
                    smallBoard[i + 2][j].returnValue()
                );

                // Evaluate diagonals
                if (i <= 7 && j <= 7) score += evaluateLine(
                    smallBoard[i][j].returnValue(),
                    smallBoard[i + 1][j + 1].returnValue(),
                    smallBoard[i + 2][j + 2].returnValue()
                );
                if (i <= 7 && j >= 3) score += evaluateLine(
                    smallBoard[i][j].returnValue(),
                    smallBoard[i + 1][j - 1].returnValue(),
                    smallBoard[i + 2][j - 2].returnValue()
                );
            }
        }

        return score;
    }

    // Helper method to evaluate a line for scoring
    private int evaluateLine(int a, int b, int c) {
        if (a == b && b == c) {
            if (a == 2) return 10; // AI wins
            if (a == 1) return -10; // Player wins
        } else if ((a == 2 && b == 2 && c == 0) || 
                   (a == 2 && b == 0 && c == 2) || 
                   (a == 0 && b == 2 && c == 2)) {
            return 5; // AI has two in a row
        } else if ((a == 1 && b == 1 && c == 0) || 
                   (a == 1 && b == 0 && c == 1) || 
                   (a == 0 && b == 1 && c == 1)) {
            return -5; // Player has two in a row
        }
        return 0;
    }

    // Check if the game is over
    private boolean isGameOver() {
        // Check for a winning line in the smallBoard
        for (int i = 1; i <= 9; i+=3) {
            if (i <= 7) { // Evaluate rows and columns
                for (int j = 1; j <= 7; j+=3) {
                    // System.out.println("1");
                    if (checkLine(smallBoard[i][j], smallBoard[i][j + 1], smallBoard[i][j + 2])) return true;
                    // System.out.println("2");
                    if (checkLine(smallBoard[j][i], smallBoard[j + 1][i], smallBoard[j + 2][i])) return true;
                    // System.out.println("3");
                }
            }
            // Evaluate diagonals
            if (checkLine(smallBoard[i][i], smallBoard[i + 1][i + 1], smallBoard[i + 2][i + 2])) return true;
            // System.out.println("4");
            // System.out.println(i);
            if (checkLine(smallBoard[i][10 - i], smallBoard[i + 1][9- i], smallBoard[i + 2][8 - i])) return true;
            // System.out.println("5");
        }

        return false;
    }

    private boolean checkLine(Tile a, Tile b, Tile c) {
        return a.returnValue() == b.returnValue() &&
               b.returnValue() == c.returnValue() &&
               a.returnValue() != 0;
    }
}