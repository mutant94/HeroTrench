package com.example.targon.herotrench.viewobjects.pads;

import android.graphics.Bitmap;

import com.example.targon.herotrench.viewobjects.Pad;

/**
 * Created by Targon on 13.09.2016.
 */
public class MovePad extends Pad {
    public MovePad(Bitmap backImage, Bitmap image) {
        super(backImage, image);
        positionBackX = Pad.PAD_LEFT_BOTTOM_POSITION_X;
        positionBackY = Pad.PAD_BOTTOM_POSITION_Y;
        positionX = Pad.PAD_LEFT_POSITION_X;
        positionY = Pad.PAD_POSITION_Y;
        setOtherPosition();
    }
}
