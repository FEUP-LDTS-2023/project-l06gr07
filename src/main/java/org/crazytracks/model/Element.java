package org.crazytracks.model;

import org.crazytracks.viewer.SurferDrawer;

public class Element{
    Position position;
    public Element(Position position){
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Object getView() {
        return new SurferDrawer();
    }
}
