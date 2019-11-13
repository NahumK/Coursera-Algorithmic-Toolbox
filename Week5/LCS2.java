package Week5;
import java.util.*;

public class LCS2 
{

	private static int lcs2(int[] firstStr, int[] secondStr) 
	{
		//Write your code here
		
		int len1 = firstStr.length, len2 = secondStr.length;
		
		int[][] matrice = new int[len1 + 1][len2 + 1];
		
		for(int i = 1; i <= len1; i++)
		{
			for(int j = 1; j <= len2; j++)
			{
				if(firstStr[i - 1] == secondStr[j - 1])
					matrice[i][j] = matrice[i - 1][j - 1] + 1;
				else
					matrice[i][j] = Math.max(matrice[i - 1][j], matrice[i][j - 1]);
			}
		}
		
		return matrice[len1][len2];
	}

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] firstStr = new int[n];

		for (int i = 0; i < n; i++) 
			firstStr[i] = scanner.nextInt();

		int m = scanner.nextInt();
		int[] secondStr = new int[m];

		for (int i = 0; i < m; i++) 
			secondStr[i] = scanner.nextInt();
		
		System.out.println(lcs2(firstStr, secondStr));
	}

}

