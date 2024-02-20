package com.bullethell.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bullethell.game.gameObject.Enemy;
import com.bullethell.game.gameObject.GameObjectManager;
import com.bullethell.game.gameObject.Player;
import com.bullethell.game.gameObject.PowerUp;
import com.bullethell.game.gameObject.Projectile;

public class MainGameClass extends ApplicationAdapter {
    GameObjectManager gameObjectManager;
    ShapeRenderer shapeRenderer;
    
    Player player;
    Enemy enemy;
    Projectile projectile;
    PowerUp powerUp;
    
    float deltaTime;
    
    @Override
    public void create () {
        gameObjectManager = new GameObjectManager();
        shapeRenderer = new ShapeRenderer(); // Initialize the ShapeRenderer
        
        // Initialize your game objects here and add them to the manager
        player = new Player(100, 100);
        enemy = new Enemy(200, 200);
        projectile = new Projectile(300, 300);
        powerUp = new PowerUp(400, 400);
        
        gameObjectManager.addGameObject(player);
        gameObjectManager.addGameObject(enemy);
        gameObjectManager.addGameObject(projectile);
        gameObjectManager.addGameObject(powerUp);
    }

    @Override
    public void render () {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled); // Or Line, depending on your preference
        gameObjectManager.draw(shapeRenderer); // Pass the ShapeRenderer to the draw method
        shapeRenderer.end();
    }
    
    @Override
    public void dispose () {
        gameObjectManager.dispose();
        shapeRenderer.dispose(); // Dispose of the ShapeRenderer
    }
}

