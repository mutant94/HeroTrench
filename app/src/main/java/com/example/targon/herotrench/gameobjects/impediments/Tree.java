package com.example.targon.herotrench.gameobjects.impediments;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.targon.herotrench.gameobjects.GameObject;
import com.example.targon.herotrench.mapcreator.MapCreator;
import com.example.targon.herotrench.surfaceview.GamePanel;

/**
 * Created by Targon on 13.09.2016.
 */
public class Tree extends Impediment{

    public Tree(int positionX, int positionY, int sizeX, int sizeY, Bitmap image) {
        super(positionX, positionY, sizeX, sizeY, image);
    }
}
