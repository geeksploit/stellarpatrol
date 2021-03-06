package com.shootan.stellarpatrol.screens.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
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
        screenViewport.apply();
        spriteBatch.setProjectionMatrix(screenViewport.getCamera().combined);

        spriteBatch.begin();
        {
            int margin = 20;
            stringBuilder.setLength(0);
            stringBuilder.append("Difficulty: ").append(game.getDifficulty().label);
            bitmapFont.draw(spriteBatch, stringBuilder, margin, screenViewport.getScreenHeight() - margin, 0, Align.left, false);
        }
        spriteBatch.end();
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
