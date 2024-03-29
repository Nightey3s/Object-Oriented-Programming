package com.bullethell.game.Factory;

import java.util.ArrayList;
import java.util.List;

import com.bullethell.game.gameObject.BigRubbish;
import com.bullethell.game.gameObject.Earth;
import com.bullethell.game.gameObject.Enemy;
import com.bullethell.game.gameObject.GameObject;
import com.bullethell.game.gameObject.GameObjectManager;
import com.bullethell.game.gameObject.Player;
import com.bullethell.game.gameObject.PowerUp;
import com.bullethell.game.gameObject.Projectile;
import com.bullethell.game.gameObject.Ship;
import com.bullethell.game.gameObject.SmallRubbish;
import com.bullethell.game.gameObject.Recyclable;
import com.bullethell.game.scene.SceneManager;


public class ObjectFactory {
	private static final String P_ASSET = "Player.png";
	private static final String SR_ASSET = "SmallRubbish.png";
	private static final String BR_ASSET = "BigRubbish.png";
	private static final float SR_SPEED = 100;
	private static final float BR_SPEED = 150;
	private static final int BR_W= 100;
	private static final int BR_H= 100;
	private static final int SR_W = 40;
	private static final int SR_H = 50;
	
	private static final List<String> SMALLTEXTURE_PATHS = new ArrayList<String>() {{
		add("battery.png");
		add("styrofoam_cup.png");
		add("styrofoam_box.png");
		add("food.png");
	}};
	private static final List<String> BIGTEXTURE_PATHS = new ArrayList<String>() {{
		add("toxic.png");
		add("BigRubbish.png");
	}};
	private static final List<String> POWERUPTEXTURE_PATHS = new ArrayList<String>() {{
		add("upHealth.png");
		add("upTime.png");
		add("x2Dmg.png");
		add("x2Points.png");

	}};

	private static final List<String> RECTEXTURE_PATHS = new ArrayList<String>() {{
		add("cardboard.png");
		add("bottle.png");
		add("canDrinks.png");
		add("newspaper.png");
		add("glass.png");
	}};

	public static String getRandomSmallTexture() {
		int randomIndex = (int) (Math.random() * SMALLTEXTURE_PATHS.size());
		return SMALLTEXTURE_PATHS.get(randomIndex);
	}

	public static String getRandomBigTexture() {
		int randomIndex = (int) (Math.random() * BIGTEXTURE_PATHS.size());
		return BIGTEXTURE_PATHS.get(randomIndex);
	}
	public static String getRandomPowerUp() {
		int randomIndex = (int) (Math.random() * POWERUPTEXTURE_PATHS.size());
		return POWERUPTEXTURE_PATHS.get(randomIndex);
	}

	public static String getRandomRecTexture() {
		int randomIndex = (int) (Math.random() * RECTEXTURE_PATHS.size());
		return RECTEXTURE_PATHS.get(randomIndex);
	}

	public static Player createPlayer(float x, float y, GameObjectManager gameObjectManager,
			SceneManager sceneManager) {
		return new Player(x, y, gameObjectManager, sceneManager);
	}

	public static GameObject createEarth(float x, float y, int width, int height) {
		return new Earth(x, y, width, height);
	}

	public static Ship createShip(float x, float y, GameObjectManager gameObjectManager, SceneManager sceneManager) {
		return new Ship(x, y, gameObjectManager, sceneManager);
	}

	public static GameObject createBigRubbish(float x, float y) {
		return new BigRubbish(x, y, BR_W, BR_H, BR_ASSET);
	}

	public static GameObject createSmallRubbish(float x, float y, String texfilepath) {
		return new SmallRubbish(x, y, SR_W, SR_H, texfilepath);
	}

	public static GameObject createRecyclable(float x, float y, String texfilepath) {
		return new Recyclable(x, y, SR_W, SR_H, texfilepath);
	}

	public static Enemy createEnemy(float x, float y) {
		return new Enemy(x, y);
	}

	public static Projectile createProjectile(float x, float y) {
		return new Projectile(x, y);
	}

	public static PowerUp createPowerUp(float x, float y, String texfilepath) {
		return new PowerUp(x, y, 64, 64, texfilepath); // Adjust size as needed
	}
}
