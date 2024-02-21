package com.bullethell.game.collision;

import com.badlogic.gdx.utils.Array;
import com.bullethell.game.gameObject.GameObject;
import com.bullethell.game.gameObject.Enemy;
import com.bullethell.game.gameObject.Player;
import com.bullethell.game.gameObject.PowerUp;

public class CollisionManager implements iCollision{
    private Array<GameObject> collisionList;

    // Constructor
    public CollisionManager() {
        this.collisionList = new Array<GameObject>();
    }

    // getters and setters
    public Array<GameObject> getCollisionList() {
        return collisionList;
    }

    public GameObject getCollisionItem(int index) {
        return collisionList.get(index);
    }

    @Override
    public void isCollidable(GameObject Object) { // Interface connects to gameObject and appends to CollisionList
        collisionList.add(Object);
    }

    public void removeCollidable(GameObject Object) {
        collisionList.removeValue(Object, true);
    }

    // Might have to add remove method depending on implementation of destroying objects.

    public boolean checkCollision(GameObject Object1, GameObject Object2) {
        return Object1.getBounds().overlaps(Object2.getBounds());
    }

    public void resolveCollision(GameObject Object1, GameObject Object2) {  
        if (Object1 instanceof Player && Object2 instanceof Enemy) {
            // If object 1 is a player and object 2 is an enemy, object 1 takes damage and object 2 is destroyed etc.
        }
        else if (Object1 instanceof Enemy && Object2 instanceof Player) {
            // Then do something
        }
        else if (Object1 instanceof Enemy && Object2 instanceof Enemy) {
            // Then do something
        }
        else if (Object1 instanceof Player && Object2 instanceof PowerUp) {
            // Then do something
        }
    }

}