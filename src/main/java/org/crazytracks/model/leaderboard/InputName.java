package org.crazytracks.model.leaderboard;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Surfer;

import java.util.Timer;
import java.util.TimerTask;

public class InputName {
    private final Surfer surfer;
    private String inputText;
    private final int inputTextLimit;
    private boolean isInputInvalid;
    private final GUI gui;
    public InputName(Surfer surfer, GUI gui){
        this.surfer = surfer;
        this.inputText = "";
        this.inputTextLimit = 15;
        this.isInputInvalid = false;
        this.gui = gui;
    }

    public boolean isInputInvalid(){
        return this.isInputInvalid;
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

    public void sendInvalidInputWarning(){
        this.isInputInvalid = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isInputInvalid = false;
            }
        }, 2000);
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
