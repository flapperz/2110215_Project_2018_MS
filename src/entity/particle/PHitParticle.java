package entity.particle;

import resource.Sprites;

public class PHitParticle extends Particle{

	public PHitParticle(double x, double y) {
		super(Sprites.fx_phit, x, y, 3);
	}

}
