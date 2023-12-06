package org.crazytracks.model;

import org.crazytracks.viewer.SurferViewer;

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

    public Position getLeftPosition(){
        return new Position(position.getX()-1, position.getY());
    }

    public Position getRightPosition(){
        return new Position(position.getX()+1, position.getY());
    }

    public Position getUpPosition(){
        return new Position(position.getX(), position.getY()-1);
    }

    public Position getDownPosition(){
        return new Position(position.getX(), position.getY()+1);
    }

    public Object getView() {
        return new SurferViewer();
    }
}
