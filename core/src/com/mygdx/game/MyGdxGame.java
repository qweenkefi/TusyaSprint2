package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {
	ScreenGame screenGame;
	SpriteBatch batch;
	public static final int SCR_WIDTH = 1280;
	public static final int SCR_HEIGHT = 720;
	public OrthographicCamera camera;
	int birdX = 0;
	int birdY = 0;
	int birdSpeed = 5;

	Texture birdTexture;
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		batch = new SpriteBatch();
		birdTexture = new Texture("bird0.png");

		screenGame = new ScreenGame(this);
		setScreen(screenGame);

	}

	@Override
	public void render () {
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		birdX += birdSpeed;
		birdY += birdSpeed;
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(birdTexture,birdX, birdY);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		birdTexture.dispose();
	}
}
