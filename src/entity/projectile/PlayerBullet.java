package entity.projectile;

import controller.View;
import input.Input;
import resource.Sprites;

public class PlayerBullet extends Projectile {

	public PlayerBullet(double x, double y) {
		super(Sprites.fx_bullet, x, y, 
				Input.getMouseX()+Math.random()*40-20  + View.getInstance().getX(), 
				Input.getMouseY()+Math.random()*40-20  + View.getInstance().getY(), 35.);
	}
	
	@Override
	public int attack() {
		return 10;
	}
	
}
