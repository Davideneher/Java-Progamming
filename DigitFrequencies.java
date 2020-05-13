import java.util.Scanner;

public class DigitFrequencies {

	public static void main(String[] args) {
	
		int[] digitCounter = new int[10];
		for (int count = 0; count < 10; count++)
		{
			Scanner input = new Scanner( System.in );
			System.out.println("Enter a number> ");
			int number = input.nextInt();
			countDigitFrequencies(number, digitCounter);
			printDigitFrequencies(number, digitCounter);
		}
	}
	
	public static void countDigitFrequencies( int number, int[ ] digitCounter )
	{
		do
		{
			int lastNumber = number % 10;
			number /= 10;
			digitCounter[lastNumber]++;
			
		} while (number > 0);		
	}
	
	public static void printDigitFrequencies(int number, int[ ] digitCounter )
	{
	System.out.println("Digit Frequencies:");
	
	for (int count = 0; count < 10; count++)
	{
		if (digitCounter[count] > 0)
		{
			System.out.print(count + "(" + digitCounter[count] + ")");
		}
	}
	}
}
