package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.TrainsMenu;

public class DeleteTrainActionTest extends TestCase {

    public void testExecute() {
        TrainsMenu tm = new TrainsMenu();
        DeleteTrainAction dta = new DeleteTrainAction(tm);
        dta.io = new simIOClass(1);
        dta.execute();
        assertEquals(tm.get(0).getString(), new TrainsMenu().get(1).getString());
    }
}