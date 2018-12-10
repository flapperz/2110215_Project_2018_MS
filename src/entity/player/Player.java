package entity.player;



import constants.Const;
import resource.scene.GameScene;

import entity.DamageableEntity;
import entity.IAttackable;
import entity.monster.Monster;
import entity.particle.HitParticle;
import entity.particle.HoverParticle;
import entity.particle.JumpParticle;
import entity.particle.PHitParticle;
import entity.projectile.MonsterBullet;
import exception.CharacterOutBoundException;
import input.Input;
import javafx.scene.input.KeyCode;
import resource.Sounds;
import resource.Sprites;
import resource.scene.Scenes;

public class Player extends DamageableEntity {
	
	private final double WALK_SPEED = 10;
	private final double JUMP_SPEED = 20;
	private final double GRAVITY = 1;
	private final double MAX_SPEEDY = 20;
	private final int MAXIMMORTALTICK = 90;
	private int MAXJUMPCOUNT = 2;
	
	private boolean isImmortal = false;
	private int immortalTick;
	private boolean isGround = true;
	private int jumpCount = MAXJUMPCOUNT;
	
	private int warpTick = 0;
	

	public Player(double x, double y) {
		super(Sprites.p_idleR,x,y,Const.PLAYER_WIDTH,Const.PLAYER_HEIGHT, Const.MAX_HP);
		sprite.setSpeed(0.2);
	}
	
	@Override
	public void update() {
		
		if( y < 630 ) {
			isGround = false;
		}else if( y == 630) {
			isGround = true;
			speedY = 0;
			jumpCount = MAXJUMPCOUNT;
		}
		
		if (isImmortal && immortalTick > 0) {
			immortalTick --;
		} else if (isImmortal && immortalTick == 0) {
			immortalTick = MAXIMMORTALTICK;
			isImmortal = false;
		}
		
		if (!hover()) {
			processWalk();
			processJump();
			processGravity();
			move();
		}
		
		processWarp();
	}
	

	public void move() {
		x += speedX;
		y += speedY;
		if(x < 0) { x = 0; } 
		else if(x > 2400) { x = 2400; }
		if(y > 630) { y = 630; }
		
	}
	
	private void processWalk() {
		if(Input.isKeyActive(KeyCode.A)) {
			sprite.setSprite(Sprites.p_walkL);
			facing = LEFT;
			speedX = -WALK_SPEED;
		} else if (Input.isKeyActive(KeyCode.D)) {
			sprite.setSprite(Sprites.p_walkR);
			facing = RIGHT;
			speedX = WALK_SPEED;
		}else {
			sprite.setSprite(facing == LEFT ? Sprites.p_idleL : Sprites.p_idleR);
			speedX = 0;
		}
	}
	
	private void processJump() {
		if(Input.isKeyTrigger(KeyCode.W) && jumpCount > 0) {
			speedY = -JUMP_SPEED;
			jumpCount -= 1;
			(new JumpParticle(x, y+87)).create();
			Sounds.fx_jump.play();
		}
	}
	
	private void processGravity() {
		if(!isGround) {
			sprite.setSprite(facing == LEFT ? Sprites.p_jumpL : Sprites.p_jumpR);
			speedY += GRAVITY;
			if(speedY > MAX_SPEEDY) {
				speedY = MAX_SPEEDY;
			}
		}
		
	}
	
	private void processWarp() {
		if(warpTick > 0) {
			sprite.setSprite(Sprites.p_dashL);
			sprite.setSpeed(0.1);
			warpTick--;
		}
	}
	
	private boolean hover() {
		if(Input.isKeyActive(KeyCode.S) && !isGround) {
			sprite.setSprite(facing == LEFT ? Sprites.p_idleL : Sprites.p_idleR);
			speedY = 0;
			(new HoverParticle(x,y+90)).create();
			return true;
		}
		return false;
	}
	
	public void setOnWarp() {
		sprite.setSprite(Sprites.p_dashL);
		sprite.setSpeed(0.1);
		warpTick = 40;
	}
	
	
	@Override
	public int getZ() {
		
		return 1;
	}
	

	@Override
	public void onDestroy() {
		((GameScene)Scenes.getGameScene()).stopMainTimeline();
		((GameScene)Scenes.getGameScene()).playOverAnim();
	}

	@Override
	public void attackedBy(IAttackable e) {
		if(e instanceof Monster && isImmortal == false) {
			Sounds.fx_onhitp.play();
			(new PHitParticle(x,y)).create();
			damaged(e.attack(this));
			isImmortal = true;
		} else if (e instanceof MonsterBullet) {
			Sounds.fx_onhitp.play();
			(new PHitParticle(x,y)).create();
			damaged(e.attack(this));
		}
		
	}
	

	@Override
	public void setX(double x) throws CharacterOutBoundException {
		if(x < 0 || x > 2400) {
			throw new CharacterOutBoundException("Out bound axis : x");
		} else {
			this.x = x;
		}
	}
	
	@Override
	public void setY(double y) throws CharacterOutBoundException {
		if(y > 630) {
			throw new CharacterOutBoundException("Out bound axis : y");
		} else {
			this.y = y;
		}
	}
	
	public void heal(int amount) {
		if (hp < Const.MAX_HP + amount) {
			hp += amount;
		} else {
			hp = Const.MAX_HP;
		}
	}
	
	//Getter-Setter
	
	public boolean isImmortal() {
		return isImmortal;
	}

	public void setImmortal(boolean isImmortal) {
		this.isImmortal = isImmortal;
	}

	public boolean isGround() {
		return isGround;
	}

	public int getJumpCount() {
		return jumpCount;
	}

	public void setJumpCount(int jumpCount) {
		this.jumpCount = jumpCount;
	}

	public void setGround(boolean isGround) {
		this.isGround = isGround;
	}

	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
}
