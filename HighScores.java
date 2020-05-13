import java.util.Scanner;
import java.util.Arrays;

public class HighScores {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.print("Enter how many scores to input: ");
		int numOfScores = Integer.parseInt(input .nextLine());
		
		
		int[] highScores = new int[numOfScores];
		
		for (int count = 0; count < highScores.length; count++)
		{
			System.out.print("Enter the high score " + (count+1) + " : ");
	        highScores[count] = input.nextInt();
	        
		}
		printHighScores(highScores);
	
		System.out.println("Enter your new score: ");
		int highScore = input.nextInt();
		if (higherThan(highScores, highScore) == true)
		{
			System.out.println("Your score is higher than values that are currently on the list");
		}
		else
		{
			System.out.println("Your score is not higher than values that are currently on the list");
		}
		
		insertScore(highScores, highScore);
		printHighScores(highScores);
		
	}
	public static int[] initialiseHighScores (int numOfScores)
	{
		int[] initialiseHighScores = new int[numOfScores];
        for(int count = 0; count < numOfScores; count++){
            initialiseHighScores[count] = 0;
        }
        return initialiseHighScores;
	}
	
	
	public static void printHighScores (int[] highScores)
	{
		System.out.print("The high scores are ");
		Arrays.sort(highScores);
		
		for (int count = 0; count < highScores.length; count++)
		{
			
		      System.out.print(highScores[count] + ",");

		}	
		System.out.println();
	}
	
	public static boolean higherThan(int[] highScores, int highScore)
	{
	        for(int count = 0; count < highScores.length; count++){
	            if(highScore > highScores[count]){
	                return true;
	            }
	        }
	        return false;
	    }
	
	public static int [] insertScore(int[] highScores, int highScore)
	{
		for(int count = highScores.length - 1; count >= 0; count--)
		{ 
		if(highScore > highScores[count])
		{
             for(int shift = 1; shift <= count; shift++)
             {
                 highScores[shift-1]=highScores[shift];
             }
             highScores[count] = highScore;
             count = -1;
         }
     }
     return highScores;
	
	}
}
