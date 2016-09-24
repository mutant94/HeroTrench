package com.example.targon.herotrench.surfaceview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by Targon on 15.09.2016.
 */
public class Background {
    private Paint paint;

    public Background(int color) {
        paint = new Paint();
        paint.setColor(color);
    }

    public void draw(Canvas canvas){
        canvas.drawRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, paint);
}
}
