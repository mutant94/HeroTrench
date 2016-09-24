package com.example.targon.herotrench.controller;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.targon.herotrench.R;
import com.example.targon.herotrench.gameobjects.GameObject;
import com.example.targon.herotrench.gameobjects.impediments.Tree;
import com.example.targon.herotrench.gameobjects.place.SoldierFabric;
import com.example.targon.herotrench.gameobjects.soldiers.Soldier;
import com.example.targon.herotrench.gameobjects.soldiers.armament.Bullet;
import com.example.targon.herotrench.gameobjects.soldiers.french.FrenchSoldier;
import com.example.targon.herotrench.gameobjects.soldiers.french.Player;
import com.example.targon.herotrench.gameobjects.soldiers.german.GermanSoldier;
import com.example.targon.herotrench.gameobjects.trenchs.Trench;
import com.example.targon.herotrench.gameobjects.trenchs.TrenchCheck;
import com.example.targon.herotrench.mapcreator.Level;
import com.example.targon.herotrench.surfaceview.GamePanel;
import com.example.targon.herotrench.viewobjects.MainButton;
import com.example.targon.herotrench.viewobjects.Pad;
import com.example.targon.herotrench.viewobjects.pads.MovePad;
import com.example.targon.herotrench.viewobjects.pads.ShootPad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Targon on 17.09.2016.
 */
public abstract class GameController {
    //view
    protected Pad padMove, padShoot;
    protected MainButton upLeft, upRight;
    //objects
    protected List<Tree> trees;
    protected List<Trench> trenches;
    protected List<GermanSoldier> germanSoldiers;
    protected List<FrenchSoldier> frenchSoldiers;
    protected List<SoldierFabric> soldierFabrics;
    protected List<Bullet> bullets;
    protected Player player;

    public GameController(Level level, Context context) {
        trees = level.getTrees();
        trenches = level.getTrenches();
        germanSoldiers = level.getGermanSoldiers();
        frenchSoldiers = level.getFrenchSoldiers();

        bullets = new ArrayList<>();
        padMove = new MovePad(BitmapFactory.decodeResource(context.getResources(), R.drawable.padback), BitmapFactory.decodeResource(context.getResources(), R.drawable.padmove));
        padShoot = new ShootPad(BitmapFactory.decodeResource(context.getResources(), R.drawable.padback), BitmapFactory.decodeResource(context.getResources(), R.drawable.padshoot));
        player = new Player(GamePanel.WIDTH/2  - Soldier.SOLDIER_SIZE /2, GamePanel.HEIGHT/2 - Soldier.SOLDIER_SIZE /2 , Soldier.SOLDIER_SIZE, Soldier.SOLDIER_SIZE,
                level.getFrenchSoldierImage(), level.getFrenchSoldierWalkImages(), level.getGunImage());

    }

    public void update(){
        updatePad();
        updateObjects();
        if(player.canShoot() && padShoot.canShoot()){

        }
    }

    private void updatePad(){
        padMove.update();
        padShoot.update();
    }

    private void updateObjects(){
        int moveX = padMove.getMoveX(), moveY = padMove.getMoveY();
        for(Tree tree : trees){
            tree.update(moveX, moveY);
        }
        for (Trench trench : trenches){
            trench.update(moveX, moveY);
        }
        for (GermanSoldier germanSoldier : germanSoldiers){
            germanSoldier.update(moveX, moveY);
        }
        for(FrenchSoldier frenchSoldier : frenchSoldiers){
            frenchSoldier.update(moveX, moveY);
        }
        for(SoldierFabric soldierFabric : soldierFabrics){
            soldierFabric.update(moveX, moveY);
        }
        //player
        player.update(moveX, moveY);
        player.setAngle((float) padShoot.getAngle());
    }



    public void draw(Canvas canvas){

        for (Tree tree : trees){
            tree.draw(canvas);
        }
        for (Trench trench : trenches){
            trench.draw(canvas);
        }
        player.draw(canvas);



        padMove.draw(canvas);
        padShoot.draw(canvas);
    }
    public void click(MotionEvent event){
        padMove.click(event);
        padShoot.click(event);
    }
}
