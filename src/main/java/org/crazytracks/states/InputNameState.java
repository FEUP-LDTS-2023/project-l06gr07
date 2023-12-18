package org.crazytracks.states;

import org.crazytracks.control.Controller;
import org.crazytracks.control.InputNameController;
import org.crazytracks.leaderboard.InputName;
import org.crazytracks.viewer.InputNameViewer;
import org.crazytracks.viewer.Viewer;

public class InputNameState extends State<InputName>{
    public InputNameState(InputName model) {
        super(model);
    }

    @Override
    protected Viewer<InputName> getViewer() {
        return new InputNameViewer(getModel());
    }

    @Override
    protected Controller<InputName> getController() {
        return new InputNameController(getModel());
    }
}
