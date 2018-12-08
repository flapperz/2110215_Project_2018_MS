package entity.player;

import constants.Const;
import entity.Entity;
import input.Input;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import resource.Sprites;

public class Player extends Entity{
	
	private final double WALKSPEED = 10;
	private final double JUMPSPEED = 20;
	private final double GRAVITY = 1;
	private final double MAXYSPEED = 20;
	
	private boolean isGround = true;
	private int jumpCount = 2;
	

	public Player(double x, double y) {
		super(Sprites.p_idleR,x,y,Const.PLAYER_WIDTH,Const.PLAYER_HEIGHT);
		sprite.setSpeed(0.2);
	}
	
	@Override
	public void update() {
		if( y < 540 ) {
			isGround = false;
		}else if( y == 540) {
			isGround = true;
			speedY = 0;
			jumpCount = 2;
		}
		if(!hover()) {
			processWalk();
			processJump();
			processGravity();
			move();
		}
	}
	
	@Override
	public void move() {
		x += speedX;
		y += speedY;
		if(x < 0) { x = 0; } 
		else if(x > 2310) { x = 2310; }
		if(y > 540) { y = 540; }
		
	}
	
	public void processWalk() {
		if(Input.isKeyActive(KeyCode.A)) {
			sprite.setSprite(Sprites.p_walkL);
			facing = LEFT;
			speedX = -WALKSPEED;
		} else if (Input.isKeyActive(KeyCode.D)) {
			sprite.setSprite(Sprites.p_walkR);
			facing = RIGHT;
			speedX = WALKSPEED;
		}else {
			sprite.setSprite(facing == LEFT ? Sprites.p_idleL : Sprites.p_idleR);
			speedX = 0;
		}
	}
	
	public void processJump() {
		if(Input.isKeyTrigger(KeyCode.W) && jumpCount > 0) {
			speedY = -JUMPSPEED;
			jumpCount -= 1;
		}
	}
	
	public void processGravity() {
		if(!isGround) {
			sprite.setSprite(facing == LEFT ? Sprites.p_jumpL : Sprites.p_jumpR);
			speedY += GRAVITY;
		}
	}
	
	public boolean hover() {
		if(Input.isKeyActive(KeyCode.S)) {
			sprite.setSprite(facing == LEFT ? Sprites.p_idleL : Sprites.p_idleR);
			speedY = 0;
			return true;
		}
		return false;
	}
	
	@Override
	public int getZ() {
		
		return 1;
	}

	@Override
	public void onDestroy() {
		
	}

	
}
