package com.example.targon.herotrench.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.targon.herotrench.controller.GameController;
import com.example.targon.herotrench.controller.levelcontrollers.apocalypse.ControllerApocalypse;
import com.example.targon.herotrench.controller.levelcontrollers.compaign.ControllerLevel;
import com.example.targon.herotrench.controller.levelcontrollers.custom.ControllerCustom;
import com.example.targon.herotrench.mapcreator.Level;
import com.example.targon.herotrench.mapcreator.apocalypse.LevelApocalypse;
import com.example.targon.herotrench.mapcreator.custom.LevelCustom;
import com.example.targon.herotrench.surfaceview.GamePanel;

/**
 * Created by Targon on 17.09.2016.
 */
public class GameActivity extends Activity {

    public final static int APOCALYPSE = -2, CUSTOM = -1, LVL_1 = 1;
    public final static String KEY_LVL = "LVL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int gameType = intent.getIntExtra(KEY_LVL, LVL_1);
        Level level;
        GameController gameController;
        switch (gameType){
            case APOCALYPSE:
                level = new LevelApocalypse(this);
                gameController = new ControllerApocalypse(level, this);
                break;
            case CUSTOM:
                level = new LevelCustom(this);
                gameController = new ControllerCustom(level, this);
                break;
            case LVL_1:
                //TODO
                level = new LevelCustom(this);
                gameController = new ControllerLevel(level, this);
                break;
            default:
                //TODO
                level = new LevelCustom(this);
                gameController = new ControllerLevel(level, this);
                break;
        }
        setContentView(new GamePanel(this, gameController));
        Log.e("TEST", "TEST=============");
    }
}
