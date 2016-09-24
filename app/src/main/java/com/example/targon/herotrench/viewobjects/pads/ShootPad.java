package com.example.targon.herotrench.viewobjects.pads;

import android.graphics.Bitmap;

import com.example.targon.herotrench.viewobjects.Pad;

/**
 * Created by Targon on 13.09.2016.
 */
public class ShootPad extends Pad {
    public ShootPad(Bitmap backImage, Bitmap image) {
        super(backImage, image);
        positionBackX = Pad.PAD_RIGHT_BOTTOM_POSITION_X;
        positionBackY = Pad.PAD_BOTTOM_POSITION_Y;
        positionX = Pad.PAD_RIGHT_POSITION_X;
        positionY = Pad.PAD_POSITION_Y;
        setOtherPosition();
    }
}
