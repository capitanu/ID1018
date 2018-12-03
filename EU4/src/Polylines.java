
public class Polylines {
	public static void rtn(Polyline[] polyline)
	{
		int i, j = 0;
		double len = -1;
		for(i = 0; i < polyline.length; i++) {
			if(polyline[i].getColour().equals("Yellow")) {
				len = polyline[i].length();
				j = i; 
				break;
			}
		}
		for(; i < polyline.length; i++) {
			if(polyline[i].getColour().equals("Yellow") && polyline[i].length() < len) {
				len = polyline[i].length();
				j = i;
			}
		}
		if ( len != -1)
			System.out.println("The shortest Yellow polyline is : " + polyline[j].toString());
		else System.out.println("There seems to be no Yellow polyline.");
	}
}
