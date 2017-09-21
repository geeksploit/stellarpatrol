package com.shootan.stellarpatrol;

import com.badlogic.gdx.Game;
import com.shootan.stellarpatrol.screens.CombatScreen;
import com.shootan.stellarpatrol.screens.DifficultyScreen;

import static com.shootan.stellarpatrol.util.Constants.Difficulty;

public class StellarPatrolGame extends Game {

	private Difficulty difficulty;

	@Override
	public void create() {
		setDifficultyScreen();
	}

	public void setCombatScreen() {
		setScreen(new CombatScreen(this));
	}

	public void setDifficultyScreen() {
		setScreen(new DifficultyScreen(this));
	}

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

	public void gameOver() {
        setDifficultyScreen();
	}
}
