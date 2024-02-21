package com.bullethell.game.scene;

import com.badlogic.gdx.utils.Array;
import com.bullethell.game.scene.Scene;

public class SceneManager implements iScene{
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
        sceneList.add(new MainMenu());
        sceneList.add(new GameScene());
        // Default Scene
        setCurrentScene(sceneList.get(1));
    }

    public void changeScene(Scene newScene) {
        // currentScene.dispose(); do we need to Clean up the current scene?
        this.currentScene = newScene;
    }

    public void loadScene() {
        this.currentScene.sceneRender();
    }



}
