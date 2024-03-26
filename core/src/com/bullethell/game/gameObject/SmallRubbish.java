package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.Ai.AIPatterns;

public class SmallRubbish extends TextureObject implements IMovable{
	private float speed;
	

	public SmallRubbish(String tex, float speed,float x, float y) {
		super(tex,x,y,50,50);
		this.speed = speed;
	}

	@Override
	public void move(float delta) {
		// Implement movement logic here
		this.bounds.y -= this.speed * delta;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	public void update(float delta) {
		move(delta);
	}
}
