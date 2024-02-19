package com.bullethell.game.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class GameObjectManager {

	private Array<GameObject> gameObjects;
	
	public GameObjectManager()
	{
		gameObjects = new Array<>();
	}
	
    public void addGameObject(GameObject gameObject)
    {
        gameObjects.add(gameObject);
    }
    
    public void update(float delta)
    {
        for (GameObject obj : gameObjects)
        {
            obj.update(delta);
        }
    }
    
    public void draw(SpriteBatch batch)
    {
    	for (GameObject obj : gameObjects)
    	{
    		obj.draw(batch);
    	}
    }
}
