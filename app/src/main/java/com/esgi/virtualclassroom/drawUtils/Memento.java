package com.esgi.virtualclassroom.drawUtils;

import android.graphics.Path;

/**
 * Created by apple on 15/07/2018.
 */

public class Memento {
    private String state;
    private Path path;

    public Memento(String state,Path path) {
        this.state = state;
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
