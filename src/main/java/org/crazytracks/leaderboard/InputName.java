package org.crazytracks.leaderboard;

import org.crazytracks.model.Surfer;

public class InputName {
    private Surfer surfer;
    private String inputText;
    public InputName(Surfer surfer){
        this.surfer = surfer;
        this.inputText = "";
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
