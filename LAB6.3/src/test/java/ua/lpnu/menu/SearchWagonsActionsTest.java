package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.WagonsMenu;

public class SearchWagonsActionsTest extends TestCase {

    public void testInitActions() {
        SearchWagonsActions tActions = new SearchWagonsActions(new WagonsMenu());
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(4, tActions.actions.size());
    }
}