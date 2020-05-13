import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;
public class etest {
	public static final int TRUE = 1;
	public static final int FALSE = 0;
			
	public static void main(String[] args) {
		
		Scanner input = new Scanner( System.in );
		boolean finished = false;
		int[]integersArray = null;
		
		do {
			System.out.println("Enter an integer to add to the array (or 'quit' to finish) ");
			if (input.hasNextInt())
            {
				
				int[] newIntegers = new int[(integersArray==null)?1:integersArray.length+1];
				if (integersArray!= null)
					System.arraycopy( integersArray, 0, newIntegers, 0, integersArray.length );
				newIntegers[newIntegers.length-1] = input.nextInt();;
				integersArray = newIntegers;
				System.out.print("The minimum value is " + calculateMinimumValue(integersArray));
				int lengthOfArray = integersArray.length;
				System.out.print(isArrayPalindromic(integersArray, lengthOfArray));
				System.out.println();
			}
			else
			{
				finished = false;
				System.out.println("Thanks for playing, bye");
				break;
				
			}
		} while (!finished);
	}
     public static int calculateMinimumValue (int[] integersArray)  
     {
    	 Arrays.sort(integersArray);
    	 int minimumvalue = integersArray[0];
    	 return minimumvalue;	 
     }
        
     public static String isArrayPalindromic (int[] integersArray, int lengthOfArray)
     {
    	     int flag = FALSE; 
    	     for (int palindromeCount = 0; palindromeCount <= lengthOfArray / 2 && lengthOfArray != 0; palindromeCount++) 
    	     { 
    	         if (integersArray[palindromeCount] != integersArray[lengthOfArray - palindromeCount - 1]) 
    	         { 
    	             flag = TRUE; 
    	             break; 
    	         }
    	     } 
    	     	if (flag == TRUE)
	         	{
	         		String isPalindromic =  (" and the values are palindromic");
	         		return isPalindromic;
	         	}
	         	else
	         	{
	         		String isPalindromic =  (" and the values are not palindromic");
	         		return isPalindromic;
	         	}
    
     }

}
