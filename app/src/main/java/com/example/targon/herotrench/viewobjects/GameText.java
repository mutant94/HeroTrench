package com.example.targon.herotrench.viewobjects;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Targon on 27.09.2016.
 */

public abstract class GameText {
    public final static int NORMAL_SIZE = 15;
    protected int positionX, positionY;
    protected boolean show;
    protected Paint paint;
    protected String text;

    public GameText(int positionX, int positionY, int textSize, String text, int color) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.text = text;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setTextSize(textSize);
        show = false;
    }

    protected void updateText(String text){
        this.text = text;
    }

    public void draw(Canvas canvas){
        if(show){
            canvas.drawText(text, positionX, positionY, paint);
        }
    }


}
