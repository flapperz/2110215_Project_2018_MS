package entity.particle;

import resource.Sounds;
import resource.Sprites;

public class HitParticle extends Particle{

	public HitParticle(double x, double y) {
		super(Sprites.fx_hit, x, y, 3);
	}

}
