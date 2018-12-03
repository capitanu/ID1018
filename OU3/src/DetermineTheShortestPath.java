import java.util.*;
public class DetermineTheShortestPath {
	public static void main(String[] args)
	{
		
		int m,n;
		Scanner in = new Scanner(System.in);
		System.out.print("Input the number of Z2 stations: ");
		m = in.nextInt();
		System.out.print("Input the number of Z3 stations: ");
		n = in.nextInt();
		double a[] = new double[m];
		// reading distances from Z1 to Z2
		for ( int i = 0; i < m; i++)
		{
			System.out.print("Distance from X to U" + (i+1) + ": ");
			a[i] = in.nextDouble();
		}
		
		
		double[][] b  = new double [m][n];
		// reading distances from Z2 to Z3
		for ( int i = 0; i < m; i++)
			for ( int j = 0; j <n; j++ )
			{
				System.out.print("Distance from U" + (i+1) + " to V" + (j+1) + ": ");
				b[i][j] = in.nextDouble();
			}
		double[] c = new double [n];
		// reading distances from Z3 to Z4
		for ( int j = 0; j < n; j++)
		{
			System.out.print("Distance from V" + (j+1) + " to Y: ");
			c[j] = in.nextDouble();
		}
		System.out.println("The length of the shortest path is: " + TheShortestPath.length(a, b, c));
		int[] locations = new int[3];
		locations = TheShortestPath.intermediateStations(a, b, c);
		System.out.println("The stations on the shortest path are: X, U" + locations[1] + ", V" + locations[2]+ ", Y.");
		
		
		in.close();
	}
}
