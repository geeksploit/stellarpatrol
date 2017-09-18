package com.shootan.stellarpatrol.gameobjects.bullets;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by geeksploit on 18.09.2017.
 */

public class BulletFactory {

    private static BulletFactory instance;
    private Array<Bullet> bullets;

    private BulletFactory() {
        bullets = new Array<Bullet>();
    }

    public static BulletFactory getInstance() {
        if (instance == null) {
            instance = new BulletFactory();
        }
        return instance;
    }

    public Array<Bullet> makeBullets(Class bulletClass, Vector2 position, float angle) {
        bullets.clear();
        return bullets;
    }
}
