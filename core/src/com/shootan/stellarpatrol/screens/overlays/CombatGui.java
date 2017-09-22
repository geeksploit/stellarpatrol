package com.shootan.stellarpatrol.screens.overlays;

import com.badlogic.gdx.Gdx;
import com.shootan.stellarpatrol.StellarPatrolGame;

/**
 * Created by geeksploit on 22.09.2017.
 */

public class CombatGui {

    private StellarPatrolGame game;

    public CombatGui() {
        game = (StellarPatrolGame) Gdx.app.getApplicationListener();
    }
}
