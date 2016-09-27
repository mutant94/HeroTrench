package com.example.targon.herotrench.mapcreator.apocalypse;

import android.content.Context;

import com.example.targon.herotrench.mapcreator.Level;
import com.example.targon.herotrench.mapcreator.MapCreator;

import java.util.ArrayList;

/**
 * Created by Targon on 17.09.2016.
 */
public class LevelApocalypse extends Level{
    public LevelApocalypse(Context context) {
        super(context);
        //TODO
        type = -2;
        stateCount = 1;
        MapCreator mapCreator = new MapCreator(this.context);

        //impediments
        impediments = mapCreator.crateTreeList(0, 0, true, 50);
        //left
        for(int i=1; i<20; i++){
            impediments.addAll(mapCreator.crateTreeList(i, 0, true, 50));
        }
        //center
        for(int i=20; i<30; i++){
            impediments.addAll(mapCreator.crateTreeList(i, 41, true, 9));
        }
        //right
        for(int i=30; i<50; i++){
            impediments.addAll(mapCreator.crateTreeList(i, 0, true, 50));
        }
        //trench
        trenches = new ArrayList<>();
        trenches.add(mapCreator.createTrench(20, 39, 10, 0));

        startPositionX = 25;
        startPositionY = 39;
        changePosition();
    }
}
