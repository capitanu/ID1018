public class Point{
	String name = new String();
	private int x,y;
	Point(Point p)
	{
		this.name = p.name;
		this.x = p.getX();
		this.y = p.getY();
	}
	Point(String pointName, int x1, int y1) {
		name = pointName;
		x = x1;
		y = y1;
}
	public String getName() {
		return name;
	}
	public int getX() {
		return x;
	}
	public int getY(){
		return y;
	}
	public double distance(Point p) {
		double d;
		d = Math.sqrt(Math.pow(p.getX()-this.x,2) + Math.pow(p.getY()-this.y, 2));
		return d;
	}
	
	public void setX(int x1) {
		this.x = x1;
	}
	public void setY(int y1) {
		this.y = y1;
	}
	public String toString() {
		String name ='(' +  this.name + ' ' +this.getX() + ' ' +this.getY() + ')';
		return name;
	}
}