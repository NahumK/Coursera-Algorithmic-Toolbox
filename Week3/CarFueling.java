package Week3;


import java.util.*;
import java.io.*;

public class CarFueling 
{
    static int computeMinRefills(int dist, int tank, int[] stops) 
    {
    	int numRefills = 0;
    	int currRefillIdx = 0;
    	int nbStops = stops.length - 1;
    	
    	while(currRefillIdx < nbStops)
    	{
    		int lastRefillIdx = currRefillIdx;
    		
    		while((currRefillIdx < nbStops) && ((stops[currRefillIdx + 1] - stops[lastRefillIdx]) <= tank))
    			currRefillIdx++;
    		
    		if(currRefillIdx == lastRefillIdx)
    			return -1;
    		
    		if(currRefillIdx < nbStops)
    			numRefills++;
    	}
    	
        return numRefills;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        
        int stops[] = new int[n + 2];
        stops[n + 1] = dist;
        
        for (int i = 1; i <= n; i++) 
            stops[i] = scanner.nextInt();

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
