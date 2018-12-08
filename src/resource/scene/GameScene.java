package resource.scene;

import constants.Const;
import controller.GameLogic;
import input.Input;
import javafx.animation.FadeTransition;
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
	
	public GameScene() {
		super(new Pane());
		root = (Pane)getRoot();
		root.setStyle("-fx-background-color: #FFFFFF;");
		canvas = new Canvas(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
		root.getChildren().add(canvas);
		
		Input.bindScene(this);
		
		addMainTimeline(canvas.getGraphicsContext2D());
				
	}
	
	private void addMainTimeline(GraphicsContext gc) {
		tl = new Timeline( new KeyFrame(Duration.seconds(1/60.),e -> {
			GameLogic.getInstance().mainUpdate(gc);
		}));
		tl.setCycleCount(Timeline.INDEFINITE);
	}
	
	public void playMainTimeline() {
		tl.play();
		FadeTransition ft = new FadeTransition(Duration.seconds(0.5),canvas);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
	}
	
	public void pauseMainTimeline() {
		tl.pause();
	}
	
	public void stopMainTimeline() {
		tl.stop();
	}
	
	
	
	
	
	
	
}
