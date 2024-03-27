package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Projectile extends GameObject implements IMovable {
    private float speed;
    private boolean outOfBounds = false;
    private float screenHeight = Gdx.graphics.getHeight();
    public Projectile(float x, float y)
    {
        super(x, y, 3, 15); // Example size, adjust as needed
        //texture = new Texture("TODO");
        this.speed = 500.0f;
    }

    @Override
    public void move(float delta)
    {
        // Implement projectile movement logic here
    	this.bounds.y += this.speed * delta;
    }

    @Override
    public void update(float delta)
    {
        move(delta);
        checkBounds();
    }
    
    public void checkBounds()
    {
    	if (this.bounds.y + this.bounds.height > screenHeight)
    	{
    		this.outOfBounds = true;
    	}
    }
    
    public boolean isOutOfBounds()
    {
    	return this.outOfBounds;
    }

    @Override
    public void draw(SpriteBatch batch) {

    }
    
    @Override
    public void draw(ShapeRenderer shape)
    {
    	shape.setColor(Color.WHITE);
        shape.ellipse(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height);
    }

    @Override
    public void dispose()
    {
        this.dispose();
    }
}