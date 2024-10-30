package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.Loc;
import ua.lpnu.train.wagon.Wagon;
import ua.lpnu.train.wagon.WagonsMenu;

public class AddLocActionTest extends TestCase {

    public void testExecute() {
        Wagon[] wagons = new Wagon[0];
        WagonsMenu wm = new WagonsMenu(wagons);
        AddLocAction ala = new AddLocAction(wm);
        int[] f = {100, 50, 200, 10};
        ala.io = new simListIOclass(f, "test");
        ala.execute();
        Wagon test = new Loc("test", 100, 50, 200, 10);
        assertEquals(test.getString(), wm.getWagon(0).getString());
    }
}