package com.bullethell.game.scene;

import com.bullethell.game.ScoreManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class SceneManager {
    private static SceneManager instance;
    private Scene currentScene;
    private Array<Scene> sceneList;
    private List<Integer> highScores;
    private InputMultiplexer multiplexer; // Switch multiplexer to handle input for different scenes

    public SceneManager() {
        sceneList = new Array<Scene>();
        currentScene = null;
        highScores = new ArrayList<Integer>();
        multiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(multiplexer);
        initScenes();
    }

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void setFinalScore() {
        int finalScore = ScoreManager.getInstance().getScore();
        // Add the final score to high scores list
        highScores.add(finalScore);
        // Sort the high scores list in descending order
        Collections.sort(highScores, Collections.reverseOrder());
        // Keep only the top 5 high scores
        if (highScores.size() > 5) {
            highScores = highScores.subList(0, 5);
        }
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
        sceneList.insert(2, new EndScene(highScores, this)); // Add EndScene to sceneList
        sceneList.insert(3, new InstructionScene());
        // Default Scene
        multiplexer.addProcessor(sceneList.get(0).getStage());
        setCurrentScene(sceneList.get(0));
    }

    public void changeScene(Scene newScene) { // Change multiplexer aswell.
        // currentScene.dispose();
        this.multiplexer.clear();
        this.multiplexer.addProcessor(newScene.getStage());
        this.currentScene = newScene;
    }

    public void loadScene() {
        this.currentScene.sceneRender();
    }

    public void startGame() {
        sceneList.insert(4, new GameScene(getInstance()));
        setCurrentScene(sceneList.get(4));
    }

    public void quitGame() {
        for (Scene scene : sceneList) {
            if (scene instanceof GameScene) {
                scene.dispose();
            } else
                return;
        }
    }
}