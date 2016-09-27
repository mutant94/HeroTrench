package com.example.targon.herotrench.mapcreator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.targon.herotrench.R;
import com.example.targon.herotrench.gameobjects.impediments.Impediment;
import com.example.targon.herotrench.gameobjects.impediments.Tree;
import com.example.targon.herotrench.gameobjects.trenchs.Trench;
import com.example.targon.herotrench.gameobjects.trenchs.TrenchCheck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Targon on 13.09.2016.
 */
public class MapCreator {
    public static final int SIZE_CHECK = 50;
    Context context;
    Bitmap trenchImage, treeImage;
    public MapCreator(Context context) {
        this.context = context;
        this.trenchImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.trench), SIZE_CHECK, SIZE_CHECK, true);
        this.treeImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.tree), SIZE_CHECK, SIZE_CHECK, true);
    }

    //Tree
    public List<Impediment> crateTreeList(int startX, int startY, boolean vertical, int count) {
        if (vertical) {
            return createVerticalTreeList(startX, startY, count);
        } else {
            return createHorizontalTreeList(startX, startY, count);
        }
    }

    private List<Impediment> createVerticalTreeList(int startX, int startY, int count) {
        List<Impediment> trees = new ArrayList<>();
        Tree tree;
        for (int i = 0; i < count; i++) {
            tree = new Tree(startX * SIZE_CHECK, (startY + i) * SIZE_CHECK, SIZE_CHECK, SIZE_CHECK, treeImage);
            trees.add(tree);
        }
        return trees;
    }

    private List<Impediment> createHorizontalTreeList(int startX, int startY, int count) {
        List<Impediment> trees = new ArrayList<>();
        Tree tree;
        for (int i = 0; i < count; i++) {
            tree = new Tree((startX + i) * SIZE_CHECK, startY * SIZE_CHECK, SIZE_CHECK, SIZE_CHECK, treeImage);
            trees.add(tree);
        }
        return trees;
    }

    //Trench

    public Trench createTrench(int startX, int startY, int count, int id) {
        Trench trench = new Trench(id);
        TrenchCheck trenchCheck;
        for (int i = 0; i < count; i++) {
            trenchCheck = new TrenchCheck((startX + i) * SIZE_CHECK, startY * SIZE_CHECK, SIZE_CHECK, SIZE_CHECK, trenchImage);
            trench.addCheckTrench(trenchCheck);
        }
        return trench;
    }
}
