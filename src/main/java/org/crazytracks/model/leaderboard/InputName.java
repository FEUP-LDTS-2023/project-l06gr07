package org.crazytracks.model.leaderboard;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Surfer;

public class InputName {
    private Surfer surfer;
    private String inputText;
    private final int inputTextLimit;
    private final GUI gui;
    public InputName(Surfer surfer, GUI gui){
        this.surfer = surfer;
        this.inputText = "";
        this.inputTextLimit = 15;
        this.gui = gui;
    }

    public GUI getGUI(){
        return this.gui;
    }

    public Surfer getSurfer() {
        return surfer;
    }

    public void setInputText(String inputText) {
        if (this.inputText.length() < inputTextLimit){
            this.inputText = inputText;
        }
    }

    public void eraseLastChar(){
        if (!inputText.isEmpty()){
            inputText = inputText.substring(0, inputText.length()-1);
        }
    }

    public String getInputText(){
        return inputText;
    }
}
