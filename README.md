# Super Tic Tac Toe (Silly) :3

Welcome to the game of Super Tic-Tac-Toe!

Super Tic Tac Toe is an advanced version of the childhood game that we all know and love, Tic Tac Toe. Super Tic Tac Toe is played on a 3x3 grid of smaller Tic Tac Toe boards, creating a larger 9x9 grid. The goal is to win three small boards in a row, column, or diagonal on the large grid. Each turn, a player places their mark on one of the squares within the small board determined by their opponent’s previous move. For example, if your opponent plays in the top-left square of a small board, you must play in the top-left small board of the large grid. If a small board is already won, tied, or full, you can play anywhere on an open square. The game continues until a player wins three small boards in a row on the large grid or all boards are filled, resulting in a draw.

## Here are the specifics for the Rules:

#### Board Structure:

- The game board is a 3x3 grid of small Tic Tac Toe boards, creating a large 9x9 grid in total.
Each small board functions as a regular Tic Tac Toe board, with its own 3x3 grid.
  <img width="1440" alt="image" src="https://github.com/user-attachments/assets/1db5477d-5c89-4bab-a843-234d0be6280b" />

---
### Gameplay Rules

#### Starting the Game:

- Player X goes first. Players then alternate turns.
  
#### Placing Your Mark:

- On each turn, a player places their mark (either X or O) on one of the 81 squares in the 9x9 grid.
A player must place their mark on the small board within the large grid that was determined by the opponent’s previous move.

#### How to Determine the Next Move:

- The small board where the next player must play is determined by the position of the last mark placed.

##### For example:

- If Player X places their mark in the top-left cell of a small board.
  <img width="1440" alt="Screenshot 2025-01-09 at 1 18 27 PM" src="https://github.com/user-attachments/assets/09a6f2dd-dad1-4708-8bdb-e9af9bbc1ae4" />
- Player O’s next move must be in the top-left small board of the large grid.
  <img width="1440" alt="Screenshot 2025-01-09 at 1 19 56 PM" src="https://github.com/user-attachments/assets/810f0446-6fc7-4233-bb29-4404e844a368" />
- If Player O places their mark in the center cell of the top-left small board, Player X must play in the center small board.
    <img width="1440" alt="Screenshot 2025-01-09 at 1 20 33 PM" src="https://github.com/user-attachments/assets/283d8f3b-8c86-4291-9477-245fed62051a" />
- If Player X places their mark in the top-middle cell of the middle small board. Player O must play in the top-middle small board.
  <img width="1440" alt="Screenshot 2025-01-09 at 1 21 48 PM" src="https://github.com/user-attachments/assets/6cfbda9b-a08a-419a-89ce-c9f7b4780140" />
- If Player O places their mark in the bottom-right cell of the top-middle small board. Player X must play in the bottom-right small board.
    <img width="1440" alt="Screenshot 2025-01-09 at 1 22 08 PM" src="https://github.com/user-attachments/assets/d3ca749b-e68f-4ea2-9900-c18378bd9c53" />


#### Winning a Small Board:

- A player wins a small board by getting three of their marks in a row, column, or diagonal within that board, just like in classic Tic Tac Toe.
Once a small board is won, it is counted as "closed" for that player in the large grid.

#### Free Move Rule:

- If a player’s move sends the opponent to a closed or fully occupied small board, the opponent can then place their mark on any open square in any open small board on the large grid.
This rule also applies if a small board has already resulted in a draw and cannot be won by either player.

  ##### For Example:
  <img width="1440" alt="Screenshot 2025-01-09 at 1 14 26 PM" src="https://github.com/user-attachments/assets/e4220f33-7f3d-45ff-bd5f-560189dcc2d1" />
  In such a case, Player O can place their mark in any board they choose since Player X captured a small board on their last turn. If either Players are ever redirected to play in the bottom-left small board, they can choose to play anywhere else.

---
### Winning the Game:

- The game ends when a player achieves a winning line in the large grid by winning three small boards in a row, column, or diagonal.
If all boards are filled without any player achieving this, the game is a draw.
Additional Notes

### Tie in a Small Board:

- If neither player wins a small board, it is considered a draw. This board is now effectively "closed," and future moves directed to this board will allow the next player to choose any available board.

---
# Good Luck!

![image](https://github.com/user-attachments/assets/5a3af9ae-0bfd-437d-a942-d1aebb38d421)
