package resource.scene;

import javafx.scene.Scene;

public class Scenes {
	
	private static Scene loadingScene = new LoadingScene();
	private static Scene startScene;
	private static Scene gameScene;
	
	
	public static void loadResource() {
		startScene = new StartScene();
		gameScene = new GameScene();
	}
	
	//Scene getter

	public static Scene getLoadingScene() {
		return loadingScene;
	}

	public static Scene getStartScene() {
		return startScene;
	}

	public static Scene getGameScene() {
		return gameScene;
	}

	public static void setLoadingScene(Scene loadingScene) {
		Scenes.loadingScene = loadingScene;
	}

	public static void setStartScene(Scene startScene) {
		Scenes.startScene = startScene;
	}

	public static void setGameScene(Scene gameScene) {
		Scenes.gameScene = gameScene;
	}

	
}
