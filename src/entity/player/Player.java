package entity.player;

import entity.Entity;
import globalVariable.Const;
import resource.Sprites;

public class Player extends Entity{

	public Player(double x, double y) {
		super(Sprites.p_idleR,x,y,Const.PLAYER_WIDTH,Const.PLAYER_HEIGHT);
		System.out.println("created");
	}

	@Override
	public int getZ() {
		
		return 1;
	}

	@Override
	public void update() {
		
	}
	
}