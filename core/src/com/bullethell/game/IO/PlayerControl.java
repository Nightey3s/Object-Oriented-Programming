package com.bullethell.game.IO;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;

public class PlayerControl {
	
	public void handleMovement(Rectangle bounds, float speed, float delta) {
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
}
