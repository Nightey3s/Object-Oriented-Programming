package com.bullethell.game.Factory;

import com.bullethell.game.Ai.AIPatterns;
import com.bullethell.game.gameObject.*;
import com.bullethell.game.scene.SceneManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

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
		add("SmallRubbish.png");
	}};
	private static final List<String> BIGTEXTURE_PATHS = new ArrayList<String>() {{
		add("toxic.png");
		add("BigRubbish.png");
	}};

	public static String getRandomSmallTexture() {
		int randomIndex = (int) (Math.random() * SMALLTEXTURE_PATHS.size());
		return SMALLTEXTURE_PATHS.get(randomIndex);
	}

	public static String getRandomBigTexture() {
		int randomIndex = (int) (Math.random() * BIGTEXTURE_PATHS.size());
		return BIGTEXTURE_PATHS.get(randomIndex);
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

	public static Enemy createEnemy(float x, float y) {
		return new Enemy(x, y);
	}

	public static Projectile createProjectile(float x, float y) {
		return new Projectile(x, y);
	}

	public static PowerUp createPowerUp(float x, float y) {
		return new PowerUp(x, y);
	}
}
