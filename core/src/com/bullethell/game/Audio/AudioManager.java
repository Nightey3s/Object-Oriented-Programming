package com.bullethell.game.Audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;

public class AudioManager {
    private Music backgroundMusic;
    private Sound collisionSound;
    private Sound collectSound;
    private Sound startGameSound;
    private Sound bulletSound;
    private Sound bulletCollision;

    private float backgroundMusicVolume = 1.0f;
    private float collisionSoundVolume = 1.0f;
    private float collectSoundVolume = 1.0f;
    private float startGameSoundVolume = 1.0f;
    private float bulletSoundVolume = 1.0f;
    private float bulletCollisionVolume = 1.0f;

    public AudioManager() {
    	loadAudio();
    }
    
    public void loadAudio() {
        // Load audio files
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgroundMusic.mp3"));
        collisionSound = Gdx.audio.newSound(Gdx.files.internal("Collision.wav"));
        collectSound = Gdx.audio.newSound(Gdx.files.internal("Collect.wav"));
        startGameSound = Gdx.audio.newSound(Gdx.files.internal("StartGame.wav"));
        bulletSound = Gdx.audio.newSound(Gdx.files.internal("bulletSound.wav"));
        bulletCollision = Gdx.audio.newSound(Gdx.files.internal("bulletCollision.wav"));

        // Play background music
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(backgroundMusicVolume);
        backgroundMusic.play();
    }

    public void setBackgroundMusicVolume(float volume) {
        backgroundMusicVolume = MathUtils.clamp(volume, 0.0f, 1.0f);
        backgroundMusic.setVolume(backgroundMusicVolume);
    }

    public void setCollisionSoundVolume(float volume) {
        collisionSoundVolume = MathUtils.clamp(volume, 0.0f, 1.0f);
    }

    public void setCollectSoundVolume(float volume) {
        collectSoundVolume = MathUtils.clamp(volume, 0.0f, 1.0f);
    }

    public void setStartGameSoundVolume(float volume) {
        startGameSoundVolume = MathUtils.clamp(volume, 0.0f, 1.0f);
    }

    public void setBulletSoundVolume(float volume) {
        bulletSoundVolume = MathUtils.clamp(volume, 0.0f, 1.0f);
    }

    public void setBulletCollisionVolume(float volume) {
        bulletCollisionVolume = MathUtils.clamp(volume, 0.0f, 1.0f);
    }

    public void playCollisionSound() {
        collisionSound.play(collisionSoundVolume);
    }

    public void playCollectSound() {
        collectSound.play(collectSoundVolume);
    }

    public void playStartGameSound() {
        startGameSound.play(startGameSoundVolume);
    }

    public void playBulletSound() {
        bulletSound.play(bulletSoundVolume);
    }

    public void playBulletCollision() {
        bulletCollision.play(bulletCollisionVolume);
    }

    public void dispose() {
        backgroundMusic.dispose();
        collisionSound.dispose();
        collectSound.dispose();
        startGameSound.dispose();
        bulletSound.dispose();
        bulletCollision.dispose();
    }
}
