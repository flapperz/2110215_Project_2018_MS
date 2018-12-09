package entity.particle;

import resource.Sprites;

public class HoverParticle extends Particle {
	public HoverParticle(double x, double y) {
		super(Sprites.fx_hover, x, y, 1);
	}
	
	@Override
	public int getZ() {
		return 0;
	}
}
