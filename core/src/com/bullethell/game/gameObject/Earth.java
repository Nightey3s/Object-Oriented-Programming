package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.scene.SceneManager;

public class Earth extends GameObject {
	private float rotationAngle = 0;
	private Sprite sprite;
	private Texture tex;
	private int healthPercentage = 40;
	private int maxHealth = 100;
	private SceneManager sceneManager;
	private boolean isAlive = true;

	public Earth(float x, float y, int width, int height, SceneManager sceneManager) {
		super(x, y, width, height, GameObjectTypes.Earth);

		this.tex = new Texture(Gdx.files.internal("Earth.png"));

		sprite = new Sprite(this.tex);
		sprite.setSize(width, height);
		sprite.setOriginCenter();
		sprite.setPosition(x, y);
		this.bounds = sprite.getBoundingRectangle();
		this.sceneManager = sceneManager;
	}

	@Override
	public Sprite getSprite() {
		return sprite; // Return the actual sprite
	}

	public void setHealthPercentage(int healthPercentage) {
		if (healthPercentage >= maxHealth) {
			this.healthPercentage = 100;
		} else {
			this.healthPercentage = healthPercentage;
		}
	}

	@Override
	public void update(float delta) {
		rotationAngle += 7 * delta;
		rotationAngle %= 360; // keep angle between 0 and 360
		sprite.setRotation(rotationAngle);
		setHealthPercentage(healthPercentage);
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	// Draw the health bar
	@Override
	public void draw(ShapeRenderer shape) {
		float barWidth = sprite.getWidth() / 2;
		float barHeight = 10; // The thickness of the bar
		float barX = sprite.getX() + (sprite.getWidth() - barWidth) / 2; // Center the health bar
		float barY = sprite.getY() + sprite.getHeight();

		shape.setColor(Color.BLACK);
		shape.rect(barX, barY, barWidth, barHeight);
		shape.setColor(Color.GREEN);
		shape.rect(barX, barY, barWidth * this.healthPercentage / 100, barHeight);

		// shape.setColor(Color.ORANGE); // Testing for collision
		// shape.rect(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	public void earthDied() {
		sceneManager.setFinalScore();
		sceneManager.changeScene(sceneManager.getSceneItem(2));
		isAlive = false;
	}

	public void takeDamage(int damage) {
		this.healthPercentage -= damage;
		if (this.healthPercentage <= 0) {
			earthDied(); // Call playerDied method when health is 0 or less
		}
	}

	public void increaseHealth(int damage) {
		this.healthPercentage += damage;
	}

	@Override
	public void dispose() {
		this.dispose();
	}

}
