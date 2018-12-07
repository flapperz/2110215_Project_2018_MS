package scene;


import globalVariable.Const;
import globalVariable.Sprites;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class StartScene extends Scene {
	
	private StackPane root;
	private Canvas canvas;
	
	private Timeline animBg;
	private int frame;
	private double backPos;
	private double frontPos;
	private double bumpFac;
	
	private Timeline animStart;
	private double playerY;
	
	private final int NORMAL = 0;
	private final int CUTSCENE = 1;
	private int state = NORMAL;
	
	private boolean isOnStart;
	
	
	public StartScene() {
		super(new StackPane(),Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);
		root = (StackPane)getRoot();
		root.setStyle("-fx-background-color: #000000;");
		
		canvas = new Canvas(Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		
		addCanvasEventHandler(canvas);
		playBgAnimation(gc);
	
	}
	
	
	private void playBgAnimation(GraphicsContext gc) {
		frame = 0;
		
		animBg = new Timeline(new KeyFrame(Duration.seconds(1./60),e->{
			backPos = (frame*Const.BACK_CITY_SPEED)%1600;
			frontPos = (frame*Const.FRONT_CITY_SPEED)%1600;
			if(frame%200 > 100) bumpFac = (frame%200)/10.;
			else bumpFac = (200-frame%200)/10.;
			gc.clearRect(0, 0, Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
			
			gc.drawImage(Sprites.bg_sky[0],200,300,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);
			
			gc.drawImage(Sprites.bg_backCity[0],backPos,bumpFac*0.2,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);

			gc.drawImage(Sprites.bg_frontCity[0],frontPos,bumpFac,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);

			gc.drawImage(Sprites.bg_train[0],0,0);
			
			gc.drawImage(Sprites.ui_nameBanner[0], 100, 100);
			
			
			gc.drawImage((isOnStart) ? Sprites.ui_start[0]:Sprites.ui_startHighlighted[0], 180, 336);
			frame++;
		}));
		
		animBg.setCycleCount(Timeline.INDEFINITE);
		animBg.play();
	
	}
	
	private void playStartAnimation(GraphicsContext gc) {
		frame = 0;
		animStart = new Timeline(new KeyFrame(Duration.seconds(1/60.),e->{
			playerY = frame*20;
			gc.clearRect(0, 0, Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
			
			gc.drawImage(Sprites.bg_sky[0],200,300,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);
			
			gc.drawImage(Sprites.bg_backCity[0],backPos,bumpFac*0.2,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);

			gc.drawImage(Sprites.bg_frontCity[0],frontPos,bumpFac,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);

			gc.drawImage(Sprites.bg_train[0],0,0);

			gc.setGlobalAlpha(0.6);
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
			
			gc.setGlobalAlpha(1);
			gc.drawImage(Sprites.p_jumpR[0], 400, playerY);
			frame++;
		}));
		animStart.setCycleCount(20);
		animStart.play();
	}
	
	private boolean isOnStartButton(MouseEvent event) {
		return event.getX() >= 180 && event.getX() < 478 && event.getY() >= 336 && event.getY() < 439;
	}
	
	private void addCanvasEventHandler(Canvas canvas) {
		canvas.setOnMouseMoved(e -> {
			if (isOnStartButton(e)) {
				isOnStart = true;
			}
			else {
				isOnStart = false;
			}
		});
		canvas.setOnMouseClicked(e -> {
			if (isOnStartButton(e) && state == NORMAL) {
				state = CUTSCENE;
				animBg.stop();
				playStartAnimation((GraphicsContext)canvas.getGraphicsContext2D());
			}
		});
	}
}
