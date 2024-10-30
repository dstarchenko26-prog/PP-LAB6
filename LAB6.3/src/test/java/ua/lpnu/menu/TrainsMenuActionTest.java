package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.TrainsMenu;

public class TrainsMenuActionTest extends TestCase {

    public void testExecute() {
        TrainsMenuAction tma = new TrainsMenuAction(new TrainsMenu(), null);
        tma.tm.io = new simIOClass(0);
        tma.execute();
    }
}