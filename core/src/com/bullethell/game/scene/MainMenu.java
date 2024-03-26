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

        stage.addActor(playButton);
        stage.addActor(exitButton);
    }

    private TextButton createButton(String text,  int x, int y,ClickListener listener) { // Function to create buttons
        TextButton button = new TextButton(text, skin);
        button.setHeight(40);
        button.setWidth(100);
        button.setPosition(x - button.getWidth() / 2, y - button.getHeight() / 2);
        button.addListener(listener);
        return button;
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
