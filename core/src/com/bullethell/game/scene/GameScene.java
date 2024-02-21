package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bullethell.game.gameObject.Enemy;
import com.bullethell.game.gameObject.GameObjectManager;
import com.bullethell.game.gameObject.Player;
import com.bullethell.game.gameObject.PowerUp;
import com.bullethell.game.gameObject.Projectile;

public class GameScene extends Scene{
    GameObjectManager gameObjectManager;
    ShapeRenderer shapeRenderer;
    
    Player player;
    Enemy enemy;
    Projectile projectile;
    PowerUp powerUp;
    
    float deltaTime;


    public GameScene() {
        super();
        gameObjectManager = new GameObjectManager();
        shapeRenderer = new ShapeRenderer(); // Initialize the ShapeRenderer
    }

    @Override
    public void sceneRender() {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1);
        deltaTime = Gdx.graphics.getDeltaTime();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled); // Or Line, depending on your preference
        gameObjectManager.update(deltaTime);
        gameObjectManager.draw(shapeRenderer); // Pass the ShapeRenderer to the draw method
        shapeRenderer.end();
    }

}
