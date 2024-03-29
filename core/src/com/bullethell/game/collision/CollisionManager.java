package com.bullethell.game.collision;

import com.badlogic.gdx.utils.Array;
import com.bullethell.game.ScoreManager;
import com.bullethell.game.Audio.AudioManager;
import com.bullethell.game.gameObject.Earth;
import com.bullethell.game.gameObject.Enemy;
import com.bullethell.game.gameObject.GameObject;
import com.bullethell.game.gameObject.GameObjectManager;
import com.bullethell.game.gameObject.Player;
import com.bullethell.game.gameObject.PowerUp;
import com.bullethell.game.gameObject.Projectile;
import com.bullethell.game.gameObject.Recyclable;

public class CollisionManager implements iCollision {
	private Array<GameObject> collisionList;
	private GameObjectManager gameObjectManager;
	private int bulletdamage = 10;
	private Earth earth;

	public void setGameObjectManager(GameObjectManager manager) {
		this.gameObjectManager = manager;
	}

	public void setEarth(Earth earth) {
		this.earth = earth;
	}

	// Constructor
	public CollisionManager() {
		this.collisionList = new Array<GameObject>();
	}

	// getters and setters
	public Array<GameObject> getCollisionList() {
		return collisionList;
	}

	public GameObject getCollisionItem(int index) {
		return collisionList.get(index);
	}

	@Override
	public void isCollidable(GameObject Object) { // Interface connects to gameObject and appends to CollisionList
		collisionList.add(Object);
	}

	public void removeCollidable(GameObject Object) {
		collisionList.removeValue(Object, true);
	}

	public boolean checkCollision(GameObject Object1, GameObject Object2) {
		return Object1.getBounds().overlaps(Object2.getBounds());
	}

	public void resolveCollision(GameObject Object1, GameObject Object2) {
		if (Object1 instanceof Player && Object2 instanceof Enemy) { // Player and Enemy collision
			System.out.println("Player moved into the enemy - takes damage");
			AudioManager.getInstance().playCollisionSound();
			// Both Player and Enemy takes 20 damage
			((Player) Object1).takeDamage(20);
			((Enemy) Object2).takeDamage(20);
		} else if (Object1 instanceof Enemy && Object2 instanceof Player) { // Enemy and Player collision
			System.out.println("Enemy hit the Player - takes damage");
			AudioManager.getInstance().playCollisionSound();
			// Both Player and Enemy takes 20 damage
			((Enemy) Object1).takeDamage(20);
			((Player) Object2).takeDamage(20);
		} else if (Object1 instanceof Enemy && Object2 instanceof Earth) { // Enemy and Earth collision
			System.out.println("Enemy hit the Earth - takes damage");
			AudioManager.getInstance().playCollisionSound();
			// Both Earth and Enemy takes 20 damage
			((Enemy) Object1).takeDamage(20);
			((Earth) Object2).takeDamage(20);
		} else if (Object1 instanceof Earth && Object2 instanceof Enemy) { // Earth and Enemy collision
			System.out.println("Enemy hit the Earth - takes damage");
			AudioManager.getInstance().playCollisionSound();
			// Both Earth and Enemy takes 20 damage
			((Earth) Object1).takeDamage(20);
			((Enemy) Object2).takeDamage(20);
		} else if (Object1 instanceof Player && Object2 instanceof PowerUp) { // Player and PowerUp collision
			System.out.println("Player picked up power up");
			PowerUp powerUp = (PowerUp) Object2;
			// Remove the power-up from the game
			powerUp.applyPowerUp(player, earth);
			gameObjectManager.removeGameObject(gameObjectManager.getDelta(), powerUp);
			AudioManager.getInstance().playCollectSound();

		} else if (Object1 instanceof Projectile && Object2 instanceof Enemy) { // Projectile and Enemy collision
			gameObjectManager.removeGameObject(gameObjectManager.getDelta(), Object1);
			((Enemy) Object2).takeDamage(bulletdamage);
			System.out.println("Projectile hit enemy");
			AudioManager.getInstance().playBulletCollision();
			Player player = null;
			for (GameObject obj : collisionList) {
				if (obj instanceof Player) {
					player = (Player) obj;
					break;
				}
			}
			if (player.isAlive()) {
				ScoreManager.getInstance().addScore(10); // Add 10 points to the score
			}
		} else if (Object1 instanceof Enemy && Object2 instanceof Projectile) { // Enemy and Projectile collision
			gameObjectManager.removeGameObject(gameObjectManager.getDelta(), Object2);
			((Enemy) Object1).takeDamage(10);
			System.out.println("Projectile hit enemy");
			AudioManager.getInstance().playBulletCollision();
			Player player = null;
			for (GameObject obj : collisionList) {
				if (obj instanceof Player) {
					player = (Player) obj;
					break;
				}
			}
			if (player.isAlive()) {
				ScoreManager.getInstance().addScore(10); // Add 10 points to the score
			}
		} else if (Object1 instanceof Recyclable && Object2 instanceof Earth) { // Recyclable and Earth
			// Earth recover 20 health
			AudioManager.getInstance().playHealSound();
			((Recyclable) Object1).takeDamage(20);
			if (((Earth) Object2).getHealth() < 100) {
				((Earth) Object2).increaseHealth(20);
			}

			ScoreManager.getInstance().addScore(20);


		} else if (Object1 instanceof Earth && Object2 instanceof Recyclable) { // Earth and Recyclable
			// Earth recover 20 health
			AudioManager.getInstance().playHealSound();
			if (((Earth) Object1).getHealth() < 100) {
				((Earth) Object1).increaseHealth(20);
			}
			((Recyclable) Object2).takeDamage(20);

			ScoreManager.getInstance().addScore(20);
		} else if (Object1 instanceof Recyclable && Object2 instanceof Projectile) { // Recyclable and Projectile
			gameObjectManager.removeGameObject(gameObjectManager.getDelta(), Object2);
			((Recyclable) Object1).takeDamage(10);
			System.out.println("Projectile hit Recyclable");
			AudioManager.getInstance().playBulletCollision2();
			Player player = null;
			for (GameObject obj : collisionList) {
				if (obj instanceof Player) {
					player = (Player) obj;
					break;
				}
			}
			if (player.isAlive()) {
				ScoreManager.getInstance().addScore(-10);
			}
		} else if (Object1 instanceof Projectile && Object2 instanceof Recyclable) { // Projectile and Recyclable
			gameObjectManager.removeGameObject(gameObjectManager.getDelta(), Object1);
			((Recyclable) Object2).takeDamage(10);
			System.out.println("Projectile hit Recyclable");
			AudioManager.getInstance().playBulletCollision2();
			Player player = null;
			for (GameObject obj : collisionList) {
				if (obj instanceof Player) {
					player = (Player) obj;
					break;
				}
			}
			if (player.isAlive()) {
				ScoreManager.getInstance().addScore(-10);
			}
		}
	}

}