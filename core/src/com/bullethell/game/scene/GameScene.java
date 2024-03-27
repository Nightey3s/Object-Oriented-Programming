package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
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
        font = new BitmapFont(); // Initialize the BitmapFont
        this.sceneManager = sceneManager; // Initialize SceneManager field
        shapeRenderer = new ShapeRenderer(); // Initialize the ShapeRenderer
        this.batch = new SpriteBatch(); // Initialize the SpriteBatch
        gameObjectManager = new GameObjectManager(this.sceneManager); // Pass SceneManager to GameObjectManager constructor
        gameObjectManager.setBatch(batch);

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
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        gameObjectManager.draw(batch); // Pass the SpriteBatch to the draw method
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