package Week2;
import java.util.*;

public class FibonacciSumLastDigit 
{
	private static long getFibonacciSumNaive(long n) 
	{
		if (n <= 1)
			return n;

		long previous = 0;
		long current  = 1;
		long sum      = 1;

		for (long i = 0; i < n - 1; ++i) 
		{
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
			sum += current;
		}

		return sum % 10;
	}

	private static long getFibonacciSum(long n)
	{
		if(n <= 1)
			return n;

		Hashtable<Long, Long> fiboMod = new Hashtable<Long, Long>();

		fiboMod.put(0L, 0L);
		fiboMod.put(1L, 1L);

		long index = 2, len = 100;

		// Compute the Pisano period
		while(index <= len)
		{
			long fibModPrec = fiboMod.get(index - 1);
			long fibModAct = (fibModPrec + fiboMod.get(index - 2)) % 10;

			fiboMod.put(index, fibModAct);

			if((fibModAct == 1L) && (fibModPrec == 0L))
				break;

			index++;
		}

		long period = index - 1;

		// Compute remainder
		long remainder = n % period, sum = 0;
		
		// Compute the sum 
		sum = (10 + (fiboMod.get(remainder + 2) - 1)) % 10;

		return sum;
	}

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		long n = scanner.nextLong();
		long s = getFibonacciSum(n);

		System.out.println(s);
	}
}

