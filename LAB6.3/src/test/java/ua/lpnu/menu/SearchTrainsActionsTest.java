package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.TrainsMenu;

public class SearchTrainsActionsTest extends TestCase {

    public void testInitActions() {
        SearchTrainsActions tActions = new SearchTrainsActions(new TrainsMenu(null));
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(5, tActions.actions.size());
    }
}