package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.bullethell.game.collision.CollisionManager;

public class GameObjectManager implements Disposable {
    private Array<GameObject> gameObjects;
    private CollisionManager collisionManager;
    
    public GameObjectManager()
    {
        gameObjects = new Array<>();
        collisionManager = new CollisionManager();
        createPlayer(100, 100);
        createEnemy(200, 200);
        createPowerUp(400, 400);
    }
    
    public void createPlayer(float x, float y)
    {
        Player player = new Player(x, y, this);
        addGameObject(player);
        collisionManager.isCollidable(player);
    }

    public void createEnemy(float x, float y)
    {
        Enemy enemy = new Enemy(x, y);
        addGameObject(enemy);
        collisionManager.isCollidable(enemy);
    }

    public void createProjectile(float x, float y) {
        Projectile projectile = new Projectile(x, y);
        addGameObject(projectile);
        collisionManager.isCollidable(projectile);
    }

    public void createPowerUp(float x, float y) {
        PowerUp powerUp = new PowerUp(x, y);
        addGameObject(powerUp);
        collisionManager.isCollidable(powerUp);
    }


    public void addGameObject(GameObject gameObject)
    {
        gameObjects.add(gameObject);
    }

    public void update(float delta)
    {
        for (GameObject gameObject : gameObjects)
        {
            gameObject.update(delta);
            if (gameObject instanceof Projectile && ((Projectile) gameObject).isOutOfBounds())
            {
            	
            	System.out.println("Projectile Destroyed");
            	
            }
        }
        
        // Collision detection cycle (Might need to move to simulation class)
        for (int i = 0; i < collisionManager.getCollisionList().size; i++) {
            for (int j = i + 1; j < collisionManager.getCollisionList().size; j++) {
                if (collisionManager.checkCollision(collisionManager.getCollisionItem(i), collisionManager.getCollisionItem(j))) {
                	collisionManager.resolveCollision(collisionManager.getCollisionItem(i), collisionManager.getCollisionItem(j));
                }
            }
        }
    }

//    public void draw(SpriteBatch batch)
//    {
//        for (GameObject gameObject : gameObjects)
//        {
//            gameObject.draw(batch);
//        }
//    }
    
    public void draw(ShapeRenderer shape)
    {
        for (GameObject gameObject : gameObjects)
        {
            gameObject.draw(shape);
        }
    }

    @Override
    public void dispose()
    {
        for (GameObject gameObject : gameObjects)
        {
            if (gameObject instanceof Disposable)
            {
                ((Disposable) gameObject).dispose();
            }
        }
    }
}
