package com.bullethell.game.IO;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.bullethell.game.scene.GameScene;
import com.bullethell.game.scene.MainMenu;
import com.bullethell.game.scene.SceneManager;

public class InputManager {
	public static PlayerControl playerControl = new PlayerControl();

    public static void ScreenControl(SceneManager sceneManager) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
        	
        	if (sceneManager.getCurrentScene() instanceof MainMenu) {
            	sceneManager.startGame();
                sceneManager.changeScene(sceneManager.getSceneItem(2));
        	}else {
        		sceneManager.changeScene(sceneManager.getSceneItem(2));
			}

        }
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.P) && sceneManager.getCurrentScene() instanceof GameScene) {
            sceneManager.changeScene(sceneManager.getSceneItem(1));
        }
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q) && !(sceneManager.getCurrentScene() instanceof MainMenu)) {
        	sceneManager.quitGame();
            sceneManager.changeScene(sceneManager.getSceneItem(0));
            
        }
    }
}

