package com.bullethell.game.gameObject;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.bullethell.game.ScoreManager;
import com.bullethell.game.collision.GameObjectTypes;

public class PowerUp extends GameObject {
    private enum PowerUpType {
        DOUBLE_POINTS,
        DOUBLE_DAMAGE,
        INCREASE_EARTH_HEALTH,
        INCREASE_TIMER
    }

    private PowerUpType type;

    public PowerUp(float x, float y, PowerUpType Ptype) {
        super(x, y, 64, 64, GameObjectTypes.PowerUp); // Example size, adjust as needed
        this.type = Ptype;
    }
    
    public PowerUp(float x, float y) {
        super(x, y, 64, 64, GameObjectTypes.PowerUp); // Example size, adjust as needed
        // Default type can be set here if needed
    }

    @Override
    public void update(float delta) {
        // PowerUp specific logic here
    }

    @Override
    public void draw(SpriteBatch batch) {
        // Draw sprite if needed
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

    public void applyPowerUp(Player player, Earth earth, ScoreManager scoreManager) {
        switch (type) {
            case DOUBLE_POINTS:
                // Apply double points effect to player for 5 seconds
                scoreManager.activateDoubleScore(); // Activate double score
                // Schedule timer to revert the effect after 5 seconds
                Timer.schedule(new Task() {
                    @Override
                    public void run() {
                        scoreManager.deactivateDoubleScore(); // Deactivate double score
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
                earth.increaseHealth(10); // Adjust the value as needed
                break;
            case INCREASE_TIMER:
                // Increase timer by 10 seconds
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        // Increase timer logic here
                    }
                }, 10); // Use int value for the delay
                break;
            default:
                break;
        }
    }
}
