package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bullethell.game.ScoreManager;

public class PauseScene extends Scene {

    public PauseScene() {
        super();

        TextButton continueButton = createButton("Continue", Gdx.graphics.getWidth() / 2, 250, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SceneManager.getInstance().changeScene(SceneManager.getInstance().getSceneItem(4));
            }
        });

        TextButton returnButton = createButton("Return To Menu", Gdx.graphics.getWidth() / 2, 200, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SceneManager.getInstance().quitGame(); // clear the game scene.
                ScoreManager.getInstance().resetScore();
                SceneManager.getInstance().changeScene(SceneManager.getInstance().getSceneItem(0)); // Go To Main Menu
            }
        });

        stage.addActor(continueButton);
        stage.addActor(returnButton);
    }

    @Override
    public void sceneRender() {
        Gdx.gl.glClearColor(0, .25f, 0, 0.1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        stage.act();
        stage.draw();

        GlyphLayout layout = new GlyphLayout();
        String pauseText = "Pause Screen!";
        layout.setText(font, pauseText);
        float pauseTextWidth = (Gdx.graphics.getWidth() - layout.width) / 2;
        font.draw(batch, pauseText, pauseTextWidth, Gdx.graphics.getHeight() * .75f);

        String scoreText = "Current Score: " + ScoreManager.getInstance().getScore();
        layout.setText(font, scoreText);
        float scoreTextWidth = (Gdx.graphics.getWidth() - layout.width) / 2;
        font.draw(batch, scoreText, scoreTextWidth, Gdx.graphics.getHeight() * .7f);

        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
