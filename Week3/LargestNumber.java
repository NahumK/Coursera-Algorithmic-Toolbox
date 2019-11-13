package Week3;
import java.util.*;

public class LargestNumber 
{
	private static int optimalMax (int firstVal, int secondVal)
	{
		int val1 = Integer.parseInt("" + firstVal + "" + secondVal); 
		int val2 = Integer.parseInt("" + secondVal + "" + firstVal);
		
		if(val1 > val2)
			return firstVal;
		else
			return secondVal;
	}
	
    private static String largestNumber(ArrayList<Integer> numbers) 
    {
        //write your code here
        String result = "";
        
        while(numbers.size() > 0)
        {
        	int maxValue = 0;
        	
        	for(int value : numbers)
        		maxValue = optimalMax(maxValue, value);
        	
        	result += maxValue;
        	numbers.remove(new Integer(maxValue));
        }
        
        return result;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++) 
        	numbers.add(scanner.nextInt());
        
        System.out.println(largestNumber(numbers));
    }
    
}

