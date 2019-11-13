package Week3;
import java.util.*;

public class DifferentSummands 
{
	private static int sum(int n)
	{
		int result = (n * (n + 1)) / 2;
		return result;
	}
	
	/*
	 *  1 + 2 + 3 + ... + n + r = N with n < r
	 *  we also have 1 + 2 + 3 ... + n = n(n + 1) / 2 that means
	 *  (n(n + 1) / 2) + r = N with n < r we have then (n(n + 1) / 2) + n < N
	 *  that means n^2 + 3n - 2N < 0
	 *  We have n < (-3 + sqrt(9 + 8N)) / 2
	 */
    private static List<Integer> optimalSummands(int N) 
    {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        long delta = 9 + (8 * (long)N);
        int n = (int)(-3 + Math.sqrt(delta)) / 2; 
        int sum = sum(n);
        int r = N - sum;
        
        while(n >= r)
        {
        	n--;
        	sum = sum(n);
        	r = N - sum;
        }
        
        for(int summand = 1; summand <= n; summand++)
        	summands.add(summand);
        
        summands.add(r);
        
        return summands;
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        
        System.out.println(summands.size());
        
        for (Integer summand : summands) 
            System.out.print(summand + " ");
        
    }
    
}

