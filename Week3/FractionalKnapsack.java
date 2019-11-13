package Week3;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FractionalKnapsack 
{
    private static double getOptimalValue(int capacity, int[] values, int[] weights) 
    {
        double value = 0;
        //write your code here
        
        HashMap<Double, Integer> unitValues = new HashMap<Double, Integer>();
        int len = values.length;
        
        for(int index = 0; index < len; index++)
        {
        	double unitValue = 0;
        	int weight = weights[index];
        	
        	if(weight > 0)
        		unitValue = (double)(values[index]) / weight;
        	
        	unitValues.put(unitValue, weight);
        }
        
        ArrayList<Double> sortedUnitValues = new ArrayList<Double>(unitValues.keySet());
        Collections.sort(sortedUnitValues, Collections.reverseOrder());
        
        for(double val : sortedUnitValues)
        {
        	if(capacity == 0)
        		return value;
        	
        	int weight = unitValues.get(val);
        	int addWeight = Math.min(weight, capacity);
        	value += addWeight * val;
        	capacity -= addWeight;
        	
        }

        return value;
        
    }

    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        
        int[] values = new int[n];
        int[] weights = new int[n];
        
        for (int i = 0; i < n; i++) 
        {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
