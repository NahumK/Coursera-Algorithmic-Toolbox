package Week2;
import java.util.*;

public class FibonacciLastDigit 
{
    private static int getFibonacciLastDigitNaive(int n) 
    {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) 
        {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    
    private static int getFibonacciLastDigit(int n)
    {
    	int[] fibonnacis = new int[n + 2];
    	
    	fibonnacis[0] = 0;
    	fibonnacis[1] = 1;
    	
    	for(int i = 2; i <= n; i++)
    		fibonnacis[i] = (fibonnacis[i - 1] + fibonnacis[i - 2]) % 10;
    	
    	return fibonnacis[n];
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        
        System.out.println(c);
    }
}

