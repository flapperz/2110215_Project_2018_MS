package entity;

import exception.CharacterOutBoundException;

public abstract class Rectangle {
	
	protected double x;
	protected double y;
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
	}
	
	public boolean isCollideWith(Rectangle b) {
		if (x - width/2 < b.x + b.width/2 && x + width/2 > b.x - b.width/2 
				&& y - height/2 < b.y + b.height/2 && height/2 + y > b.y - b.height/2) return true;
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
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) throws Exception {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) throws CharacterOutBoundException {
		this.y = y;
	}
		
	

}
