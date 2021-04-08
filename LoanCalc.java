
/**
* Course: Intro To Computer Science
* Homework: 4
* Task: 1
* Name: Guy Itzhaki
* E-mail: itzhaki1234@gmail.com
*/

/**
* Calculates the periodical payment necessary to re-pay a given loan,
*/
public class LoanCalc
 {
	
	static int iterationCounterBrute=0;  // monitors the efficiency of the calculation
	static int iterationCounterBisection=0;  // monitors the efficiency of the calculation

    /** Gets the loan data and computes the periodical payment,
     * using two methods: brute force search, and bisection search.  
     */
	public static void main(String[] args)
	{
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		
		double epsilon = 0.001;  // the computation tolerance / accuracy
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment: ");
		System.out.printf("%.2f",solveByBruteForceSearch(loan,rate,n,epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounterBrute);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment: ");
		System.out.printf("%.2f",solveByBisectionSearch(loan,rate,n,epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounterBisection);
	}
	
	/**
	* Uses a brute force search method to compute an approximation of
	* the periodical payment that will bring the ending balance of a loan to 0.
	* Given: the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double solveByBruteForceSearch(double loan, double rate, int n, double epsilon)
	{
    	// Replace the next statement with your code
		double yearsum=loan/n;
    	double end=endBalance(loan, rate, n, yearsum);
    	while (end>0)
		{
			yearsum=yearsum+epsilon;
			iterationCounterBrute++;
			end=endBalance(loan, rate, n, yearsum);
		}
		return yearsum;
    }
    
    /**
	* Uses a bisection search method to compute an approximation of
	* the periodical payment that will bring the ending balance of a loan to 0.
	* Given: the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double solveByBisectionSearch(double loan, double rate, int n, double epsilon)
	{
    	// Replace the next statement with your code
		double lo=loan/n;
		double hi=loan/2;
		double mid=(lo+hi)/2;
		while ((hi-lo)/2>epsilon)
		{
			if ((endBalance(loan, rate, n, lo))*(endBalance(loan, rate, n, mid))>0)
				lo=mid;
			else
				hi=mid;
			mid=(lo+hi)/2;
			iterationCounterBisection++;
		}
        return lo;
    }
	
	/**
	* Computes the ending balance of a loan, given: the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double payment)
	{
		// Replace the next statement with your code
		double sumleft=loan;
		for (int i=1; i<=n; i++)
			sumleft=(sumleft-payment)*(1.0+(rate/100.0));
        return sumleft;
	}
}