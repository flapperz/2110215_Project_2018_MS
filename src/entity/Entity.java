package entity;

import controller.IDrawable;
import controller.View;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import resource.Sprite;

public abstract class Entity extends Rectangle implements IDrawable{
	
	public static final int LEFT = -1;
	public static final int RIGHT = -1;
	
	protected final Sprite sprite = new Sprite();
	protected double speedX;
	protected double speedY;
	protected boolean visible;
	protected boolean destroyed;
	
	
	
	public Entity(Image[] images, double x, double y, double width, double height) {
		super(x, y, width, height);
		this.sprite.setSprite(images);
		this.speedX = 0;
		this.speedY = 0;
		this.visible = true;
		this.destroyed = false;
		
	}

	public Entity(Image[] images) {
		super();
		this.sprite.setSprite(images);
		this.speedX = 0;
		this.speedY = 0;
		this.visible = true;
		this.destroyed = false;
	}

	public abstract void update();

	
	public void move(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public void move() {
		this.x += speedX;
		this.y += speedY;
	}
	
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(sprite.getImage(),x-View.getInstance().getX(),y-View.getInstance().getY());
	}

	@Override
	public boolean isVisible() {
		return visible;
	}
	
	
	
	
	
}
