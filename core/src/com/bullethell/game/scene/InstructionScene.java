package com.bullethell.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class InstructionScene extends Scene {
    private Image instructionImage;
    private Texture instructionTexture; // Store the Texture for disposal

    public InstructionScene() {
        super();
        // Load the texture and create the image
        instructionTexture = new Texture("gameInstruction.png");
        instructionImage = new Image(instructionTexture);

        float desiredWidth = stage.getWidth(); // Set this to your desired width
        float desiredHeight = 500; // Set this to your desired height

        instructionImage.setSize(desiredWidth, desiredHeight);
        instructionImage.setPosition(stage.getWidth() / 2 - desiredWidth / 2,
                stage.getHeight() / 2 - desiredHeight / 2);

        TextButton returnButton = createButton("Return To Menu", Gdx.graphics.getWidth() / 2, 200, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SceneManager.getInstance().changeScene(SceneManager.getInstance().getSceneItem(0)); // Go To Main Menu
            }
        });

        stage.addActor(returnButton);
        stage.addActor(instructionImage);
    }

    @Override
    public void sceneRender() {
        Gdx.gl.glClearColor(0, .25f, 0, 0.1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        if (instructionTexture != null) {
            instructionTexture.dispose();
        }
        super.dispose();
    }
}
