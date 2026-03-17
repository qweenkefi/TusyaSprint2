package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

class ScreenGame implements Screen {
    private MyGdxGame myGdxGame;

    Bird bird;


    public  ScreenGame(MyGdxGame myGdxGame){

        this.myGdxGame = myGdxGame;
        bird = new Bird(0,0,new Texture("birdTiles/bird0.png"),5);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

        if (Gdx.input.justTouched()) {
            bird.onClick();
        }
        bird.fly();
        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        bird.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
