package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class Projectile extends GameObject implements IMovable {
    private float speed;
    private boolean outOfBounds = false;
    private float screeHeight = Gdx.graphics.getHeight();
    public Projectile(float x, float y)
    {
        super(x, y, 3, 10); // Example size, adjust as needed
        //texture = new Texture("TODO");
        speed = 500.0f;
    }

    @Override
    public void move(float delta)
    {
        // Implement projectile movement logic here
    	bounds.y += speed * delta;
    }

    @Override
    public void update(float delta)
    {
        move(delta);
        checkBounds();
    }
    
    public void checkBounds()
    {
    	if (bounds.y + bounds.height > screeHeight)
    	{
    		this.outOfBounds = true;
    	}
    }
    
    public boolean isOutOfBounds()
    {
    	return this.outOfBounds;
    }

//    @Override
//    public void draw(SpriteBatch batch)
//    {
//        batch.draw(texture, bounds.x, bounds.y);
//    }
    
    @Override
    public void draw(ShapeRenderer shape)
    {
    	shape.setColor(Color.WHITE);
        shape.ellipse(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    @Override
    public void dispose()
    {
        this.dispose();
    }
}