package com.mygdx.game;
import static com.mygdx.game.MyGdxGame.SRC_HEIGHT;
import static com.mygdx.game.MyGdxGame.SRC_WIDTH;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

import static com.badlogic.gdx.math.MathUtils.random;

public class Tube {
    boolean isPointReceived;

    Texture textureUpperTube;
    Texture textureDownTube;
    Random random;
    int x, gapY;
    int distanceBetweenTubes;
    int width = 200;
    int height = 700;
    int gapHeight = 400;
    int padding = 100;
    int speed = 10;
    public  Tube(int tubeCount, int tubeIdx){
        random = new Random();
        textureUpperTube = new Texture("tubes/tube_flipped.png");
        textureDownTube = new Texture("tubes/tube.png");

        gapY = gapHeight / 2 + padding + random.nextInt(SRC_HEIGHT - 2 * (padding + gapHeight / 2));
        distanceBetweenTubes = (SRC_WIDTH + width) / (tubeCount - 1);
        x = distanceBetweenTubes * tubeIdx + SRC_WIDTH;
        isPointReceived = false;
    }
     void draw(Batch batch){
        batch.draw(textureUpperTube, x, gapY + gapHeight / 2, width, height);
        batch.draw(textureDownTube, x, gapY - gapHeight / 2 - height, width, height);
    }
    void move(){
        x -= speed;
        if (x < -width){
            isPointReceived = false;
            x = SRC_WIDTH + distanceBetweenTubes;
            gapY = gapHeight / 2 + padding + random.nextInt(SRC_HEIGHT - 2 * (gapHeight / 2));
        }


    }
    public boolean needAddPoint(Bird bird){


        return !isPointReceived && (bird.x >=( x + width));
    }
    public void setPointReceived(){
        isPointReceived = true;
    }
    public boolean isHit(Bird bird){
        if (bird.y <= gapY - gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x)
            return true;
        if (bird.y + bird.height >= gapY + gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x)
            return true;

        return false;
    }

    void dispose(){
        textureDownTube.dispose();
        textureUpperTube.dispose();

    }
}
