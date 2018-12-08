package resource;

import javafx.scene.image.Image;

public class Sprites {
	
	public static final Image[]	loading_banner = {new Image(ClassLoader.getSystemResource("images/loading/banner.png").toString())};
	
	public static final Image[] ui_nameBanner = new Image[1];
	public static final Image[] ui_start = new Image[1];
	public static final Image[] ui_startH = new Image[1];
	
	public static final Image[] bg_sky = new Image[1];
	public static final Image[] bg_backCity = new Image[1];
	public static final Image[] bg_frontCity = new Image[1];
	public static final Image[] bg_train = new Image[1];
	
	public static final Image[] p_jumpL = new Image[1];
	public static final Image[] p_jumpR = new Image[1];
	public static final Image[] p_walkL = new Image[6];
	public static final Image[] p_walkR = new Image[6];
	public static final Image[] p_dashL = new Image[4];
	public static final Image[] p_dashR = new Image[4];
	public static final Image[] p_idleL = new Image[1];
	public static final Image[] p_idleR = new Image[1];
	public static final Image[] p_weapon = new Image[1];
	
	
	public static final Image[] fx_bullet = new Image[1];
	public static final Image[] fx_jump = new Image[1];
	public static final Image[] fx_hit = new Image[1];
	
	
			
	public static void loadResource() {
		
		ui_nameBanner[0] = new Image(ClassLoader.getSystemResource("images/ui/nameBanner.png").toString());
		ui_start[0] = new Image(ClassLoader.getSystemResource("images/ui/start.png").toString());
		ui_startH[0] = new Image(ClassLoader.getSystemResource("images/ui/startH.png").toString());
		
		bg_sky[0] = new Image(ClassLoader.getSystemResource("images/bg/sky.png").toString());
		bg_backCity[0] = new Image(ClassLoader.getSystemResource("images/bg/backCity.png").toString());
		bg_frontCity[0] = new Image(ClassLoader.getSystemResource("images/bg/frontCity.png").toString());
		bg_train[0] = new Image(ClassLoader.getSystemResource("images/bg/train.png").toString());
		
		p_jumpL[0] = new Image(ClassLoader.getSystemResource("images/player/jumpL.png").toString());
		p_jumpR[0] = new Image(ClassLoader.getSystemResource("images/player/jumpR.png").toString());
		p_idleL[0] = new Image(ClassLoader.getSystemResource("images/player/jumpR.png").toString());
		p_idleR[0] = new Image(ClassLoader.getSystemResource("images/player/jumpR.png").toString());
		p_weapon[0] = new Image(ClassLoader.getSystemResource("images/placeHold.png").toString());
		
		fx_bullet[0] = new Image(ClassLoader.getSystemResource("images/fx/bullet.png").toString());
		fx_jump[0] = new Image(ClassLoader.getSystemResource("images/fx/jumpFx.png").toString());
		fx_hit[0] = new Image(ClassLoader.getSystemResource("images/fx/hitFx.png").toString());
		
		
		for (int i=0; i<6; i++) {
			p_walkL[i] = new Image(ClassLoader.getSystemResource("images/player/left"+(i+1)+".png").toString());
			p_walkR[i] = new Image(ClassLoader.getSystemResource("images/player/right"+(i+1)+".png").toString());
		}
		for (int i=0; i<4; i++) {
			p_dashL[i] = new Image(ClassLoader.getSystemResource("images/player/dashL"+(i+1)+".png").toString());
			p_dashR[i] = new Image(ClassLoader.getSystemResource("images/player/dashL"+(i+1)+".png").toString());
		}
		
	}
	
	
	
}
