package com.bullethell.game.Factory;

import com.bullethell.game.gameObject.*;
import com.bullethell.game.scene.SceneManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ObjectFactory {
	private static final String P_ASSET = "Player.png";
	private static final String SR_ASSET = "SmallRubbish.png";
	private static final String BR_ASSET = "BigRubbish.png";
	private static final float SR_SPEED = 100;
	private static final float BR_SPEED = 150;

	public static GameObject createPlayer(float x, float y, GameObjectManager gameObjectManager,
			SceneManager sceneManager) {
		return new Player(x, y, gameObjectManager, sceneManager);
	}

	public static Earth createEarth(float x, float y, int width, int height) {
		return new Earth(x,y,width,height);
	}

}