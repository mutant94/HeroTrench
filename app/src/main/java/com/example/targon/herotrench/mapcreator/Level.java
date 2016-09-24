package com.example.targon.herotrench.mapcreator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.targon.herotrench.R;
import com.example.targon.herotrench.gameobjects.impediments.Tree;
import com.example.targon.herotrench.gameobjects.place.SoldierFabric;
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
    protected List <Tree> trees;
    protected List <GermanSoldier> germanSoldiers;
    protected List <FrenchSoldier> frenchSoldiers;
    protected List <SoldierFabric> soldierFabrics;
    protected List <Trench> trenches;
    protected Bitmap frenchSoldierImage, germanSoldierImage, gunImage;
    protected Bitmap [] frenchSoldierWalkImages, germanSoldierWalkImages;
    protected Context context;

    public Level(Context context) {
        this.context = context;
        trees = new ArrayList<>();
        germanSoldiers = new ArrayList<>();
        frenchSoldiers = new ArrayList<>();
        soldierFabrics = new ArrayList<>();
        trenches = new ArrayList<>();
        createImages();
    }

    private void createImages(){
        Bitmap frenchImages = BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier);
        Bitmap germanImages = BitmapFactory.decodeResource(context.getResources(), R.drawable.soldier2);
        this.frenchSoldierImage = Bitmap.createBitmap(frenchImages, 0, 0, frenchImages.getWidth() / 3, frenchImages.getHeight());
        this.germanSoldierImage = Bitmap.createBitmap(germanImages, 0, 0, frenchImages.getWidth() / 3, frenchImages.getHeight());
        this.gunImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.gun);
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

    public List<Tree> getTrees() {
        return trees;
    }

    public Bitmap getFrenchSoldierImage() {
        return frenchSoldierImage;
    }

    public Bitmap getGermanSoldierImage() {
        return germanSoldierImage;
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
        for(Tree tree:trees){
            tree.update(changeX, changeY);
        }
        for(GermanSoldier germanSoldier : germanSoldiers){
            germanSoldier.update(changeX, changeY);
        }
        for (FrenchSoldier frenchSoldier : frenchSoldiers){
            frenchSoldier.update(changeX, changeY);
        }
        for (SoldierFabric soldierFabric : soldierFabrics ){
            soldierFabric.update(changeX, changeY);
        }
        for (Trench trench : trenches){
            trench.update(changeX, changeY);
        }
    }
}
