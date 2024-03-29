package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
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
                SceneManager.getInstance().changeScene(SceneManager.getInstance().getSceneItem(3));
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
        font.draw(batch, "Pause Screen!", Gdx.graphics.getWidth() / 2,
                Gdx.graphics.getHeight() * .75f);
        font.draw(batch, "Current Score: " + ScoreManager.getInstance().getScore(), Gdx.graphics.getWidth() / 2,
                Gdx.graphics.getHeight() * .05f);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
