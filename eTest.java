import java.util.Scanner;


public class eTest {

	public static void main(String[] args) {
		
		int total = 0;
		int numberCount = 0;
		boolean finished = false;
		do
		{
			Scanner input = new Scanner( System.in );
			System.out.println("Enter a person's age (or type 'quit'): ");
			int age = input.nextInt();
			
			if (input.hasNextInt())
			{
			    total += input.nextInt();
				numberCount++;
			
				int average = ((int) total) / ((int) numberCount);
				System.out.println("The average age entered is " + average + " ");
			}
			else if (((age) > 12 && (age) < 20) && (numberCount > 0))
			{
				
				int numberOfTeenagers = 0;
				numberOfTeenagers++;
				int percentage = (((numberOfTeenagers) / (numberCount)) * (100));
				System.out.print("and " + percentage + "% of the ages corresponded to teenagers");
			}
			
			else if (input.hasNext("quit"))
			{
			finished = true;
			}
			else System.out.println("Not a valid whole number.  Try again.");
			
			}while (!finished);
			
	}
	
}
			
			
			
	
			
	
			
	

		
	
	


