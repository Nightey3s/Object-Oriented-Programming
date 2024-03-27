package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Earth extends GameObject{
	private float rotationAngle = 0;
	private Sprite sprite;
	private Texture tex;

	public Earth(float x,float y,int width,int height) {
		super(x, y, width, height);
		this.tex = new Texture(Gdx.files.internal("BigRubbish.png"));
		sprite = new Sprite(this.tex);
		sprite.setSize(width, height);
		sprite.setOriginCenter();
		sprite.setPosition(x, y);
	}
	
	@Override
    public Sprite getSprite() {
        return sprite;  // Return the actual sprite
    }

	@Override
	public void update(float delta) {
		rotationAngle += 10 * delta;
		rotationAngle %= 360; // keep angle between 0 and 360
		sprite.setRotation(rotationAngle);
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	public void draw(ShapeRenderer shape) {
		// Null since object is sprite
	}

	@Override
	public void dispose() {
		this.dispose();
	}

}
