package com.shootan.stellarpatrol.equipment.weapons;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.shootan.stellarpatrol.gameobjects.GameObject;
import com.shootan.stellarpatrol.gameobjects.bullets.Bullet;
import com.shootan.stellarpatrol.gameobjects.bullets.BulletFactory;
import com.shootan.stellarpatrol.util.Constants;

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
        reloadCooldown = Constants.WEAPON_DEFAULT_COOLDOWN;
        bulletClass = Bullet.class;
        originTransformMatrix = new Matrix3();
        bullets = new Array<GameObject>();
        reloadCooldownTimeout = reloadCooldown / 2;
    }

    public AbstractWeapon(float reloadCooldown) {
        this();
        setReloadCooldown(reloadCooldown);
        reloadCooldownTimeout = reloadCooldown / 2;
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
