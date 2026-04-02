package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.ScreenGame;
import com.mygdx.game.screens.ScreenMenu;
import com.mygdx.game.screens.ScreenRestart;

public class MyGdxGame extends Game {
	public  ScreenGame screenGame;
	public SpriteBatch batch;
	public ScreenRestart screenRestart;
	public ScreenMenu screenMenu;
	public static final int SRC_WIDTH = 1280;
	public static final int SRC_HEIGHT = 720;
	public OrthographicCamera camera;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SRC_WIDTH, SRC_HEIGHT);
		batch = new SpriteBatch();

		screenGame = new ScreenGame(this);
		screenRestart = new ScreenRestart(this);
		screenMenu = new ScreenMenu(this);
		setScreen(screenMenu);

	}

	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
