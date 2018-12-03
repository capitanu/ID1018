import java.util.Scanner;
import static java.lang.System.out;
class OperationsWithNaturalNumbersGivenAsStrings { 
	public static void main (String[] args)
	{
		out.println ("OPERATIONS ON NATURAL NUMBERS " +
	"IN CHARACTER STRINGS");
// enter two natural numbers 
		Scanner in = new Scanner (System.in);
		out.println ("two natural numbers:");
		String tal1 = in.next ();
		String tal2 = in.next (); 
		out.println ();
// add the numbers and show the result 
		String sum = add (tal1 , tal2);
		show(tal1 , tal2 , sum , '+');
// subtract the numbers and show the result 
// *** WRITE YOUR CODE HERE ***
		String sub = subtract(tal1, tal2);
		show(tal1, tal2, sub, '-');
		String mul = multiply(tal1 , tal2);
		show(tal1, tal2 , mul, '*');
		in.close();
}
// The add method accepts two natural numbers represented 
// as character strings and returns their sum as a 
// character string. 
	public static String multiply ( String num1, String num2)
	{
		String multiply = new String();
		multiply = num1;
		int i = Integer.parseInt(num2);
		while ( i > 1 )
		{
			multiply = add (multiply, num1 );
			i--;
		}
		
		
		
		return multiply;
		
	}
	public static String add (String num1 , String num2) { 
		// *** WRITE YOUR CODE HERE ***
		// Character.getNumericValue(num1.charAt();
	
		StringBuilder add = new StringBuilder();
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int sum;
		int carry = 0;
		int r;
		while ( i >= 0 && j >= 0) {
			r = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j)) + carry; 
			sum = (r%10);
			add.append(sum);
			carry = r/10;
			i--;
			j--;
			
		}
			while ( i >= 0 )
			{
				r = Character.getNumericValue(num1.charAt(i)) + carry;
				sum = (r%10);
				carry = r/10;
				i--;
				add.append(sum);
			}
			
			while ( j >= 0 )
			{
				r = Character.getNumericValue(num2.charAt(j)) + carry;
				sum = (r%10);
				carry = r/10;
				j--;
				add.append(sum);
			}
		if( carry == 1 )
		{
			add.append(carry);
		}
		add.reverse();
		//obj.insert();'
		return add.toString();
	}
// The subtract method accepts two natural numbers 
// represented as character strings and returns their 
// difference as a character string. 
// The first number is not smaller than the second 
		public static String subtract (String num1 , String num2) { 
			// *** WRITE YOUR CODE HERE *** 
			String substract = new String();
			int sub;
			int carry = 0;
			int i = num1.length() - 1;
			int j = num2.length() - 1;
			int n1, n2;
			
			while (j >= 0)
			{
				n1 = Character.getNumericValue(num1.charAt(i)) - carry;
				n2 = Character.getNumericValue(num2.charAt(j));
				//sub = Math.abs((n1-n2) - carry);
				if( n1 < n2 )
				{	sub = n1 + 10 - n2;
					carry = 1;
				}
				else {
					sub = n1 - n2;
					carry = 0;
				}
				substract = substract + sub;
				i--;
				j--;
			}
			while (i >= 0)
			{
				n1 = Character.getNumericValue(num1.charAt(i)) - carry;
				if ( n1 < 0 )
				{
					sub = n1 + 10;
					carry = 1;
				}
				else {
					sub = n1;
					carry = 0;
				}
				substract = substract + sub;
				i--;
				
			}
			StringBuilder obj = new StringBuilder(substract);
			
			return obj.reverse().toString();
		}
// The show method presents two natural numbers , an
// operator and the result string. 
		public static void show (String num1 , String num2 , String result , char operator) { 
// set an appropriate length on numbers and result 
			int len1 = num1.length (); 
			int len2 = num2.length (); 
			int len = result.length (); 
			int maxLen = Math.max (Math.max (len1 , len2), len); 
			num1 = setLen (num1 , maxLen - len1); 
			num2 = setLen (num2 , maxLen - len2); 
			result = setLen (result , maxLen - len);
// show the expression 
			out.println ("  " + num1); 
			out.println ("" + operator + " " + num2); 
			for (int i = 0; i < maxLen + 2; i++) 
				out.print ("-");
			out.println (); 
			out.println (" " + result + "\n");
}
// The setLen method prepends the supplied number of 
// spaces ato the beginning of a string 
		public static String setLen (String s, int nofSpaces) {
			StringBuilder sb = new StringBuilder (s); 
			for (int i = 0; i < nofSpaces; i++) sb.insert (0, " ");
		
			return sb.toString ();
}
}