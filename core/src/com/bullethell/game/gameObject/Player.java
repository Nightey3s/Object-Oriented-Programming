package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public class Player extends GameObject implements IMovable {
    private Texture texture;
    private float speed;

    public Player(float x, float y)
    {
        super(x, y, 64, 64); // Example size, adjust as needed
        //texture = new Texture("TODO");
        speed = 100.0f;
    }

    @Override
    public void move(float delta)
    {
        float currentSpeed = speed;
        float boundHeight = Gdx.graphics.getHeight();
        float boundWidth = Gdx.graphics.getWidth();

        
        // Implement movement logic here
        if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT))
        {
        	// Speed up
            currentSpeed *= 2.0f;
        }
        
		if (Gdx.input.isKeyPressed(Keys.W))
		{
		    // Move up
			if (bounds.y + bounds.height + currentSpeed * delta <= boundHeight)
			{
				bounds.y += currentSpeed * delta;
			}
		    
		}
		if (Gdx.input.isKeyPressed(Keys.A))
		{
		    // Move left
			if (bounds.x + currentSpeed * delta >= 0)
			{
				bounds.x -= currentSpeed * delta;
			}
		}
		
		if (Gdx.input.isKeyPressed(Keys.S))
		{
		    // Move down
			if (bounds.y + currentSpeed * delta >= 0)
			{
				bounds.y -= currentSpeed * delta;
			}
		}
		
		if (Gdx.input.isKeyPressed(Keys.D))
		{
		    // Move right
			if (bounds.x + bounds.width + currentSpeed * delta <= boundWidth)
			{
				bounds.x += currentSpeed * delta;
			}
		}
        
    }

    @Override
    public void update(float delta)
    {
        move(delta);
    }

//    @Override
//    public void draw(SpriteBatch batch)
//    {
//        batch.draw(texture, bounds.x, bounds.y);
//    }
    
    @Override
    public void draw(ShapeRenderer shape)
    {
        shape.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        shape.setColor(Color.GREEN);
    }
    
    @Override
    public void dispose()
    {
        texture.dispose();
    }
}
