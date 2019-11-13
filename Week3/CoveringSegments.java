package Week3;
import java.util.*;

public class CoveringSegments 
{
 
	private static ArrayList<Integer> optimalPoints(ArrayList<Segment> segments) 
    {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while(segments.size() > 0)
		{
			int optimalPoint = Segment.minEndSegments(segments);
			ArrayList<Segment> tmpSegments = new ArrayList<Segment>();
			
			for(Segment segment : segments)
			{
				if(!segment.contains(optimalPoint))
					tmpSegments.add(segment);
			}
			
			segments = tmpSegments;
			
			result.add(optimalPoint);
		}
		
        return result;
    }

    private static class Segment 
    {
        int start, end;

        Segment(int start, int end) 
        {
            this.start = start;
            this.end = end;
        }
        
        public boolean contains(int point)
        {
        	if((start <= point) && (end >= point))
        		return true;
        	return false;
        }
        
        public static int minEndSegments(ArrayList<Segment> segments)
        {
        	int min = 1000 * 1000 * 1000;
        	
        	for(Segment segment : segments)
        	{
        		if(segment.end < min)
        			min = segment.end;
        	}
        	
        	return min;
        }
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        ArrayList<Segment> segments = new ArrayList<Segment>();
        
        for (int i = 0; i < n; i++) 
        {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments.add(new Segment(start, end));
        }
        
        ArrayList<Integer> result = optimalPoints(segments);
        int len = result.size();
       
        System.out.println(len);
        
        for(int point : result)
        	System.out.print(point + " ");
        
    }
}
 
