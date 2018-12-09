package entity.projectile;

import controller.GameLogic;
import controller.View;
import entity.Entity;
import entity.particle.ScoreParticle;
import input.Input;
import resource.Sounds;
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
		GameLogic.getInstance().setScore(GameLogic.getInstance().getScore() + 10);
		(new ScoreParticle(x,y,10)).create();
		destroy();
		return 80;
	}
	
}
