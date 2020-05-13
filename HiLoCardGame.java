import java.util.Random;
import java.util.Scanner;
import java.util.Objects;
public class HiLoCardGame {

	
	public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
	
    public static void main(String[] args) {
	
		int winningStreak = 0;
		
		
		Random generator = new Random();
		int low = 2;
		int high = 14;
		int nextCard = generator.nextInt(high-low) + low;
		int card = 0;		
		while(winningStreak < 4)
		{
			
			card = nextCard;
			
			Random generator1 = new Random();
			nextCard = generator1.nextInt(high-low) + low;
			
			
			if(card != 1 && card <= 10) {
	            System.out.println("The card is a " + card);
	        }
	        else if(card == ACE){
	            System.out.println("The card is an Ace");
	        }
	        else if(card == JACK){
	            System.out.println("The card is a Jack");
	        }
	        else if(card == QUEEN){
	            System.out.println("The card is a Queen");
	        }
	        else if(card == KING){
	            System.out.println("The card is a King");
	        }
			
			Scanner input = new Scanner(System.in);
			System.out.print("Do you think the next card will be higher, lower or equal? ");
            String guess = input.next();
			
			
            if (!Objects.equals(guess, "higher") && !Objects.equals(guess, "lower") && !Objects.equals(guess, "equal"))
            {
            	System.out.println("Please enter a valid input. We will start again.");
            }
            else if(card < nextCard && Objects.equals(guess, "higher"))
			{
                winningStreak++;
            }
            else if(card > nextCard && Objects.equals(guess, "lower"))
            {
            	winningStreak++;
            }
            else if(card == nextCard && Objects.equals(guess, "equal"))
            {
            	winningStreak++;
            }
            else
            {
            	winningStreak = 0;
            }
			
			
		}
		System.out.print("You got four correct in a row. Congratulations");
		
		
		
	}
}

