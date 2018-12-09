package entity.monster;

import controller.SharedEntity;
import entity.Entity;
import resource.Sprites;

public class Bowling extends Monster{
	protected final int MAXWALK = 250;
	protected int walkTick = 0;
	
	public Bowling(double x, double y) {
		super(Sprites.m_mob1R, x, y, 1600, 150);
		this.width = 65;
		this.height = 65;
		this.speedX = 3;
		this.speedY = 3;
	}
	
	

	@Override
	public int attack(Entity e) {
		return 100;
	}

	@Override
	protected void subUpdate() {
		spriteUpdate();
		if(walkTick > 0) {
			walkTick--;
			
		} else {
			walkTick = MAXWALK;
			destinationX = SharedEntity.getInstance().getPlayer().getX() + (Math.random()-0.5)*700;
			destinationY = SharedEntity.getInstance().getPlayer().getY() + (Math.random()-0.8)*700;
		}
	}
	
	
	protected void spriteUpdate() {
		sprite.setSprite(facing == LEFT ? Sprites.m_mob1L : Sprites.m_mob1R);
	}
}
