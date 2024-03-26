package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public abstract class Scene {
    protected SpriteBatch batch;
    protected BitmapFont font;
    protected Stage stage; // Stage for all the ui elements to be placed on
    protected Skin skin;
    

    public Scene() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        stage = new Stage(); // 2D UI Element stage
        Gdx.input.setInputProcessor(stage); 
        skin = new Skin(Gdx.files.internal("skin/expee-ui.json")); // Default Button UI Skin
    }

    public abstract void sceneRender();

    public void dispose() {
        batch.dispose();
        font.dispose();
        stage.dispose();
        skin.dispose();
    }

}
