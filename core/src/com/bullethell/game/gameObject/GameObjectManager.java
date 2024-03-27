package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.bullethell.game.Ai.AIPatterns;
import com.bullethell.game.Ai.AiManager;
import com.bullethell.game.Audio.AudioManager;
import com.bullethell.game.collision.CollisionManager;
import com.bullethell.game.scene.SceneManager;
import com.bullethell.game.Factory.ObjectFactory;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameObjectManager implements Disposable {
    private Array<GameObject> gameObjects;
    private CollisionManager collisionManager;
    private AiManager aiManager;
    private SceneManager sceneManager; // Add SceneManager field
	private SpriteBatch batch;

    public GameObjectManager(SceneManager sceneManager) { // Add SceneManager parameter
        this.sceneManager = sceneManager; // Initialize SceneManager field
        gameObjects = new Array<>();
        collisionManager = new CollisionManager();
        aiManager = new AiManager();
        createPlayer(100, 100);
        createEnemy(200, 200);
        createPowerUp(400, 400);
		createEarth(Gdx.graphics.getWidth()/2, 50, 200, 200);
    }

	public void setBatch(SpriteBatch batch) { 
		this.batch = batch;
	}

    public void createPlayer(float x, float y) {
        Player player = new Player(x, y, this, sceneManager); // Pass SceneManager to Player constructor
        addGameObject(player);
        collisionManager.isCollidable(player);
    }

	public void createEnemy(float x, float y) {
		Enemy enemy = new Enemy(x, y);
		addGameObject(enemy);
		collisionManager.isCollidable(enemy);
		aiManager.addEnemy(enemy);
	}

	public void createProjectile(float x, float y) {
		Projectile projectile = new Projectile(x, y);
		addGameObject(projectile);
		collisionManager.isCollidable(projectile);
		AudioManager.getInstance().playBulletSound();
	}

	public void createPowerUp(float x, float y) {
		PowerUp powerUp = new PowerUp(x, y);
		addGameObject(powerUp);
		collisionManager.isCollidable(powerUp);
	}

	public void createEarth(float x, float y, int width, int height) {
		Earth earth = ObjectFactory.createEarth(x, y, width, height);
		addGameObject(earth);
		collisionManager.isCollidable(earth);
	}

	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}

	public void update(float delta) {
		for (GameObject gameObject : gameObjects) {
			gameObject.update(delta);
			if (gameObject instanceof Projectile && ((Projectile) gameObject).isOutOfBounds()) {
				// TO DO: Actually remove the projectile from the gameObjects array
				System.out.println("Projectile Destroyed");

			}
		}

		// Collision detection cycle (Might need to move to simulation class)
		for (int i = 0; i < collisionManager.getCollisionList().size; i++) {
			for (int j = i + 1; j < collisionManager.getCollisionList().size; j++) {
				if (collisionManager.checkCollision(collisionManager.getCollisionItem(i),
						collisionManager.getCollisionItem(j))) {
					collisionManager.resolveCollision(collisionManager.getCollisionItem(i),
							collisionManager.getCollisionItem(j));
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

	public void draw(ShapeRenderer shape) {
		for (GameObject gameObject : gameObjects) {
			gameObject.draw(shape); // if has sprite will do nothing
		}
	}

	public void draw(SpriteBatch batch) {
		for (GameObject gameObject : gameObjects) {
			if (gameObject.getSprite() != null) {  // Check if the GameObject has a Sprite
				gameObject.draw(batch);
			}
		}
	}

	@Override
	public void dispose() {
		for (GameObject gameObject : gameObjects) {
			if (gameObject instanceof Disposable) {
				((Disposable) gameObject).dispose();
			}
		}
	}
}
