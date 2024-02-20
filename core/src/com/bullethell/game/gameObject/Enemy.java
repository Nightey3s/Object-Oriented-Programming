package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public class Enemy extends GameObject implements IMovable {
    //private Texture texture;
    private float speed;

    public Enemy(float x, float y)
    {
        super(x, y, 64, 64); // Example size, adjust as needed
        //texture = new Texture("TODO");
        speed = (float) (Math.random() * 75 + 25); // Random speed from 25 to 100
    }

    @Override
    public void move(float delta)
    {
        // Implement movement logic here
    	bounds.y -= speed * delta;
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
        float halfWidth = bounds.width / 2;
        // Coordinates for the base of the triangle
        float baseLeftX = bounds.x;
        float baseLeftY = bounds.y;
        float baseRightX = bounds.x + bounds.width;
        float baseRightY = bounds.y;
        // Coordinates for the peak of the triangle
        float peakX = bounds.x + halfWidth;
        float peakY = bounds.y + bounds.height;

        shape.triangle(baseLeftX, baseLeftY, peakX, peakY, baseRightX, baseRightY);
        shape.setColor(Color.RED);
    }

    @Override
    public void dispose()
    {
        //texture.dispose();
    	
    }
}
