package com.bullethell.game.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class GameObject {
    protected Rectangle bounds;
    
    public GameObject() {
    	
    }

    public GameObject(float x, float y, float width, float height)
    {
        this.bounds = new Rectangle(x, y, width, height);
    }
    

    public abstract void update(float delta);
    public abstract void draw(ShapeRenderer shape);
    public abstract void draw(SpriteBatch batch);
    public abstract void dispose();

    public Sprite getSprite() {
        return null;  // Return null by default
    }

    public Rectangle getBounds()
    {
        return bounds;
    }
    
    public float getXPos()
    {
    	return this.bounds.x;
    }
    
    public float getYPos()
    {
    	return this.bounds.y;
    }
}