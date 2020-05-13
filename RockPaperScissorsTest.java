import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsTest {
	
	public final static int ROCK = 1;
	public final static int PAPER = 2;
	public final static int SCISSORS = 3;
	public static void main(String[] args) {
		int draws = 0;
		int computerScore = 0;
		int playerScore = 0;
		
		System.out.println("Enter the amount of games you want to play");
		Scanner input = new Scanner( System.in );
		int amountOfGames = input.nextInt();
		int count;
		for (count = 0; (count < amountOfGames) ; count++)
		{
			Random computerInput = new Random();
			int low = 1;
			int high = 4;
			int computerChoice = computerInput.nextInt(high-low) + low;
			
			System.out.print("Rock, Paper, Scissors.. Shoot! Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors):");
			input = new Scanner( System.in );
			int playerChoice = input.nextInt();
			
			if (playerChoice == computerChoice)
				System.out.println("Our game was a draw");
			else if (playerChoice == ROCK)
				System.out.println((playerChoice + computerChoice == 4) && (playerChoice < computerChoice) ? "Your rock beat my scissors" : "My paper beat your rock" );
			else if (playerChoice == PAPER)
				System.out.println((playerChoice + computerChoice == 3) && (playerChoice > computerChoice) ? "Your paper beat my rock" : "My scissors beat your paper" );
			else if (playerChoice == SCISSORS)
				System.out.println((playerChoice + computerChoice == 5) && (playerChoice > computerChoice) ? "Your scissors beat my paper" : "My rock beat your paper" );
			
			if (playerChoice == computerChoice) draws++;
			else if ((playerChoice - computerChoice + 3) % 3 == 1) playerScore++;
			else computerScore++;
		
		}
		
		System.out.println("Your score is " + playerScore + "");
		System.out.println("My score is " + computerScore + "");
		System.out.println("We had " + draws + " draws");
		input.close();
	}
	

}
