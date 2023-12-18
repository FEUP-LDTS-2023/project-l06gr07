package org.crazytracks.leaderboard;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Surfer;

public class InputName {
    private Surfer surfer;
    private String inputText;
    private final GUI gui;
    public InputName(Surfer surfer, GUI gui){
        this.surfer = surfer;
        this.inputText = "";
        this.gui = gui;
    }

    public GUI getGUI(){
        return this.gui;
    }

    public Surfer getSurfer() {
        return surfer;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getInputText(){
        return inputText;
    }
}
