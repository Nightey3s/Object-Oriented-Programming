package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bullethell.game.ScoreManager;
import com.bullethell.game.gameObject.GameObjectManager;

public class GameScene extends Scene{
    private GameObjectManager gameObjectManager;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font;
    private SpriteBatch batch;
    private SceneManager sceneManager; 

        
    private float deltaTime;

    public GameScene(SceneManager sceneManager) {
        super();
        this.sceneManager = sceneManager; // Initialize SceneManager field
        gameObjectManager = new GameObjectManager(this.sceneManager); // Pass SceneManager to GameObjectManager constructor
        shapeRenderer = new ShapeRenderer(); // Initialize the ShapeRenderer
        font = new BitmapFont(); // Initialize the BitmapFont
        batch = new SpriteBatch(); // Initialize the SpriteBatch
    }

    @Override
    public void sceneRender() {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1);
        deltaTime = Gdx.graphics.getDeltaTime();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled); // Or Line, depending on your preference
        gameObjectManager.update(deltaTime);
        gameObjectManager.draw(shapeRenderer); // Pass the ShapeRenderer to the draw method
        shapeRenderer.end();

        // Display the current score
        batch.begin();
        font.draw(batch, "Score: " + ScoreManager.getInstance().getScore(), 10, Gdx.graphics.getHeight() - 10);
        batch.end();
    }
    
    @Override
    public void dispose()
    {
        super.dispose();
        font.dispose(); // Dispose the BitmapFont
        batch.dispose(); // Dispose the SpriteBatch
    }
}