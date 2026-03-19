package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

class ScreenGame implements Screen {
    private MyGdxGame myGdxGame;

    Bird bird;

    int tubeCount = 3;
    Tube[] tubes;
    boolean isGameOver;


    public  ScreenGame(MyGdxGame myGdxGame){

        this.myGdxGame = myGdxGame;
        bird = new Bird(0,0,new Texture("birdTiles/bird0.png"),5);
        initTubes();
    }
    @Override
    public void show() {
        isGameOver = false;

    }

    @Override
    public void render(float v) {

        if (Gdx.input.justTouched()) {
            bird.onClick();
        }
        bird.fly();

        for (Tube tube : tubes) {
            tube.move();
            if (tube.isHit(bird)){
                System.out.println("hit");
                isGameOver = true;
        } }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        bird.draw(myGdxGame.batch);
        for (Tube tube : tubes) tube.draw(myGdxGame.batch);
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
        bird.dispose();
        for(int i = 0; i<tubes.length; i++){
            tubes[i].dispose();
        }

    }
    void initTubes(){
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount, i);
        }
    }
}
