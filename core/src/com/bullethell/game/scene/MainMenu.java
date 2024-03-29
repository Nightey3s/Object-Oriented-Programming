package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bullethell.game.scene.SceneManager;

public class MainMenu extends Scene {
    private Texture backgroundTexture;

    public MainMenu() {
        super();

        backgroundTexture = new Texture(Gdx.files.internal("main_scene.png"));

        TextButton playButton = createButton("Play", Gdx.graphics.getWidth() / 2, 250, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SceneManager.getInstance().startGame();
                SceneManager.getInstance().changeScene(SceneManager.getInstance().getSceneItem(4));
            }
        });

        TextButton exitButton = createButton("Exit", Gdx.graphics.getWidth() / 2, 100, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        TextButton highscoreButton = createButton("High Scores", Gdx.graphics.getWidth() / 2, 200, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SceneManager.getInstance().changeScene(SceneManager.getInstance().getSceneItem(2));
            }
        });

        TextButton instruction = createButton("Game Instructions", Gdx.graphics.getWidth() / 2, 150,
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        SceneManager.getInstance().changeScene(SceneManager.getInstance().getSceneItem(3));
                    }
                });

        this.stage.addActor(playButton);
        this.stage.addActor(exitButton);
        this.stage.addActor(highscoreButton);
        this.stage.addActor(instruction);
    }

    @Override
    public void sceneRender() {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(backgroundTexture, -900, 0);
        batch.end();

        stage.act();
        stage.draw();
        batch.begin();

        GlyphLayout layout = new GlyphLayout();
        String text = "SAVE THE EARTH";
        layout.setText(font, text);
        float textWidth = (Gdx.graphics.getWidth() - layout.width) / 2;
        font.draw(batch, text, textWidth, Gdx.graphics.getHeight() * .75f);

        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        if (backgroundTexture != null) {
            backgroundTexture.dispose();
        }
    }

}
