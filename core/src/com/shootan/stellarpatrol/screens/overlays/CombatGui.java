package com.shootan.stellarpatrol.screens.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.shootan.stellarpatrol.StellarPatrolGame;

/**
 * Created by geeksploit on 22.09.2017.
 */

public class CombatGui {

    private StellarPatrolGame game;
    private StringBuilder stringBuilder;

    private BitmapFont bitmapFont;
    private ScreenViewport screenViewport;
    private SpriteBatch spriteBatch;

    public CombatGui() {
        game = (StellarPatrolGame) Gdx.app.getApplicationListener();
        stringBuilder = new StringBuilder();
    }

    public void render(float delta) {

    }

    public void setFont(BitmapFont font) {
        this.bitmapFont = font;
    }

    public void setViewport(ScreenViewport viewport) {
        this.screenViewport = viewport;
    }

    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }
}
