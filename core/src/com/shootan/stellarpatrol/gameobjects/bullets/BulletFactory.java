package com.shootan.stellarpatrol.gameobjects.bullets;

/**
 * Created by geeksploit on 18.09.2017.
 */

public class BulletFactory {

    private static BulletFactory instance;

    private BulletFactory() {
    }

    public BulletFactory getInstance() {
        if (instance == null) {
            instance = new BulletFactory();
        }
        return instance;
    }
}
