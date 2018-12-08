package scene;

import controller.GameLogic;
import globalVariable.Const;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameScene extends Scene {
	
	private Pane root;
	private Canvas canvas;
	
	private Timeline tl;
	private Timeline introAnim;
	private int introFrame;
	
	public GameScene() {
		super(new Pane());
		root = (Pane)getRoot();
		root.setStyle("-fx-background-color: #000000;");
		
		canvas = new Canvas(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
		
		root.getChildren().add(canvas);
		
		addMainTimeline(canvas.getGraphicsContext2D());
		
		playMainTimeline();
		
	}
	
	private void addMainTimeline(GraphicsContext gc) {
		tl = new Timeline( new KeyFrame(Duration.seconds(1/60.),e -> {
			GameLogic.getInstance().update();
			GameLogic.getInstance().draw(gc);
		}));
	}
	
	private void playMainTimeline() {
		tl.play();
	}
	
	private void pauseMainTimeline() {
		tl.pause();
	}
	
	private void stopMainTimeline() {
		tl.stop();
	}
	
	
	
	
	
	
	
}
