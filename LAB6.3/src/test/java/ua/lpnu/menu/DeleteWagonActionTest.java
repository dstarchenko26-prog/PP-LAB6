package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.*;

public class DeleteWagonActionTest extends TestCase {

    public void testExecute() {
        Wagon[] wagons = new Wagon[3];
        Wagon[] etalon = new Wagon[2];
        wagons[0] = new Loc("L01", 100, 50, 200, 10);
        wagons[1] = new Loc("L02", 100, 50, 500, 15);
        wagons[2] = new Passengers("P01", 120, 60, 120, 75, 150);
        etalon[0] = new Loc("L01", 100, 50, 200, 10);
        etalon[1] = new Passengers("P01", 120, 60, 120, 75, 150);
        WagonsMenu wm = new WagonsMenu(wagons);
        DeleteWagonAction wwa = new DeleteWagonAction(wm);
        wwa.io = new simIOClass(2);
        wwa.execute();
        wagons = wwa.wagonsMenu.getList();
        for (int i = 0; i < wagons.length; i++) {
            assertEquals(etalon[i].getString(), wagons[i].getString());
        }
    }
}