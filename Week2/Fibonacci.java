package Week2;
import java.util.Scanner;

public class Fibonacci 
{
	private static long calc_fib(int n) 
	{
		int[] fibonnacis = new int[n + 2];

		fibonnacis[0] = 0;
		fibonnacis[1] = 1;

		for(int i = 2; i <= n; i++)
			fibonnacis[i] = fibonnacis[i - 1] + fibonnacis[i - 2];

		return fibonnacis[n];
	}

	public static void main(String args[]) 
	{
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		System.out.println(calc_fib(n));
	}
}
