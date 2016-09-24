package com.example.targon.herotrench.viewobjects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;

import com.example.targon.herotrench.surfaceview.GamePanel;

/**
 * Created by Targon on 13.09.2016.
 */
public abstract class Pad {
    public final static int PAD_PADDING = 50, PAD_BOTTOM_SIZE = 200, PAD_SIZE = 100, PAD_CORNER = PAD_BOTTOM_SIZE / 2 - PAD_SIZE / 2;
    public final static int PAD_LEFT_BOTTOM_POSITION_X = PAD_PADDING, PAD_BOTTOM_POSITION_Y = GamePanel.HEIGHT - PAD_PADDING - PAD_BOTTOM_SIZE,
            PAD_RIGHT_BOTTOM_POSITION_X = GamePanel.WIDTH - PAD_BOTTOM_SIZE - PAD_PADDING;
    public final static int PAD_LEFT_POSITION_X = PAD_LEFT_BOTTOM_POSITION_X + PAD_CORNER, PAD_POSITION_Y = PAD_BOTTOM_POSITION_Y + PAD_CORNER,
            PAD_RIGHT_POSITION_X = PAD_RIGHT_BOTTOM_POSITION_X + PAD_CORNER;
    protected Bitmap backImage, image;
    protected int positionBackX, positionBackY;
    protected int positionX, positionY, defaultX, defaultY, centerX, centerY;
    protected float clickX, clickY, length;
    private Paint paint;
    protected boolean clicked, show;
    protected double angle;

    public Pad(Bitmap backImage, Bitmap image) {
        this.backImage = backImage;
        this.image = image;
        paint = new Paint();
        paint.setAntiAlias(true);
        show = true;
        clicked = false;
        length = 0;
        angle = 0;
    }

    protected void setOtherPosition() {
        defaultY = positionY;
        defaultX = positionX;
        centerX = positionX + PAD_SIZE / 2;
        centerY = positionY + PAD_SIZE / 2;
    }

    public void click(MotionEvent event) {
        //TODO delete log
        if (isClicked(event)) {
            angle = angleBetween2Lines();
            Log.e("ANGLE", "" + angle);
        } else {
            Log.e("ANGLE", "NOTHING");
        }
    }

    private boolean isClicked(MotionEvent event) {
        for (int i = 0; i < event.getPointerCount(); i++) {
            float x = event.getX(i) * GamePanel.scaleX, y = event.getY(i) * GamePanel.scaleY;
            if (y > positionBackY - PAD_PADDING && x > positionBackX - PAD_PADDING && x < positionBackX + PAD_BOTTOM_SIZE + PAD_PADDING) {
                clickX = x;
                clickY = y;
                clicked = true;
                return true;
            }
        }
        clicked = false;
        return false;
    }

    public void update() {
        if (clicked) {
            changePadPosition();
        } else {
            positionX = defaultX;
            positionY = defaultY;
        }
        clicked = false;
    }

    private void changePadPosition() {
        if (countLength(centerX, clickX, centerY, clickY) > PAD_BOTTOM_SIZE / 2) {
            length = PAD_BOTTOM_SIZE / 2;
            float clickLength = countLength(centerX, clickX, centerY, clickY);
            positionX = (int) ((this.clickX - this.centerX) * (length / clickLength) + this.centerX - PAD_SIZE / 2);
            positionY = (int) ((this.clickY - this.centerY) * (length / clickLength) + this.centerY - PAD_SIZE / 2);
        } else {
            this.positionX = (int) (this.clickX - PAD_SIZE / 2);
            this.positionY = (int) (this.clickY - PAD_SIZE / 2);
            length = countLength(centerX, clickX, centerY, clickY);
        }
    }

    public void draw(Canvas canvas) {
        if (show) {
            canvas.drawBitmap(backImage, positionBackX, positionBackY, paint);
            canvas.drawBitmap(image, positionX, positionY, paint);
        }
    }

    public float countLength(float x1, float x2, float y1, float y2) {
        return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private double angleBetween2Lines() {
        double angle = Math.toDegrees(Math.atan2(clickY - centerY, clickX - centerX));
        angle += 90;
        while (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    public boolean canShoot() {
        return length > 0.8 * PAD_BOTTOM_SIZE / 2;
    }

    public int getMoveX() {
        return (positionX - centerX + PAD_SIZE / 2) / 12;
    }

    public int getMoveY() {
        return (positionY - centerY + PAD_SIZE / 2) / 12;
    }

    public double getAngle() {
        return angle;
    }
}
