package com.bullethell.game.Ai;

import com.badlogic.gdx.math.Rectangle;
import com.bullethell.game.gameObject.Enemy;

public class GothroughPattern extends AIPatterns {
	private float gameX;
	private float gameY;
	private float delta;

	public GothroughPattern(float gameX, float gameY, float delta) {
		this.gameX = gameX;
		this.gameY = gameY;
		this.delta = delta;
	}

	@Override
	public void move(Enemy entity) {
		// TODO Auto-generated method stub
		Rectangle bound = entity.getBounds();
		if (bound.x + bound.getWidth() > gameX / 2) {

			bound.x += entity.getSpeed() * delta;
		}
		if (bound.x - bound.getWidth() < gameX / 2) {
			bound.x += entity.getSpeed() * delta;
		}
		if (Math.abs(bound.x + bound.getWidth() / 2 - gameX / 2) < 150) {
			bound.y += entity.getSpeed() * delta;
		}

	}
}
