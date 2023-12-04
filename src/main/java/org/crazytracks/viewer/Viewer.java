package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;

<<<<<<< HEAD
import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clearScreen();
        drawElements(gui);
        gui.refreshScreen();
    }

    protected abstract void drawElements(GUI gui) throws IOException;
=======
public interface Viewer {
    public void draw(GUI gui);
>>>>>>> 3cb26f2aa4fae63373b032e8ee4b20dacd93d81d
}
