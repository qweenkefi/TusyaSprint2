package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {
    int x, y;
    int width, height;
    Texture texture;
    int speed;

    int jumpHeight;
    final int maxHeightOfJump = 200;
    boolean jump;
    int frameCounter;
    Texture[] framesArray;

    public Bird(int x, int y, Texture texture, int speed) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.speed = speed;
        frameCounter = 0;
        this.width = 200;
        this.height = 200;

        framesArray = new Texture[]{
                new Texture("birdTiles/bird0.png"),
                new Texture("birdTiles/bird1.png"),
                new Texture("birdTiles/bird2.png"),
                new Texture("birdTiles/bird1.png"),
        };
    }

    public void fly(){
        if (y >= jumpHeight) {
            jump = false;
        }
        if (jump) {
            y += speed;
        } else{
            y -= speed;
        }

    }
    public void draw(Batch batch){
        int frameMultiplier = 10;
        batch.draw(framesArray[frameCounter/ frameMultiplier], x, y, width,height);
        if (frameCounter++ == framesArray.length * frameMultiplier - 1) frameCounter = 0;
    }
    public void dispose() {
        for (Texture texture : framesArray) {
            texture.dispose();
        }
    }
    void onClick(){
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }

}
