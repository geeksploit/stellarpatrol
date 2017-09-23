package com.shootan.stellarpatrol.gameobjects.bullets;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.shootan.stellarpatrol.equipment.weapons.PrimaryWeapon;
import com.shootan.stellarpatrol.equipment.weapons.Weapon;

/**
 * Created by geeksploit on 18.09.2017.
 */

public class BulletFactory extends Pool {

    private static BulletFactory instance;
    private Array<Bullet> bullets;

    private BulletFactory() {
        bullets = new Array<Bullet>();
    }

    @Override
    protected Object newObject() {
        return null;
    }

    public static BulletFactory getInstance() {
        if (instance == null) {
            instance = new BulletFactory();
        }
        return instance;
    }

    public Array<Bullet> makeBullets(Weapon weapon, Vector2 position, float angle) {
        bullets.clear();
        if (weapon instanceof PrimaryWeapon) {
            bullets.add(new BulletPrimary(position.cpy(), angle));
        }
        return bullets;
    }
}
