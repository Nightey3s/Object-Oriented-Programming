package com.bullethell.game.Ai;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.bullethell.game.gameObject.Enemy;
import com.bullethell.game.gameObject.GameObject;
import com.bullethell.game.gameObject.Player;

public class AiManager {

	private List<Enemy> enemyList;

	public AiManager() {
		this.enemyList = new ArrayList<Enemy>();
	}

	public void addEnemy(Enemy enemy) {
		enemyList.add(enemy);
	}

	public void removeEnemy(Enemy enemy) {
		int index = enemyList.indexOf(enemy);
		if (index != -1) {
			enemyList.remove(index);
		}

	}

	public void update() {
		for (Enemy enemy : enemyList) {
			if (enemy.getAItype() != null) {
				enemy.getAItype().move(enemy);
			} else {
				enemy.move(Gdx.graphics.getDeltaTime());
			}
		}
	}
}