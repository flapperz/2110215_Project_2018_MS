package entity.monster;

import controller.SharedEntity;
import entity.Entity;
import entity.IAttackable;
import entity.projectile.PlayerBullet;
import resource.Sprites;

public class Bowling extends Monster{
	private final int MAXWALK = 250;
	private int walkTick = 0;
	
	public Bowling(double x, double y) {
		super(Sprites.m_mob1R, x, y, 1000);
		this.speedX = 3;
		this.speedY = 3;
	}

	@Override
	public int attack(Entity e) {
		return 100;
	}

	@Override
	protected void subUpdate() {
		if(walkTick > 0) {
			walkTick--;
			
		} else {
			walkTick = MAXWALK;
			destinationX = SharedEntity.getInstance().getPlayer().getX() + (Math.random()-0.5)*700;
			destinationY = SharedEntity.getInstance().getPlayer().getY() + (Math.random()-0.8)*700;
		}
		
	}
}
