package com.bullethell.game.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class PowerUp extends GameObject {
    private Texture texture;

    public PowerUp(float x, float y)
    {
        super(x, y, 48, 48); // Example size, adjust as needed
        texture = new Texture("TODO");
    }

    @Override
    public void update(float delta)
    {
        // PowerUp specific logic here
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.draw(texture, bounds.x, bounds.y);
    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }
}