package Week5;
import java.util.*;

public class LCS3 
{

	private static int max(int a, int b, int c)
	{
		int max = a;
		
		if(b > a)
			max = b;
		
		if(c > max)
			return c;
		
		return max;
	}
	
    private static int lcs3(int[] firstStr, int[] secondStr, int[] thirdStr) 
    {
        //Write your code here
    	
    	int len1 = firstStr.length, len2 = secondStr.length, len3 = thirdStr.length;
    	
    	int[][][] matrice = new int[len1 + 1][len2 + 1][len3 + 1];
    	
    	for(int i = 1; i <= len1; i++)
    	{
    		for(int j = 1; j <= len2; j++)
    		{
    			for(int k = 1; k <= len3; k++)
    			{
    				if((firstStr[i - 1] == secondStr[j - 1]) && (secondStr[j - 1] == thirdStr[k - 1]))
    					matrice[i][j][k] = 1 + matrice[i - 1][j - 1][k - 1];
    				else
    					matrice[i][j][k] = max(matrice[i - 1][j][k], matrice[i][j - 1][k], matrice[i][j][k - 1]);
    			}
    		}
    	}
    	
        return matrice[len1][len2][len3];
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int len1 = scanner.nextInt();
        int[] firstStr = new int[len1];
        
        for (int i = 0; i < len1; i++) 
            firstStr[i] = scanner.nextInt();
        
        int len2 = scanner.nextInt();
        int[] secondStr = new int[len2];
        
        for (int i = 0; i < len2; i++) 
            secondStr[i] = scanner.nextInt();
        
        int len3 = scanner.nextInt();
        int[] thirdStr = new int[len3];
        
        for (int i = 0; i < len3; i++) 
            thirdStr[i] = scanner.nextInt();
        
        System.out.println(lcs3(firstStr, secondStr, thirdStr));
    }
}

