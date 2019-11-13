package Week3;
import java.util.*;

public class DotProduct 
{
    private static long maxDotProduct(ArrayList<Integer> a, ArrayList<Integer> b) 
    {
        //write your code here
        long result = 0;
        int len = a.size();
        
        for (int index = 0; index < len; index++)
            result += ((long)a.get(index) * b.get(index));

        return result;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++)
            a.add(scanner.nextInt());
        
        Collections.sort(a, Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) 
        	b.add(scanner.nextInt());
        
        Collections.sort(b, Collections.reverseOrder());
        
        System.out.println(maxDotProduct(a, b));
    }
}

