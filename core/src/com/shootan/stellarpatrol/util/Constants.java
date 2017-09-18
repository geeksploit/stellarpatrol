package com.shootan.stellarpatrol.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

    public static final float WORLD_SIZE = 10;

    public static final float WEAPON_DEFAULT_COOLDOWN = 5;
    public static final float BULLET_MAX_VELOCITY = 10f;

    private static final float HARD_SPAWN_COOLDOWN = .075f;
    private static final float MEDIUM_SPAWN_COOLDOWN = HARD_SPAWN_COOLDOWN / 2;
    private static final float EASY_SPAWN_COOLDOWN = MEDIUM_SPAWN_COOLDOWN / 2;

    public enum Difficulty {
        EASY(EASY_SPAWN_COOLDOWN, EASY_LABEL),
        MEDIUM(MEDIUM_SPAWN_COOLDOWN, MEDIUM_LABEL),
        HARD(HARD_SPAWN_COOLDOWN, HARD_LABEL);

        public float enemySpawnCooldown;
        public float powerupSpawnCooldown;
        public float trapSpawnCooldown;
        public float asteroidSpawnCooldown;
        public float bossSpawnCooldown;
        public String label;

        Difficulty(float spawnRate, String label) {
            this.enemySpawnCooldown = spawnRate;
            this.powerupSpawnCooldown = spawnRate / 20;
            this.trapSpawnCooldown = spawnRate / 5;
            this.asteroidSpawnCooldown = spawnRate / 5;
            this.bossSpawnCooldown = spawnRate / 100;
            this.label = label;
        }
    }

    public static final Array<Texture> BACKGROUND = new Array<Texture>() {{
        add(new Texture("backgrounds/background_0.jpg"));
        add(new Texture("backgrounds/background_1.jpg"));
        add(new Texture("backgrounds/background_2.jpg"));
        add(new Texture("backgrounds/background_3.jpg"));
    }};

    public static final Array<TextureRegion> BULLET_TEXTURE_REGIONS = new Array<TextureRegion>() {{
        add(new TextureRegion(new Texture("bullets/bullet_0.png")));
        add(new TextureRegion(new Texture("bullets/bullet_1.png")));
        add(new TextureRegion(new Texture("bullets/bullet_2.png")));
        add(new TextureRegion(new Texture("bullets/bullet_3.png")));
        add(new TextureRegion(new Texture("bullets/bullet_4.png")));
        add(new TextureRegion(new Texture("bullets/bullet_5.png")));
        add(new TextureRegion(new Texture("bullets/bullet_6.png")));
    }};
}
