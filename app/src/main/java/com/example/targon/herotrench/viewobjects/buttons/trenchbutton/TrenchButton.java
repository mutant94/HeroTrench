package com.example.targon.herotrench.viewobjects.buttons.trenchbutton;

import android.graphics.Bitmap;

import com.example.targon.herotrench.viewobjects.GameButton;

/**
 * Created by Targon on 27.09.2016.
 */

public abstract class TrenchButton extends GameButton{
    public TrenchButton(int positionX, int positionY, int sizeX, int sizeY, Bitmap image) {
        super(positionX, positionY, sizeX, sizeY, image);
    }
}
