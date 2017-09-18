package com.shootan.stellarpatrol.equipment.weapons;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.shootan.stellarpatrol.gameobjects.GameObject;
import com.shootan.stellarpatrol.gameobjects.bullets.BulletFactory;

/**
 * Created by geeksploit on 17.09.2017.
 */

abstract class AbstractWeapon implements Weapon {

    private float reloadCooldown;
    private Class bulletClass;
    private Matrix3 originTransformMatrix;
    private Array<GameObject> bullets;
    private float reloadCooldownTimeout;

    AbstractWeapon() {
         bullets = new Array<GameObject>();
    }

    @Override
    public Array<GameObject> shoot(float deltaTime, Vector2 parentPosition, float parentAngle) {
        bullets.clear();
        if (isReadyToShoot(deltaTime)) {
            bullets.addAll(BulletFactory.getInstance().makeBullets(bulletClass, parentPosition, parentAngle));
        }
        return bullets;
    }

    @Override
    public void setReloadCooldown(float reloadCooldown) {
        this.reloadCooldown = reloadCooldown;
    }

    @Override
    public float getReloadCooldown() {
        return reloadCooldown;
    }

    @Override
    public void setBulletClass(Class bulletClass) {
        this.bulletClass = bulletClass;
    }

    @Override
    public Matrix3 getOriginTransformMatrix() {
        return originTransformMatrix;
    }

    private boolean isReadyToShoot(float deltaTime) {
        reloadCooldownTimeout -= deltaTime;
        if (reloadCooldownTimeout < 0) {
            reloadCooldownTimeout = reloadCooldown;
            return true;
        }
        return false;
    }
}
