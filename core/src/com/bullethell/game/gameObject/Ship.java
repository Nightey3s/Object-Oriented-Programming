package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
	private TextureRegion[] shipStates; // Array to hold different ship states
	private int currentShipState; // Index to track current ship state
	private TextureRegion neutralRegion, leftRegion1, leftRegion2, rightRegion1, rightRegion2;
	private float stateTime;
	private float fireTimer = 0.0f;
	private final float FIRE_RATE = 0.15f;// 0.15 seconds
	private boolean wasLeftKeyPressed;
	private boolean wasRightKeyPressed;

	public Ship(float x, float y, GameObjectManager gameObjectManager, SceneManager sceneManager) {
		super(x, y, gameObjectManager, sceneManager); // Assumes that your ship is 100x100 in size.
		this.spriteSheet = new Texture(Gdx.files.internal("ship.png"));
		// int spriteWidth = 17; // Must match the frame width in the sprite sheet
		// int spriteHeight = 32; // Must match the frame height in the sprite sheet
		// TextureRegion[][] spriteRegions = TextureRegion.split(spriteSheet,
		// spriteWidth, spriteHeight);
		// this.sprite = new Sprite(spriteRegions[0][0]); // Correctly assign to the
		// class field

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
		this.speed = 100f;
		this.bounds = sprite.getBoundingRectangle();

	}

	@Override
	public void move(float delta) {
		// InputManager.handleMovement(this.bounds, this.speed, delta);
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

		if (isLeftKeyPressedCurrently) {
			if (!wasLeftKeyPressed) {
				// The left key was just pressed
				stateTime = 0;
				this.sprite.setRegion(leftRegion1);
			} else if (stateTime > FIRE_RATE) {
				// The left key is being held down
				this.sprite.setRegion(leftRegion2);
			}
			stateTime += delta; // Increment the time the key has been held down
		} else if (wasLeftKeyPressed) {
			// The left key was just released
			this.sprite.setRegion(neutralRegion);
		}
		wasLeftKeyPressed = isLeftKeyPressedCurrently;

		if (isRightKeyPressedCurrently) {
			if (!wasRightKeyPressed) {
				// The right key was just pressed
				stateTime = 0;
				this.sprite.setRegion(rightRegion1);
			} else if (stateTime > FIRE_RATE) {
				// The right key is being held down
				this.sprite.setRegion(rightRegion2);
			}
			stateTime += delta; // Increment the time the key has been held down
		} else if (wasRightKeyPressed) {
			// The right key was just released
			this.sprite.setRegion(neutralRegion);
		}
		wasRightKeyPressed = isRightKeyPressedCurrently;

		// If no keys are being pressed or held, reset to neutral
		if (!isLeftKeyPressedCurrently && !isRightKeyPressedCurrently) {
			this.sprite.setRegion(neutralRegion);
			stateTime = 0; // Reset the time since no key is pressed
		}

		// Update the sprite's position
		this.sprite.setPosition(bounds.x, bounds.y);
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	public void draw(ShapeRenderer shapeRenderer) {
		shapeRenderer.setColor(Color.ORANGE); // Testing for collision
		shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	@Override
	public void dispose() {
		if (spriteSheet != null)
			spriteSheet.dispose();
	}

}
