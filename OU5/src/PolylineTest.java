import java.util.*;

public class PolylineTest {
	public static void probablySecondMain() {
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		System.out.print("Input the number of vertices: ");
		int m = in.nextInt();
		in.nextLine();
		Point[] vertices = new Point[m];
		int x1,y1;
		String name = new String();
		for(int i = 0; i < m; i++)
		{
			
			System.out.print("Write the name of the vertex[" + (i+1) + "]: ");
			name = in.nextLine();
			System.out.print("X = ");
			x1 = in.nextInt();
			System.out.print("Y = ");
			y1 = in.nextInt();
			in.nextLine();
			vertices[i] = new Point(name, x1 ,y1);
		}
		Polyline we = new Polyline(vertices);
		int t = 1; 
		int s;
		String the = new String();
		do {
			System.out.println("Press 1 to set the color");
			System.out.println("Press 2 to set the width");
			System.out.println("Press 3 to calculate the length");
			System.out.println("Press 4 to add at the end");
			System.out.println("Press 5 to add before");
			System.out.println("Press 6 to remove a vertix");
			s = in.nextInt();
			in.nextLine();
			switch(s)
			{
			case 1:
				System.out.print("Write your color here: ");
				the = in.nextLine();
				we.setColour(the);
				break;
			case 2:
				System.out.print("Write the desired width here: ");
				x1 = in.nextInt();
				in.nextLine();
				we.setWidth(x1);
			case 3:
				System.out.print("The length is = " + we.length());
				break;
			case 4:
				System.out.print("Input the name of the new vertix: ");
				the = in.nextLine();
				System.out.print("X = ");
				x1 = in.nextInt();
				in.nextLine();
				System.out.print("Y = ");
				y1 = in.nextInt();
				in.nextLine();
				Point nr = new Point(the,x1,y1);
				we.addLast(nr);
				break;
			case 5:
				System.out.print("Input the name of the new vertix before: ");
				String str = new String();
				str = in.nextLine();
				System.out.print("Input the new point name: ");
				the = in.nextLine();
				System.out.print("X = ");
				x1 = in.nextInt();
				in.nextLine();
				System.out.print("Y = ");
				y1 = in.nextInt();
				in.nextLine();
				nr = new Point(the,x1,y1);
				we.addBefore(nr , str);
				break;
			case 6:
				System.out.print("Input a vertix name to remove: ");
				the = in.nextLine();
				we.remove(the);
				break;
				
			default:
				System.out.println("Your input number is not in the list, try again");
				break;
			}
			
			
			System.out.println();
			System.out.println("Press 1 to do another opreation or 0 to print the vertices and terminate");
			t = in.nextInt();
		}while(t == 1);
		
		
		System.out.println(we.toString() + " - And has a lentgh of: " + we.length());
		System.out.println("______________________________________________");
		System.out.println();
		in.close();
		
		
		
		Polyline.PolylineIterator pi = we.new PolylineIterator();
		while(pi.hasVertex()) {
			System.out.println(pi.vertex().getName() + ", " + pi.vertex().getX() + ", " + pi.vertex().getY());
			pi.advance();
		}
		System.out.println("_______________________________________________");
		System.out.println();
	}
}
