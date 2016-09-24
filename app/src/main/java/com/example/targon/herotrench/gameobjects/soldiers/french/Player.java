package com.example.targon.herotrench.gameobjects.soldiers.french;

import android.graphics.Bitmap;

import com.example.targon.herotrench.gameobjects.soldiers.Soldier;

/**
 * Created by Targon on 19.09.2016.
 */
public class Player extends Soldier {

    public Player(int positionX, int positionY, int sizeX, int sizeY, Bitmap imageStay, Bitmap[] imagesWalk, Bitmap imageGun) {
        super(positionX, positionY, sizeX, sizeY, imageStay, imagesWalk, imageGun);
        this.country = FRENCH;
    }

    @Override
    public void update(int moveX, int moveY) {
        gun.update(positionX, positionY, angle);
        this.image = imageStay;
    }


}
