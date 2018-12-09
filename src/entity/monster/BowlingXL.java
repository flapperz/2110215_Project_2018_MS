package entity.monster;

import entity.Entity;
import resource.Sprites;

public class BowlingXL extends Bowling{
	public BowlingXL(double x, double y) {
		super(x,y);
		sprite.setSprite(Sprites.m_mob3R);
		hp = 3000;
		width = 100;
		height = 100;
		speedX = 1.5;
		speedY = 1.5;
		value = 450;
	}
	
	@Override
	public int attack(Entity e) {
		return 200;
	}
	
	@Override
	protected void spriteUpdate() {
		sprite.setSprite(facing == LEFT ? Sprites.m_mob3L : Sprites.m_mob3R);
	}
}
