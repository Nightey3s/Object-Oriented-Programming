package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Earth extends TextureObject{
	
	public Earth() {
		super("Earth.png",0, 0, 100, 100);
	}
	
	@Override
	public void update(float delta) {
		// TODO make it rotate??
		
	}

}
