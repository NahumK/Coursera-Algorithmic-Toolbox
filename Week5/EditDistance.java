package Week5;
import java.util.*;

class EditDistance 
{
	
	public static int min(int a, int b, int c)
	{
		int min = a;
		
		if(b < a)
			min = b;
		if(c < min)
			return c;
		
		return min;
	}
	
	public static int EditDistance(String firstStr, String secondStr) 
	{
		//write your code here
		
		int len1 = firstStr.length(), len2 = secondStr.length();
		
		int[][] matrice = new int[len1 + 1][len2 + 1];
		
		// Initialize the matrice
		for(int i = 1; i <= len1; i++)
			matrice[i][0] = i;
		
		for(int j = 1; j <= len2; j++)
			matrice[0][j] = j;
		
		// Fill the matrice 
		for(int colIdx = 1; colIdx <= len2; colIdx++)
		{
			for(int rowIdx = 1; rowIdx <= len1; rowIdx++)
			{
				int insertion = matrice[rowIdx][colIdx - 1] + 1;
				int deletion = matrice[rowIdx - 1][colIdx] + 1;
				int match = matrice[rowIdx - 1][colIdx - 1];
				int mismatch = matrice[rowIdx - 1][colIdx - 1] + 1;
				
				if(firstStr.charAt(rowIdx - 1) == secondStr.charAt(colIdx - 1))
					matrice[rowIdx][colIdx] = min(insertion, deletion, match);
				else
					matrice[rowIdx][colIdx] = min(insertion, deletion, mismatch);	
			}
		}
		
		return matrice[len1][len2];
	}

	public static void main(String args[]) 
	{
		Scanner scan = new Scanner(System.in);

		String firstStr = scan.next();
		String secondStr = scan.next();

		System.out.println(EditDistance(firstStr, secondStr));
	}

}
