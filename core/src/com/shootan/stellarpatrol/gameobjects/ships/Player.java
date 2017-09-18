package com.shootan.stellarpatrol.gameobjects.ships;

import com.badlogic.gdx.math.Vector2;
import com.shootan.stellarpatrol.util.Constants;

/**
 * Created by geeksploit on 18.09.2017.
 */

public final class Player extends Ship {

    public Player(Vector2 position) {
        super(position);
        setTextureRegion(Constants.SHIP_TEXTURE_REGIONS.get(0));
    }
}
