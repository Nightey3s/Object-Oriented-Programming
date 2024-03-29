package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.bullethell.game.ScoreManager;

public class PowerUp extends GameObject {
	

	private PowerUpType type;
	private Sprite sprite;
	private Texture tex;
	private float speed = 50;

	public PowerUp(float x, float y, int width, int height, String texturePath, PowerUpType type) {
		super(x, y, width, height, GameObjectTypes.PowerUp);
		this.tex = new Texture(Gdx.files.internal(texturePath));
		sprite = new Sprite(this.tex);
		sprite.setSize(width, height);
		sprite.setOriginCenter();
		sprite.setPosition(x, y);
		this.bounds = sprite.getBoundingRectangle();
		this.type = type;
	}

	
	@Override
	public void update(float delta) {
		// Moving down slowly.
		sprite.setY(sprite.getY() - speed * delta);
		bounds.y = sprite.getY();
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	public void draw(ShapeRenderer shape) {
		// Draw shape for the power-up
		float radius = this.bounds.height / 2;
		shape.setColor(Color.BLUE);
		shape.circle(this.bounds.x + radius, this.bounds.y + radius, radius);
	}

	@Override
	public void dispose() {
		// Dispose resources if needed
	}

	@Override
	public Sprite getSprite() {
		return sprite; // Return the actual sprite
	}

	public void applyPowerUp(Player player, Earth earth) {
		switch (type) {
		case DOUBLE_POINTS:
			// Apply double points effect to player for 5 seconds
			ScoreManager.getInstance().activateDoubleScore(); // Activate double score
			// Schedule timer to revert the effect after 5 seconds
			Timer.schedule(new Task() {
				@Override
				public void run() {
					ScoreManager.getInstance().deactivateDoubleScore(); // Deactivate double score
				}
			}, 5f); // Use float value for the delay
			break;
		case DOUBLE_DAMAGE:
			// Apply double damage effect to player for 5 seconds
			player.setDoubleDamage(true);
			// Schedule timer to revert the effect after 5 seconds
			Timer.schedule(new Task() {
				@Override
				public void run() {
					player.setDoubleDamage(false);
				}
			}, 5);
			break;
		case INCREASE_EARTH_HEALTH:
			// Increase Earth's health
			earth.increaseHealth(30); // Adjust the value as needed
			break;
		default:
			break;
		}
	}
}