/*
1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: Function takes the wager as well but has the String and Wallet.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8 ].
Comment: Works as intended.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: Uses the .check function.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15 ]..
Comment: Presented the Dice values and makes the variable.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20 ].
Comment: Used a buttload of if else statements.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10 ].
Comment: Works as intended.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15 ]
Comment: Works as intended.
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5 ]
Comment: Works as intended.
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: Works as intended.
My program calls resolveBet for each bet type entered [Mark out of 5: 5 ].
Comment: Works as intended.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment: Summarised perfectly.

 Total Mark out of 100 (Add all the previous marks):
*/

import java.util.Scanner;
public class ChuckALuck {
	static double initialValue;
    static double finalValue;
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
        Wallet playerWallet = new Wallet();

        
        System.out.println("Show me them dolla' bills bro");
        if(input.hasNextInt()) {
            	initialValue = input.nextInt();
                playerWallet.put(initialValue);
        }
        else {
        	System.out.println("Please don't waste my time. LEROY, escort this idiot out.");
        }
        boolean quit = false;
        while(!quit){
            if(playerWallet.check() <= 0){
                quit = true;
                finalValue = playerWallet.check();
            }
            else{
                System.out.println("What's your bet bro? [Triple] [High] [Field] [Low] (or enter 'quit' if you're a chicken..): ");
                if(input.hasNext("quit")) quit = true;
                else{
                    String bet = input.next();
                    System.out.println("How many dolla bills you betting?: ");
                    if(input.hasNextInt()){
                        double wager = input.nextInt();
                        ResolveBet(bet, wager, playerWallet);
                    }
                    else{
                      
                        System.out.println("Please enter a valid number or Leroy here will kick you out. *Leroy cracks knuckles menacingly*");
                    }
                }
            }
        }
        if(initialValue > finalValue){
            System.out.println("You lost ");
        	System.out.print(initialValue - finalValue);
        	System.out.print(" dollars");
        }
        else if(initialValue < finalValue){
        	System.out.println("You lost ");
        	System.out.print(finalValue - initialValue);
        	System.out.print(" dollars");        
        }
}
 
	 public static void ResolveBet(String bet, double wager, Wallet playerWallet){
	 
		 playerWallet.get(wager);
		 double cash = (playerWallet.check()) ;
		 if (cash < wager) {
			 System.out.println("I don't think you have the facilities for that big man.");
		 }
		 else {
		 Dice[] dice = new Dice[3];
         int[] rolls = new int[3];
         for(int i = 0; i < 3; i++){
             dice[i] = new Dice();
             rolls[i] = dice[i].roll();
             System.out.println(dice[i].toString());
         }
         
         if(rolls[0] == rolls[1] && rolls[0] == rolls[2] && bet.equalsIgnoreCase("Triple")){
             
             if(rolls[0] != 1 && rolls[0] != 6){
                 playerWallet.put(31*wager);
                 System.out.println("You won. You better stop getting lucky or you'll have to face Leroy bro.");
                 System.out.println(playerWallet.toString());
             }
             else {
                 System.out.println("Close, but you lost :'(");
                 System.out.println(playerWallet.toString());
             }
         }
         
         else {
        	 int total = rolls[0] + rolls[1] + rolls[2];
        	 
        	 if(total < 8 && total > 12 && bet.equalsIgnoreCase("Field")) {
        		 playerWallet.put(2*wager);
                 System.out.println("You won...");
                 System.out.println(playerWallet.toString());
        	 }
        	 else if(total > 10 && bet.equalsIgnoreCase("High")) {
        		 playerWallet.put(2*wager);
                 System.out.println("You won...");
                 System.out.println(playerWallet.toString());
        	 }
        	 else if(total < 11 && bet.equalsIgnoreCase("Low")){
        	 }
        	 else if(!bet.equalsIgnoreCase("Low") && !bet.equalsIgnoreCase("High") && !bet.equalsIgnoreCase("Field")
        			 && !bet.equalsIgnoreCase("Triple")) {
        		 System.out.println("Please enter a valid bet you idiot. (And I'm keeping your money)");
        		 System.out.println(playerWallet.toString());
        	 }
        	 else {
        		 System.out.println("You lost :/");
                 System.out.println(playerWallet.toString());
        	 }
        	 }
        	 
         }
         
	 }
	 
}

