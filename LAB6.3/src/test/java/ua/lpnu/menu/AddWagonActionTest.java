package ua.lpnu.menu;

import junit.framework.TestCase;

public class AddWagonActionTest extends TestCase {

    public void testExecute() {
        AddWagonAction awma = new AddWagonAction(null);
        awma.awm.io = new simIOClass(0);
        awma.execute();
    }
}