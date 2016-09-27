package com.example.targon.herotrench.gameobjects.soldiers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.example.targon.herotrench.gameobjects.GameObject;
import com.example.targon.herotrench.gameobjects.soldiers.armament.Gun;
import com.example.targon.herotrench.gameobjects.trenchs.Trench;
import com.example.targon.herotrench.viewobjects.Pad;

import java.util.List;

/**
 * Created by Targon on 13.09.2016.
 */
public abstract class Soldier extends GameObject{
    public final static int SPEED_LIMIT = 15, MAX_SPEED = (Pad.PAD_BOTTOM_SIZE /2) / SPEED_LIMIT, SOLDIER_SIZE = 34, FRENCH = 1, GERMAN = 2, NOT_IN_TRENCH = -1;
    protected int country, trenchId;
    protected Bitmap imageStay;
    protected Bitmap[] imagesWalk;
    protected boolean walk, inTrench, inFactory;
    protected Gun gun;
    protected float angle;

    public Soldier(int positionX, int positionY, int sizeX, int sizeY, Bitmap imageStay, Bitmap[] imagesWalk, Bitmap imageGun) {
        super(positionX, positionY, sizeX, sizeY);
        this.imageStay = imageStay;
        this.imagesWalk = imagesWalk;
        walk = false;
        inTrench = false;
        inFactory = false;
        gun = new Gun(imageGun);
        angle = 0;
    }

    @Override
    public void update(int moveX, int moveY) {
        super.update(moveX, moveY);
        gun.update(positionX, positionY, angle);
        this.image = imageStay;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Matrix matrix = new Matrix();
        matrix.postRotate(angle, SOLDIER_SIZE/2 , SOLDIER_SIZE /2);
        canvas.drawBitmap(Bitmap.createBitmap(image, 0, 0, SOLDIER_SIZE, SOLDIER_SIZE, matrix, true), positionX - getCorrectionInRotation(), positionY - getCorrectionInRotation(), new Paint());
        gun.draw(canvas);
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

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setInFactory(boolean inFactory) {
        this.inFactory = inFactory;
    }

    public boolean isInTrench() {
        return inTrench;
    }

    public void setInTrench(boolean inTrench) {
        this.inTrench = inTrench;
    }

    public boolean canShoot(){
        return gun.canShoot();
    }

    public void checkTrenches(List<Trench> trenches) {

    }
}
