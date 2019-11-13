package Week3;
import java.util.Scanner;

public class Change 
{

	private static int getChange(int m) 
	{
		//write your code here
		int[] coins = {10, 5, 1};
		int nbCoins = 0, change = m;

		for(int index = 0; index < 3; index++)
		{
			if(change == 0)
				return nbCoins;

			int coin = coins[index];

			if(change >= coin)
			{
				int toRemove = change - (change % coin);
				nbCoins += (toRemove / coin);
				change -= toRemove;
			}
		}

		return nbCoins;
	}

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		int m = scanner.nextInt();

		System.out.println(getChange(m));
	}
}

