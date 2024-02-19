package com.bullethell.game.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Enemy extends GameObject implements IMovable {
    private Texture texture;

    public Enemy(float x, float y)
    {
        super(x, y, 64, 64); // Example size, adjust as needed
        texture = new Texture("TODO");
    }

    @Override
    public void move(float delta)
    {
        // Implement movement logic here
    }

    @Override
    public void update(float delta)
    {
        move(delta);
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
