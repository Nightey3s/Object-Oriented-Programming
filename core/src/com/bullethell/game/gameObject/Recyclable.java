package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Recyclable extends GameObject {
    private Sprite sprite;
    private Texture tex;
    private float speed = 50;
    private int healthPoints;
    private boolean outOfBounds = false;

	public Recyclable(float x, float y, int width, int height, String texturePath) {
		super(x, y, 40, 50, GameObjectTypes.Recyclable);
        this.healthPoints = 20;
        this.tex = new Texture(Gdx.files.internal(texturePath));
        sprite = new Sprite(this.tex);
        sprite.setSize(width, height);
        sprite.setOriginCenter();
        sprite.setPosition(x, y);
        this.bounds = sprite.getBoundingRectangle();
    }

    public void takeDamage(int damage) {
		this.healthPoints -= damage;
	}

    public int getHealth() {
        return healthPoints;
    }

    public void checkBounds() {
		if (this.bounds.y + this.bounds.height < 0) {
			this.outOfBounds = true;
		}
	}

	public boolean isOutOfBounds() {
		return this.outOfBounds;
	}

    @Override
    public void update(float delta) {
        // Moving down slowly.
        sprite.setY(sprite.getY() - speed * delta);
        bounds.y = sprite.getY();
    }

    @Override
    public void draw(ShapeRenderer shape) {
        // empty
        shape.setColor(Color.ORANGE); // Testing for collision
        shape.rect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void dispose() {
        this.dispose();
    }

    @Override
    public Sprite getSprite() {
        return sprite; // Return the actual sprite
    }

}
