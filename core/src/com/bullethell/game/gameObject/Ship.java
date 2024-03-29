package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.IO.InputManager;
import com.bullethell.game.scene.SceneManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Color;

public class Ship extends Player {
	private Sprite sprite;
	private Texture spriteSheet;
	private float speed;
	private TextureRegion neutralRegion, leftRegion1, leftRegion2, rightRegion1, rightRegion2;
	private float fireTimer = 0.0f;
	private final float FIRE_RATE = 0.15f;// 0.15 seconds
	private boolean isFiring = false;
	private boolean wasLeftKeyPressed;
	private boolean wasRightKeyPressed;

	public Ship(float x, float y, GameObjectManager gameObjectManager, SceneManager sceneManager) {
		super(x, y, gameObjectManager, sceneManager);
		this.spriteSheet = new Texture(Gdx.files.internal("ship.png"));

		int frameWidth = 17;
		int frameHeight = spriteSheet.getHeight() / 5; // 5 rows in total

		// Create texture regions for the ship states
		neutralRegion = new TextureRegion(spriteSheet, 0, 0, frameWidth, frameHeight);
		leftRegion1 = new TextureRegion(spriteSheet, 0, frameHeight, frameWidth, frameHeight);
		leftRegion2 = new TextureRegion(spriteSheet, 0, frameHeight * 2, frameWidth, frameHeight);
		rightRegion1 = new TextureRegion(spriteSheet, 0, frameHeight * 3, frameWidth, frameHeight);
		rightRegion2 = new TextureRegion(spriteSheet, 0, frameHeight * 4, frameWidth, frameHeight);

		this.sprite = new Sprite(neutralRegion);
		this.sprite.setPosition(x, y); // Set the sprite's position
		this.sprite.setSize(34, 64); // Set the sprite's size
		this.sprite.setOriginCenter();
		this.speed = 200f;
		this.bounds = sprite.getBoundingRectangle();

	}

	@Override
	public void move(float delta) {
		
		InputManager.playerControl.handleMovement2(this.sprite, this.speed, delta);
	}

	@Override
	public Rectangle getBounds() {
		return this.bounds;
	}

	@Override
	public Sprite getSprite() {
		return sprite; // Return the actual sprite
	}

	@Override
	public void update(float delta) {
		move(delta);
		this.bounds = sprite.getBoundingRectangle();// Update sprite bounds
		super.update(delta);
		boolean isLeftKeyPressedCurrently = Gdx.input.isKeyPressed(Keys.A);
		boolean isRightKeyPressedCurrently = Gdx.input.isKeyPressed(Keys.D);
		boolean isSpacePressed = Gdx.input.isKeyPressed(Keys.SPACE);

		// Handling left key press for tilting the ship
		if (isLeftKeyPressedCurrently) {
			if (!wasLeftKeyPressed) {
				// The left key was just pressed
				this.sprite.setRegion(leftRegion1);
			} else {
				// The left key is being held down
				this.sprite.setRegion(leftRegion2);
			}
		} else if (wasLeftKeyPressed) {
			// The left key was just released
			this.sprite.setRegion(neutralRegion);
		}
		wasLeftKeyPressed = isLeftKeyPressedCurrently;

		// Handling right key press for tilting the ship
		if (isRightKeyPressedCurrently) {
			if (!wasRightKeyPressed) {
				// The right key was just pressed
				this.sprite.setRegion(rightRegion1);
			} else {
				// The right key is being held down
				this.sprite.setRegion(rightRegion2);
			}
		} else if (wasRightKeyPressed) {
			// The right key was just released
			this.sprite.setRegion(neutralRegion);
		}
		wasRightKeyPressed = isRightKeyPressedCurrently;

		// Reset to neutral if no tilt keys are pressed
		if (!isLeftKeyPressedCurrently && !isRightKeyPressedCurrently) {
			this.sprite.setRegion(neutralRegion);
		}

		if (isSpacePressed) {
			if (!isFiring) {
				fireProjectile(); // Fire immediately on first press
				isFiring = true; // Mark that we're firing
				fireTimer = 0; // Reset the timer after firing
			} else {
				fireTimer += delta; // Increment timer only if we've started firing
				if (fireTimer >= FIRE_RATE) {
					fireProjectile(); // Fire a projectile
					fireTimer -= FIRE_RATE; // Adjust the timer for the next shot
				}
			}
		} else {
			isFiring = false; // Spacebar released, reset the firing flag
		}

		// Update the sprite's position
		this.sprite.setPosition(bounds.x, bounds.y);
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);

	}

	@Override
	public void draw(ShapeRenderer shape) {
		float barWidth = sprite.getWidth() / 2;
		float barHeight = 10; // The thickness of the bar
		float barX = sprite.getX() + (sprite.getWidth() - barWidth) / 2; // Center the health bar
		float barY = sprite.getY() + sprite.getHeight();

		shape.setColor(Color.BLACK);
		shape.rect(barX, barY, barWidth, barHeight);
		shape.setColor(Color.GREEN);
		shape.rect(barX, barY, barWidth * getHealth() / 100, barHeight);

	}

	@Override
	public void dispose() {
		if (spriteSheet != null)
			spriteSheet.dispose();
	}

}
