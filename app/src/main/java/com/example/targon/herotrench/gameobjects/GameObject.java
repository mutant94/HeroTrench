package com.example.targon.herotrench.gameobjects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Targon on 13.09.2016.
 */
public abstract class GameObject {
    protected int positionX, positionY, sizeX, sizeY;
    protected Bitmap image;

    public GameObject(int positionX, int positionY, int sizeX, int sizeY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void update(int moveX, int moveY) {
        positionX -= moveX;
        positionY -= moveY;
    }

    public void draw(Canvas canvas) {

    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public Rect getRect(){
        return new Rect(this.positionX, this.positionY, this.positionX + this.sizeX, this.positionY + this.sizeY);
    }

    public Rect getNewRect(int newPositionX, int newPositionY){
        return new Rect(newPositionX, newPositionY, this.sizeX, this.sizeY);
    }

    public boolean collision(GameObject object) {
        return Rect.intersects(this.getRect(), object.getRect());
    }

    public boolean collision(Rect rect) {
        return Rect.intersects(this.getRect(), rect);
    }
}
