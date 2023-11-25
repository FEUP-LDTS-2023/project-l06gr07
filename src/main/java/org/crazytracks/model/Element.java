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

<<<<<<< HEAD
    public void setPosition(Position position) {
        this.position = position;
=======
    public Object getView() {
        return new SurferDrawer();
>>>>>>> 78de752c07b17b11af25b1665e8d878d4750eab4
    }
}
