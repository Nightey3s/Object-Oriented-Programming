package com.bullethell.game.collision;

import com.badlogic.gdx.utils.Array;
import com.bullethell.game.gameObject.GameObject;

public class CollisionManager implements iCollision{
    private Array<GameObject> collisionList;

    // Constructor
    public CollisionManager() {
        this.collisionList = new Array<GameObject>();
    }

    @Override
    public void isCollidable(GameObject Object) { // Interface connects to gameObject and appends to CollisionList
        collisionList.add(Object);
    }

    // Might have to add remove method depending on implementation of destroying objects.

    public void checkCollision(GameObject Object1, GameObject Object2) {

    }

}