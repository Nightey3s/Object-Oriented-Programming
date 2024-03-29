package com.bullethell.game.IO;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input;
import com.bullethell.game.scene.GameScene;
import com.bullethell.game.scene.SceneManager;

public class InputManager {

	public InputManager() {
	}

	public static PlayerControl playerControl = new PlayerControl();

	public void ScreenControl(SceneManager sceneManager) {

		if (Gdx.input.isKeyJustPressed(Input.Keys.P) && sceneManager.getCurrentScene() instanceof GameScene) {
			sceneManager.changeScene(sceneManager.getSceneItem(1)); // Pause when in game
		}

	}
}
