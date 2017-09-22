package com.shootan.stellarpatrol.screens.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.shootan.stellarpatrol.StellarPatrolGame;

/**
 * Created by geeksploit on 22.09.2017.
 */

public class CombatGui {

    private StellarPatrolGame game;
    private StringBuilder stringBuilder;

    private BitmapFont bitmapFont;

    public CombatGui() {
        game = (StellarPatrolGame) Gdx.app.getApplicationListener();
        stringBuilder = new StringBuilder();
    }

    public void setFont(BitmapFont font) {
        this.bitmapFont = font;
    }
}
