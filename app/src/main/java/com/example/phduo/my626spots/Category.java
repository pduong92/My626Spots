package com.example.phduo.my626spots;

import android.app.Activity;
import android.content.res.Resources;

/**
 * Created by phduo on 3/11/2017.
 */

public class Category {

    private int iconID;
    private String title;
    private int colorID;
    private Class activity;

    private final int NOICON = 0;

    public Category(Class c, int iconID, int stringID, int colorID, Resources res) {
        this.activity = c;
        this.iconID = iconID;
        this.title = res.getString(stringID);
        this.colorID = colorID;
    }

    public Category(Class c, int iconID, String title, int colorID) {
        this.activity = c;
        this.iconID = iconID;
        this.title = title;
        this.colorID = colorID;
    }

    public Category(Class c, String title, int colorID) {
        this.activity = c;
        this.iconID = NOICON;
        this.title = title;
        this.colorID = colorID;
    }

    public int getIconID() { return iconID; }

    public String getTitle() { return title; }

    public int getColorID() { return colorID; }

    public Class obtainClass() { return activity; }

    public boolean hasIconID() { return (iconID == NOICON) ? false:true; }
}
