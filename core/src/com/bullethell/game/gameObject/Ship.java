package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.IO.InputManager;
import com.bullethell.game.scene.SceneManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Ship extends Player{
	private Sprite sprite;
	private Texture spriteSheet;
	private float speed;
	private float fireTimer = 0.0f;
    private final float FIRE_RATE = 0.15f;//0.15 seconds

	public Ship(float x, float y, GameObjectManager gameObjectManager, SceneManager sceneManager) {
        super(x, y, gameObjectManager, sceneManager); // Assumes that your ship is 100x100 in size.
        this.spriteSheet = new Texture(Gdx.files.internal("ship.png"));
        int spriteWidth = 17; // Must match the frame width in the sprite sheet
        int spriteHeight = 32; // Must match the frame height in the sprite sheet
        TextureRegion[][] spriteRegions = TextureRegion.split(spriteSheet, spriteWidth, spriteHeight);
        this.sprite = new Sprite(spriteRegions[0][0]); // Correctly assign to the class field
        this.sprite.setPosition(x, y); // Set the sprite's position
        this.sprite.setSize(34, 64); // Set the sprite's size
        this.sprite.setOriginCenter();
        this.speed = 100f;

    }
	
	@Override
    public void move(float delta)
    {
    	//InputManager.handleMovement(this.bounds, this.speed, delta);
    	InputManager.playerControl.handleMovement2(this.sprite, this.speed, delta);
    }
	
	@Override
    public Sprite getSprite() {
        return sprite;  // Return the actual sprite
    }

	@Override
	public void update(float delta) {
		move(delta);
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
		if (spriteSheet != null) spriteSheet.dispose();
	}

}
