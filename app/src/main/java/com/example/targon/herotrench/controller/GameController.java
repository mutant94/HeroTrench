package com.example.targon.herotrench.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.targon.herotrench.R;
import com.example.targon.herotrench.gameobjects.impediments.Impediment;
import com.example.targon.herotrench.gameobjects.place.SoldierFactory;
import com.example.targon.herotrench.gameobjects.soldiers.Soldier;
import com.example.targon.herotrench.gameobjects.soldiers.french.FrenchSoldier;
import com.example.targon.herotrench.gameobjects.soldiers.french.Player;
import com.example.targon.herotrench.gameobjects.soldiers.german.GermanSoldier;
import com.example.targon.herotrench.gameobjects.trenchs.Trench;
import com.example.targon.herotrench.mapcreator.Level;
import com.example.targon.herotrench.surfaceview.GamePanel;
import com.example.targon.herotrench.viewobjects.GameButton;
import com.example.targon.herotrench.viewobjects.Pad;
import com.example.targon.herotrench.viewobjects.pads.MovePad;
import com.example.targon.herotrench.viewobjects.pads.ShootPad;

/**
 * Created by Targon on 17.09.2016.
 */
public abstract class GameController {
    //view
    protected Pad padMove, padShoot;
    protected GameButton upLeft, upRight;
    //objects
    protected Model model;

    public GameController(Level level, Context context) {
        model = new Model(new Player(GamePanel.WIDTH/2  - Soldier.SOLDIER_SIZE /2, GamePanel.HEIGHT/2 - Soldier.SOLDIER_SIZE /2 , Soldier.SOLDIER_SIZE, Soldier.SOLDIER_SIZE,
                level.getFrenchSoldierImage(), level.getFrenchSoldierWalkImages(), level.getGunImage()),
                level.getImpediments(), level.getGermanSoldiers(), level.getFrenchSoldiers(), level.getTrenches(), level.getSoldierFactories());
        padMove = new MovePad(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.padback), Pad.PAD_BOTTOM_SIZE, Pad.PAD_BOTTOM_SIZE, true),
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.padmove), Pad.PAD_SIZE, Pad.PAD_SIZE, true));
        padShoot = new ShootPad(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.padback), Pad.PAD_BOTTOM_SIZE, Pad.PAD_BOTTOM_SIZE, true),
                Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.padshoot), Pad.PAD_SIZE, Pad.PAD_SIZE, true));


    }

    public void update(){
        updatePad();
        updateObjects();
        if(model.getPlayer().canShoot() && padShoot.canShoot()){

        }
    }

    private void updatePad(){
        padMove.update();
        padShoot.update();
    }

    private void updateObjects(){
        int moveX = padMove.getMoveX(), moveY = padMove.getMoveY();
        for(Impediment impediment : model.getImpediments()){
            impediment.update(moveX, moveY);
        }
        for (Trench trench : model.getTrenches()){
            trench.update(moveX, moveY);
        }
        for (GermanSoldier germanSoldier : model.getGermanSoldiers()){
            germanSoldier.update(moveX, moveY);
        }
        for(FrenchSoldier frenchSoldier : model.getFrenchSoldiers()){
            frenchSoldier.update(moveX, moveY);
        }
        for(SoldierFactory soldierFabric : model.getSoldierFactories()){
            soldierFabric.update(moveX, moveY);
        }
        //player
        model.getPlayer().update(moveX, moveY);
        model.getPlayer().setAngle((float) padShoot.getAngle());
    }



    public void draw(Canvas canvas){
        for (Impediment impediment : model.getImpediments()){
            impediment.draw(canvas);
        }
        for (Trench trench : model.getTrenches()){
            trench.draw(canvas);
        }
        model.getPlayer().draw(canvas);
        //view object
        padMove.draw(canvas);
        padShoot.draw(canvas);
    }
    public void click(MotionEvent event){
        padMove.click(event);
        padShoot.click(event);
    }
}
