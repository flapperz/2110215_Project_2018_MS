package input;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Input {
	private static Set<KeyCode> activeKeys = new HashSet<>();
	private static Set<KeyCode> triggerKeys = new HashSet<>();

	private static boolean leftMouseActive;
	private static boolean rightMouseActive;
	private static boolean leftMouseTrigger;
	private static boolean rightMouseTrigger;
	private static double mouseX;
	private static double mouseY;

	private static void addKey(KeyCode code) {
		if (!activeKeys.contains(code)) {
			triggerKeys.add(code);
		}
		activeKeys.add(code);
	}
	
	private static void removeKey(KeyCode code) {
		activeKeys.remove(code);
	}
	
	public static void clear() {
		activeKeys.clear();
	}
	
	public static void bindScene(Scene scene) {
		scene.setOnKeyPressed((KeyEvent event) -> addKey(event.getCode()));
		scene.setOnKeyReleased((KeyEvent event) -> removeKey(event.getCode()));
		scene.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		scene.setOnMousePressed(e -> {
			MouseButton b = e.getButton();
			if (b == MouseButton.PRIMARY) {
				leftMouseActive = true;
				leftMouseTrigger = true;
			} else if (b == MouseButton.SECONDARY) {
				rightMouseActive = true;
				rightMouseActive = true;
			}
		});
		scene.setOnMouseReleased(e -> {
			MouseButton b = e.getButton();
			if (b == MouseButton.PRIMARY) {
				leftMouseActive = false;
				leftMouseTrigger = false;
			} else if (b == MouseButton.SECONDARY) {
				rightMouseActive = false;
				rightMouseActive = false;
			}
		});
	}
	
	public static void unBindScene(Scene scene) {
		scene.setOnKeyPressed(null);
		scene.setOnKeyReleased(null);
	}
	
	public static boolean isKeyActive(KeyCode code) {
		return activeKeys.contains(code);
	}
	
	public static boolean isKeyTrigger(KeyCode code) {
			return triggerKeys.remove(code);
	}
	
	public boolean isLeftMouseActive() {
		return leftMouseActive;
	}
	
	public boolean isRightMouseActive() {
		return rightMouseActive;
	}
	
	public boolean isLeftMouseTrigger() {
		try{
			return leftMouseTrigger;
		} finally {
			leftMouseTrigger = false;
		}
	}
	
	public boolean isRightMouseTrigger() {
		try {
			return rightMouseTrigger;			
		} finally {
			rightMouseTrigger = false;
		}
		
	}
	
	public double getMouseX() {
		return mouseX;
	}
	
	public double getMouseY() {
		return mouseY;
	}

	
}
