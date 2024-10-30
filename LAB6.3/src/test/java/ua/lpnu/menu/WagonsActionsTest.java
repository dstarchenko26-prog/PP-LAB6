package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.WagonsMenu;

public class WagonsActionsTest extends TestCase {

    public void testInitActions() {
        WagonsActions tActions = new WagonsActions(new WagonsMenu());
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(5, tActions.actions.size());
    }
}