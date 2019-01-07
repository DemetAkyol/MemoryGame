package com.example.user.hafizaoyunu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatDrawableManager;


public class Card extends AppCompatButton {

    boolean isOpen = false;
    int imageId;
    int backgroundImageId;
    int frontId = 0;
    Drawable back;
    Drawable front;
    boolean translatable=true;

    public Card(Context context, int butonId) {

        super(context);
        setId(butonId);
        backgroundImageId = R.drawable.back;
        if (butonId % 8 == 1) {
            frontId = R.drawable.p1;
        }
        if (butonId % 8 == 1) {
            frontId = R.drawable.p1;
        }
        if (butonId % 8 == 2) {
            frontId = R.drawable.p2;
        }
        if (butonId % 8 == 3) {
            frontId = R.drawable.p3;
        }
        if (butonId % 8 == 4) {
            frontId = R.drawable.p4;
        }
        if (butonId % 8 == 5) {
            frontId = R.drawable.p5;
        }
        if (butonId % 8 == 6) {
            frontId = R.drawable.p6;
        }
        if (butonId % 8 == 7) {
            frontId = R.drawable.p7;
        }
        if (butonId % 8 == 0) {
            frontId = R.drawable.p8;
        }
        back = AppCompatDrawableManager.get().getDrawable(context, backgroundImageId);
        front = AppCompatDrawableManager.get().getDrawable(context, frontId);
        setBackground(back);

    }

    public void turnButton(){
        if(translatable) {
            if (!isOpen) {
                setBackground(front);
                isOpen = true;
            } else {
                setBackground(back);
                isOpen = false;
            }
        }
    }
}