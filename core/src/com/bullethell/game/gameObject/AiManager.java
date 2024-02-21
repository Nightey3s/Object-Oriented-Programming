package com.bullethell.game.gameObject;

import java.util.ArrayList;

public class AiManager {

	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private float delta;
	private Player player;
	
	public AiManager(Player player, float delta) {
		this.delta = delta;
		this.player = player;
	}
	
	public void update() {
		for (Enemy enemy : enemyList) {
			enemy.move(delta);
		}
	}
}