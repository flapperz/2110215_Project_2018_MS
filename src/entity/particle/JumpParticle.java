package entity.particle;


import resource.Sprites;

public class JumpParticle extends Particle{
	public JumpParticle(double x, double y) {
		super(Sprites.fx_jump,x,y,3);
	}
	
}
