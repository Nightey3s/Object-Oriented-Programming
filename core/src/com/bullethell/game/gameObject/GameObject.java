package com.bullethell.game.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {
    protected Rectangle bounds;

    public GameObject(float x, float y, float width, float height)
    {
        this.bounds = new Rectangle(x, y, width, height);
    }

    public abstract void update(float delta);
    public abstract void draw(SpriteBatch batch);

    public Rectangle getBounds()
    {
        return bounds;
    }
}