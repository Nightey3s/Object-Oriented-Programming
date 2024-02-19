package com.bullethell.game.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	protected Vector2 position;
	protected Vector2 size;
	
	public GameObject(Vector2 position, Vector2 size)
	{
		this.position = position;
		this.size = size;
	}
	
	public abstract void update(float delta);
	public abstract void draw(SpriteBatch draw);
}
