package Week5;
import java.util.*;

public class PrimitiveCalculator 
{
	private static List<Integer> optimalSequence(int number) 
	{
		List<Integer> sequence = new ArrayList<Integer>();
		int[] minOperations = new int[number + 1];

		// Compute the minimal number of operations for each value from 2 to number
		for(int n = 2; n <= number; n++)
		{
			int minNberOper = Integer.MAX_VALUE;

			if((n % 3 == 0) && (minOperations[n / 3] < minNberOper))
				minNberOper = minOperations[n / 3];

			if((n % 2 == 0) && (minOperations[n / 2] < minNberOper))
				minNberOper = minOperations[n / 2];

			if(minOperations[n - 1] < minNberOper)
				minNberOper = minOperations[n - 1];

			minOperations[n] = minNberOper + 1;
		}
		
		int optimalVal = number;
		
		// Compute the optimal sequence
		while(optimalVal > 1)
		{
			sequence.add(optimalVal);
			
			int minNberOper = Integer.MAX_VALUE, n = optimalVal;
			
			if((n % 3 == 0) && (minOperations[n / 3] < minNberOper))
			{
				optimalVal = n / 3;
				minNberOper = minOperations[optimalVal];
			}
			if((n % 2 == 0) && (minOperations[n / 2] < minNberOper))
			{
				optimalVal = n / 2;
				minNberOper = minOperations[optimalVal];
			}
			if(minOperations[n - 1] < minNberOper)
			{
				optimalVal = n - 1;
				minNberOper = minOperations[optimalVal];
			}
			
		}
		
		sequence.add(1);
		
		Collections.sort(sequence);

		return sequence;
	}

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		List<Integer> sequence = optimalSequence(n);
		System.out.println(sequence.size() - 1);

        for (Integer x : sequence) 
            System.out.print(x + " ");

	}

}

