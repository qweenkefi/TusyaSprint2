package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.AddText;
import com.mygdx.game.components.MovingBackground;
import com.mygdx.game.components.PointCounter;
import com.mygdx.game.components.TextButton;

public class ScreenRestart implements Screen {
    MovingBackground background;
    TextButton buttonRestart;
    TextButton buttonMenu;

    PointCounter pointCounter;
    AddText addText;
    Texture texture;
    private MyGdxGame myGdxGame;
    int gamePoints;


    public ScreenRestart(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        pointCounter = new PointCounter(750, 530);
        addText = new AddText(750, 350);
        buttonRestart = new TextButton(100,400, "Restart");
        buttonMenu = new TextButton(100, 200, "Menu");

        background = new MovingBackground("background/restart_bg.png");
    }




    @Override
    public void show() {


    }

    @Override
    public void render(float v) {

        if (Gdx.input.justTouched()) {

            Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (buttonRestart.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
            if (buttonMenu.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.setScreen(myGdxGame.screenMenu);
            }

        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        background.draw(myGdxGame.batch);
        buttonRestart.draw(myGdxGame.batch);
        buttonMenu.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, gamePoints);
        if(gamePoints<5) { addText.draw(myGdxGame.batch);}
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
