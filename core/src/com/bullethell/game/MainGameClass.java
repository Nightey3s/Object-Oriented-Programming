package com.bullethell.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.IO.InputManager;
import com.bullethell.game.gameObject.GameObjectManager;
import com.bullethell.game.scene.GameScene;
import com.bullethell.game.scene.MainMenu;
import com.bullethell.game.scene.Scene;
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
        
        // if press space, change scene to game
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
        	
        	if (sceneManager.getCurrentScene() instanceof MainMenu) {
            	sceneManager.startGame();
                sceneManager.changeScene(sceneManager.getSceneItem(2));
        	}else {
        		sceneManager.changeScene(sceneManager.getSceneItem(2));
			}

        }
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            sceneManager.changeScene(sceneManager.getSceneItem(1));
        }
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
        	sceneManager.quitGame();
            sceneManager.changeScene(sceneManager.getSceneItem(0));
            
        }
        sceneManager.loadScene();
  
    }
    
    @Override
    public void dispose () {
        gameObjectManager.dispose();
        shapeRenderer.dispose(); // Dispose of the ShapeRenderer
    }
}

