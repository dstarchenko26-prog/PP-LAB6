package ua.lpnu.menu;

import junit.framework.TestCase;

public class RedactTrainActionsTest extends TestCase {

    public void testInitActions() {
        RedactTrainActions tActions = new RedactTrainActions(null);
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(4, tActions.actions.size());
    }
}