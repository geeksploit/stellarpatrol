package com.shootan.stellarpatrol.gameobjects.bullets;

import com.badlogic.gdx.math.Vector2;
import com.shootan.stellarpatrol.util.Constants;

/**
 * Created by geeksploit on 18.09.2017.
 */

public final class BulletPrimary extends Bullet {

    public BulletPrimary(Vector2 position, float angle) {
        super(position, angle);
        setTextureRegion(Constants.BULLET_TEXTURE_REGIONS.get(1));
    }
}
