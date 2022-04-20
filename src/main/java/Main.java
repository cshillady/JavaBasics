import java.text.NumberFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {
        // Declare variables.  Using doubles to eliminate need for conversion later.
        int principal = 0;
        double interestRateAnnual = -1.0;
        double interestRateMonth;
        int termYears = 0;
        double termMonths;
        double monthlyMortgageRate;
        double parenthesesToPower;
        double formulaNumerator;
        double formulaDenominator;
        String mortgagePayment;

        logo();
        System.out.print(" Welcome to Connor Cares Loan Company!  \n\n");

        // Get information from the user with restrictions on input.
        while (principal < 10_000 || principal > 500_000_000)
        {
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Please enter your loan principal amount from $10,000 and $500,000,000.  Please only use numbers; omit commas and the $.\n");
            principal = scanner1.nextInt();
        }
        while (interestRateAnnual < 0.00 || interestRateAnnual > 25.00)
        {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("\nPlease enter your Annual Interest Rate from 0.00 to 25.00 percent.  Please use just a number up to two decimal places.");
            interestRateAnnual = scanner2.nextDouble();
        }
        while (termYears < 5 || termYears > 60)
        {
            Scanner scanner3 = new Scanner(System.in);
            System.out.println("\nPlease enter the term of your loan in years from 5 to 60 years.  Please use whole number years using just numbers.");
            termYears = scanner3.nextInt();
        }

        // Calculate monthly interest rate and term in months.
        interestRateAnnual = interestRateAnnual / 100;
        interestRateMonth = interestRateAnnual / 12;
        termMonths = (double)termYears * 12;

        // Generate monthly payment using Mortgage Formula.
        parenthesesToPower = Math.pow((interestRateMonth + 1), termMonths);
        formulaNumerator = interestRateMonth * parenthesesToPower;
        formulaDenominator = parenthesesToPower - 1;
        monthlyMortgageRate = (double)principal * (formulaNumerator / formulaDenominator);

        // Convert calculated mortgage rate to currency string.
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        mortgagePayment = currency.format(monthlyMortgageRate);

        // Monthly Payment results output.
        System.out.println("\nThank you for your inputs.  We are calculating your payment amount...");
        try
        {
            TimeUnit.SECONDS.sleep(2);
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
        System.out.println("Thank you for your patience. \n");
        System.out.println("Your monthly mortgage payment will be:  " + mortgagePayment + ".  Thank you again for choosing Connor Cares Loan Company!!  \n\n");
    }
    public static String logo()  // ASCII Art logo for visual flair.
    {
        System.out.print("\n");
        System.out.print("         #######      #######   \n");
        System.out.print("        #########    #########  \n");
        System.out.print("       ###     ###  ###     ### \n");
        System.out.print("       ###     ###  ###     ### \n");
        System.out.print("       ###          ###         \n");
        System.out.print("       ###  Connor  ###   Cares \n");
        System.out.print("       ###          ###         \n");
        System.out.print("       ###     ###  ###     ### \n");
        System.out.print("       ###     ###  ###     ### \n");
        System.out.print("        #########    #########  \n");
        System.out.print("         #######      #######   \n\n");

        return "";
    }
}