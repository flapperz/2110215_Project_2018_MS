package globalVariable;

import javafx.scene.image.Image;

public class Sprites {
	
	public static final Image[] ui_nameBanner = new Image[1];
	public static final Image[] ui_start = new Image[1];
	public static final Image[] ui_startHighlighted = new Image[1];
	
	public static final Image[] bg_sky = new Image[1];
	public static final Image[] bg_backCity = new Image[1];
	public static final Image[] bg_frontCity = new Image[1];
	public static final Image[] bg_train = new Image[1];
	
	public static final Image[] p_jumpR = new Image[1];
	
	public static void loadResource() {
		ui_nameBanner[0] = new Image(ClassLoader.getSystemResource("images/ui/nameBanner.png").toString());
		ui_start[0] = new Image(ClassLoader.getSystemResource("images/ui/start.png").toString());
		ui_startHighlighted[0] = new Image(ClassLoader.getSystemResource("images/ui/startHighlighted.png").toString());
		
		bg_sky[0] = new Image(ClassLoader.getSystemResource("images/bg/sky.png").toString());
		bg_backCity[0] = new Image(ClassLoader.getSystemResource("images/bg/backCity.png").toString());
		bg_frontCity[0] = new Image(ClassLoader.getSystemResource("images/bg/frontCity.png").toString());
		bg_train[0] = new Image(ClassLoader.getSystemResource("images/bg/train.png").toString());
		
		p_jumpR[0] = new Image(ClassLoader.getSystemResource("images/right/right1.png").toString());
	}
	
	
	
}
