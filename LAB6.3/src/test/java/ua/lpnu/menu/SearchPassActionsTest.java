package ua.lpnu.menu;

import junit.framework.TestCase;

public class SearchPassActionsTest extends TestCase {

    public void testInitActions() {
        SearchPassActions tActions = new SearchPassActions(null);
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(5, tActions.actions.size());
    }
}