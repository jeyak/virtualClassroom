package com.esgi.virtualclassroom.drawUtils;

import android.graphics.Path;

/**
 * Created by apple on 15/07/2018.
 */

public class MementoContainer {
    private String state;
    private Path path;

    public void setState(String state,Path path) {
        System.out.println("etat =  " + state);
        this.state = state;
        this.path = path;
    }

    public Memento save() {
        System.out.println("save");
        return new Memento(state,path);
    }

    public void restore(Memento m) {
        if (m != null) {
            m.setState("undraw");
            System.out.println("etat = " + m.getState());
        }
    }

    public void cancelRestore(Memento m) {
        if (m != null) {
            m.setState("draw");
            System.out.println("etat = " + m.getState());
        }
    }
}

