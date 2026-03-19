package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	ScreenGame screenGame;
	SpriteBatch batch;
	public static final int SRC_WIDTH = 1280;
	public static final int SRC_HEIGHT = 720;
	public OrthographicCamera camera;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SRC_WIDTH, SRC_HEIGHT);
		batch = new SpriteBatch();

		screenGame = new ScreenGame(this);
		setScreen(screenGame);

	}

	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
