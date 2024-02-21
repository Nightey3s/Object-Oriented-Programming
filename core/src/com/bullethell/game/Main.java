package com.bullethell.game;

import com.badlogic.gdx.ApplicationAdapter;


public class Main extends ApplicationAdapter{
	
	MainGameClass mainGameClass;
    @Override
    public void create () {
    	mainGameClass = new MainGameClass();
    }
    
    @Override
    public void render() {
    	mainGameClass.render();
    }
    
    @Override
    public void dispose () {
    	mainGameClass.dispose();
    }
}
