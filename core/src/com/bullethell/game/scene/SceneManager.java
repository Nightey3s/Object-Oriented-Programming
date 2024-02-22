package com.bullethell.game.scene;

import com.badlogic.gdx.utils.Array;

public class SceneManager{
    private Scene currentScene;
    private Array<Scene> sceneList;

    public SceneManager() {
        sceneList = new Array<Scene>();
        currentScene = null;
        initScenes();
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(Scene currentScreen) {
        this.currentScene = currentScreen;
    }

    public Array<Scene> getSceneList() {
        return sceneList;
    }

    public Scene getSceneItem(int index) {
        return sceneList.get(index);
    }

    public void initScenes() { 
        // Add all scenes to the sceneList
        sceneList.insert(0, new MainMenu());
        sceneList.insert(1, new PauseScene());
        // Default Scene
        setCurrentScene(sceneList.get(0));
    }

    public void changeScene(Scene newScene) {
        //currentScene.dispose();
        this.currentScene = newScene;
    }

    public void loadScene() {
        this.currentScene.sceneRender();
    }


    public void startGame()
    {
    	sceneList.insert(2, new GameScene());
    	setCurrentScene(sceneList.get(2));
    }
    
    public void quitGame()
    {
    	Scene scene = sceneList.pop();
    	scene.dispose();
    }
    

}
