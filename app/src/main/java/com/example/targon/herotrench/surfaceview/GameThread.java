package com.example.targon.herotrench.surfaceview;

import android.graphics.Canvas;
import android.provider.Settings;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by Targon on 13.09.2016.
 */
public class GameThread extends Thread{
    public final static int FPS = 30;
    public boolean running = true;
    GamePanel gamePanel;
    SurfaceHolder surfaceHolder;
    public Canvas canvas;
    public final String TAG = "GameThread", ERROR1 = "UPDATE OR DRAW",ERROR2 = "SLEEP";

    public GameThread(GamePanel gamePanel, SurfaceHolder surfaceHolder) {
        this.gamePanel = gamePanel;
        this.surfaceHolder = surfaceHolder;
        running = true;
    }

    @Override
    public void run() {
        long targetTime = 1000 / FPS, startTime, waitTime, timeMillis;
        while (running){
            startTime = System.nanoTime();
            canvas = null;
            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (this.surfaceHolder){
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            }catch (Exception ex){
                Log.e(TAG, ERROR1, ex);
            }finally {
                if(canvas != null){
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            timeMillis=(System.nanoTime()-startTime)/1000000;
            waitTime=targetTime-timeMillis;
            if(waitTime>0) {
                try {
                    this.sleep(waitTime);
                } catch (Exception ex) {
                    Log.e(TAG, ERROR2, ex);
                }
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
