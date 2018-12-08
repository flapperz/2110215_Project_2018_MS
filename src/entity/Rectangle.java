package entity;

public abstract class Rectangle {
	
	protected double x;
	protected double y;
	protected double cx;
	protected double cy;
	protected double width;
	protected double height;
	
	public Rectangle() {
		this(0,0,0,0);
	}
	
	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.cx = x + width/2;
		this.cy = y + width/2;
	}
	
	public boolean isCollideWith(Rectangle b) {
		if (x < b.x + b.width && x + width > b.x && y < b.y + b.height && height + y > b.y) return true;
		return false;
	}
	
	public boolean isCollideWith(double x, double y, double width, double height) {
		if (this.x < x + width && this.x + this.width > x && this.y < y + height && this.height + this.y > y) return true;
		return false;
	}
	
	//Getter-Setter

	public double getWidth() {
		return width;
	}

	public void setWidth(double widht) {
		this.width = widht;
		cx = x+widht/2;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		cy = y + height/2;
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

	public double getCx() {
		return cx;
	}

	public void setCx(double cx) {
		this.cx = cx;
		x = cx - width/2;
	}

	public double getCy() {
		return cy;
	}

	public void setCy(double cy) {
		this.cy = cy;
		y = cy - width/2;
	}
	
	
	
	
	
	

}
