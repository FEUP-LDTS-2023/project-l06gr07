package org.crazytracks.states;

import org.crazytracks.control.Controller;
import org.crazytracks.control.MenuController;
import org.crazytracks.model.Menu;
import org.crazytracks.viewer.MenuViewer;
import org.crazytracks.viewer.Viewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}