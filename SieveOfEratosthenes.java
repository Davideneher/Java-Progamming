/* SELF ASSESSMENT
   1.  createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment: Indeed I did
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment: Indeed I did
Did I return the correct item?
Mark out of 5: 5
Comment: Indeed I did
   2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment: Indeed I did
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2
Comment: Indeed I did
Did I loop through the array using the correct multiple?
Mark out of 5: 2
Comment: Something went wrong and It doesn't work for higher numbers. Couldn't figure out why.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 2
Comment: Indeed I did but some things shouldn't have been crossed out.
   3.  sieve  
Did I have the correct function definition?
Mark out of 5: 5
Comment: Indeed I did
Did I make calls to other methods?
Mark out of 5: 5
Comment: Indeed I did. I used this function to call every other function apart from the createSequence for effiency.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2
Comment: Indeed I did
   4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment: Indeed I did
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: Indeed I did
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets?
Mark out of 10: 8
Comment: Probably should've made it so there was no comma at the end.
   5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5
Comment:Indeed I did        
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment: Indeed I did
Did I loop through the array updating the String variable with just the non-crossed out numbers?
Mark out of 5: 5
Comment: Indeed I did
   6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 5
Comments: Probably should've made the error handling recursive if wrong.
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment: Indeed I did  
Did I print the output as shown in the question?  
Mark out of 5: 5
Comment: Indeed I did
   7.  Overall
Is my code indented correctly?
Mark out of 4: 3
Comments: I'm not the best indenter at times.
Do my variable names make sense?
Mark out of 4: 3
Comments: Some variable names were difficult to describe
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: Indeed they did
      Total Mark out of 100 (Add all the previous marks): 92
*/
 
 
 
import java.util.Scanner;
import java.util.Arrays;
 
 
public class SieveOfEratosthenes {
 
    public static void main(String[] args){
        boolean quit = false;
 
        while(!quit)
        {
       
        Scanner input = new Scanner(System.in);
       
            System.out.print("Enter your number (or enter quit)");
            int number = 0;
            if(input.hasNextInt()){
            number = input.nextInt();
           
            int[] primedSequence = sieve(number);
            System.out.println(nonCrossedOutSubseqToString(primedSequence));
        }
        else if(input.hasNext("quit")){
            quit = true;
        }
        else {
            System.out.println("Please enter a valid number ma'am. (or enter quit m'lady)");
            input.next();
       
        }
        }
     
    }
   
        public static int[] createSequence(int n){
            int[] listOfNumbers = new int[n];
            int originalSequence = 1;
            for(int i = originalSequence; i < listOfNumbers.length; i++){
                listOfNumbers[i] = originalSequence;
                originalSequence++;
            }
            return listOfNumbers;
        }
 
        public static int[] crossOutHigherMultiples(int[] sequence){
             
            int multiple = 2;
            while(multiple <= Math.sqrt(sequence.length+2)){
            for(int i = multiple; i < sequence.length; i++){
                if(sequence[i] % multiple == 0 && sequence[i] > 0 && sequence[i] != 2  && sequence[i] != 5 && sequence[i] != 3)
                     sequence[i] *= -1;
                       }
                       System.out.println(sequenceToString(sequence));
                       multiple++;
                   
               }
               return sequence;
           
        }
 
        public static int[] sieve(int n){
            int[] listOfNumbers = createSequence(n);
            System.out.println(sequenceToString(listOfNumbers));
            listOfNumbers = crossOutHigherMultiples(listOfNumbers);
            return listOfNumbers;
        }
 
        public static String sequenceToString(int[] sequence){
            String sequenceString = "";
            for(int i = 0; i < sequence.length; i++){
                if(sequence[i] > 0) {
                    sequenceString += i + ", ";
                }else if (sequence[i] < 0 && sequence[i] != 2) {
                    sequenceString += "[" + Math.abs(i) + "], ";
                }
           
            }
            //System.out.println(Arrays.toString(sequence));
            return sequenceString;
        }
 
        public static String nonCrossedOutSubseqToString(int[]sequence){
            String finalString = "";
            for(int i = 0; i < sequence.length; i++){
                if(sequence[i] > 0) {
                    finalString += i + ", ";
                }
       
            }
            return finalString;
        }
}