package com.example.targon.herotrench.mapcreator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.targon.herotrench.R;
import com.example.targon.herotrench.gameobjects.impediments.Impediment;
import com.example.targon.herotrench.gameobjects.impediments.Tree;
import com.example.targon.herotrench.gameobjects.place.SoldierFactory;
import com.example.targon.herotrench.gameobjects.soldiers.Soldier;
import com.example.targon.herotrench.gameobjects.soldiers.french.FrenchSoldier;
import com.example.targon.herotrench.gameobjects.soldiers.german.GermanSoldier;
import com.example.targon.herotrench.gameobjects.trenchs.Trench;
import com.example.targon.herotrench.surfaceview.GamePanel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Targon on 15.09.2016.
 */
public abstract class Level {
    public static final int COUNT_LVL = 2;
    protected int type, stateCount;
    protected int startPositionX, startPositionY;
    protected List <Impediment> impediments;
    protected List <GermanSoldier> germanSoldiers;
    protected List <FrenchSoldier> frenchSoldiers;
    protected List <SoldierFactory> soldierFactories;
    protected List <Trench> trenches;
    protected Bitmap frenchSoldierImage, germanSoldierImage, gunImage;
    protected Bitmap [] frenchSoldierWalkImages, germanSoldierWalkImages;
    protected Context context;

    public Level(Context context) {
        this.context = context;
        impediments = new ArrayList<>();
        germanSoldiers = new ArrayList<>();
        frenchSoldiers = new ArrayList<>();
        soldierFactories = new ArrayList<>();
        trenches = new ArrayList<>();
        createImages();
    }

    private void createImages(){
        Bitmap frenchImages = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier), Soldier.SOLDIER_SIZE * 3, Soldier.SOLDIER_SIZE, true);
        Bitmap germanImages = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier2), Soldier.SOLDIER_SIZE * 3, Soldier.SOLDIER_SIZE, true);
        this.frenchSoldierImage = Bitmap.createBitmap(frenchImages, 0, 0, frenchImages.getWidth() / 3, frenchImages.getHeight());
        this.germanSoldierImage = Bitmap.createBitmap(germanImages, 0, 0, frenchImages.getWidth() / 3, frenchImages.getHeight());
        this.gunImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.gun), Soldier.SOLDIER_SIZE, Soldier.SOLDIER_SIZE, true);
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setStateCount(int stateCount) {
        this.stateCount = stateCount;
    }

    public int getType() {
        return type;
    }

    public int getStateCount() {
        return stateCount;
    }

    public List<GermanSoldier> getGermanSoldiers() {
        return germanSoldiers;
    }

    public List<FrenchSoldier> getFrenchSoldiers() {
        return frenchSoldiers;
    }

    public List<Trench> getTrenches() {
        return trenches;
    }

    public List<Impediment> getImpediments() {
        return impediments;
    }

    public Bitmap getFrenchSoldierImage() {
        return frenchSoldierImage;
    }

    public Bitmap getGermanSoldierImage() {
        return germanSoldierImage;
    }

    public List<SoldierFactory> getSoldierFactories() {
        return soldierFactories;
    }

    public Bitmap getGunImage() {
        return gunImage;
    }

    public Bitmap[] getFrenchSoldierWalkImages() {
        return frenchSoldierWalkImages;
    }

    public Bitmap[] getGermanSoldierWalkImages() {
        return germanSoldierWalkImages;
    }

    public void changePosition(){
        int changeX = MapCreator.SIZE_CHECK/2 + startPositionX * MapCreator.SIZE_CHECK - GamePanel.WIDTH/2;
        int changeY = MapCreator.SIZE_CHECK/2 + startPositionY * MapCreator.SIZE_CHECK - GamePanel.HEIGHT/2;
        for(Impediment impediment: impediments){
            impediment.update(changeX, changeY);
        }
        for(GermanSoldier germanSoldier : germanSoldiers){
            germanSoldier.update(changeX, changeY);
        }
        for (FrenchSoldier frenchSoldier : frenchSoldiers){
            frenchSoldier.update(changeX, changeY);
        }
        for (SoldierFactory soldierFactory : soldierFactories){
            soldierFactory.update(changeX, changeY);
        }
        for (Trench trench : trenches){
            trench.update(changeX, changeY);
        }
    }


}
