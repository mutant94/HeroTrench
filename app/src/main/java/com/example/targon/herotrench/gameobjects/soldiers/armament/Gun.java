package com.example.targon.herotrench.gameobjects.soldiers.armament;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import static com.example.targon.herotrench.gameobjects.soldiers.Soldier.SOLDIER_SIZE;

/**
 * Created by Targon on 13.09.2016.
 */
public class Gun {
    public final static int GUN_ROTATION_SIZE = 15;
    private int countBullet, stateReloading, stateShoot, soldierPositionX, soldierPositionY, positionX, positionY;
    private boolean reloaded, wasShoot;
    public final static int MAX_MAGAZINE = 5, RELOADING_DELAY = 30, SHOOT_DELAY = 10;
    private Bitmap image;
    private float angle;

    public Gun(Bitmap image) {
        this.countBullet = MAX_MAGAZINE;
        reloaded = false;
        this.image = image;
        stateShoot = SHOOT_DELAY;
        stateReloading = 0;
        wasShoot = false;
    }

    public void update(int soldierPositionX, int soldierPositionY, float angle){
        this.soldierPositionX = soldierPositionX;
        this.soldierPositionY = soldierPositionY;
        this.angle = angle;
        checkState();
        if(reloaded){
            stateReloading++;
        }else if(wasShoot){
            stateShoot++;
        }
    }

    public void draw(Canvas canvas){
        positionY = (int) (soldierPositionY - Math.cos(Math.toRadians(angle)) * GUN_ROTATION_SIZE);
        positionX = (int) (soldierPositionX + Math.sin(Math.toRadians(angle)) * GUN_ROTATION_SIZE);
        Matrix matrix = new Matrix();
        matrix.setRotate(angle, image.getWidth(), image.getHeight());
        canvas.drawBitmap(Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true), positionX - getCorrectionInRotation(), positionY - getCorrectionInRotation(), new Paint(Paint.DITHER_FLAG));
    }
    private int getCorrectionInRotation(){
        return (int) (((SOLDIER_SIZE * Math.sqrt(2) - SOLDIER_SIZE)/2) * getPercentCorrectRotation());
    }

    private float getPercentCorrectRotation(){
        if(angle%90<=45){
            return (angle%90) / 45;
        }
        return (90 - (angle%90)) / 45;
    }

    private void checkState(){
        if(reloaded){
            checkReloading();
        }else if (wasShoot){
            checkShoot();
        }
    }

    private void checkReloading(){
        if(stateReloading>=RELOADING_DELAY){
            reloaded = false;
        }
    }

    private void checkShoot(){
        if(stateShoot>=SHOOT_DELAY){
            wasShoot = false;
        }
    }

    public Bullet shoot(int nationality){
        Bullet bullet = new Bullet(0, 0, angle, nationality);
        shoot();
        return bullet;
    }

    public void shoot(){
        countBullet--;
        wasShoot = true;
        stateShoot = 0;
        if(countBullet<=0){
            reloading();
        }
    }

    public void reloading(){
        if(countBullet < MAX_MAGAZINE){
            wasShoot = false;
            reloaded = true;
            stateReloading = 0;
        }
    }

    public boolean canShoot(){
        return !reloaded && !wasShoot && countBullet>0;
    }


}
