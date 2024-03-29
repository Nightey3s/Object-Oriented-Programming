package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class Earth extends GameObject{
	private float rotationAngle = 0;
	private Sprite sprite;
	private Texture tex;
	private int healthPercentage = 10;

	public Earth(float x,float y,int width,int height) {
		super(x, y, width, height, GameObjectTypes.Earth);

		this.tex = new Texture(Gdx.files.internal("Earth.png"));

		sprite = new Sprite(this.tex);
		sprite.setSize(width, height);
		sprite.setOriginCenter();
		sprite.setPosition(x, y);
		this.bounds = sprite.getBoundingRectangle();
	}
	
	@Override
    public Sprite getSprite() {
        return sprite;  // Return the actual sprite
    }

	@Override
	public void update(float delta) {
		rotationAngle += 7 * delta;
		rotationAngle %= 360; // keep angle between 0 and 360
		sprite.setRotation(rotationAngle);
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	// Draw the health bar
	@Override
	public void draw(ShapeRenderer shape) {
		float barWidth = sprite.getWidth() / 2;
		float barHeight = 10;  // The thickness of the bar
		float barX = sprite.getX() + (sprite.getWidth() - barWidth) / 2;  // Center the health bar
		float barY = sprite.getY() + sprite.getHeight();

		shape.setColor(Color.BLACK);
		shape.rect(barX, barY, barWidth, barHeight);
		shape.setColor(Color.GREEN);
		shape.rect(barX, barY, barWidth * this.healthPercentage / 10, barHeight);

		// shape.setColor(Color.ORANGE); // Testing for collision
		// shape.rect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
	public void takeDamage(int damage) {
        this.healthPercentage -= damage;
	}
	public void increaseHealth(int damage) {
        this.healthPercentage -= damage;
	}
		
	@Override
	public void dispose() {
		this.dispose();
	}

}
