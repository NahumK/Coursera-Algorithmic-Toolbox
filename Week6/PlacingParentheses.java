package Week6;
import java.util.Scanner;

public class PlacingParentheses 
{
	private static long[] minAndMax(int i, int j, char[] operands, 
			long[][]minMatrice, long[][]maxMatrice)
	{
		long[] minMax = new long[2];
		
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		
		for(int k = i; k < j; k++)
		{
			char op = operands[k];
			long a = eval(maxMatrice[i][k], maxMatrice[k + 1][j], op);
			long b = eval(maxMatrice[i][k], minMatrice[k + 1][j], op);
			long c = eval(minMatrice[i][k], maxMatrice[k + 1][j], op);
			long d = eval(minMatrice[i][k], minMatrice[k + 1][j], op);
			
			min = Math.min(Math.min(min, Math.min(a, b)), Math.min(c, d));
			max = Math.max(Math.max(max, Math.max(a, b)), Math.max(c, d));
		}
		
		minMax[0] = min;
		minMax[1] = max;
		
		return minMax;
	}
	
	private static long parentheses(int[] digits, char[] operands)
	{
		int len = digits.length;
		
		long[][] minMatrice = new long[len][len];
		long[][] maxMatrice = new long[len][len];
		
		for(int i = 0; i < len; i++)
			minMatrice[i][i] = maxMatrice[i][i] = digits[i];
		
		for(int s = 1; s < len; s++)
		{
			for(int i = 0; i < len - s; i++)
			{
				int j = i + s;
				long[] minMax = minAndMax(i, j, operands, minMatrice, maxMatrice);
				minMatrice[i][j] = minMax[0];
				maxMatrice[i][j] = minMax[1];
 			}
		}
		
		return  maxMatrice[0][len - 1];
	}
	
	private static long getMaximValue(String exp) 
	{
		//write your code here
		int len = exp.length();
		int n = (len + 1) / 2;
		
		int[] digits = new int[n];
		char[] operands = new char[n - 1];
		
		for(int i = 0; i < len; i++)
		{
			int index = i / 2;
			
			if(i % 2 == 0)
				digits[index] = Integer.parseInt("" + exp.charAt(i));
			else
				operands[index] = exp.charAt(i);
		}
		
		return parentheses(digits, operands);
	}
	

	private static long eval(long a, long b, char op) 
	{
		if (op == '+') 
			return a + b;
		else if (op == '-') 
			return a - b;
		else if (op == '*') 
			return a * b;
		else 
		{
			assert false;
			return 0;
		}
	}

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		String exp = scanner.next();
		
		System.out.println(getMaximValue(exp));
	}
}

