package Week2;
import java.util.*;

public class FibonacciPartialSum 
{
	private static long getFibonacciPartialSumNaive(long from, long to) 
	{
		long sum = 0;

		long current = 0;
		long next  = 1;

		for (long i = 0; i <= to; ++i) 
		{
			if (i >= from) {
				sum += current;
			}

			long new_current = next;
			next = next + current;
			current = new_current;
		}

		return sum % 10;
	}

	private static long getFibonacciPartialSum(long from, long to) 
	{
		if(to <= 1)
			return to;

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

		// Compute remainders
		long start = from % period;
		long end = to % period, sum = 0;

		// Compute the sum 
		sum = (10 + (fiboMod.get(end + 2) - fiboMod.get(start + 1))) % 10;

		return sum;
	}

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		long from = scanner.nextLong();
		long to = scanner.nextLong();

		System.out.println(getFibonacciPartialSum(from, to));
	}
}

