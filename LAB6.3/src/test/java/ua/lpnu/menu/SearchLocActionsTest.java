package ua.lpnu.menu;

import junit.framework.TestCase;

public class SearchLocActionsTest extends TestCase {

    public void testInitActions() {
        SearchLocActions tActions = new SearchLocActions(null);
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(5, tActions.actions.size());
    }
}