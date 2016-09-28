package com.example.targon.herotrench.gameobjects.soldiers.armament;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.targon.herotrench.gameobjects.GameObject;
import com.example.targon.herotrench.gameobjects.soldiers.Soldier;
import com.example.targon.herotrench.mapcreator.MapCreator;

import java.util.List;

/**
 * Created by Targon on 13.09.2016.
 */
public class Bullet extends GameObject {
    public final static int MAX_STATE = 5, MAX_LENGTH = 8 * MapCreator.SIZE_CHECK;
    private int state;
    private float angle;
    private int country;
    private Paint paint;

    public Bullet(int positionX, int positionY, float angle, int country) {
        super(positionX, positionY, 1, 1);
        this.angle = angle;
        this.country = country;
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }

    @Override
    public void update(int moveX, int moveY) {
        super.update(moveX, moveY);
        state++;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(positionX, positionY, positionX + sizeX, positionY + sizeY, paint);
    }

    public boolean canDelete() {
        return state >= MAX_STATE;
    }


}
