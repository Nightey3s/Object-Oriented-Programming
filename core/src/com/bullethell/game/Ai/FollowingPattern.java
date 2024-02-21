package com.bullethell.game.Ai;

import com.bullethell.game.gameObject.Enemy;
import com.bullethell.game.gameObject.GameObject;

public class FollowingPattern extends AIPatterns {
	private int xspeed = 100;
	private int yspeed = 70;
	private float delta;
	private GameObject target;

	public FollowingPattern(GameObject target, float delta) {
		this.target = target;
		this.delta = delta;
	}

	@Override
	public void move(Enemy entity) {
		// TODO Auto-generated method stub
		float dx = target.getBounds().x - entity.getBounds().getX();
		float dy = target.getBounds().y - entity.getBounds().y;
		float distance = (float) Math.sqrt(dx * dx + dy * dy);
		System.out.println(distance);

		if (distance > 0) {
			dx /= distance;
			dy /= distance;

			entity.getBounds().x += dx * xspeed * delta;
			entity.getBounds().y += dx * yspeed * delta;
		}

	}

}
