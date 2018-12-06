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

public class StartScene extends Scene{
	
	private BooleanProperty bool = new SimpleBooleanProperty(false);
	
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
		System.out.println("draw");
		Timeline animBg = new Timeline(new KeyFrame(Duration.seconds(1./60),e->{
			gc.drawImage(Sprites.bg_train[0],0,0);
		}));
		
		animBg.setCycleCount(Timeline.INDEFINITE);
		animBg.play();
	
	}
}
