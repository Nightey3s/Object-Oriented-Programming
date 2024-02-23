package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class MainMenu extends Scene{
    
    public MainMenu() {
        super();
    }

    @Override
    public void sceneRender() {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
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
