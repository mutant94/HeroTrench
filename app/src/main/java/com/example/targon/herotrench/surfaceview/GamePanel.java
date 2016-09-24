package com.example.targon.herotrench.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.targon.herotrench.R;
import com.example.targon.herotrench.controller.GameController;
import com.example.targon.herotrench.mapcreator.Level;

/**
 * Created by Targon on 13.09.2016.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    public final static int HEIGHT = 650, WIDTH = 1000;
    public static float scaleX, scaleY;
    private GameThread thread;
    private GameController gameController;
    private Background background;

    public GamePanel(Context context, GameController gameController) {
        super(context);
        getHolder().addCallback(this);
        this.gameController = gameController;
        this.background = new Background(ContextCompat.getColor(context, R.color.background));
        setFocusable(true);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new GameThread(this, getHolder());
        thread = new GameThread(this, holder);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        scaleX = WIDTH  / (getWidth() * 1.f);
        scaleY = HEIGHT / (getHeight() * 1.f);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
                retry = false;
                thread = null;
            } catch (InterruptedException ex) {
                Log.e("GamePanel", "JOIN", ex);
            }

        }
    }

    public void update() {
        gameController.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        final float scaleFactoryX = getWidth() / (WIDTH * 1.f);
        final float scaleFactoryY = getHeight() / (HEIGHT * 1.f);
        if (canvas != null) {
            int savedState=canvas.save();
            canvas.scale(scaleFactoryX, scaleFactoryY);
            background.draw(canvas);
            gameController.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gameController.click(event);
        return true;
    }


}
