package com.bullethell.game;

public class ScoreManager {
    private static ScoreManager instance;
    private int score;

    private ScoreManager() {
        score = 0;
    }

    public static ScoreManager getInstance() {
        if (instance == null) {
            instance = new ScoreManager();
        }
        return instance;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }

    public void resetScore() {
        score = 0;
    }
}