package com.example.targon.herotrench.gameobjects.place;

import android.graphics.Bitmap;

import com.example.targon.herotrench.gameobjects.GameObject;
import com.example.targon.herotrench.gameobjects.soldiers.Soldier;
import com.example.targon.herotrench.gameobjects.soldiers.french.FrenchSoldier;
import com.example.targon.herotrench.gameobjects.soldiers.german.GermanSoldier;
import com.example.targon.herotrench.mapcreator.MapCreator;

/**
 * Created by Targon on 20.09.2016.
 */

public class SoldierFabric extends GameObject{
    public final static int DELAY_STANDARD = 10;
    private int state, delay, country;

    public SoldierFabric(int positionX, int positionY, int sizeX, int sizeY, int startDelay, int delay, int country) {
        super(positionX, positionY, sizeX, sizeY);
        state = delay - startDelay;
        this.delay = delay;
        this.country = country;
    }

    public void update(){
        state ++;
    }

    public boolean canCreateSoldier(){
        if(state >= delay){
            state = 0;
            return true;
        }
        return false;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public Soldier getSoldier(Bitmap image, Bitmap[] walkImage, Bitmap gunImage){
        Soldier soldier;
        if(country == Soldier.GERMAN){
            soldier = new GermanSoldier(positionX - (MapCreator.SIZE_CHECK - Soldier.SOLDIER_SIZE)/2, positionY - (MapCreator.SIZE_CHECK - Soldier.SOLDIER_SIZE)/2, Soldier.SOLDIER_SIZE, Soldier.SOLDIER_SIZE, image, walkImage, gunImage);
            soldier.setInFabric(true);
            return soldier;

        }
        soldier = new FrenchSoldier(positionX - (MapCreator.SIZE_CHECK - Soldier.SOLDIER_SIZE)/2, positionY - (MapCreator.SIZE_CHECK - Soldier.SOLDIER_SIZE)/2, Soldier.SOLDIER_SIZE, Soldier.SOLDIER_SIZE, image, walkImage, gunImage);
        soldier.setInFabric(true);
        return soldier;
    }
}
