package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.Ai.AIPatterns;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy extends GameObject implements IMovable {
	// private Texture texture;
	private float speed;
	private AIPatterns AItype;

	public Enemy(float x, float y, AIPatterns AItype) {
		super(x, y, 64, 64); // Example size, adjust as needed
		// texture = new Texture("TODO");
		this.speed = (float) (Math.random() * 75 + 25); // Random speed from 25 to 100
		this.AItype = AItype;
	}

	public Enemy(float x, float y) {
		super(x, y, 64, 64); // Example size, adjust as needed
		// texture = new Texture("TODO");
		this.speed = (float) (Math.random() * 75 + 25); // Random speed from 25 to 100
	}

	public Enemy(float x, float y, int width, int height, float speed){
		super(x, y, width, height);
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

	public AIPatterns getAItype() {
		return AItype;
	}

	public void setAItype(AIPatterns aItype) {
		AItype = aItype;
	}

	@Override
	public void update(float delta) {
		move(delta);
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
