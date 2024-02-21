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
import com.bullethell.game.collision.CollisionManager;

public class MainGameClass extends ApplicationAdapter {
    GameObjectManager gameObjectManager;
    ShapeRenderer shapeRenderer;
    CollisionManager collisionManager;
    
    Player player;
    Enemy enemy;
    Projectile projectile;
    PowerUp powerUp;
    
    float deltaTime;
    
    @Override
    public void create () {
        gameObjectManager = new GameObjectManager();
        shapeRenderer = new ShapeRenderer(); // Initialize the ShapeRenderer
        collisionManager = new CollisionManager();
        
        // Initialize your game objects here and add them to the manager
        player = new Player(100, 100);
        enemy = new Enemy(200, 200);
        projectile = new Projectile(300, 300);
        powerUp = new PowerUp(400, 400);
        
        gameObjectManager.addGameObject(player);
        gameObjectManager.addGameObject(enemy);
        gameObjectManager.addGameObject(projectile);
        gameObjectManager.addGameObject(powerUp);

        // Add the game objects to the collision manager
        collisionManager.isCollidable(player);
        collisionManager.isCollidable(enemy);
        collisionManager.isCollidable(projectile);
        collisionManager.isCollidable(powerUp);

    }

    @Override
    public void render () {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1);
        deltaTime = Gdx.graphics.getDeltaTime();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled); // Or Line, depending on your preference
        gameObjectManager.update(deltaTime);
        gameObjectManager.draw(shapeRenderer); // Pass the ShapeRenderer to the draw method
        shapeRenderer.end();

        // Collision detection cycle (Might need to move to simulation class)
        for (int i = 0; i < collisionManager.getCollisionList().size; i++) {
            for (int j = i + 1; j < collisionManager.getCollisionList().size; j++) {
                if (collisionManager.checkCollision(collisionManager.getCollisionItem(i), collisionManager.getCollisionItem(j))) {
                    collisionManager.resolveCollision(collisionManager.getCollisionItem(i), collisionManager.getCollisionItem(j));
                }
            }
        }

    }
    
    @Override
    public void dispose () {
        gameObjectManager.dispose();
        shapeRenderer.dispose(); // Dispose of the ShapeRenderer
    }
}

