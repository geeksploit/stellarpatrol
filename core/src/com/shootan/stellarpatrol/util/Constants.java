package com.shootan.stellarpatrol.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

/**
 * Created by geeksploit on 16.09.2017.
 */

public class Constants {
    public static final float DIFFICULTY_WORLD_SIZE = 480.0f;
    public static final float DIFFICULTY_BUBBLE_RADIUS = DIFFICULTY_WORLD_SIZE / 9;
    public static final float DIFFICULTY_LABEL_SCALE = 1.5f;
    public static final Color EASY_COLOR = new Color(0.2f, 0.5f, 1, 0.5f);
    public static final Color MEDIUM_COLOR = new Color(0.5f, 0.75f, 1, 0.5f);
    public static final Color HARD_COLOR = new Color(0.7f, 1f, 1, 0.5f);
    public static final String EASY_LABEL = "Rookie";
    public static final String MEDIUM_LABEL = "Cadet";
    public static final String HARD_LABEL = "Captain";

    public static final Array<Texture> BACKGROUND = new Array<Texture>() {{
        add(new Texture("backgrounds/background_0.jpg"));
        add(new Texture("backgrounds/background_1.jpg"));
        add(new Texture("backgrounds/background_2.jpg"));
        add(new Texture("backgrounds/background_3.jpg"));
    }};
}
