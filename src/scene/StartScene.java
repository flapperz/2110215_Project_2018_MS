package scene;



import globalVariable.Const;
import globalVariable.Sprites;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class StartScene extends Scene {
	
	private Pane root;
	private Canvas canvas;
	private ImageView nameBanner;
	private ImageView startBtn;
	
	private Timeline animBg;
	private int bgFrame;
	private double backPos;
	private double frontPos;
	
	private Timeline animFade;
	private int fadeFrame;
	
	private Timeline animDrop;
	private int dropFrame;
	
	private final int NORMAL = 0;
	private final int CUTSCENE = 1;
	private int state = NORMAL;
	
	
	public StartScene() {
		super(new Pane());
		root = (Pane)getRoot();
		root.setStyle("-fx-background-color: #000000;");
		
		canvas = new Canvas(Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		nameBanner = new ImageView(Sprites.ui_nameBanner[0]);
		nameBanner.setX(120);
		nameBanner.setY(300);
		
		startBtn = new ImageView(Sprites.ui_start[0]);
		startBtn.setX(800);
		startBtn.setY(500);
		
		root.getChildren().addAll(canvas,nameBanner,startBtn);
		
		addStartEventHandler();
		playBgAnimation(gc);
	
	}
	
	
	private void playBgAnimation(GraphicsContext gc) {
		bgFrame = 0;
		
		animBg = new Timeline(new KeyFrame(Duration.seconds(1./60),e->{
			backPos = (bgFrame*Const.BACK_CITY_SPEED)%3600;
			frontPos = (bgFrame*Const.FRONT_CITY_SPEED)%3600;
			gc.clearRect(0, 0, Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
			
			gc.drawImage(Sprites.bg_sky[0],300,450,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);
			
			gc.drawImage(Sprites.bg_backCity[0],backPos,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);

			gc.drawImage(Sprites.bg_frontCity[0],frontPos,50,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);

			gc.drawImage(Sprites.bg_train[0],0,0);
			
			bgFrame++;
		}));
		
		animBg.setCycleCount(Timeline.INDEFINITE);
		animBg.play();
	
	}
	
	private void playStartAnimation(GraphicsContext gc) {
		fadeFrame = 0;
		
		animFade = new Timeline(new KeyFrame(Duration.seconds(1/60.),e->{
			backPos = (bgFrame*Const.BACK_CITY_SPEED)%3600;
			frontPos = (bgFrame*Const.FRONT_CITY_SPEED)%3600;
			
			gc.clearRect(0, 0, Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
			
			gc.drawImage(Sprites.bg_sky[0],300,450,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);
			
			gc.drawImage(Sprites.bg_backCity[0],backPos,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);

			gc.drawImage(Sprites.bg_frontCity[0],frontPos,50,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT,
					0,0,Const.WINDOW_WIDHT,Const.WINDOW_HEIGHT);

			gc.drawImage(Sprites.bg_train[0],0,0);

			gc.setGlobalAlpha(1/30.*fadeFrame);
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
			gc.setGlobalAlpha(1);
			fadeFrame++;
			bgFrame++;
		}));
		animFade.setCycleCount(30);
		animFade.play();
		animFade.setOnFinished(e ->{ 
			animDrop.play();
		});
		dropFrame = 0;
		animDrop = new Timeline(new KeyFrame(Duration.seconds(1/60.),e -> {
			gc.clearRect(0, 0, Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
			gc.drawImage(Sprites.p_jumpR[0], 600-46, (1.8*(Math.pow(dropFrame,2.0))-180));
			dropFrame++;
		}));
		animDrop.setCycleCount(21);
		animDrop.setOnFinished(e ->{ 
		});
	}
	
	private void addStartEventHandler() {
		startBtn.setOnMouseEntered(e -> {
			if (state == NORMAL) {
				startBtn.setImage(Sprites.ui_startH[0]);
			}
		});
		startBtn.setOnMouseExited(e -> {
			if (state == NORMAL) {
				startBtn.setImage(Sprites.ui_start[0]);
			}			
		});
		startBtn.setOnMouseClicked(e -> {
			if (state == NORMAL) {
				state = CUTSCENE;
				startBtn.setVisible(false);
				nameBanner.setVisible(false);
				animBg.stop();
				playStartAnimation((GraphicsContext)canvas.getGraphicsContext2D());
			}
		});
	}
}
