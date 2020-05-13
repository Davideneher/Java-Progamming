/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment:  yes
 2. Did I implement the getVerse function correctly and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  yes
 3. Did I implement the getChristmasGift function correctly using a switch statement and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  yes
 4. Did I implement the getOrdinalString function correctly using if or conditional operators and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  yes
 5. Does the program produce the output correctly?
       Mark out of 10: 10
        Comment:  yes
 6. How well did I complete this self-assessment?
        Mark out of 5: 2
        Comment:  yes
 Total Mark out of 100 (Add all the previous marks): 97
*/ 


public class TwelveDaysOfChristmas {
    public static void main(String[] args){
    for (int dayCount = 1; dayCount <= 12; dayCount++)
    	{
    	System.out.println(getVerse(dayCount));
    	}
    }
    private static String getVerse (int dayCount)
    {
    	return"\nOn the "+getOrdinalString(dayCount)+" day of Christmas my true glove gave to me: " + getChristmasGift(dayCount);
    }
    private static String getChristmasGift (int dayCount)
    {
    	String gift = "";
    	switch (dayCount)
    	{
    	case 12:gift += "\nTwelve Drummers Drumming,";
    	case 11:gift += "\nEleven Pipers Piping,";
    	case 10:gift += "\nTen Lords a-Leaping,";
    	case 9: gift += "\nNine Ladies Dancing,";
    	case 8: gift += "\nEight Maids a-Milking,";       
    	case 7: gift += "\nSeven Swans a-Swimming,";
    	case 6: gift += "\nSix Geese a-Laying,";  	
    	case 5: gift += "\nFive Gold Rings,";        
    	case 4: gift += "\nFour Calling Birds,";       
    	case 3: gift += "\nThree French Hens,";       
    	case 2: gift += "\nTwo Turtle Doves";    
    	case 1: if (dayCount == 1)
    			gift += "\na Partridge in a Pear Tree.";
    			else
    			gift += "\nAnd a Partridge in a Pear Tree.";
    	break;
    	default:
    	}
    	return(gift);
    	}
    	 	
    private static String getOrdinalString (int dayCount)
    {
    	String day = "";
    	if (dayCount == 1)
    		day = "first";
    	else if (dayCount == 2)
    		day = "second";
    	else if (dayCount == 3)
    		day = "third";
    	else if (dayCount == 4)
    		day = "fourth";
    	else if (dayCount == 5)
    		day = "fifth";
    	else if (dayCount == 6)
    		day = "sixth";
    	else if (dayCount == 7)
    		day = "seventh";
    	else if (dayCount == 8)
    		day = "eight";
    	else if (dayCount == 9)
    		day = "ninth";
    	else if (dayCount == 10)
    		day = "tenth";
    	else if (dayCount == 11)
    		day = "eleventh";
    	else
    		day = "twelveth";
    	 
    	return day;
    		
    } 
}







