package com.shootan.stellarpatrol.gameobjects.bullets;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.shootan.stellarpatrol.equipment.weapons.PrimaryWeapon;
import com.shootan.stellarpatrol.equipment.weapons.Weapon;
import com.shootan.stellarpatrol.gameobjects.GameObject;
import com.shootan.stellarpatrol.util.Constants;

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
        GameObject gameObject = new BulletPrimary(new Vector2(), 0);
        gameObject.setPool(this);
        return gameObject;
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
            Bullet bullet = (Bullet) this.obtain();
            bullet.setTextureRegion(Constants.BULLET_TEXTURE_REGIONS.get(1));
            bullet.setScale(.4f);
        }
        return bullets;
    }
}
