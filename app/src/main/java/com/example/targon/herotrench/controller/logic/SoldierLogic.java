package com.example.targon.herotrench.controller.logic;

import com.example.targon.herotrench.controller.Model;
import com.example.targon.herotrench.gameobjects.impediments.Impediment;
import com.example.targon.herotrench.gameobjects.soldiers.Soldier;

/**
 * Created by Targon on 27.09.2016.
 */

public class SoldierLogic {
    Model model;

    public SoldierLogic(Model model) {
        this.model = model;
    }

    public boolean canChangePosition(Soldier soldier, int newPositionX, int newPositionY){
        return checkCollisionWithSoldiers(soldier, newPositionX, newPositionY);
    }

    private boolean checkCollisionWithSoldiers(Soldier soldier, int newPositionX, int newPositionY){
        for(Soldier testSoldier : model.getFrenchSoldiers()){
            if(soldier != testSoldier && testSoldier.collision(soldier.getNewRect(newPositionX, newPositionY))){
                return false;
            }
        }
        for(Soldier testSoldier : model.getGermanSoldiers()){
            if(soldier != testSoldier && testSoldier.collision(soldier.getNewRect(newPositionX, newPositionY))){
                return false;
            }
        }
        return checkCollisionWithImpediments(soldier, newPositionX, newPositionY);
    }

    private boolean checkCollisionWithImpediments(Soldier soldier, int newPositionX, int newPositionY){
        for(Impediment impediment : model.getImpediments()){
            if(impediment.collision(soldier.getNewRect(newPositionX, newPositionY))){
                return false;
            }
        }
        return true;
    }



}
