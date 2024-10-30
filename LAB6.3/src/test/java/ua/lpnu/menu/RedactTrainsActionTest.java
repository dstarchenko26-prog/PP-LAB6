package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;
import ua.lpnu.train.wagon.*;

public class RedactTrainsActionTest extends TestCase {

    public void testExecute() {
        Train[] trains = new Train[1];
        trains[0] = new Train("test");
        TrainsMenu tm = new TrainsMenu(trains);
        WagonsMenu wm = new WagonsMenu();

        RedactTrainsAction rtma = new RedactTrainsAction(tm, wm);
        rtma.io = new simIOClass(1);
        rtma.rtm.io = new simIOClass(0);
        rtma.execute();
    }
}