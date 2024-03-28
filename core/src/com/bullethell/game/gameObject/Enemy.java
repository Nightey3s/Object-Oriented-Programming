package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.Ai.AIPatterns;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy extends GameObject implements IMovable {
	// private Texture texture;
	private float speed;
	private boolean outOfBounds = false;
	private AIPatterns AItype;
	private int healthPoints;

	public Enemy(float x, float y, AIPatterns AItype, int healthPoints) {
		super(x, y, 64, 64); // Example size, adjust as needed
		this.healthPoints = healthPoints;
		this.speed = (float) (Math.random() * 75 + 25); // Random speed from 25 to 100
		this.AItype = AItype;
	}

	public Enemy(float x, float y) {
		super(x, y, 64, 64); // Example size, adjust as needed
		// texture = new Texture("TODO");
		this.speed = (float) (Math.random() * 75 + 25); // Random speed from 25 to 100
	}

	public Enemy(float x, float y, int width, int height, float speed, int healthPoints) {
		super(x, y, width, height);
		this.speed = speed;
		this.healthPoints = healthPoints;
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

	public AIPatterns getAItype() {
		return AItype;
	}

	public void setAItype(AIPatterns aItype) {
		AItype = aItype;
	}

	@Override
	public void update(float delta) {
		move(delta);
		checkBounds();
	}

	public void checkBounds() {
		if (this.bounds.y + this.bounds.height < 0) {
			this.outOfBounds = true;
		}
	}

	public boolean isOutOfBounds() {
		return this.outOfBounds;
	}

	// if healthPoints is 0 enemy is destroyed
	public void takeDamage(int damage) {
		this.healthPoints -= damage;
		if (this.healthPoints <= 0) {
			this.dispose();
		}
	}

	@Override
	public void draw(SpriteBatch batch) {

	}

	@Override
	public void draw(ShapeRenderer shape) {
		shape.setColor(Color.RED);
		float halfWidth = this.bounds.width / 2;
		// Coordinates for the base of the triangle
		float baseLeftX = this.bounds.x;
		float baseLeftY = this.bounds.y;
		float baseRightX = this.bounds.x + this.bounds.width;
		float baseRightY = this.bounds.y;
		// Coordinates for the peak of the triangle
		float peakX = this.bounds.x + halfWidth;
		float peakY = this.bounds.y + this.bounds.height;
		shape.triangle(baseLeftX, baseLeftY, peakX, peakY, baseRightX, baseRightY);

	}

	@Override
	public void dispose() {
		// texture.dispose();
		this.dispose();

	}
}
