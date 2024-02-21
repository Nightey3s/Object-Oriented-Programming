package com.bullethell.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bullethell.game.gameObject.GameObjectManager;
import com.bullethell.game.gameObject.Player;
import com.bullethell.game.gameObject.PowerUp;
import com.bullethell.game.gameObject.Projectile;
import com.bullethell.game.scene.SceneManager;
import com.badlogic.gdx.Input.Keys;

public class MainGameClass extends ApplicationAdapter {
    GameObjectManager gameObjectManager;
    ShapeRenderer shapeRenderer;
    SceneManager sceneManager;
    
    @Override
    public void create () {
        gameObjectManager = new GameObjectManager();
        shapeRenderer = new ShapeRenderer();
        sceneManager = new SceneManager();
    }
    
    @Override
    public void render() {
        sceneManager.loadScene();
        // if press space, change scene to game
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && sceneManager.getCurrentScene() == sceneManager.getSceneItem(0)) {
            sceneManager.changeScene(sceneManager.getSceneItem(1));
        }
        
        if (Gdx.input.isKeyPressed(Input.Keys.P) && sceneManager.getCurrentScene() == sceneManager.getSceneItem(1)) {
            sceneManager.changeScene(sceneManager.getSceneItem(0));
        }
  
    }
    
    @Override
    public void dispose () {
        gameObjectManager.dispose();
        shapeRenderer.dispose(); // Dispose of the ShapeRenderer
    }
}

