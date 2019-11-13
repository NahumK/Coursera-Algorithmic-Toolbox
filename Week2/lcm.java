package Week2;
import java.util.*;

public class lcm 
{
	private static long lcm_naive(int a, int b) 
	{
		for (long l = 1; l <= (long) a * b; ++l)
			if (l % a == 0 && l % b == 0)
				return l;

		return (long) a * b;
	}

	private static long gcd(long a, long b)
	{	
		while(b > 0)
		{
			long tmp = b;
			b = a % b;
			a = tmp;
		}

		return a;
	}
	
	private static long lcm(long a, long b)
	{
		long gcdVal = gcd(a, b);
		
		long result = (a / gcdVal) * b;
		
		return result;
	}

	public static void main(String args[]) 
	{
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		int b = scanner.nextInt();

		System.out.println(lcm(a, b));
	}
}
