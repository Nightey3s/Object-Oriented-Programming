package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
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

        TextButton returnButton = createButton("Return To Menu", Gdx.graphics.getWidth() / 2, 200, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SceneManager.getInstance().quitGame(); // clear the game scene.
                ScoreManager.getInstance().resetScore();
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

        GlyphLayout layout = new GlyphLayout();
        String finalScoreText = "Final Score: " + finalScore;
        layout.setText(font, finalScoreText);
        float finalScoreX = (Gdx.graphics.getWidth() - layout.width) / 2;
        font.draw(batch, finalScoreText, finalScoreX, Gdx.graphics.getHeight() * .75f);

        for (int i = 0; i < Math.min(this.highScores.size(), 5); i++) {
            String highScoreText = "High Score " + (i + 1) + ": " + this.highScores.get(i);
            layout.setText(font, highScoreText); // Measure the text
            float highScoreX = (Gdx.graphics.getWidth() - layout.width) / 2; // Calculate x position for centering text
            font.draw(batch, highScoreText, highScoreX, Gdx.graphics.getHeight() * (.75f - (i + 1) * .05f));
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