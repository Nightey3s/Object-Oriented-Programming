package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class PauseScene extends Scene {

	public PauseScene()
	{
		super();
	}
	
    @Override
    public void sceneRender() {
        Gdx.gl.glClearColor(0, .25f, 0, 0.1f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            font.draw(batch, "Pause Screen!", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .75f);
            font.draw(batch, "Press space to play.", Gdx.graphics.getWidth()*.25f, Gdx.graphics.getHeight() * .25f);
            batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
