package entity;

import controller.IDrawable;
import controller.IUpdatable;
import controller.SharedEntity;
import controller.View;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import resource.Sprite;

public abstract class Entity extends Rectangle implements IDrawable,IUpdatable{
	
	protected static final int LEFT = -1;
	protected static final int RIGHT = 1;
	
	protected final Sprite sprite = new Sprite();
	protected double speedX;
	protected double speedY;
	protected double destinationX;
	protected double destinationY;
	protected int facing;
	protected boolean visible;
	
	
	
	public Entity(Image[] images, double x, double y, double width, double height) {
		super(x, y, width, height);
		this.sprite.setSprite(images);
		this.speedX = 0;
		this.speedY = 0;
		this.destinationX = x;
		this.destinationY = y;
		this.facing = RIGHT;
		this.visible = true;
	}

	public Entity(Image[] images) {
		super();
		this.sprite.setSprite(images);
		this.speedX = 0;
		this.speedY = 0;
		this.destinationX = x;
		this.destinationY = y;
		this.facing = RIGHT;
		this.visible = true;
	}
	
	public Entity() {
		super();
		this.speedX = 0;
		this.speedY = 0;
		this.destinationX = x;
		this.destinationY = y;
		this.facing = RIGHT;
		this.visible = true;
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(sprite.getImage(),x - View.getInstance().getX() - sprite.getImage().getWidth()/2,
				y - View.getInstance().getY() - sprite.getImage().getHeight()/2);
		sprite.animate();
	}
	
	protected void move() {
		if(x < destinationX-speedX) {
			facing = RIGHT;
			x += speedX;
		}else if(x > destinationX+speedX) {
			facing = LEFT;
			x -= speedX;
		}else {
			x = destinationX;
		}
		if(y < destinationY-speedY) {
			y += speedY;
		}else if(y > destinationY+speedY) {
			y -= speedY;
		}else {
			y = destinationY;
		}	
	}
	
	public void create() {
		SharedEntity.getInstance().add(this);
	}

	public void destroy() {
		onDestroy();
		SharedEntity.getInstance().remove(this);
	}
	
	public abstract void onDestroy();
	
	
	@Override
	public boolean isVisible() {
		return visible;
	}
	
	//getter setter;

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public double getDestinationX() {
		return destinationX;
	}

	public void setDestinationX(double destinationX) {
		this.destinationX = destinationX;
	}

	public double getDestinationY() {
		return destinationY;
	}

	public void setDestinationY(double destinationY) {
		this.destinationY = destinationY;
	}

	public int getFacing() {
		return facing;
	}

	public void setFacing(int facing) {
		this.facing = facing;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
	
	
}
