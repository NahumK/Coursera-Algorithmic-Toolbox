package Week4;
import java.util.*;

public class Inversions 
{
	private static long getNumberOfInversions(int[] arr, int[] result)
	{
		int len = arr.length;
		long numberOfInversions = 0;

		if(len <= 1)
			return numberOfInversions;

		int middle = len / 2;

		int[] arr2 = Arrays.copyOfRange(arr, 0, middle), result2 = Arrays.copyOfRange(arr, 0, middle);
		numberOfInversions += getNumberOfInversions(arr2, result2);

		int[] arr3 = Arrays.copyOfRange(arr, middle, len), result3 = Arrays.copyOfRange(arr, middle, len);
		numberOfInversions += getNumberOfInversions(arr3, result3);

		numberOfInversions += merge(result2, result3, result);

		return numberOfInversions;
	}

	private static long merge(int[] arr1, int[] arr2, int[] result)
	{
		long numberOfInversions = 0;
		int len1 = arr1.length, len2 = arr2.length, index1 = 0, index2 = 0, index = 0;

		while((index1 < len1) && (index2 < len2))
		{
			int elt1 = arr1[index1];
			int elt2 = arr2[index2];

			if(elt1 <= elt2)
			{
				result[index] = elt1;
				index1++;
			}
			else
			{
				result[index] = elt2;
				index2++;
				//(len1 - index1) = nber of remaining elts in arr1 they are all > elt2
				numberOfInversions += (len1 - index1);
			}
			index++;
		}

		while(index1 < len1)
		{
			result[index] = arr1[index1];
			index++;
			index1++;
		}

		while(index2 < len2)
		{
			result[index] = arr2[index2];
			index++;
			index2++;
		}

		return numberOfInversions;
	}


	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) 
			arr[i] = scanner.nextInt();

		int[] result = new int[n];

		System.out.println(getNumberOfInversions(arr, result));
	}
}

