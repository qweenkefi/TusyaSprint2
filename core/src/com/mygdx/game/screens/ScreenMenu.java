package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.MovingBackground;
import com.mygdx.game.components.TextButton;

public class ScreenMenu implements Screen {
    Texture texture;
    MovingBackground background;
    TextButton buttonNewGame;
    TextButton buttonExit;
    private MyGdxGame myGdxGame;

     public ScreenMenu(MyGdxGame myGdxGame){
         this.myGdxGame = myGdxGame;
         background = new MovingBackground("background/restart_bg.png");
         buttonNewGame = new TextButton(100, 400, "New Game");
         buttonExit = new TextButton(100, 200, "Exit");
     }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        if (Gdx.input.justTouched()) {

            Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (buttonNewGame.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
            if (buttonExit.isHit((int) touch.x, (int) touch.y)){
                Gdx.app.exit();

            }
        }
        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        background.draw(myGdxGame.batch);
        buttonNewGame.draw(myGdxGame.batch);
        buttonExit.draw(myGdxGame.batch);
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
