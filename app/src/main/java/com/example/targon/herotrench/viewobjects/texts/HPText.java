package com.example.targon.herotrench.viewobjects.texts;

import com.example.targon.herotrench.viewobjects.GameText;

/**
 * Created by Targon on 27.09.2016.
 */

public class HPText extends GameText {
    public final static String HP = "HP: ";
    public HPText(int positionX, int positionY, int textSize, String text, int color) {
        super(positionX, positionY, textSize, text, color);
    }
}
