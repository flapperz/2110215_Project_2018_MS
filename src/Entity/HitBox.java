package Entity;

public class HitBox {
	
	protected double x;
	protected double y;
	protected double width;
	protected double height;
	
	protected boolean isEnable;
	
	public HitBox() {
		this(0,0,0,0);
		this.isEnable = false;
	}
	
	public HitBox(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isEnable = true;
	}
	
	public boolean isCollideWith(HitBox b) {
		if (x < b.x + b.width && x + width > b.x && y < b.y + b.height && height + y > b.y) return true;
		return false;
	}
	
	public boolean isCollideWith(double x, double y, double width, double height) {
		if (this.x < x + width && this.x + this.width > x && this.y < y + height && this.height + this.y > y) return true;
		return false;
	}
	
	//Getter-Setter

	public double getWidht() {
		return width;
	}

	public void setWidht(double widht) {
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

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	
	
	
	
	

}
