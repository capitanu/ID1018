import java.util.Iterator;

public class NPolyline implements Polyline {
	int size = 0;
	private static class Node {
		public Point vertex;
		public Node nextNode;
		public Node (Point vertex) {
			this.vertex = vertex;
			nextNode = null;

		}
	}
	private Node vertices;
	private String colour = "black";
	private int width = 1;
	// pixels
	public NPolyline () {
		this.vertices = null;
	}
	public NPolyline (Point [] vertices) {
		if (vertices.length > 0) {
			Node node = new Node (new Point (vertices[0]));
			this.vertices = node;
			size++;
			int pos = 1;
			while (pos < vertices.length) {
				node.nextNode = new Node (new Point (vertices[pos++]));
				node = node.nextNode;
				size++;
			}
		}

	}
	public String toString() {
		StringBuilder rtn = new StringBuilder("[");
		Node n = this.vertices;
		while (n != null)
		{
			rtn.append("(" + n.vertex.getName() + " , " + n.vertex.getX() + ", " + n.vertex.getY() + ")");
			n = n.nextNode;
		}
		rtn.append(", " + this.getWidth() + ", " + this.getColour() + ']' + " -- with length: " + this.length());
		return rtn.toString();
	}
	public String getColour() {
		return this.colour;
	}
	public Point[] getVertices() {
		Point[] pt = new Point[size];
		int i = 0;
		Node n = this.vertices;
		while(n != null)
		{
			pt[i] = n.vertex;
			n = n.nextNode;
		}
		return pt;
	}
	public int getWidth() {
		return this.width;
	}
	public double length() {
		double len = 0;
		Point pn = new Point (this.vertices.vertex);
		Node n = vertices.nextNode;
		while(n != null ) {
			len += Math.sqrt(Math.pow(pn.getX() - n.vertex.getX(), 2) + Math.pow(pn.getY() - n.vertex.getY(), 2));
			pn = n.vertex;
			n = n.nextNode;
		}
		return len;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void add(Point vertex) {
		Node node = new Node(vertex);
		if ( this.vertices == null) {
			this.vertices = node;
			return;
		}
		Node n = this.vertices;
		while(n.nextNode != null)
		{
			n = n.nextNode;
		}
		n.nextNode = node;
		size++;
	}
	public void insertBefore(Point vertex, String vertexName) {
		Node node = new Node(vertex);
		if( this.vertices.vertex.getName().equals(vertexName))
		{
			node.nextNode = this.vertices;
			this.vertices = node;
			return;
		}
		Node n = this.vertices;
		boolean t = false;
		while ( n.nextNode != null)
		{
			if(n.nextNode.vertex.getName().equals(vertexName))
			{
				node.nextNode = n.nextNode;
				n.nextNode = node;
				t = true;
				n = n.nextNode;
			}
			n = n.nextNode;
		}
		size++;
		if (!t) {
			size--;
			System.err.println("Nu such point with that name found.");
		}
	}
	public void remove(String vertexName) {
		Node n = this.vertices;
		boolean t = false;
		if (this.vertices.vertex.getName().equals(vertexName))
		{
			this.vertices = this.vertices.nextNode;
			return;
		}
		while(n != null) {
			if(n.vertex.getName().equals(vertexName))
			{
				n = n.nextNode.nextNode;
				t = true;
				size--;
			}
			n = n.nextNode;
		}
		if(!t)

		{
			System.err.println("Nu such point with that name found.");
		}
	}
	public Iterator<Point> iterator() {
		return this.new Itr();
	}
	class Itr implements Iterator<Point>{
		Node n;;
		public Itr() {
			if ( NPolyline.this.vertices != null)
			{
				n = NPolyline.this.vertices;
			}
			else n = null;
		}
		public boolean hasNext() {
			if(n != null && n.nextNode != null )
				return true;
			return false;
		}

		public Point next() {
			n = n.nextNode;
			return n.vertex;

		}

	}
}
