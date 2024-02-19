package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public class Projectile extends GameObject implements IMovable {
    private Texture texture;

    public Projectile(float x, float y)
    {
        super(x, y, 3, 10); // Example size, adjust as needed
        //texture = new Texture("TODO");
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

//    @Override
//    public void draw(SpriteBatch batch)
//    {
//        batch.draw(texture, bounds.x, bounds.y);
//    }
    
    @Override
    public void draw(ShapeRenderer shape)
    {
        shape.ellipse(bounds.x, bounds.y, bounds.width, bounds.height);
        shape.setColor(Color.WHITE);
    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }
}