package com.bullethell.game.Ai;

import java.util.Random;
import com.badlogic.gdx.math.Rectangle;
import com.bullethell.game.gameObject.Enemy;

public class HoveringPattern extends AIPatterns {
	private Random rand = new Random();
	private float delta;
	private float yboundary;

	public HoveringPattern(float yboundary, float delta) {
		this.yboundary = yboundary;
		this.delta = delta;
	}

	@Override
	public void move(Enemy entity) {
		Rectangle bound = entity.getBounds();
		float speed = entity.getSpeed();
		// TODO Auto-generated method stub
		if (bound.y != yboundary) {
			bound.y += (yboundary - bound.y) * speed;
		} else {
			int counter = rand.nextInt(22);
			if (counter > 5 && counter < 21) {
				if (counter < 13) {
					bound.x += speed * delta;
				} else {
					bound.x -= speed * delta;
				}
			}
		}

	}

}
