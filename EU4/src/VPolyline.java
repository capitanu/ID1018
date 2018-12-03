import java.util.Iterator;
import java.util.NoSuchElementException;
public class VPolyline implements Polyline {
	private Point[] vertices;
	private String colour = "black";
	private int width = 1;
	public VPolyline () { 
		this.vertices = new Point[0]; 
	}
	public VPolyline (Point[] vertices) { 
		this.vertices = new Point[vertices.length]; 
		for (int i = 0; i < vertices.length; i++) 
			this.vertices[i] = new Point (vertices[i]); 
	}
	public String toString () {
		String toStringReturn = new String(); //StringBuilder 
		toStringReturn = "[";
		for(int i = 0; i < this.vertices.length; i++)
			toStringReturn += '(' + this.vertices[i].name + ", " + this.vertices[i].getX() + ", " + this.vertices[i].getY() + ')';
		toStringReturn += ", " + this.colour + ", "+ this.width + "]" + " -- with the length equal to: " + this.length();
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




	public void add(Point vertex) {
		Point[] h = new Point[this.vertices.length + 1];
		int i = 0; 
		for (i = 0; i < this.vertices.length; i++)
			h[i] = this.vertices[i];
		h[i] = new Point(vertex);
		this.vertices = h;
	}
	public void insertBefore(Point vertex, String vertexName) throws NoSuchElementException {
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
	public void remove (String vertexName) throws NoSuchElementException {
		int i=0;
		boolean t = false;
		Point[] h = new Point[vertices.length - 1];
		while(this.vertices[i].name.equals(vertexName) == false)
		{
			h[i] = vertices[i]; 
			i++;
		}
		while(i<this.vertices.length - 1)
		{
			t = true;
			h[i] = this.vertices[i+1];
			i++;
		}
		if ( t == false )
			throw new NoSuchElementException("No element");
		this.vertices = h;
	}
	
	public Iterator<Point> iterator() {
		return this.new Itr();
	}
	public class Itr implements Iterator<Point>{
		int t;
		public Itr() {
			if(VPolyline.this.vertices.length == 0) {
				t = -1 ;
			}
			else t = 0;
		}
		public boolean hasNext() {
			if ( t != -1 && t < VPolyline.this.vertices.length)
				return true;
			return false;
		}

		public Point next() {
			return VPolyline.this.vertices[t++];
		}
		
	}
	
}

