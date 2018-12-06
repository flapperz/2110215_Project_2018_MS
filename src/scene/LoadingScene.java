package scene;

import globalVariable.Const;
import globalVariable.Scenes;
import globalVariable.Sounds;
import globalVariable.Sprites;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import main.Main;

public class LoadingScene extends Scene {
	
	private StackPane root;
	private Thread loadThread;
	

	private int animationFrame = 0;
	private boolean animFinished = false;
	
	public LoadingScene() {
		super(new StackPane(), Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
		root = (StackPane)getRoot();
		root.setStyle("-fx-background-color: #FFFFFF;");
		
		Canvas canvas = new Canvas(Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		
		
		loadThread = new Thread(new Runnable() {
				public void run() {
					Sprites.loadResource();
					Sounds.loadResouce();
					Scenes.loadResource();
					
					while (!animFinished) { //wait for load animation finish
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
							break;
						}
					}
				}
			});
		
		
		loadThread.start();
		
		playLoopAnimation(gc);
		
		new Thread( () -> { //wrap with Thread because join problem
			try {
				loadThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			playFadeOutAnimation(gc);
		}).start(); //wait for loading finish
		
		
	}
	
	
	private void playFadeOutAnimation(GraphicsContext gc) {
		FadeTransition ft = new FadeTransition(Duration.seconds(0.5),root);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setOnFinished(e->{
			Scenes.setMainScene(Scenes.getStartScene());
		});	
		ft.play();
	}
	
	private void playLoopAnimation(GraphicsContext gc) {
		KeyFrame kf = new KeyFrame(Duration.seconds(1./60),e-> {
			animationFrame ++;
			gc.clearRect(0, 0, Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
			if(animationFrame <= 120) {
				gc.setFill(Color.color(0,0,0,animationFrame/120.));
				gc.setFont(new Font(72));
				gc.setTextAlign(TextAlignment.CENTER);
				gc.fillText("GANG ROCKET",400,300);
			}
			else {
				gc.setFill(Color.color(0,0,0,1));
				gc.fillText("GANG ROCKET",400,300);
			}
			//TODO enhance loading
			
		});
		
		Timeline animLoop = new Timeline(kf);
		animLoop.setCycleCount(180);
		animLoop.setOnFinished(e->{
			animFinished = true;
		});
		animLoop.play();
	}
	
	//Getter-Setter

	public Thread getLoadThread() {
		return loadThread;
	}

}
