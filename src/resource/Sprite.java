package resource;

import javafx.scene.image.Image;

public class Sprite {
	protected Image[] sprite;
	protected double frame;
	protected double speed;
	
	public Sprite() {
		this.sprite = new Image[1];
		this.frame = 0;
		this.speed = 1;
	}
	
	public Sprite(Image[] image) {
		this.sprite = image;
		this.frame = 0;
		this.speed = 1;
	}
	
	public Sprite(Image[] image, int frame, int speed) {
		this.sprite = image;
		this.frame = frame;
		this.speed = speed;
	}
	
	public void animate() {
		frame = (frame+speed)%sprite.length;
	}
	
	//Getter-Setter
	public Image getImage() {
		try{
			return sprite[(int)frame];
		}catch(ArrayIndexOutOfBoundsException e) {
			frame = 0;
			return sprite[(int)frame];
		}
	}
	
	public Image[] getSprite() {
		return sprite;
	}

	public void setSprite(Image[] images) {
		frame = frame%sprite.length;
		this.sprite = images;
	}

	public int getFrame() {
		return (int)frame;
	}

	public void setFrame(double frame) {
		this.frame = frame%sprite.length;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	
	
}
