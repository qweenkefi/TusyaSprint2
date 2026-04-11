package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.characters.Bird;
import com.mygdx.game.characters.Tube;
import com.mygdx.game.components.MovingBackground;
import com.mygdx.game.components.PointCounter;

import static com.mygdx.game.MyGdxGame.SRC_HEIGHT;
import static com.mygdx.game.MyGdxGame.SRC_WIDTH;

public class ScreenGame implements Screen {
    public int gamePoints;
    private MyGdxGame myGdxGame;

    Bird bird;

    MovingBackground background;
    PointCounter pointCounter;

    final int pointCounterMarginTop = 60;
    final int pointCounterMarginRight = 400;



    int tubeCount = 3;
    Tube[] tubes;
    boolean isGameOver;
    boolean isGameStarted;
    boolean backgroundChanged;



    public ScreenGame(MyGdxGame myGdxGame) {

        this.myGdxGame = myGdxGame;
        bird = new Bird(0, 0, new Texture("birdTiles/bird0.png"), 5);
        background = new MovingBackground("background/game_bg.png");
        initTubes();
        pointCounter = new PointCounter(SRC_WIDTH - pointCounterMarginRight, SRC_HEIGHT - pointCounterMarginTop);
    }

    @Override
    public void show() {
        gamePoints = 0;
        isGameOver = false;
        bird.setY(SRC_HEIGHT / 2);
        initTubes();
        isGameStarted = false;

    }


    @Override
    public void render(float v) {
        //if isGameStarted


        if (Gdx.input.justTouched()) {
            bird.onClick();
        }
        background.move();
        bird.fly();
        if (!bird.isInField()) {
            System.out.println("not in field");
            isGameOver = true;
        }
        if (gamePoints >= 5 && !backgroundChanged){
            background.setTexture(new Texture("background/restart_bg.png"));
        }

        if (isGameOver) {
            myGdxGame.screenRestart.gamePoints = gamePoints;
            myGdxGame.setScreen(myGdxGame.screenRestart);
        }


        for (Tube tube : tubes) {
            tube.move();
            if (tube.isHit(bird)) {
                System.out.println("hit");
                isGameOver = true;
            } else if (tube.needAddPoint(bird)) {
                gamePoints += 1;
                tube.setPointReceived();
            }
        }

// this texture dispose texture


        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);
        for (Tube tube : tubes) tube.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, gamePoints);
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
        background.dispose();
        for (int i = 0; i < tubes.length; i++) {
            tubes[i].dispose();
        }

    }

    void initTubes() {
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount, i);
        }
    }
}
