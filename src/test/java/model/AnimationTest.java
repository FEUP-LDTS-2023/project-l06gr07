package model;

import org.crazytracks.model.Animation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimationTest {
    @Test
    public void nextAnimMode(){
        int numOfAnimModes = 2;
        int expected1 = 1;
        int expected2 = 0;

        Animation animation = new Animation(numOfAnimModes);
        animation.nextAnimMode();
        Assertions.assertEquals(animation.getAnimMode(), expected1);

        animation.nextAnimMode();
        Assertions.assertEquals(animation.getAnimMode(), expected2);
    }
}
