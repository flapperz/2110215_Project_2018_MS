package resource;

import javafx.scene.media.AudioClip;

public class Sounds {
	public static AudioClip bgm_boss;
	public static AudioClip bgm_game;
	public static AudioClip bgm_gameOver;
	public static AudioClip bgm_train;
	public static AudioClip bgm_victory;
	public static AudioClip fx_fire;
	public static AudioClip fx_onhit;
	public static AudioClip fx_onhitp;
	public static AudioClip fx_jump;
	public static AudioClip fx_skill;
	public static AudioClip fx_targetLock;
	public static AudioClip fx_dash;
	public static AudioClip fx_explosion;
	
	
	public static void loadResouce() {
		bgm_boss = new AudioClip(ClassLoader.getSystemResource("sounds/bgmBoss.mp3").toString());
		bgm_game = new AudioClip(ClassLoader.getSystemResource("sounds/bgmGame.mp3").toString());
		bgm_gameOver = new AudioClip(ClassLoader.getSystemResource("sounds/gameover.mp3").toString());
		bgm_train = new AudioClip(ClassLoader.getSystemResource("sounds/trainmix.mp3").toString());
		bgm_victory = new AudioClip(ClassLoader.getSystemResource("sounds/trainmix.mp3").toString());
		fx_fire = new AudioClip(ClassLoader.getSystemResource("sounds/lasershot.mp3").toString());
		fx_onhit = new AudioClip(ClassLoader.getSystemResource("sounds/onhit.mp3").toString());
		fx_onhitp = new AudioClip(ClassLoader.getSystemResource("sounds/onhitPlayer.mp3").toString());
		fx_jump = new AudioClip(ClassLoader.getSystemResource("sounds/jumpsound.mp3").toString());
		fx_skill = new AudioClip(ClassLoader.getSystemResource("sounds/skill.mp3").toString());
		fx_targetLock = new AudioClip(ClassLoader.getSystemResource("sounds/targetLock.mp3").toString());
		fx_dash = new AudioClip(ClassLoader.getSystemResource("sounds/dash.mp3").toString());
		fx_explosion = new AudioClip(ClassLoader.getSystemResource("sounds/explosion.mp3").toString());
	}


	public static AudioClip getBgm_train() {
		return bgm_train;
	}
}
