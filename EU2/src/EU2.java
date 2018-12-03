import java.util.Scanner;
public class EU2 {
//	public static int[] swap(int a, int b )
//	{
//		int t = a;
//		a = b;
//		b = t;
//		int[] m = {a,b};
//		return m;
//	} QUICKSORT
	//java swing package
	
	public static void main(String[] args) {
		int m;
		Scanner in = new Scanner(System.in);
		System.out.print("Input the length of the array: ");
		m = in.nextInt();
		int[] t = new int[m];
		for( int i = 0; i < m ; i++)
		{
			System.out.print("Input number " + (i+1) + " = " );
			t[i] = in.nextInt();
		}
		in.close();
		sort(m , t);
	}
	public static void sort(int len, int[] arr)
	{
		for(int i = 0; i < len; i++)
		{
			for(int j = i + 1; j < len; j++ )
			{
				if(arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i = 0; i < len; i++)
			System.out.println(arr[i]);
	}
	
}
