import java.util.*;


class SelectPolyline { 
	public static final Random rand = new Random ();
	public static final int NOF_POLYLINES = 10;
	public static void probablyThirdMain () { 
		int j = 0;
		// Create a random number of polylines 
		Polyline[] polylines = new Polyline[NOF_POLYLINES];
		for (int i = 0; i < NOF_POLYLINES; i++) 
			polylines[i] = randomPolyline ();
		// Show the polylines
		for (int i = 0; i < NOF_POLYLINES; i++)
		{
//			Point[] vertices = new Point[9];
//			vertices = polylines[i].getVertices();
			System.out.println(polylines[i].toString() + " -- And has the length of:  " + polylines[i].length());
		}
		
		// Determine the shortest yellow polyline
		int i;
		double sum = -1;
		for(i = 0; i < NOF_POLYLINES; i++)
		{
			if(polylines[i].getColour().equals("Yellow"))
			{
//				Point[] vertices = new Point[9];
//				vertices = polylines[i].getVertices();
				sum = polylines[i].length();
				j = i;
				break;
			}
		}
		for(; i < NOF_POLYLINES; i++)
		{
			if(polylines[i].getColour().equals("Yellow"))
			{
//				Point[] vertices = new Point[9];
//				vertices = polylines[i].getVertices();
				if(polylines[i].length() < sum) {
					sum = polylines[i].length();
					j = i;
				}
			}
		}
		// Show the selected polyline
//		Point[] vertices = new Point[9];
//		vertices = polylines[j].getVertices();
		if(sum != -1) {
			System.out.println();
			System.out.println("The shortest Yellow polyline is: ");
			System.out.println(polylines[j].toString());
			System.out.println("With the length of: " + polylines[j].length());
		}
		else System.out.println("There is no Yellow Polyline");

		
	}
	// The randomPoint method returns a new Point with a name 
	// randomly chosen from the single letters A--Z. Coordinates 
	// are random. 
	public static Point randomPoint () { 
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		return new Point (n, x, y);
	}
	// The method randomPolyline returns a random polyline , 
	// with a colour either blue , red, or yellow. The names 
	// of the vertices are single letters from the set A--Z. 
	// Two vertices can not have the same name. 
	public static Polyline randomPolyline () { 
		// Create an empty polyline and add vertices 
		int nofVertices = 2 + rand.nextInt (7);
		Point[] vertices = new Point[nofVertices];
		Polyline polyline = new Polyline();

		int nofSelectedVertices = 0; 
		boolean[] selectedNames = new boolean[26];
		// Two vertices can not have the same name 
		int t;
		Point chosenPoint = null; 
		//char chosenChar = 0;
		while (nofSelectedVertices < nofVertices) {
			chosenPoint = randomPoint();
			if(selectedNames[chosenPoint.name.charAt(0) - 65] == false)
			{
				selectedNames[chosenPoint.name.charAt(0) - 65] = true;
				vertices[nofSelectedVertices] = chosenPoint;
				vertices[nofSelectedVertices].setX(chosenPoint.getX());
				vertices[nofSelectedVertices].setY(chosenPoint.getY());
				polyline.addLast(chosenPoint);
				
			}
			else continue;	
			
			nofSelectedVertices++;
		}
		t = rand.nextInt(2);
		switch (t)
		{
		case 0:
			polyline.setColour("Red");
			break;
		case 1:
			polyline.setColour("Yellow");
			break;
		case 2:
			polyline.setColour("Blue");
			break;		
		}
		polyline.setWidth(rand.nextInt(10));
		// Assign a colour
		
		return polyline;
	}
}