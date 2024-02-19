package com.bullethell.game.gameObject;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class GameObjectManager implements Disposable {
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
        for (GameObject gameObject : gameObjects)
        {
            gameObject.update(delta);
        }
    }

//    public void draw(SpriteBatch batch)
//    {
//        for (GameObject gameObject : gameObjects)
//        {
//            gameObject.draw(batch);
//        }
//    }
    
    public void draw(ShapeRenderer shape)
    {
        for (GameObject gameObject : gameObjects)
        {
            gameObject.draw(shape);
        }
    }

    @Override
    public void dispose()
    {
        for (GameObject gameObject : gameObjects)
        {
            if (gameObject instanceof Disposable)
            {
                ((Disposable) gameObject).dispose();
            }
        }
    }
}
