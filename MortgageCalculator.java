import java.util.Objects;
import java.util.Scanner;
import java.lang.Math;


public class MortgageCalculator {
	public static final String MORTGAGE_AMOUNT = "Please enter the mortgage amount:";
	public static final String APR = "Please enter the annual interest rate (APR):";
	public static final String AFFORDED_RATE = "How much can you afford to pay per month?";
	public final static int MORTGAGE_DURATION = -240;
	public final static int MONTHS_IN_YEAR = 12;
	public static void main(String[] args){
		boolean quit = false;
		
		
		
		
		
		while (!quit)
		{
		Scanner input = new Scanner( System.in );
		
		double principal = readDoubleFromUser(MORTGAGE_AMOUNT);
		
		double interestRate = readDoubleFromUser(APR);
		
		double affordedRepayment = readDoubleFromUser(AFFORDED_RATE);
		
		double interestMonthly = (interestRate/12/100);
		
		
		
		System.out.println("Assuming a 20 year term, the monthly repayments would be " +calculateMonthlyRepayment(principal,interestMonthly));
		System.out.println(calculateMonthsToRepayMortgage(principal,affordedRepayment,interestMonthly));
		
		
		
		
		System.out.println("Would you like to use the mortgage calculator again (yes/no)?");
        String again = input.next();
        if(!Objects.equals(again, "yes"))
        {
            quit = true;

            if(!Objects.equals(again, "no"))
            {
                System.out.println("Sorry didn't get that but guessing you quit.");
            }
            else
            {
            	System.out.println("Thanks for playing!");
            }
        }
	}
	}
        
	

	 private static double calculateMonthlyRepayment (double principal, double interestMonthly)
	 {
		 double numerator = (principal * interestMonthly);
		 double denominator1 = (1 + interestMonthly);
		 double denominator2 = Math.pow(denominator1, MORTGAGE_DURATION);
		 double denominator = (1 - denominator2);
		 double monthlyRepayment1 = ((numerator/denominator)*10);
		 double monthlyRepayment = Math.round(monthlyRepayment1 * 100.0) / 100.0;
		 return monthlyRepayment;
		 
	 }

	
	 private static String calculateMonthsToRepayMortgage (double principal, double affordedRepayment, double interestMonthly)
	 {
		 double numerator1 = (1-((principal)*(interestMonthly))/affordedRepayment);
		 double numerator2 = Math.pow(numerator1, -1);
		 double numerator = Math.log(numerator2);
		 double denominator1 = (1 + interestMonthly);
		 double denominator = Math.log(denominator1);
		 double timeToRepay = (numerator/denominator);
		 double years1 = Math.round(timeToRepay * 100.0) / 100.0;
		 double years = Math.round(years1);
		 double months1 = (years1 * MONTHS_IN_YEAR) - (years * MONTHS_IN_YEAR);
		 double months = Math.round(months1);
		
		 
		 String monthsToRepay = ("If you pay " + affordedRepayment + " per month your mortgage would be paid off in " + years + " years and " + months + " months");
		 
		 return monthsToRepay;
		 
		 
	 }
	 private static double readDoubleFromUser (String userPrompt)
	 {
		 Scanner input = new Scanner( System.in ); 
		 System.out.println(userPrompt);
		 double answer = 0.0;
		 if (input.hasNextDouble())
		 {
			 answer = input.nextDouble();
			 return answer;
		 }
		 else 
		 {
			 return readDoubleFromUser(userPrompt);
		 }
	 }
		 
	 }

