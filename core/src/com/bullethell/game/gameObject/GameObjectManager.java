package com.bullethell.game.gameObject;

import java.util.Iterator;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.bullethell.game.Ai.AiManager;
import com.bullethell.game.Audio.AudioManager;
import com.bullethell.game.Factory.ObjectFactory;
import com.bullethell.game.collision.CollisionManager;
import com.bullethell.game.scene.SceneManager;

public class GameObjectManager implements Disposable {
	private Array<GameObject> gameObjects;
	private CollisionManager collisionManager;
	private AiManager aiManager;
	private SceneManager sceneManager; // Add SceneManager field
	private SpriteBatch batch;
	private float delta;
	private int cap = 5;
	private int count = 0;
	private int bigcap = 1;
	private int bigcount = 0;
	private Random random;
	private boolean randomBool;
	private int gameW = Gdx.graphics.getWidth();
	private int gameH = Gdx.graphics.getHeight();

	public GameObjectManager(SceneManager sceneManager) { // Add SceneManager parameter
		this.sceneManager = sceneManager; // Initialize SceneManager field
		gameObjects = new Array<>();
		collisionManager = new CollisionManager();
		collisionManager.setGameObjectManager(this);
		aiManager = new AiManager();
		// createPlayer(100, 100);
		// createEnemy(200, 800);
		createPowerUp(400, 400);
		createEarth(0, -250, gameW, gameW);
		createShip(200, 200, this, this.sceneManager);

		random = new Random();
		randomBool = random.nextBoolean();
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public void minuscount() {
		count -= 1;
	}

	public void pluscap() {
		cap += 1;
	}

	public void pluscount() {
		count += 1;
	}

	public void minusbigcount() {
		bigcount -= 1;
	}

	public void plusbigcap() {
		bigcap += 1;
	}

	public void plusbigcount() {
		bigcount += 1;
	}

	public void createPlayer(float x, float y) {
		Player player = ObjectFactory.createPlayer(x, y, this, sceneManager); // Pass SceneManager to Player constructor
		addGameObject(player);
		collisionManager.isCollidable(player);
	}

	public void createEnemy(float x, float y) {
		Enemy enemy = ObjectFactory.createEnemy(x, y);
		addGameObject(enemy);
		collisionManager.isCollidable(enemy);
		aiManager.addEnemy(enemy);
	}

	public void createProjectile(float x, float y) {
		Projectile projectile = ObjectFactory.createProjectile(x, y);
		addGameObject(projectile);
		collisionManager.isCollidable(projectile);
		AudioManager.getInstance().playBulletSound();
	}

	public void createPowerUp(float x, float y) {
		PowerUp powerUp = ObjectFactory.createPowerUp(x, y);
		addGameObject(powerUp);
		collisionManager.isCollidable(powerUp);
	}

	public void createEarth(float x, float y, int width, int height) {
		GameObject earth = ObjectFactory.createEarth(x, y, width, height);
		addGameObject(earth);
		collisionManager.isCollidable(earth);
	}

	public void createShip(float x, float y, GameObjectManager gameObjectManager, SceneManager sceneManager) {
		Ship ship = ObjectFactory.createShip(x, y, gameObjectManager, sceneManager);
		addGameObject(ship);
		collisionManager.isCollidable(ship);
	}

	public void createBigRubbish(float x, float y) {
		GameObject bigRubbish = ObjectFactory.createBigRubbish(x, y);
		addGameObject(bigRubbish);
		collisionManager.isCollidable(bigRubbish);
	}

	public void createSmallRubbish(float x, float y) {
		if (randomBool) {
			GameObject smallRubbish = ObjectFactory.createSmallRubbish(x, y, ObjectFactory.getRandomSmallTexture());
			addGameObject(smallRubbish);
			collisionManager.isCollidable(smallRubbish);
			randomBool = random.nextBoolean();
		}
		else {
			GameObject smallRubbish = ObjectFactory.createRecyclable(x, y, ObjectFactory.getRandomRecTexture());
			addGameObject(smallRubbish);
			collisionManager.isCollidable(smallRubbish);
			randomBool = random.nextBoolean();
		}
	}

	public void spawnBigRubbish() {
		float x = 100 + random.nextFloat() * (gameW - 200);
		float y = 600 + random.nextFloat() * (gameH - 600);
		createBigRubbish(x, y);
		pluscount();
		plusbigcount();
	}

	public void spawnSmallRubbish() {
		float x = 100 + random.nextFloat() * (gameW - 200);
		float y = 600 + random.nextFloat() * (gameH - 600);
		createSmallRubbish(x, y);
		pluscount();
	}

	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}

	public void removeGameObject(float delta, GameObject GO) {
		Iterator<GameObject> iterator = gameObjects.iterator();
		while (iterator.hasNext()) {
			GameObject gameObject = iterator.next();
			gameObject.update(delta);
			if (GO == gameObject) {
				iterator.remove();
				collisionManager.removeCollidable(GO);
				break;
			}
		}
	}

	public void update(float delta) {
		this.delta = delta;
		Iterator<GameObject> iterator = gameObjects.iterator();
		while (iterator.hasNext()) {
			GameObject gameObject = iterator.next();
			gameObject.update(delta);
			if (gameObject instanceof Enemy && ((Enemy) gameObject).isOutOfBounds()) {
				System.out.println("Enemy Destroyed");
				collisionManager.removeCollidable(gameObject);
				minuscount();
				if (gameObject instanceof BigRubbish) {
					minusbigcount();
				}
				iterator.remove();
			}
			if (gameObject instanceof Enemy && ((Enemy) gameObject).getHealth() <= 0) {
				System.out.println("Enemy Destroyed");
				collisionManager.removeCollidable(gameObject);
				if (gameObject instanceof BigRubbish) {
					minusbigcount();
				}
				minuscount();
				iterator.remove();
			}
			if (gameObject instanceof Projectile && ((Projectile) gameObject).isOutOfBounds()) {
				System.out.println("Projectile Destroyed");
				collisionManager.removeCollidable(gameObject);
				iterator.remove();
			}
			if (gameObject instanceof Ship && !((Player) gameObject).getFlashing()) {
				collisionManager.isCollidable(gameObject); // once flashing stops player can collide again
			}

		}
		while (count <= cap) {
			if (bigcount < bigcap) {
				int rand = random.nextInt();
				if (rand % 15 == 0) {
					spawnBigRubbish();
					System.out.println("bigcount " + bigcount);
				} else if (rand % 5 == 0) {
					spawnSmallRubbish();

				}
			} else {
				spawnSmallRubbish();
			}

		}

		// Collision detection cycle
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

	// public void draw(SpriteBatch batch)
	// {
	// for (GameObject gameObject : gameObjects)
	// {
	// gameObject.draw(batch);
	// }
	// }
	public float getDelta() {
		return delta;
	}

	public void draw(ShapeRenderer shape) {
		for (GameObject gameObject : gameObjects) {
			gameObject.draw(shape); // if has sprite will do nothing
		}
	}

	public void draw(SpriteBatch batch) {
		for (GameObject gameObject : gameObjects) {
			if (gameObject.getSprite() != null) { // Check if the GameObject has a Sprite
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
