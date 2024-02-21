package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bullethell.game.IO.InputManager;
import com.badlogic.gdx.graphics.Color;

public class Player extends GameObject implements IMovable {
    private float speed;

    private float fireTimer = 0.0f;
    private final float FIRE_RATE = 0.15f;//0.15 seconds
       
    private GameObjectManager gameObjectManager;

    public Player(float x, float y, GameObjectManager gameObjectManager)
    {
        super(x, y, 64, 64); // Example size, adjust as needed
        //texture = new Texture("TODO");
        this.speed = 100.0f;
        this.gameObjectManager = gameObjectManager;
    }

    @Override
    public void move(float delta)
    {
    	InputManager.handleMovement(this.bounds, this.speed, delta);
    }
  
    @Override
    public void update(float delta)
    {
        move(delta);
        fireTimer += delta;
        if (fireTimer >= FIRE_RATE) {
            fireProjectile();
            fireTimer = 0; // Reset the fire timer
        }
        
    }

    private void fireProjectile()
    {
        // Example projectile position; adjust according to your needs
        float projectileX = (this.bounds.x + this.bounds.width / 2);
        float projectileY = this.bounds.y + this.bounds.height;

        // Create a projectile at the player's position (or offset as needed)
        gameObjectManager.createProjectile(projectileX, projectileY);
    }


//    @Override
//    public void draw(SpriteBatch batch)
//    {
//        batch.draw(texture, bounds.x, bounds.y);
//    }
    
    @Override
    public void draw(ShapeRenderer shape)
    {
    	shape.setColor(Color.GREEN);
        shape.rect(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height);
    }
    
    @Override
    public void dispose()
    {
        this.dispose();
    }

}
