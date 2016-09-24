package com.example.targon.herotrench.gameobjects.impediments;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.targon.herotrench.gameobjects.GameObject;
import com.example.targon.herotrench.mapcreator.MapCreator;
import com.example.targon.herotrench.surfaceview.GamePanel;

/**
 * Created by Targon on 13.09.2016.
 */
public class Tree extends GameObject{
    Bitmap image;

    public Tree(int positionX, int positionY, int sizeX, int sizeY, Bitmap image) {
        super(positionX, positionY, sizeX, sizeY);
        this.image = image;
    }

    @Override
    public void update(int moveX, int moveY){
        super.update(moveX, moveY);
    }

    @Override
    public void draw(Canvas canvas){
        if(image!=null && positionX > -MapCreator.SIZE_CHECK && positionX < GamePanel.WIDTH &&
                positionY > - MapCreator.SIZE_CHECK && positionY < GamePanel.WIDTH){
            canvas.drawBitmap(image, positionX, positionY, null);
        }
    }
}
