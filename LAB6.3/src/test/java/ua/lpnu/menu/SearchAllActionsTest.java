package ua.lpnu.menu;

import junit.framework.TestCase;

public class SearchAllActionsTest extends TestCase {

    public void testInitActions() {
        SearchAllActions tActions = new SearchAllActions(null);
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(3, tActions.actions.size());
    }
}