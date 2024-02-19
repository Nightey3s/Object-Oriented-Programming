package com.bullethell.game.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameObject implements IMovable{
	
	public Player(Vector2 position, Vector2 size)
	{
		super(position, size);
	}
	
	@Override
	public void move(float delta)
	{
		
	}
	
	@Override
	public void update(float delta)
	{
		move(delta);
	}
	
	@Override
	public void draw(SpriteBatch batch)
	{
		
	}
}
