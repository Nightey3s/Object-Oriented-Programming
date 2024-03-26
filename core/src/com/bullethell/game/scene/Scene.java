package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public abstract class Scene {
    protected SpriteBatch batch;
    protected BitmapFont font;
    protected Stage stage; // Stage for all the ui elements to be placed on
    protected Skin skin;

    public Scene() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        skin = new Skin(Gdx.files.internal("skin/expee-ui.json")); // Default Button UI Skin
        stage = new Stage();
    }

    public Stage getStage() {
        return this.stage;
    }

    public TextButton createButton(String text, int x, int y, ClickListener listener) { // Function to create buttons
        TextButton button = new TextButton(text, skin);
        button.setHeight(40);
        button.setWidth(100);
        button.setPosition(x - button.getWidth() / 2, y - button.getHeight() / 2);
        button.addListener(listener);
        return button;
    }

    public abstract void sceneRender();

    public void dispose() {
        batch.dispose();
        font.dispose();
        stage.dispose();
        skin.dispose();
    }

}
