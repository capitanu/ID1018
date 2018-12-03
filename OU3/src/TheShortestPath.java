public class TheShortestPath {
	public static int[] intermediateStations (double [] a, double b[][], double [] c)
	{
		double d = a[0] + b[0][0] + c[0];
		int[] locationOfTheStation = new int[3];
		for( int i = 0; i < a.length; i++)
			for ( int j = 0; j < b.length; j++ )
						if(a[i] + b[i][j] + c[j] < d)
						{
							d = a[i] + b[i][j] + c[j];
							locationOfTheStation[1] = i + 1;
							locationOfTheStation[2] = j + 1;
						}
					
						
		
			
				
		return locationOfTheStation;
	}
	
	public static double length (double [] a, double [][] b, double [] c)
	{
		double d = a[0] + b[0][0] + c[0];
		for( int i = 0; i < a.length; i++)
			for ( int j = 0; j < b.length; j++ )
				if(a[i] + b[i][j] + c[j] < d)
					d = a[i] + b[i][j] + c[j];						
		
		
		return d;
	}

}
