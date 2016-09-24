package com.example.targon.herotrench.gameobjects.trenchs;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.targon.herotrench.gameobjects.soldiers.Soldier;
import com.example.targon.herotrench.mapcreator.MapCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Targon on 18.09.2016.
 */
public class Trench {
    public final static int TRENCH_NOTHING = 0, TRENCH_FRENCH = 1, TRENCH_GERMANY = 2, TRENCH_FIGHT = 3;
    private List<TrenchCheck> trenchCheckList;
    private int control;
    private int id;


    public Trench(int id) {
        this.trenchCheckList = new ArrayList<>();
        control = TRENCH_NOTHING;
        this.id = id;
    }

    public List<TrenchCheck> getTrenchCheckList() {
        return trenchCheckList;
    }

    public void addCheckTrench(TrenchCheck trenchCheck){
        this.trenchCheckList.add(trenchCheck);
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public void update(int moveX, int moveY) {
        for(TrenchCheck trenchCheck : trenchCheckList){
            trenchCheck.update(moveX, moveY);
        }
    }

    public void draw(Canvas canvas){
        for(TrenchCheck trenchCheck : trenchCheckList){
            trenchCheck.draw(canvas);
        }
    }

    public Rect getRect(){
        return new Rect(trenchCheckList.get(0).getPositionX(), trenchCheckList.get(0).getPositionY(),
                (trenchCheckList.get(trenchCheckList.size() - 1).getPositionX() + MapCreator.SIZE_CHECK),
                (trenchCheckList.get(trenchCheckList.size() - 1).getPositionY() + MapCreator.SIZE_CHECK));
    }

    public void setToTrench(Soldier soldier){
        if(soldier.getPositionY() > trenchCheckList.get(0).getPositionY()){
            soldier.setPositionY(trenchCheckList.get(0).getPositionY());
        }else {
            soldier.setPositionY(trenchCheckList.get(0).getPositionY() + MapCreator.SIZE_CHECK - Soldier.SOLDIER_SIZE);
        }
    }

    public boolean isInTrench(Soldier soldier){
        //TODO
        return false;
    }
}
