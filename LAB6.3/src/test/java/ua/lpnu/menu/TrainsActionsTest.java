package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.TrainsMenu;

public class TrainsActionsTest extends TestCase {

    public void testInitActions() {
        TrainsActions tActions = new TrainsActions(new TrainsMenu(), null);
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(6, tActions.actions.size());
    }
}