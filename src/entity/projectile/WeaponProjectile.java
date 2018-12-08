package entity.projectile;

import constants.Const;
import controller.View;
import input.Input;
import resource.Sprites;

public class WeaponProjectile extends Projectile{
	
	private int age = 240;
	
	public WeaponProjectile(double x, double y) {
		super(Sprites.p_weapon, x, y, 
				Input.getMouseX()  + View.getInstance().getX(), 
				Input.getMouseY()  + View.getInstance().getY(), 30.);
	}
	
	@Override
	public void update() {
		age -= 1;
		move();
		if(this.x < 0 || this.x > Const.STAGE_WIDTH || this.y < -9000 || this.y > Const.WINDOW_HEIGHT) {
			this.destroy();
		}
	}
	
	@Override
	public int attack() {
		return 0;
	}
}
