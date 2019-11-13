package Week2;
import java.util.*;

public class FibonacciHuge 
{
    private static long getFibonacciHugeNaive(long n, long m) 
    {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) 
        {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    
    private static long getFibonacciHuge(long n, long m)
    {
    	
    	if(n <= 1)
    		return n;
    	
    	Hashtable<Long, Long> fiboMod = new Hashtable<Long, Long>();
    	
    	fiboMod.put(0L, 0L);
    	fiboMod.put(1L, 1L);
    	
    	long index = 2, len = m * m;
    	
    	// Compute the Pisano period
    	while(index <= len)
    	{
    		long fibModPrec = fiboMod.get(index - 1);
    		long fibModAct = (fibModPrec + fiboMod.get(index - 2)) % m;
    		
    		fiboMod.put(index, fibModAct);
    		
    		if((fibModAct == 1L) && (fibModPrec == 0L))
    			break;
    		
    		index++;
    	}
    	
    	long period = index - 1;
    	
    	// Compute remainder
    	long remainder = n % period;
    	
    	return fiboMod.get(remainder);
    }
    
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        
        System.out.println(getFibonacciHuge(n, m));
    }
}

