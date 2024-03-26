package com.bullethell.game.Factory;

import com.bullethell.game.gameObject.*;
import com.bullethell.game.scene.SceneManager;

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

	public static GameObject createSmallRubbish(float x, float y) {

		return new SmallRubbish(SR_ASSET, SR_SPEED, x, y);

	}

	public static GameObject createBigRubbish(float x, float y) {

		return new BigRubbish(SR_ASSET, SR_SPEED, x, y);

	}

}
