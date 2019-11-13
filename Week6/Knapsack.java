package Week6;
import java.util.*;

public class Knapsack 
{
    static int optimalWeight(int totalWeight, int[] weights) 
    {
    	
    	int nberItems = weights.length;
    	
    	int[][] values = new int[nberItems + 1][totalWeight + 1];
    	
    	for(int i = 1; i <= nberItems; i++)
    	{
    		for(int weight = 1; weight <= totalWeight; weight++)
    		{
    			values[i][weight] = values[i - 1][weight];
    			int wi = weights[i - 1];
    			
    			if(wi <= weight)
    			{
    				int val = values[i - 1][weight - wi] + wi;
    				
    				if(values[i][weight] < val)
    					values[i][weight] = val;
    			}
    		}
    	}
    	
    	
        return values[nberItems][totalWeight];
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int totalWeight = scanner.nextInt();
        int nberItems = scanner.nextInt();
        
        int[] weights = new int[nberItems];
        
        for (int i = 0; i < nberItems; i++) 
            weights[i] = scanner.nextInt();
        
        System.out.println(optimalWeight(totalWeight, weights));
    }
}

