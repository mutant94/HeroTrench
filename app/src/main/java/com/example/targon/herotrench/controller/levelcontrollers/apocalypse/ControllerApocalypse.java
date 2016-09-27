package com.example.targon.herotrench.controller.levelcontrollers.apocalypse;

import android.content.Context;

import com.example.targon.herotrench.controller.GameController;
import com.example.targon.herotrench.gameobjects.impediments.Tree;
import com.example.targon.herotrench.gameobjects.trenchs.Trench;
import com.example.targon.herotrench.mapcreator.Level;

/**
 * Created by Targon on 17.09.2016.
 */
public class ControllerApocalypse extends GameController {

    public ControllerApocalypse(Level level, Context context) {
        super(level, context);
    }

    @Override
    public void update() {
        super.update();
        for(Trench trench: trenches){
            //trench.update(1, 1);
        }
        for (Tree tree: impediments){
            //tree.update(1, 1);
        }
    }
}
