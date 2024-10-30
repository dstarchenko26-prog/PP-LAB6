package ua.lpnu.menu;

import junit.framework.TestCase;

public class SearchCargoActionsTest extends TestCase {

    public void testInitActions() {
        SearchCargoActions tActions = new SearchCargoActions(null);
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(4, tActions.actions.size());
    }
}