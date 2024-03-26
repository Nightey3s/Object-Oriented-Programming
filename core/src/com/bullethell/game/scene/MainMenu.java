package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bullethell.game.scene.SceneManager;


public class MainMenu extends Scene{

    public MainMenu() {
        super();

        TextButton playButton = createButton("Play",Gdx.graphics.getWidth() / 2,250, new ClickListener() {
            @Override
                public void clicked(InputEvent event, float x, float y) {
                SceneManager.getInstance().startGame();
                SceneManager.getInstance().changeScene(SceneManager.getInstance().getSceneItem(3));
                }
        });

        TextButton exitButton = createButton("Exit",Gdx.graphics.getWidth() / 2,200, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        TextButton highscoreButton = createButton("High Scores",Gdx.graphics.getWidth() / 2,150, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SceneManager.getInstance().changeScene(SceneManager.getInstance().getSceneItem(2)); 
            }
        });

        this.stage.addActor(playButton);
        this.stage.addActor(exitButton);
        this.stage.addActor(highscoreButton);
    }


    @Override
    public void sceneRender() {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            stage.act();
            stage.draw();
            font.draw(batch, "Title Screen!", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .75f);
            font.draw(batch, "Press Space to play.", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .25f);
            font.draw(batch, "Press P to pause.", Gdx.graphics.getWidth()*.20f, Gdx.graphics.getHeight() * .20f);
            font.draw(batch, "Press Q to quit to main menu.", Gdx.graphics.getWidth()*.15f, Gdx.graphics.getHeight() * .15f);
            font.draw(batch, "Press H to view high scores.", Gdx.graphics.getWidth()*.10f, Gdx.graphics.getHeight() * .10f);
            batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
