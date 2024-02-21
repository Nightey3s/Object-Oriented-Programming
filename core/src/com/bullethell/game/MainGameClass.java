package com.bullethell.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.IO.InputManager;
import com.bullethell.game.gameObject.GameObjectManager;
import com.bullethell.game.scene.SceneManager;

public class MainGameClass extends ApplicationAdapter {
    GameObjectManager gameObjectManager;
    ShapeRenderer shapeRenderer;
    SceneManager sceneManager;
    InputManager inputManager;
    
    @Override
    public void create () {
        gameObjectManager = new GameObjectManager();
        shapeRenderer = new ShapeRenderer();
        sceneManager = new SceneManager();
        inputManager = new InputManager();
    }
    
    @Override
    public void render() {
        
        InputManager.ScreenControl(sceneManager);
        sceneManager.loadScene();
  
    }
    
    @Override
    public void dispose () {
        gameObjectManager.dispose();
        shapeRenderer.dispose(); // Dispose of the ShapeRenderer
    }
}

