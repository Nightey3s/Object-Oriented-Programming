package com.bullethell.game.Ai;

import com.bullethell.game.gameObject.Enemy;
import com.bullethell.game.gameObject.GameObject;

public class HomingPattern extends AIPatterns {
	private float delta;
	private GameObject target;

	public HomingPattern(GameObject target, float delta) {
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

			entity.getBounds().x += dx * entity.getSpeed() * delta;
			entity.getBounds().y += dx * entity.getSpeed() * 0.7 * delta;
		}

	}

}
