import java.util.Iterator;
import java.util.Random;
public class Testing {
	public static void main(String[] args) {
		Point[] pt = new Point[3];
		pt[0] = new Point("A",9,1);
		pt[1] = new Point("B",3,2);
		pt[2] = new Point("C",3,6);
		Polyline polyline = null;
		polyline = new VPolyline (pt); // (1)
		//polyline = new NPolyline (pt); // (2)
		Point vertex = new Point ("X",3 ,2);
		Point vertex1 = new Point ("Y", 4, 7 );
		System.out.println(polyline.toString());
		polyline.add(vertex);
		System.out.println("Adding a vertex");
		System.out.println(polyline.toString());
		polyline.remove("A");
		System.out.println("Removing a vertex");
		System.out.println(polyline.toString());
		polyline.insertBefore(vertex1, "B");
		System.out.println("Adding a vertex in a specific position");
		System.out.println(polyline.toString());
		@SuppressWarnings("unused")
		Iterator<Point> itr = polyline.iterator();
		for(@SuppressWarnings("unused") Point vertecs : polyline) {
			// Iterator is meant to iterate through vertices which are made up in a Polyline.
		}
		Random rand = new Random();
		System.out.println("_______________________________________________________________________________________________________________");
		System.out.println();
		System.out.println("Testing random VPolyline: ");
		System.out.println();
		int colour;
		int nofPoints;
		Polyline[] vp = new VPolyline[7];
		for(int i = 0; i < vp.length; i++) {
			vp[i] = new VPolyline();
			colour = rand.nextInt(2);
			switch(colour) {
			case 0:
				vp[i].setColour("Yellow");
				break;
			case 1:
				vp[i].setColour("Blue");
				break;
			case 2:
				vp[i].setColour("Red");
				break;
			}
			vp[i].setWidth(rand.nextInt(7));
			nofPoints = 5 + rand.nextInt(5);
			while(nofPoints > 0) {
				vp[i].add(randomPoint());
				nofPoints--;
			}
			System.out.println(vp[i].toString());

		}
		System.out.println();
		Polylines.rtn(vp);
		System.out.println("_______________________________________________________________________________________________________________");
		System.out.println();
		System.out.println("Testing random NPolyline: ");
		System.out.println();
		Polyline[] np = new NPolyline[7];
		for(int i = 0; i < np.length; i++) {
			np[i] = new NPolyline();
			colour = rand.nextInt(2);
			switch(colour) {
			case 0:
				np[i].setColour("Yellow");
				break;
			case 1:
				np[i].setColour("Blue");
				break;
			case 2:
				np[i].setColour("Red");
				break;
			}
			np[i].setWidth(rand.nextInt(7));
			nofPoints = 5 + rand.nextInt(5);
			while(nofPoints > 0) {
				np[i].add(randomPoint());
				nofPoints--;
			}
			System.out.println(np[i].toString());

		}
		System.out.println();
		Polylines.rtn(np);
		System.out.println("_______________________________________________________________________________________________________________");
		System.out.println();
		System.out.println("Testing random both NPolyine and VPolyline: ");
		System.out.println();
		int type;
		Polyline[] vpolnpol = new Polyline[7];
		for(int i = 0; i < vpolnpol.length; i++) {
			type = rand.nextInt(2);
			switch (type) {
			case 0:
				vpolnpol[i] = new VPolyline();
				break;
			case 1:
				vpolnpol[i] = new NPolyline();
				break;
			}
			colour = rand.nextInt(3);
			switch(colour) {
			case 0:
				vpolnpol[i].setColour("Yellow");
				break;
			case 1:
				vpolnpol[i].setColour("Blue");
				break;
			case 2:
				vpolnpol[i].setColour("Red");
				break;
			}
			vpolnpol[i].setWidth(rand.nextInt(7));
			nofPoints = 5 + rand.nextInt(5);
			while(nofPoints > 0) {
				vpolnpol[i].add(randomPoint());
				nofPoints--;
			}
			switch (type) {
			case 0:
				System.out.println("VPolyline: " + vpolnpol[i].toString());
				break;
			case 1:
				System.out.println("NPolyline: " + vpolnpol[i].toString());
			}

		}
		System.out.println();
		Polylines.rtn(vpolnpol);
	}


	public static Point randomPoint () {
		Random rand = new Random();
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		return new Point (n, x, y);
	}

}

// junit.test
