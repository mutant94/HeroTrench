package com.example.targon.herotrench.viewobjects.texts;

import com.example.targon.herotrench.viewobjects.GameText;

/**
 * Created by Targon on 27.09.2016.
 */

public class AmmoText extends GameText {
    public final static String RELOADING = "reloading", SLASH = "/", AMMO = "AMMO: ";
    public AmmoText(int positionX, int positionY, int textSize, String text, int color) {
        super(positionX, positionY, textSize, text, color);
    }

}
