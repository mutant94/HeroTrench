package com.example.targon.herotrench.gameobjects.soldiers.german;

import android.graphics.Bitmap;

import com.example.targon.herotrench.gameobjects.soldiers.Soldier;

/**
 * Created by Targon on 19.09.2016.
 */
public class GermanSoldier extends Soldier {

    public GermanSoldier(int positionX, int positionY, int sizeX, int sizeY, Bitmap imageStay, Bitmap[] imagesWalk, Bitmap imageGun) {
        super(positionX, positionY, sizeX, sizeY, imageStay, imagesWalk, imageGun);
        this.country = GERMAN;
    }
}
