package com.example.targon.herotrench.viewobjects;

import android.graphics.Paint;

/**
 * Created by Targon on 27.09.2016.
 */

public abstract class GameText {
    protected int positionX, positionY, textSize;
    protected boolean show;
    protected Paint paint;
    protected String text;

    public GameText(int positionX, int positionY, int textSize, String text) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.textSize = textSize;
        this.text = text;
    }
}
