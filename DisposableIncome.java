/* SELF ASSESSMENT
   1. Did I use easy-to-understand meaningful variable and CONSTANT names? 
       Mark out of 10: 10
       Comment: My constants and variables were easy to understand/decipher 
   2. Did I format the variable and CONSTANT names properly (in lowerCamelCase and UPPERCASE_WITH_UNDERSCORES)?
       Mark out of 10: 10
       Comment: All variables and constants formatted properly.
   3. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: Code indented correctly.
   4. Did I read the input correctly from the user using appropriate questions?
       Mark out of 15: 15
       Comment: Questions taken exactly from assignment instructions.
   5. Did I computer the disposable income and disposable income percentage correctly, and output it in the correct format?
       Mark out of 15: 14
       Comment: Tested and it all works.
  6. Did I use an appropriate series of if statements to generate the income analysis to the user?
       Mark out of 25: 25
       Comment: Tested and it all works.
   7. Did I provide the correct output for each possibility in an easy to read format?
       Mark out of 10: 10
       Comment: Explained the results to the user using clear english.
   8. How well did I complete this self-assessment?
       Mark out of 5: 4
       Comment: Didn't know what to fill in comments at times.
   Total Mark out of 100 (Add all the previous marks): 98
*/

import java.util.Scanner;
import javax.swing.JOptionPane;

public class DisposableIncome {

	 public static final double AVERAGE_INCOME = 500.00;
     public static final double TAX_PERCENTAGE = 0.65;
     public static final double AVERAGE_PERCENTAGE_ABOVE = 1.5;
     public static final double AVERAGE_PERCENTAGE_BELOW = 0.5;
     
     public static void main(String []args) {
       
        String grossIncomeInput = JOptionPane.showInputDialog ("How much are you paid a month before tax?");
        Scanner inputScanner = new Scanner( grossIncomeInput );
        double grossIncome = inputScanner.nextDouble();
       
        String acommodationInput = JOptionPane.showInputDialog ("How much do you pay in rent/mortgage a month?");
        inputScanner = new Scanner ( acommodationInput );
        double acommodation = inputScanner.nextDouble();
       
        String travelInput = JOptionPane.showInputDialog ("How much does your commute cost a month?");
        inputScanner = new Scanner ( travelInput );
        double travel = inputScanner.nextDouble();
       
        String foodInput = JOptionPane.showInputDialog ("How much do you spend on food per month?");
        inputScanner = new Scanner ( foodInput );
       
        double food = inputScanner.nextDouble();
        double netIncome = grossIncome * TAX_PERCENTAGE;
        double disposableIncome = netIncome - acommodation - travel - food;
        double percentageIncome = ((disposableIncome * 100 )/grossIncome);
        JOptionPane.showMessageDialog(null, "Your monthly disposable income is " + disposableIncome + " which is " + percentageIncome + " percent of your salary" );
       

        if (disposableIncome <= 0)
        {
        	JOptionPane.showMessageDialog(null, "You have no disposable income");
        }
        else if (disposableIncome < AVERAGE_INCOME * AVERAGE_PERCENTAGE_BELOW)
        {
        	JOptionPane.showMessageDialog(null, "Your disposable income is much below average");
        }
        else if (disposableIncome > AVERAGE_INCOME * AVERAGE_PERCENTAGE_ABOVE)
        {
     		JOptionPane.showMessageDialog(null, "Your disposable income is much above average");
     	}
        else if (disposableIncome > AVERAGE_INCOME)
        {
     		JOptionPane.showMessageDialog(null, "Your disposable income is above average");
        }
     	else if (disposableIncome < AVERAGE_INCOME)
     	{
         	JOptionPane.showMessageDialog(null, "Your disposable income is below average");	
        }		
        else 
        {
        	JOptionPane.showMessageDialog(null, "Your disposable income is average");
        }
   
        inputScanner.close();
        
        
     }
     
}
