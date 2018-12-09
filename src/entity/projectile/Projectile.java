package entity.projectile;

import constants.Const;
import entity.Entity;
import entity.IAttackable;
import javafx.scene.image.Image;

public abstract class Projectile extends Entity implements IAttackable{
	protected double speed;
	
	public Projectile(Image[] image, double x, double y, double destinationX, double destinationY, double speed) {
		super(image,x,y,0,0);
		this.x = x;
		this.y = y;
		this.speed = speed;
		double r = Math.sqrt(Math.pow(destinationX - x, 2) + Math.pow(destinationY - y, 2));
		this.speedX = ((destinationX - x) / r)*speed;
		this.speedY = ((destinationY - y) / r)*speed;
	}
	
	@Override
	public int getZ() {
		return 99;
	}

	@Override
	public void update() {
		
		move();
		if(this.x < 0 || this.x > Const.STAGE_WIDTH || this.y < -9000 || this.y > Const.WINDOW_HEIGHT) {
			this.destroy();
		}
	}
	
	@Override
	public void move() {
		x += speedX;
		y += speedY;
	}

	@Override
	public void onDestroy() {
		
	}

}
