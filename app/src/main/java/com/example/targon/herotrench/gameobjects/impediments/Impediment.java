package com.example.targon.herotrench.gameobjects.impediments;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.targon.herotrench.gameobjects.GameObject;
import com.example.targon.herotrench.surfaceview.GamePanel;

/**
 * Created by Targon on 26.09.2016.
 */

public abstract class Impediment extends GameObject{
    public Impediment(int positionX, int positionY, int sizeX, int sizeY, Bitmap image) {
        super(positionX, positionY, sizeX, sizeY);
        this.image = image;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(canShow()){
            canvas.drawBitmap(image, positionX, positionY, null);
        }

    }

    private boolean canShow(){
        if(positionX+sizeX>0 && positionX > GamePanel.WIDTH && positionY+sizeY>0 && positionY > GamePanel.HEIGHT ){
            return true;
        }
        return false;
    }
}
