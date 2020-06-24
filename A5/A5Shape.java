package application;

public class A5Shape {
	private double x;
	private double y;
	private double radius;
	
	//default constructor: initialize an A5Sshape with default values
	public A5Shape(){this(0.0, 0.0, 0.0);}

	//non-default constructor: initialize an A5Sshape with provided values
	public A5Shape(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}
