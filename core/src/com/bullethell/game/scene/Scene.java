package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Scene {
    protected SpriteBatch batch;
    protected BitmapFont font;

    public Scene() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    public void initScene() {
    }

    public void sceneRender() {
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}
