package com.bullethell.game.IO;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.bullethell.game.ScoreManager;
import com.bullethell.game.scene.EndScene;
import com.bullethell.game.scene.GameScene;
import com.bullethell.game.scene.MainMenu;
import com.bullethell.game.scene.PauseScene;
import com.bullethell.game.scene.SceneManager;

public class InputManager {

    public InputManager() {
    }

    public static PlayerControl playerControl = new PlayerControl();

    public void ScreenControl(SceneManager sceneManager) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.P) && sceneManager.getCurrentScene() instanceof GameScene) {
            sceneManager.changeScene(sceneManager.getSceneItem(1)); // Pause when in game
        }

        // ==================(DEPRECATED VIA UI BUTTONS)==========================
        // if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {

        // if (sceneManager.getCurrentScene() instanceof MainMenu) {
        // sceneManager.startGame(); // Mainmenu play
        // sceneManager.changeScene(sceneManager.getSceneItem(3));
        // }else if (sceneManager.getCurrentScene() instanceof PauseScene){ // Pause
        // Screen Continue.
        // sceneManager.changeScene(sceneManager.getSceneItem(3));
        // }
        // else if(sceneManager.getCurrentScene() instanceof EndScene) {
        // ScoreManager.getInstance().resetScore();
        // sceneManager.changeScene(sceneManager.getSceneItem(0));
        // }
        // }
        
        // if (Gdx.input.isKeyJustPressed(Input.Keys.Q) &&
        // (sceneManager.getCurrentScene() instanceof GameScene)) {
        // sceneManager.quitGame();
        // sceneManager.changeScene(sceneManager.getSceneItem(0));
        // }

        // if (Gdx.input.isKeyJustPressed(Input.Keys.H) &&
        // (sceneManager.getCurrentScene() instanceof MainMenu)) {
        // sceneManager.changeScene(sceneManager.getSceneItem(2));
        // }
        // ======================================================================
    }
}
