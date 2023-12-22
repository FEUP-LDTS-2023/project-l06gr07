package model;

import org.crazytracks.model.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MenuTest {
    private Menu menu;

    @BeforeEach
    public void setUp(){
        this.menu = new Menu();

    }

    @Test
    public void nextEntry(){
        String expected1 = menu.getEntries().get(0);
        String expected2 = menu.getEntries().get(1);
        String expected3 = menu.getEntries().get(2);
        String expected4 = menu.getEntries().get(0);

        Assertions.assertEquals(menu.getCurrentEntry(), expected1);

        menu.nextEntry();
        Assertions.assertEquals(menu.getCurrentEntry(), expected2);

        menu.nextEntry();
        Assertions.assertEquals(menu.getCurrentEntry(), expected3);

        menu.nextEntry();
        Assertions.assertEquals(menu.getCurrentEntry(), expected4);
    }

    @Test
    public void previousEntry(){
        String expected1 = menu.getEntries().get(0);
        String expected2 = menu.getEntries().get(1);
        String expected3 = menu.getEntries().get(2);
        String expected4 = menu.getEntries().get(3);

        Assertions.assertEquals(menu.getCurrentEntry(), expected1);

        menu.previousEntry();
        Assertions.assertEquals(menu.getCurrentEntry(), expected2);

        menu.previousEntry();
        Assertions.assertEquals(menu.getCurrentEntry(), expected3);

        menu.previousEntry();
        Assertions.assertEquals(menu.getCurrentEntry(), expected4);
    }
}
