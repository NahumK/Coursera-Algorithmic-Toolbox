package Week4;
import java.util.*;
import java.io.*;

public class MajorityElement 
{
	private static int getMajorityElement(int[] a) 
	{
		HashMap<Integer, Integer> countElts = new HashMap<Integer, Integer>();
		int len = a.length, majElt = -1, maxCount = 0;

		for(int index = 0; index < len; index++)
		{
			int elt = a[index], count = 1;
			if(countElts.containsKey(elt))
				count = countElts.get(elt) + 1;
			countElts.put(elt, count);

			if(count > maxCount)
			{
				maxCount = count;
				majElt = elt;
			}

		}

		if(maxCount > (len / 2))
			return majElt;

		return -1;
	}

	public static void main(String[] args) 
	{
		FastScanner scanner = new FastScanner(System.in);

		int n = scanner.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) 
			a[i] = scanner.nextInt();
		
		int majorityElt = getMajorityElement(a);
		
		//System.out.println("Majority Element : " + majorityElt);

		if (majorityElt != -1) 
			System.out.println(1);
		else 
			System.out.println(0);

	}

	static class FastScanner 
	{
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) 
		{
			try 
			{
				br = new BufferedReader(new InputStreamReader(stream));
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}

		String next() 
		{
			while (st == null || !st.hasMoreTokens()) 
			{
				try 
				{
					st = new StringTokenizer(br.readLine());
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}

			return st.nextToken();

		}

		int nextInt() 
		{
			return Integer.parseInt(next());
		}
	}

}

