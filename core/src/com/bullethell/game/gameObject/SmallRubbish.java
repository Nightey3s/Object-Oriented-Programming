package com.bullethell.game.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class SmallRubbish extends Enemy {
    private Sprite sprite;
    private Texture tex;
    private float speed = 50;

    public SmallRubbish(float x, float y, int width, int height, String texturePath) {
        super(x, y, width, height, 50, 20);
        this.tex = new Texture(Gdx.files.internal(texturePath));
        sprite = new Sprite(this.tex);
        sprite.setSize(width, height);
        sprite.setOriginCenter();
        sprite.setPosition(x, y);
        this.bounds = sprite.getBoundingRectangle();
    }

    @Override
    public void update(float delta) {
        // Moving down slowly.
        sprite.setY(sprite.getY() - speed * delta);
        bounds.y = sprite.getY();
    }

    @Override
    public void draw(ShapeRenderer shape) {
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void dispose() {
        this.dispose();
    }

    @Override
    public Sprite getSprite() {
        return sprite; // Return the actual sprite
    }

}
