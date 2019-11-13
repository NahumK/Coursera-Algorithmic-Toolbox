package Week2;
import java.util.*;

public class FibonacciSumSquares 
{
	private static long getFibonacciSumSquaresNaive(long n) 
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
			sum += current * current;
		}

		return sum % 10;
	}

	private static long getFibonacciSumSquares(long n) 
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
		long remainder = n % period, sumQuadrat = 0;

		// Compute the sum 
		sumQuadrat = (fiboMod.get(remainder) * fiboMod.get(remainder + 1)) % 10;
		
		return sumQuadrat;
	}

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		long n = scanner.nextLong();
		long s = getFibonacciSumSquares(n);

		System.out.println(s);
	}
}

