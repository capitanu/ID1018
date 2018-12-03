import java.lang.*;
import java.util.Scanner;

public class Triangle {
	public static double lengthAndBase( double a, double b )
	{
		return (a*b)/2;
	}
	public static double allLengths (double a, double b, double c)
	{
		double x;
		x = (a+b+c)/2;
		return Math.sqrt(x*(x-a)*(x-b)*(x-c));
	}
	public static double twoLengthsAndOneAngle (double alpha, double a , double b)
	{
		double sin = Math.sin(alpha);
		return (a*b*sin)/2;
	}
	public static double circumference (double a, double b, double c)
	{
		return a+b+c;
	}
	public static double bisector (double alpha, double a , double b)
	{
		double x = Math.cos(alpha / 2);
		return Math.abs((2*a*b*x)/(a+b));
		// The method does not need to be repeated in order to find all the three bisectors
		// You can just call the method more than once, with different variables, and get different 
		// results
	}
	public static double circumradius ( double a, double b, double c) {
		double numerator = a * a * b * b * c * c;
		double denomitor = (a+b+c)*(a-b+c)*(a+b-c)*(b-a+c);
		return Math.sqrt(numerator/denomitor);
	}
	public static double inradius ( double a , double b, double c)
	{
		double numerator = (a-b+c)*(a+b-c)*(b-a+c);
		double denomitor = 4* (a+b+c);
		return Math.sqrt(numerator / denomitor);
	}
	
}
