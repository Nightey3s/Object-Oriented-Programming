package com.bullethell.game.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Projectile extends GameObject implements IMovable {
    private Texture texture;

    public Projectile(float x, float y)
    {
        super(x, y, 32, 32); // Example size, adjust as needed
        texture = new Texture("TODO");
    }

    @Override
    public void move(float delta)
    {
        // Implement projectile movement logic here
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