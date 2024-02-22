package com.bullethell.game.scene;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Scene {
    protected SpriteBatch batch;
    protected BitmapFont font;

    public Scene() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    public abstract void sceneRender();

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}
