package Week5;

import java.util.HashMap;
import java.util.Scanner;

public class ChangeDP 
{
    private static int getChange(int money, int[] coins) 
    {
        //write your code here
    	HashMap<Integer, Integer> minNumCoins = new HashMap<Integer, Integer>();
    	minNumCoins.put(0, 0);
    	
    	for(int amount = 1; amount <= money; amount++)
    	{
    		minNumCoins.put(amount, Integer.MAX_VALUE);
    		
    		for(int coin : coins)
    		{
    			if(amount >= coin)
    			{
    				int coinChange = amount - coin;
    				int nbCoins = minNumCoins.get(coinChange) + 1;
    				
        			if(nbCoins < minNumCoins.get(amount))
        				minNumCoins.put(amount, nbCoins);
    			}
    		}
    	}
    	
        return minNumCoins.get(money);
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int[] coins = {1, 3, 4};
        
        int money = scanner.nextInt();
        
        System.out.println(getChange(money, coins));
        
    }
}

