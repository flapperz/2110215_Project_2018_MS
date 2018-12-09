package entity.monster;

import controller.GameLogic;
import controller.View;
import entity.DamageableEntity;
import entity.IAttackable;
import entity.particle.DMarkParticle;
import entity.particle.ExplosionParticle;
import entity.particle.HitParticle;
import entity.particle.MarkParticle;
import entity.particle.ScoreParticle;
import entity.projectile.PlayerBullet;
import entity.projectile.WeaponProjectile;
import javafx.scene.image.Image;
import resource.Sounds;

public abstract class Monster extends DamageableEntity implements IAttackable{
	protected final int NORMAL = 0;
	protected final int MARK = 1;
	protected final int DMARK = 2;
	protected int state = NORMAL;
	protected int value;
	
	public Monster(Image[] images, double x, double y, int maxHp, int value) {
		super(images, x, y, maxHp);
		this.value = value;
	}
	
	@Override
	public void update() {
		move();
		processMark();
		subUpdate();
	}
	
	protected abstract void subUpdate();

	
	protected void processMark() {
		if(hp < 500 && state == NORMAL) {
			state = MARK;
		}
		if(state == MARK) {
			(new MarkParticle(x,y)).create();
		} else if (state == DMARK) {
			(new DMarkParticle(x,y)).create();
		}
	}

	@Override
	public int getZ() {
		return 2;
	}
	
	@Override
	public void attackedBy(IAttackable e) {
		if(e instanceof PlayerBullet) {
			Sounds.fx_onhit.play();
			(new HitParticle(x,y)).create();
			damaged(e.attack(this));
		} else if (e instanceof WeaponProjectile && state == MARK) {
			(new HitParticle(x,y)).create();
			damaged(e.attack(this));
			state = DMARK;
		}
		
	}
	
	@Override
	public void onDestroy() {
		Sounds.fx_explosion.play();
		GameLogic.getInstance().setScore(GameLogic.getInstance().getScore() + value);
		GameLogic.getInstance().setKillCount(GameLogic.getInstance().getKillCount() + 1);
		View.getInstance().shake();
		(new ExplosionParticle(x,y)).create();
		(new ScoreParticle(x,y,value)).create();
	}

	//Getter-Setter
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	


}
