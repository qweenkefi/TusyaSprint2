package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AddText {

        int x, y;
        BitmapFont font;
        public AddText(int x, int y) {
            this.x = x;
            this.y = y;
            font = new BitmapFont();
            font.getData().setScale(5f);
            font.setColor(Color.WHITE);
        }

        public void draw(Batch batch) {
             font.draw(batch, "Get 5 points \nto change\nthe background ", x, y);
        }
}
