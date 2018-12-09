package entity.particle;

import resource.Sprites;

public class ExplosionParticle extends Particle{
	public ExplosionParticle(double x, double y) {
		super(Sprites.fx_explosion, x, y, 30);
		sprite.setSpeed(0.13);
	}
}
