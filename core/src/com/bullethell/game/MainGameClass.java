package com.bullethell.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bullethell.game.gameObject.GameObjectManager;

public class MainGameClass extends ApplicationAdapter {
	private GameObjectManager gameObjectManager;
    private ShapeRenderer shapeRenderer;  
    private float deltaTime;
    
    @Override
    public void create () {
        gameObjectManager = new GameObjectManager();
        shapeRenderer = new ShapeRenderer(); // Initialize the ShapeRenderer
        
    }

    @Override
    public void render () {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1);
        deltaTime = Gdx.graphics.getDeltaTime();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled); // Or Line, depending on your preference
        gameObjectManager.update(deltaTime);
        gameObjectManager.draw(shapeRenderer); // Pass the ShapeRenderer to the draw method
        shapeRenderer.end();

    }
    
    @Override
    public void dispose () {
        gameObjectManager.dispose();
        shapeRenderer.dispose(); // Dispose of the ShapeRenderer
    }
}

