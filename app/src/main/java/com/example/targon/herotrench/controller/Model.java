package com.example.targon.herotrench.controller;

import android.graphics.Canvas;

import com.example.targon.herotrench.gameobjects.impediments.Impediment;
import com.example.targon.herotrench.gameobjects.place.SoldierFactory;
import com.example.targon.herotrench.gameobjects.soldiers.armament.Bullet;
import com.example.targon.herotrench.gameobjects.soldiers.french.FrenchSoldier;
import com.example.targon.herotrench.gameobjects.soldiers.french.Player;
import com.example.targon.herotrench.gameobjects.soldiers.german.GermanSoldier;
import com.example.targon.herotrench.gameobjects.trenchs.Trench;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Targon on 26.09.2016.
 */

public class Model {
    private Player player;
    private List<Impediment> impediments;
    private List<GermanSoldier> germanSoldiers;
    private List<FrenchSoldier> frenchSoldiers;
    private List<Trench> trenches;
    private List<SoldierFactory> soldierFactories;
    private List<Bullet> bullets;

    public Model(Player player, List<Impediment> impediments, List<GermanSoldier> germanSoldiers, List<FrenchSoldier> frenchSoldiers, List<Trench> trenches, List<SoldierFactory> soldierFactories) {
        this.player = player;
        this.impediments = impediments;
        this.germanSoldiers = germanSoldiers;
        this.frenchSoldiers = frenchSoldiers;
        this.trenches = trenches;
        this.soldierFactories = soldierFactories;
        this.bullets = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public List<Impediment> getImpediments() {
        return impediments;
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

    public List<SoldierFactory> getSoldierFactories() {
        return soldierFactories;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void update(){

    }

    public void draw(Canvas canvas){

    }
}
