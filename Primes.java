/**
* Course: Intro To Computer Science
* Homework: 4
* Task: 2
* Name: Guy Itzhaki
* E-mail: itzhaki1234@gmail.com
*/
public class Primes
{
	public static boolean isPrime (int num)
	{
		double div=num;
		for (int i=2; i<=Math.sqrt(num); i++) 
			if (num%i==0)
				return false;
		return true;
	}

	public static void main(String[] args) 
	{
		/* First code, changed to arrays...
		
		int N = Integer.parseInt(args[0]);
		System.out.println("The Primes from 2 to "+N+" are:");
		for (int i=2; i<N; i++) 
			if (isPrime(i))
				System.out.println(i);
		**/

		int N = Integer.parseInt(args[0]);
		Boolean[] isPrimes=new Boolean[N];
		for (int i=0; i<isPrimes.length; i++)
			if (isPrime(i))
				isPrimes[i]=true;
			else
				isPrimes[i]=false;
		System.out.println("The Primes from 2 to "+N+" are:");
		for (int i=0; i<isPrimes.length; i++) 
			if (isPrimes[i])
				System.out.println(i);
	}
}