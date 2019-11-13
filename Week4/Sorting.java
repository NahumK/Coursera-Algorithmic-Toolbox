package Week4;
import java.io.*;
import java.util.*;

public class Sorting 
{
	private static Random random = new Random();

	private static int[] partition3(int[] arr, int start, int end) 
	{
		//write your code here
		
		int pivot = arr[start];
		int indexMaxLess = start, tmp;
		
		for(int i = start + 1; i <= end; i++)
		{
			if (arr[i] < pivot) 
			{
				indexMaxLess++;
				tmp = arr[i];
				arr[i] = arr[indexMaxLess];
				arr[indexMaxLess] = tmp;
			}
		}
		
		tmp = arr[start];
		arr[start] = arr[indexMaxLess];
		arr[indexMaxLess] = tmp;
		
		int indexMinGreater = indexMaxLess;
		
		for(int i = indexMaxLess + 1; i <= end; i++)
		{
			if (arr[i] == pivot) 
			{
				indexMinGreater++;
				tmp = arr[i];
				arr[i] = arr[indexMinGreater];
				arr[indexMinGreater] = tmp;
			}
		}
		
		int[] result = {indexMaxLess, indexMinGreater};
		
		return result;
	}

	private static int partition2(int[] arr, int start, int end) 
	{
		int pivot = arr[start];
		int indexMaxLess = start;

		for (int i = start + 1; i <= end; i++) 
		{

			if (arr[i] <= pivot) 
			{
				indexMaxLess++;
				int tmp = arr[i];
				arr[i] = arr[indexMaxLess];
				arr[indexMaxLess] = tmp;
			}
		}

		int tmp = arr[start];
		arr[start] = arr[indexMaxLess];
		arr[indexMaxLess] = tmp;

		return indexMaxLess;
	}

	private static void randomizedQuickSort(int[] arr, int start, int end) 
	{
		if (start >= end) 
			return;

		// Random number between start and end
		int k = random.nextInt(end - start + 1) + start;
		// swap arr[l] and arr[k]
		int tmp = arr[start];
		arr[start] = arr[k];
		arr[k] = tmp;

		//use partition3
		//int middle = partition2(arr, start, end);
		int[] partitions = partition3(arr, start, end);
		randomizedQuickSort(arr, start, partitions[0] - 1);
		randomizedQuickSort(arr, partitions[1] + 1, end);
	}

	public static void main(String[] args) 
	{
		FastScanner scanner = new FastScanner(System.in);

		int n = scanner.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) 
			a[i] = scanner.nextInt();

		randomizedQuickSort(a, 0, n - 1);

		for (int i = 0; i < n; i++) 
			System.out.print(a[i] + " ");

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

