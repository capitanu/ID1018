import java.util.Scanner;

public class ExecProg {

public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		double a,b,c;
		double alpha;
		int t = 1;
		do {
		System.out.println("What would you like to find?");
		System.out.println("Area with 2 sides and 1 angle ... Press 1");
		System.out.println("Area with 3 sides ... Press 2");
		System.out.println("Area with 1 side and 1 height ... Press 3");
		System.out.println("Circumference with 3 sides ... Press 4");
		System.out.println("Bisector with 2 sides and 1 angle ... Press 5");
		System.out.println("Circumradius with 3 sides ... Press 6");
		System.out.println("Inradius with 3 sides ... Press 7");
		int x = in.nextInt();
		switch (x) {
		case 1:
			System.out.print("Side 1 = ");
			a = in.nextDouble();
			System.out.println();
			System.out.print("Side 2 = ");
			b = in.nextDouble();
			System.out.println();
			System.out.print("Angle in radians = ");
			alpha = in.nextDouble();
			System.out.println();
			System.out.println(Triangle.twoLengthsAndOneAngle(a,b,alpha));
			break;
		case 2:
			System.out.print("Side 1 = ");
			a = in.nextDouble();
			System.out.println();
			System.out.print("Side 2 = ");
			b = in.nextDouble();
			System.out.println();
			System.out.print("Side 3 = ");
			c = in.nextDouble();
			System.out.println();
			System.out.println(Triangle.allLengths(a,b,c));
			break;
		case 3:
			System.out.print("Side 1 = ");
			a = in.nextDouble();
			System.out.println();
			System.out.print("Height = ");
			b = in.nextDouble();
			System.out.println();
			System.out.println(Triangle.lengthAndBase(a,b));
		case 4:
			System.out.print("Side 1 = ");
			a = in.nextDouble();
			System.out.println();
			System.out.print("Side 2 = ");
			b = in.nextDouble();
			System.out.println();
			System.out.print("Side 3 = ");
			alpha = in.nextDouble();
			System.out.println();
			System.out.println(Triangle.circumference(a,b,alpha));
			break;
		case 5:
			System.out.print("Side 1 = ");
			a = in.nextDouble();
			System.out.println();
			System.out.print("Side 2 = ");
			b = in.nextDouble();
			System.out.println();
			System.out.print("Angle in radians = ");
			alpha = in.nextDouble();
			System.out.println();
			System.out.println(Triangle.bisector(a,b,alpha));
			break;
		case 6:
			System.out.print("Side 1 = ");
			a = in.nextDouble();
			System.out.println();
			System.out.print("Side 2 = ");
			b = in.nextDouble();
			System.out.println();
			System.out.print("Side 3 = ");
			alpha = in.nextDouble();
			System.out.println();
			System.out.println(Triangle.circumradius(a,b,alpha));
			break;
		case 7:
			System.out.print("Side 1 = ");
			a = in.nextDouble();
			System.out.println();
			System.out.print("Side 2 = ");
			b = in.nextDouble();
			System.out.println();
			System.out.print("Side 3 = ");
			alpha = in.nextDouble();
			System.out.println();
			System.out.println(Triangle.inradius(a,b,alpha));
			break;
		default:
			System.err.println("Please input again...");
		
			
		
		}
		System.out.println("Do you want to find something else?\n" + "Input 1 for YES and 0 for NO");
		t = in.nextInt();
}while(t == 1);
		in.close();
		}

}
