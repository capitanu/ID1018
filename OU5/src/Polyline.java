import java.util.*;

public class Polyline {
	private Point[] vertices;
	private String colour = "black";
	private int width = 1;
	public Polyline () { 
		this.vertices = new Point[0]; 
	}
	public Polyline (Point[] vertices) { 
		this.vertices = new Point[vertices.length]; 
		for (int i = 0; i < vertices.length; i++) 
			this.vertices[i] = new Point (vertices[i]); 
	}
	public String toString () {
		String toStringReturn = new String(); //StringBuilder 
		toStringReturn = "{[";
		for(int i = 0; i < this.vertices.length; i++)
			toStringReturn += '(' + this.vertices[i].name + ", " + this.vertices[i].getX() + ", " + this.vertices[i].getY() + ')';
		toStringReturn += "], " + this.colour + ", "+ this.width + "}";
		return toStringReturn;
	}
	public Point[] getVertices () {
		Point[] h = new Point[this.vertices.length];
		for(int i=0 ;i< this.vertices.length; i++)
		{
			h[i] = new Point(this.vertices[i]);
		}
		return h;	
	}
	public String getColour () {
		return colour;

	}
	public int getWidth () {
		return width;
	}
	public void setColour (String colour) {
		this.colour = colour;

	}
	public void setWidth (int width) {
		this.width = width;

	}
	public double length () {
		double sum = 0;
		for(int i = 1; i < this.vertices.length; i++)
			sum += Math.sqrt(Math.pow(this.vertices[i].getX()-this.vertices[i-1].getX(), 2) + Math.pow(this.vertices[i].getY() - this.vertices[i-1].getY(), 2));
		return sum;
	}

	public void addLast (Point vertex) {
		Point[] h = new Point[this.vertices.length + 1];
		int i = 0; 
		for (i = 0; i < this.vertices.length; i++)
			h[i] = this.vertices[i];
		h[i] = new Point(vertex);
		this.vertices = h;
	}
	public void addBefore (Point vertex , String vertexName) {
		//	Point[] h = new Point[this.vertices.length + 1];
		//	h[this.vertices.length] = new Point(this.vertices[this.vertices.length - 1]); 
		//	for(int i = this.vertices.length - 1; i >= 0; i--)
		//	{
		//		if(this.vertices[i].name.equals(vertexName) == true)
		//			h[i] = new Point(vertex);
		//		else h[i] = new Point(this.vertices[i]);
		//	this.vertices = h;
		int t = this.vertices.length;
		Point[] h = new Point[t + 1];
		h[t] = vertices[t-1];
		int i;
		for ( i = t - 1; i >= 0; i--)
		{
			if(this.vertices[i].name.equals(vertexName))
			{
				h[i] = new Point(vertex);
				break;
			}
			else h[i] = this.vertices[i - 1];
		}
		for( i--; i >= 0; i--)
		{
			h[i] = this.vertices[i];
		}
		this.vertices = h;


	}
	public void remove (String vertexName) {
		int i=0;
		Point[] h = new Point[vertices.length - 1];
		while(this.vertices[i].name.equals(vertexName) == false)
		{
			h[i] = vertices[i]; 
			i++;
		}
		while(i<this.vertices.length - 1)
		{
			h[i] = this.vertices[i+1];
			i++;
		}
		this.vertices = h;
	}


	public class PolylineIterator { 
		private int current = -1;
		public PolylineIterator () { 
			if (Polyline.this.vertices.length > 0) 
				current = 0;
		}
		public boolean hasVertex () { 
			return current != -1; 
		}
		public Point vertex () throws NoSuchElementException {
			if (!this.hasVertex ()) 
				throw new NoSuchElementException ("end of iteration");
			Point vertex = new Point(Polyline.this.vertices[current]);
			return vertex;
		}
		public void advance () { 
			if (current >= 0 && current < Polyline.this.vertices.length - 1)
				current++; 
			else current = -1; }
	}

} //Returning refferences or numbers
