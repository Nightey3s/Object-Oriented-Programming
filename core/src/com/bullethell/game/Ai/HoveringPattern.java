package com.bullethell.game.Ai;

import java.util.Random;

import com.bullethell.game.gameObject.Enemy;
import com.bullethell.game.gameObject.Player;

public class HoveringPattern extends AIPatterns {
	private Random rand = new Random();
	private float delta;
	private float yboundary;
	private float yspeed = 80;
	private float xspeed = 100;

	public HoveringPattern(float yboundary, float delta) {
		this.yboundary = yboundary;
		this.delta = delta;
	}

	@Override
	public void move(Enemy entity) {
		// TODO Auto-generated method stub
		if (entity.getBounds().y != yboundary) {
			entity.getBounds().y += (yboundary - entity.getBounds().y) * yspeed;
		} else {
			int counter = rand.nextInt(22);
			if (counter > 5 && counter < 21) {
				if (counter < 13) {
					entity.getBounds().x += xspeed * delta;
				} else {
					entity.getBounds().x -= xspeed * delta;
				}
			}
		}

	}

}
