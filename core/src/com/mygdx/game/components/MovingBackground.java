package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.MyGdxGame;

public class MovingBackground {
    Texture texture;
    int texture1x, texture2x;
    int speed = 5;



    public MovingBackground() {
        texture1x = 0;
        texture2x = MyGdxGame.SRC_WIDTH;
        texture = new Texture("background/game_bg.png");

    }
    public void draw(Batch batch) {
        batch.draw(texture, texture1x, 0, MyGdxGame.SRC_WIDTH, MyGdxGame.SRC_HEIGHT);
        batch.draw(texture, texture2x, 0, MyGdxGame.SRC_WIDTH, MyGdxGame.SRC_HEIGHT);

    }
    public void move(){
        texture1x -= speed;
        texture2x -= speed;

        if (texture1x <= -MyGdxGame.SRC_WIDTH){
            texture1x = MyGdxGame.SRC_WIDTH;
        }
        if (texture2x <= -MyGdxGame.SRC_WIDTH){
            texture2x = MyGdxGame.SRC_WIDTH;
        }
    }

    public void dispose(){
        texture.dispose();
    }
}
