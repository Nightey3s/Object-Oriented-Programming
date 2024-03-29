package com.bullethell.game.gameObject;

// Utility class to define the available type of GameObjects that have unique collisions
// - to bypass the use of instanceof for performance improvements.
public enum GameObjectTypes {
    Player,
    Enemy,
    PowerUp,
    Projectile,
    Earth,
    Recyclable,
    
    // Add other types as needed
}