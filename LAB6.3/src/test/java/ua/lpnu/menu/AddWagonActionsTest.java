package ua.lpnu.menu;

import junit.framework.TestCase;

public class AddWagonActionsTest extends TestCase {

    public void testInitActions() {
        AddWagonActions tActions = new AddWagonActions(null);
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(3, tActions.actions.size());
    }
}