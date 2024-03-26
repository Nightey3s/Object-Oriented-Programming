package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bullethell.game.ScoreManager;
import java.util.List;

public class EndScene extends Scene {
    private List<Integer> highScores;
    private SceneManager sceneManager;

    public EndScene(List<Integer> highScores, SceneManager sceneManager) {
        super();
        this.highScores = highScores;
        this.sceneManager = sceneManager;

        TextButton returnButton = createButton("Return To Menu",Gdx.graphics.getWidth() / 2,200, new ClickListener() {
            @Override
                public void clicked(InputEvent event, float x, float y) {
                SceneManager.getInstance().quitGame(); // clear the game scene.
                SceneManager.getInstance().changeScene(SceneManager.getInstance().getSceneItem(0)); // Go To Main Menu
                }
        });

        stage.addActor(returnButton);
    }

    public void displayFinalScores() {
        int finalScore = ScoreManager.getInstance().getScore();
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Final Score: " + finalScore, Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .75f);
        for (int i = 0; i < Math.min(this.highScores.size(), 5); i++) {
            font.draw(batch, "High Score " + (i+1) + ": " + this.highScores.get(i), Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * (.75f - (i+1)*.05f));
        }
        batch.end();
    }


    @Override
    public void sceneRender() {
        displayFinalScores();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}