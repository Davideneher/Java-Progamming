
/* SELF ASSESSMENT

Connect4Game class (35 marks) 32
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: Works as intended but might not have tested everything.

Connect4Grid interface (10 marks) 10
I define all 7 methods within this interface.
Comment: Everything defined.

Connect4Grid2DArray class (25 marks) 22
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: Everything works as intended but again might not have tested everything.

ConnectPlayer abstract class (10 marks) 10
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: Classes defined as required.

C4HumanPlayer class (10 marks) 10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment: Works as intended.

C4RandomAIPlayer class (10 marks) 10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment: The 'claas' works as intended.

Total Marks out of 100: 94

*/


import java.util.Scanner;

public class Connect4Game {
	public static void main(String args[]) {
		Connect4Grid2DArray gridArray = new Connect4Grid2DArray();
		Scanner userInput = new Scanner(System.in);
		
		boolean gameOver = false;
		boolean gamemodeChosen = false;
		boolean finished = false;
		int userMove;
		
		
		gridArray.emptyGrid();
		
		while(!finished) {
			
			while(!gamemodeChosen) {
			
			System.out.println("Would you like to play: \n 1] Against an AI? \n 2] Against another player? \n 3] Not at all");
			int userDecision = userInput.nextInt();
			
			if (userDecision == 3) {
				System.out.println("Cya bro");
				
				finished = true;
			}
			else if(userDecision == 1) {
				//AI Code
				gamemodeChosen = true;
				
				C4HumanPlayer user = new C4HumanPlayer();
				C4RandomAIPlayer computer = new C4RandomAIPlayer();
				
				user.setPlayerID(1);
				computer.setPlayerID(2);
				user.setIsTurn(true);
				computer.setIsTurn(false);
				
				while(!gameOver && !gridArray.isGridFull()) {
					if(user.getIsTurn()) {
						System.out.println(gridArray.toString());
						System.out.println("User's turn. Please pick a column.");
						userMove = userInput.nextInt();
						if(gridArray.isValidColumn(userMove)) {
							if(!gridArray.isColumnFull(userMove)) {
								gridArray.dropPiece(user, userMove);
								user.setIsTurn(false);
								computer.setIsTurn(true);
								
								if(gridArray.didLastPieceConnect4()) {
									gameOver = true;
									System.out.println(gridArray.toString());
									System.out.println("User wins. Game over.");
								}
							}
							else {
								System.out.println("Please select a column that is not full.");
							}
						}
						else {
							System.out.println("Please select a column within the bounds of the grid.");
						}
					}
					else if(computer.getIsTurn()) {
						int computerChoice = C4RandomAIPlayer.takeTurn();
						if(gridArray.isValidColumn(computerChoice)) {
							if(!gridArray.isColumnFull(computerChoice)) {
								gridArray.dropPiece(computer, computerChoice);
								computer.setIsTurn(false);
								user.setIsTurn(true);

								if(gridArray.didLastPieceConnect4()) {
									gameOver = true;
									System.out.println(gridArray.toString());
									System.out.println("Computer wins. Game over.");
								}
							}
						}
					}
				}
				
			}
			
			else if(userDecision == 2) {
				//2-Player Code
				gamemodeChosen = true;
				
				C4HumanPlayer user1 = new C4HumanPlayer();
				user1.setPlayerID(1);
				C4HumanPlayer user2 = new C4HumanPlayer();
				user2.setPlayerID(2);
				
				user1.setIsTurn(true);
				user2.setIsTurn(false);
				
				while(!gameOver && !gridArray.isGridFull()) {
					if(user1.getIsTurn()) {
						System.out.println(gridArray.toString());
						System.out.println("User's turn. Please pick a column.");
						userMove = userInput.nextInt();
						if(gridArray.isValidColumn(userMove)) {
							if(!gridArray.isColumnFull(userMove)) {
								gridArray.dropPiece(user1, userMove);
								user1.setIsTurn(false);
								user2.setIsTurn(true);
								if(gridArray.didLastPieceConnect4()) {
									gameOver = true;
									System.out.println(gridArray.toString());
									System.out.println("User 1 wins. Game over.");
								}
							}
							else {
								System.out.println("Please select a column that is not full.");
							}
						}
						else {
							System.out.println("Please select a column within the bounds of the grid.");
						}
					}
					else if(user2.getIsTurn()) {
						System.out.println(gridArray.toString());
						System.out.println("User's turn. Please pick a column.");
						userMove = userInput.nextInt();
						if(gridArray.isValidColumn(userMove)) {
							if(!gridArray.isColumnFull(userMove)) {
								gridArray.dropPiece(user2, userMove);
								user2.setIsTurn(false);
								user1.setIsTurn(true);
								if(gridArray.didLastPieceConnect4()) {
									gameOver = true;
									System.out.println(gridArray.toString());
									System.out.println("User 2 wins. Game over.");
								}
							}
							else {
								System.out.println("Please select a column that is not full.");
							}
						}
						else {
							System.out.println("Please select a column within the bounds of the grid.");
						}
					}
				}
			}
			
			else {
				System.out.println("Please select a valid option.");
			}
		}
	}
	}
}
