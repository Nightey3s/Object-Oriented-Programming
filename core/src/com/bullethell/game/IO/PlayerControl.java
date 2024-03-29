package com.bullethell.game.IO;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class PlayerControl {
	
	public void handleTextureMovement(Rectangle bounds, float speed, float delta) {
        float currentSpeed = speed;
        float boundHeight = Gdx.graphics.getHeight();
        float boundWidth = Gdx.graphics.getWidth();

        if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT)) {
            currentSpeed *= 2.0f;
        }

        if (Gdx.input.isKeyPressed(Keys.W) && bounds.y + bounds.height + currentSpeed * delta < boundHeight) {
            bounds.y += currentSpeed * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.A) && bounds.x - currentSpeed * delta > 0) {
            bounds.x -= currentSpeed * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.S) && bounds.y - currentSpeed * delta > 0) {
            bounds.y -= currentSpeed * delta;
        }
        if (Gdx.input.isKeyPressed(Keys.D) && bounds.x + bounds.width + currentSpeed * delta < boundWidth) {
            bounds.x += currentSpeed * delta;
        }
    }

	public void handleSpriteMovement(Sprite sprite, float speed, float delta) {
	    float currentSpeed = speed;
	    float boundHeight = Gdx.graphics.getHeight();
	    float boundWidth = Gdx.graphics.getWidth();
	
	    if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT)) {
	        currentSpeed *= 2.0f;
	    }
	
	    if (Gdx.input.isKeyPressed(Keys.W) && sprite.getY() + sprite.getHeight() + currentSpeed * delta < boundHeight) {
	        sprite.setY(sprite.getY() + currentSpeed * delta);
	    }
	    if (Gdx.input.isKeyPressed(Keys.A) && sprite.getX() - currentSpeed * delta > 0) {
	        sprite.setX(sprite.getX() - currentSpeed * delta);
	    }
	    if (Gdx.input.isKeyPressed(Keys.S) && sprite.getY() - currentSpeed * delta > 0) {
	        sprite.setY(sprite.getY() - currentSpeed * delta);
	    }
	    if (Gdx.input.isKeyPressed(Keys.D) && sprite.getX() + sprite.getWidth() + currentSpeed * delta < boundWidth) {
	        sprite.setX(sprite.getX() + currentSpeed * delta);
	    }
	}

}
