package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TextureObject extends GameObject{

	private Texture tex;
	private SpriteBatch batch;

	public SpriteBatch getBatch() {
		return batch;
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public TextureObject(String tex, float x, float y, float width, float height) {
		super(x, y, width, height);
		this.tex = new Texture(Gdx.files.internal(tex));
		this.batch = new SpriteBatch();
	}
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(ShapeRenderer shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.dispose();
	}

}
