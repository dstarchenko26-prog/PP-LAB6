package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.TrainsMenu;
import ua.lpnu.train.wagon.WagonsMenu;

public class MainMenuTest extends TestCase {

    public void testInitActions() {
        MainMenu tActions = new MainMenu(new WagonsMenu(), new TrainsMenu(), null);
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(3, tActions.actions.size());
    }
}