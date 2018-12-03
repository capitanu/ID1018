public class Polyline1 {
	private Point[] vertices;
	private String colour = "black";
	private int width = 1;
	String toStringReturn = new String();
public Polyline1 () { 
	this.vertices = new Point[0]; 
	}
public Polyline1 (Point[] vertices) { 
	this.vertices = new Point[vertices.length]; 
	for (int i = 0; i < vertices.length; i++) 
		this.vertices[i] = new Point (vertices[i]); 
	}
public String toString (Point[] vertices) {
	
	toStringReturn = "{[";
	for(int i = 0; i < vertices.length; i++)
		toStringReturn += '(' + vertices[i].name + ", " + vertices[i].getX() + ", " + vertices[i].getY() + ')';
	toStringReturn += "], " + this.colour + ", "+ this.width + "}";
	return toStringReturn;
}
public Point[] getVertices () {
	Point[] h = new Point[vertices.length];
	h = vertices;
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
public double length (Point[] vertices) {
	double sum = 0;
	for(int i = 1; i < vertices.length; i++)
		sum += Math.sqrt(Math.pow(vertices[i].getX()-vertices[i-1].getX(), 2) + Math.pow(vertices[i].getY() - vertices[i-1].getY(), 2));
	return sum;
}

public void addLast (Point vertex) {
	Point[] h = new Point[this.vertices.length + 1];
	int i = 0; 
	for (i = 0; i < this.vertices.length; i++)
		h[i] = this.vertices[i];
	h[i] = new Point (vertex);
this.vertices = h;
}
public void addBefore (Point vertex , String vertexName) {
	Point[] h = new Point[this.vertices.length + 1];
	h[this.vertices.length+1] = vertices[vertices.length]; 
	for(int i = vertices.length - 1; i > 0; i--)
	{
		if(vertices[i+1].name.equals(vertexName) == true)
			h[i] = vertex;
		else h[i+1] = vertices[i];
	this.vertices = h;
	}
	
	
}
public void remove (String vertexName) {
	int i=0;
	Point[] h = new Point[vertices.length - 1];
	while(!(vertices[i].name.equals(vertexName)))
	{
		h[i] = vertices[i];
		i++;
	}
	while(i<vertices.length)
	{
		h[i] = vertices[i+1];
	}
	this.vertices = h;
}
}
