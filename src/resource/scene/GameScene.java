package resource.scene;

import constants.Const;
import controller.GameLogic;
import controller.SharedEntity;
import controller.View;
import input.Input;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import main.Main;
import resource.Sounds;
import resource.Sprites;

public class GameScene extends Scene {
	
	private Pane root;
	private Canvas canvas;
	
	private MediaPlayer bgm;
	
	private Timeline tl;
	
	public GameScene() {
		super(new Pane());
		root = (Pane)getRoot();
		root.setStyle("-fx-background-color: #FFFFFF;");
		
		bgm = new MediaPlayer(new Media(Sounds.bgm_game.getSource())); //fix audio not play bug
		bgm.setCycleCount(MediaPlayer.INDEFINITE);
		
		canvas = new Canvas(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		
		setCursor(new ImageCursor(Sprites.ui_cursor[0]));
		
		Input.bindScene(this);
		
		addMainTimeline(gc);
		
				
	}
	
	public MediaPlayer getBgm() {
		return bgm;
	}

	public void setBgm(AudioClip bgm) {
		this.bgm = new MediaPlayer(new Media(bgm.getSource()));
	}

	private void addMainTimeline(GraphicsContext gc) {
		tl = new Timeline(new KeyFrame(Duration.seconds(1/60.), e -> {
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
		bgm.play();
	}
	
	public void pauseMainTimeline() {
		tl.pause();
	}
	
	public void stopMainTimeline() {
		tl.stop();
		bgm.stop();
	}
	
	public void playOverAnim() {
		Sounds.bgm_gameOver.play();
		ImageView gameOver = new ImageView(Sprites.bg_over[0]);
		gameOver.setX(0);
		gameOver.setY(0);
		Text scoreText = new Text("SCORE : " + Integer.toString(GameLogic.getInstance().getScore()));
		Text killText = new Text("KILL : " + Integer.toString(GameLogic.getInstance().getKillCount()));
		scoreText.setFont(new Font(100));
		killText.setFont(new Font(100));
		scoreText.setX(200);
		scoreText.setY(600);
		killText.setX(200);
		killText.setY(700);
		root.getChildren().add(gameOver);
		root.getChildren().addAll(scoreText, killText);
		
		FadeTransition ft = new FadeTransition(Duration.seconds(1),gameOver);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
		gameOver.setOnMouseClicked(e -> {
			gameReset();
		});
	}
	
	public void playWinAnim() {
		Sounds.bgm_victory.play();
		ImageView gameWin = new ImageView(Sprites.bg_win[0]);
		gameWin.setX(0);
		gameWin.setY(0);
		Text scoreText = new Text("SCORE : " + Integer.toString(GameLogic.getInstance().getScore()));
		Text killText = new Text("KILL : " + Integer.toString(GameLogic.getInstance().getKillCount()));
		scoreText.setFont(new Font(120));
		killText.setFont(new Font(120));
		scoreText.setX(200);
		scoreText.setY(600);
		killText.setX(200);
		killText.setY(700);
		root.getChildren().add(gameWin);
		root.getChildren().addAll(scoreText, killText);
		
		FadeTransition ft = new FadeTransition(Duration.seconds(1),gameWin);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
		gameWin.setOnMouseClicked(e -> {
			gameReset();
		});
	}
	
	public void gameReset() {
		GameLogic.getInstance().reset();
		SharedEntity.getInstance().reset();
		View.getInstance().reset();
		Scenes.setStartScene((Scene)new StartScene());
		Scenes.setGameScene((Scene)new GameScene());
		Main.getStage().setScene(Scenes.getStartScene());
	}
	
	
	
	
	
	
	
}
