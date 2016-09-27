package com.example.targon.herotrench.viewobjects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.targon.herotrench.surfaceview.GamePanel;

/**
 * Created by Targon on 13.09.2016.
 */
public abstract class GameButton {
    protected int positionX, positionY, sizeX, sizeY;
    protected Bitmap image;
    protected boolean show;

    public GameButton(int positionX, int positionY, int sizeX, int sizeY, Bitmap image) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.image = image;
        this.show = true;
    }

    public boolean click(MotionEvent event){
        if(show){
            return checkClick(event);
        }
        return false;
    }

    private boolean checkClick(MotionEvent event) {
        for (int i = 0; i < event.getPointerCount(); i++) {
            int x = (int) (event.getX(i) * GamePanel.scaleX), y = (int) (event.getY(i) * GamePanel.scaleY);
            if (getRect().contains(x, y)) {
                return true;
            }
        }
        return false;
    }

    public void show(){
        show = true;
    }

    public void hide(){
        show = false;
    }

    public void draw(Canvas canvas){
        if(show){
            //canvas.drawBitmap(image, positionX, positionY, null);
            //TODO delete tested rect
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            canvas.drawRect(positionX, positionY, positionX + sizeX, positionY + sizeY, paint);
        }
    }

    private Rect getRect(){
        return new Rect(positionX, positionY, positionX + sizeX, positionY + sizeY);
    }
}
