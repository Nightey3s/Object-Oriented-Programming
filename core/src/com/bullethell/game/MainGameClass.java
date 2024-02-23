package com.bullethell.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.Audio.AudioManager;
import com.bullethell.game.IO.InputManager;
import com.bullethell.game.gameObject.GameObjectManager;
import com.bullethell.game.scene.SceneManager;

public class MainGameClass {
    private GameObjectManager gameObjectManager;
    private ShapeRenderer shapeRenderer;
    private SceneManager sceneManager;
    private InputManager inputManager;
    private AudioManager audioManager;
    
    public MainGameClass () {
        sceneManager = new SceneManager();
        inputManager = new InputManager();
        audioManager = new AudioManager();
        shapeRenderer = new ShapeRenderer();
        gameObjectManager = new GameObjectManager(sceneManager);
        
        audioManager.playBackgroundMusic();
    }
    
    public void render() {

        inputManager.ScreenControl(sceneManager);
        sceneManager.loadScene();
  
    }
    
    public void dispose () {
        gameObjectManager.dispose();
        shapeRenderer.dispose(); // Dispose of the ShapeRenderer
    }
}

