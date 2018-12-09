package entity.projectile;

import controller.View;
import entity.Entity;
import input.Input;
import resource.Sprites;

public class PlayerBullet extends Projectile {

	public PlayerBullet(double x, double y) {
		super(Sprites.fx_bullet, x, y, 
				Input.getMouseX()+Math.random()*40-20  + View.getInstance().getX(), 
				Input.getMouseY()+Math.random()*40-20  + View.getInstance().getY(), 35.);
		this.width = 15;
		this.height = 15;
	}
	
	@Override
	public int attack(Entity e) {
		destroy();
		return 50;
	}
	
}
