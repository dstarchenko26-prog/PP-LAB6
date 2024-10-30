package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.Loc;
import ua.lpnu.train.wagon.Passengers;
import ua.lpnu.train.wagon.Wagon;
import ua.lpnu.train.wagon.WagonsMenu;

public class AddPassActionTest extends TestCase {

    public void testExecute() {
        Wagon[] wagons = new Wagon[0];
        WagonsMenu wm = new WagonsMenu(wagons);
        AddPassAction apa = new AddPassAction(wm);
        int[] f = {120, 60, 120, 75, 150};
        apa.io = new simListIOclass(f, "test");
        apa.execute();
        Wagon test = new Passengers("test", 120, 60, 120, 75, 150);
        assertEquals(test.getString(), wm.getWagon(0).getString());
    }
}