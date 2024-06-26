package com.bullethell.game.gameObject;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.IO.InputManager;
import com.bullethell.game.scene.SceneManager;

public class Player extends GameObject implements IMovable {
    private float speed;
    private int health;
    private boolean isAlive = true;
    private GameObjectManager gameObjectManager;
    private SceneManager sceneManager; //
    private boolean doubleDamageActive; // Flag to indicate if double damage is active
    private float doubleDamageDuration; // Duration for which double damage remains active
    private float doubleDamageTimer; // Timer to track the duration of double damage



    public Player(float x, float y, GameObjectManager gameObjectManager, SceneManager sceneManager) {
        super(x, y, 64, 64, GameObjectTypes.Player); // Example size, adjust as needed
        // Other initialization...
        doubleDamageActive = false;
        doubleDamageDuration = 5; // Default duration for double damage (in seconds)
        doubleDamageTimer = 0;
        this.speed = 300.0f;
        this.gameObjectManager = gameObjectManager;
        this.sceneManager = sceneManager;
        this.health = 100;
    }
    
    public boolean isDoubleDamageActive() {
		return doubleDamageActive;
	}

	public void setDoubleDamage(boolean active) {
        doubleDamageActive = active;
    }
    public int getHealth() {
        return health;
    }

    public void playerDied() {
        sceneManager.setFinalScore();
        sceneManager.changeScene(sceneManager.getSceneItem(2));
        isAlive = false;

    }

    public boolean isAlive() {
        return isAlive;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            playerDied(); // Call playerDied method when health is 0 or less
        }
    }

    @Override
    public void move(float delta) {
        InputManager.playerControl.handleTextureMovement(this.bounds, this.speed, delta);
    }

    @Override
    public void update(float delta) {
        move(delta);
        if (doubleDamageActive) {
            doubleDamageTimer += delta;
            // Check if the double damage duration has elapsed
            if (doubleDamageTimer >= doubleDamageDuration) {
                doubleDamageActive = false; // Deactivate double damage
                doubleDamageTimer = 0; // Reset the timer
            }
        }

    }

    protected void fireProjectile() {
        // Example projectile position; adjust according to your needs
        float projectileX = (this.bounds.x + this.bounds.width / 2);
        float projectileY = this.bounds.y + this.bounds.height;

        // Create a projectile at the player's position (or offset as needed)
        gameObjectManager.createProjectile(projectileX, projectileY);
    }


    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    
    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.GREEN);
        shape.rect(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height);
    }

    @Override
    public void dispose() {
        this.dispose();
    }

}
