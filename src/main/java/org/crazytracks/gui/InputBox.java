package org.crazytracks.gui;

public class InputBox {
    private String inputText;
    private final int numChars;
    public InputBox(int numChars){
        this.numChars = numChars;
    }

    public void putChar(char c){
        this.inputText = this.inputText + c;
    }

    public int getNumChars() {
        return numChars;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}
