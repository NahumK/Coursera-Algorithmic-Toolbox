package Week4;
import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments 
{
	private static int binarySearch(int[] arr, int key, boolean lessOrEq)
	{
		int len = arr.length;
		int low = 0, high = len - 1, middle = 0, value = arr[middle];
		
		while(low <= high)
		{
			middle = low + (high - low)/2;
			value = arr[middle];
			
			if(key == value)
			{
				if(lessOrEq)
				{
					if((middle + 1 < len) && arr[middle + 1] == key)
						low = middle + 1;
					else 
						return middle + 1;
				}
				else
				{
					if((middle - 1 >= 0) && arr[middle - 1] == key)
						high = middle - 1;
					else 
						return middle;
				}
			}
			else if(key < value)
				high = middle - 1;
			else
				low = middle + 1;
		}
		
		if (value > key)
			return middle;
		else
			return middle + 1;
	}
	
	// Nber of segments N having point x on them is given by formula N = nStarts + nEnds - len
	// With nStarts =  number of segments with left end points l : l <= x
	// And with nEnds = number of segments having right end points  r : r >= x
	// And len = total number of segments
	
	private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) 
	{
		int nbPoints = points.length, len = starts.length;
		
		int[] counts = new int[nbPoints];
		
		Arrays.sort(starts);
		Arrays.sort(ends);
		
		for(int index = 0; index < nbPoints; index++)
		{
			int point = points[index];
			int nbSegStartLessPoint = binarySearch(starts, point, true);
			int nbSegEndGreaterPoint = len - binarySearch(ends, point, false);
			counts[index] = (nbSegEndGreaterPoint + nbSegStartLessPoint) - len;
		}
		
		return counts;
	}

	private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) 
	{
		int[] cnt = new int[points.length];

		for (int i = 0; i < points.length; i++) 
		{
			for (int j = 0; j < starts.length; j++) 
			{
				if (starts[j] <= points[i] && points[i] <= ends[j]) 
					cnt[i]++;
			}
		}

		return cnt;
	}

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];

        for (int i = 0; i < n; i++) 
        {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) 
            points[i] = scanner.nextInt();

        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);

        for (int x : cnt) 
            System.out.print(x + " ");

    }

}

