package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PowerUp extends GameObject {


    public PowerUp(float x, float y)
    {
        super(x, y, 64, 64); // Example size, adjust as needed
        //texture = new Texture("TODO");
    }

    @Override
    public void update(float delta)
    {
        // PowerUp specific logic here
    }

    @Override
    public void draw(SpriteBatch batch) {
    	
    }
    
    @Override
    public void draw(ShapeRenderer shape)
    {
    	float radius = this.bounds.height / 2;
    	shape.setColor(Color.BLUE);
        shape.circle(this.bounds.x + radius, this.bounds.y + radius, radius);
        
    }

    @Override
    public void dispose()
    {
        this.dispose();
    }
}