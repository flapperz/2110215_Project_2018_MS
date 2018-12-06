package scene;

import globalVariable.Const;
import globalVariable.Sprites;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class StartScene extends Scene {
	
	private int animationFrame;
	
	public StartScene() {
		super(new StackPane(),Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);
		StackPane root = (StackPane)getRoot();
		root.setStyle("-fx-background-color: #000000;");
		
		Canvas canvas = new Canvas(Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		
		playBgAnimation(gc);
	
	}
	
	
	private void playBgAnimation(GraphicsContext gc) {
		animationFrame = 0;
		
		Timeline animBg = new Timeline(new KeyFrame(Duration.seconds(1./60),e->{
			double backPos = (animationFrame*Const.BACK_CITY_SPEED)%1600;
			double frontPos = (animationFrame*Const.FRONT_CITY_SPEED)%1600;
			gc.clearRect(0, 0, Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
			
			gc.drawImage(Sprites.bg_sky[0],200,300,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);
			
			gc.drawImage(Sprites.bg_backCity[0],backPos,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);

			gc.drawImage(Sprites.bg_frontCity[0],frontPos,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);

			gc.drawImage(Sprites.bg_train[0],0,0);
			
			animationFrame++;
		}));
		
		animBg.setCycleCount(Timeline.INDEFINITE);
		animBg.play();
	
	}
}
