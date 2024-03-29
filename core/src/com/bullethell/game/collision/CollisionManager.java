package com.bullethell.game.collision;

import com.badlogic.gdx.utils.Array;
import com.bullethell.game.gameObject.GameObject;
import com.bullethell.game.gameObject.GameObjectTypes;
import com.bullethell.game.gameObject.GameObjectManager;
import com.bullethell.game.ScoreManager;
import com.bullethell.game.Audio.AudioManager;
import com.bullethell.game.gameObject.Enemy;
import com.bullethell.game.gameObject.Player;
import com.bullethell.game.gameObject.PowerUp;
import com.bullethell.game.gameObject.Projectile;

public class CollisionManager implements iCollision {
	private Array<GameObject> collisionList;
	private GameObjectManager gameObjectManager;

	public void setGameObjectManager(GameObjectManager manager) {
		this.gameObjectManager = manager;
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

	// Might have to add remove method depending on implementation of destroying
	// objects.

	public boolean checkCollision(GameObject Object1, GameObject Object2) {
		return Object1.getBounds().overlaps(Object2.getBounds());
	}

	// =====================Deprecated in favor of switch-cases.=====================
	// public void resolveCollision(GameObject Object1, GameObject Object2) {
	// 	if (Object1 instanceof Player && Object2 instanceof Enemy) {
	// 		System.out.println("Player moved into the enemy - takes damage");
	// 		AudioManager.getInstance().playCollisionSound();
	// 		((Player) Object1).takeDamage(10); // Player takes 10 damage
	// 	} else if (Object1 instanceof Enemy && Object2 instanceof Player) {
	// 		System.out.println("Enemy hit the Player - takes damage");
	// 		AudioManager.getInstance().playCollisionSound();
	// 		((Player) Object2).takeDamage(10); // Player takes 10 damage
	// 	} else if (Object1 instanceof Player && Object2 instanceof PowerUp) {
	// 		System.out.println("Player picked up power up");
	// 		AudioManager.getInstance().playCollectSound();
	// 	} else if (Object1 instanceof Projectile && Object2 instanceof Enemy) {
	// 		gameObjectManager.removeGameObject(gameObjectManager.getDelta(), Object1);
	// 		((Enemy) Object2).takeDamage(10);
	// 		System.out.println("Projectile hit enemy");
	// 		AudioManager.getInstance().playBulletCollision();
	// 		Player player = null;
	// 		for (GameObject obj : collisionList) {
	// 			if (obj instanceof Player) {
	// 				player = (Player) obj;
	// 				break;
	// 			}
	// 		}
	// 		if (player.isAlive()) {
	// 			ScoreManager.getInstance().addScore(10); // Add 10 points to the score
	// 		}
	// 	} else if (Object1 instanceof Enemy && Object2 instanceof Projectile) {
	// 		gameObjectManager.removeGameObject(gameObjectManager.getDelta(), Object2);
	// 		((Enemy) Object1).takeDamage(10);
	// 		System.out.println("Projectile hit enemy");
	// 		AudioManager.getInstance().playBulletCollision();
	// 		Player player = null;
	// 		for (GameObject obj : collisionList) {
	// 			if (obj instanceof Player) {
	// 				player = (Player) obj;
	// 				break;
	// 			}
	// 		}
	// 		if (player.isAlive()) {
	// 			ScoreManager.getInstance().addScore(10); // Add 10 points to the score
	// 		}
	// 	} else {

	// 	}
	// } ===================================================================================

	// Using switch-cases allows our code to be better maintained and extensible
	// instead of instanceof checks.
	public void resolveCollision(GameObject Object1, GameObject Object2) {
		switch (Object1.getType()) {
			case Player:
				if (Object2.getType() == GameObjectTypes.Enemy) { // Player and Enemy
					System.out.println("Player moved into the enemy - takes damage");
					AudioManager.getInstance().playCollisionSound();
					((Player) Object1).takeDamage(10);

				} else if (Object2.getType() == GameObjectTypes.PowerUp) { // Player and PowerUp
					System.out.println("Player picked up power up");
					AudioManager.getInstance().playCollectSound();
				}

				break;

			case Projectile:
				if (Object2.getType() == GameObjectTypes.Enemy) { // Projectile and Enemy
					gameObjectManager.removeGameObject(gameObjectManager.getDelta(), Object1);
					((Enemy) Object2).takeDamage(10); // damage need to be a variable of Player's Damage state.
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
						ScoreManager.getInstance().addScore(10);
					}
				}
				break;

			case Enemy: {
				if (Object2.getType() == GameObjectTypes.Player) { // Enemy and Player
					System.out.println("Enemy hit the Player - takes damage");
					AudioManager.getInstance().playCollisionSound();
					((Player) Object2).takeDamage(10);

				} else if (Object2.getType() == GameObjectTypes.Projectile) { // Enemy and Projectile
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
				}
			}

			case PowerUp: {
				if (Object2.getType() == GameObjectTypes.Player) { // PowerUp and Player
					System.out.println("Player picked up power up");
					AudioManager.getInstance().playCollectSound();
				}
			}

			case Earth: {

			}
		}
	}

}