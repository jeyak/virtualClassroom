package com.esgi.virtualclassroom.drawUtils;

import java.util.ArrayList;

/**
 * Created by apple on 15/07/2018.
 */

public class PathCommandManager {
    private ArrayList<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public Memento getMemento(int indice) {
        return mementos.get(indice);
    }

    public ArrayList<Memento> getDrawMementos() {
        ArrayList<Memento> tmp = new ArrayList<>();
        for (Memento memento : mementos) {
            if(memento.getState().equals("draw"))
                tmp.add(memento);
        }
        return tmp;
    }

    public Memento getLastDrawMemento() {
        Memento tmp = null;
        for (Memento memento : mementos) {
            if(memento.getState().equals("draw"))
                tmp = memento;
        }
        return tmp;
    }

    public Memento getLastUnDrawMemento() {
        Memento tmp = null;
        for (Memento memento : mementos) {
            if(memento.getState().equals("undraw"))
                tmp = memento;
        }
        return tmp;
    }


    public void removeAllUndrawMemento() {
       for(int i = 0; i < mementos.size(); i++) {
           Memento memento;
           memento = mementos.get(i);
           if(memento.getState().equals("undraw")) {
               mementos.remove(memento);
              i--;
           }
       }
    }

    public Memento getFirstUnDrawMemento() {
        Memento tmp = null;
        for (Memento memento : mementos) {
            if(memento.getState().equals("undraw"))
                return tmp;
        }
        return tmp;
    }
}
