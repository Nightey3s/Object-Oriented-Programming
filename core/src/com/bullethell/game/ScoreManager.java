package com.bullethell.game;

public class ScoreManager {
    private static ScoreManager instance;
    private int score;
    private boolean doubleScoreActive; // Flag to indicate if double score is active
    private float doubleScoreDuration; // Duration for which double score remains active
    private float doubleScoreTimer; // Timer to track the duration of double score

    private ScoreManager() {
        score = 0;
        doubleScoreActive = false;
        doubleScoreDuration = 5; // Default duration for double score (in seconds)
        doubleScoreTimer = 0;
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
        if (doubleScoreActive) {
            points *= 2; // Double the points if double score is active
        }
        score += points;
    }

    public void resetScore() {
        score = 0;
    }

    public void update(float delta) {
        // Update the double score timer if double score is active
        if (doubleScoreActive) {
            doubleScoreTimer += delta;
            // Check if the double score duration has elapsed
            if (doubleScoreTimer >= doubleScoreDuration) {
                doubleScoreActive = false; // Deactivate double score
                doubleScoreTimer = 0; // Reset the timer
            }
        }
    }

    // Method to activate double score
    public void activateDoubleScore() {
        doubleScoreActive = true;
    }

    // Method to deactivate double score
    public void deactivateDoubleScore() {
        doubleScoreActive = false;
    }
}
