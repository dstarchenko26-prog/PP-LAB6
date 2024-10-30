package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.Cargo;
import ua.lpnu.train.wagon.Wagon;
import ua.lpnu.train.wagon.WagonsMenu;

public class AddCargoActionTest extends TestCase {

    public void testExecute() {
        Wagon[] wagons = new Wagon[0];
        WagonsMenu wm = new WagonsMenu(wagons);
        AddCargoAction aca = new AddCargoAction(wm);
        int[] f = {80, 60, 45};
        aca.io = new simListIOclass(f, "test");
        aca.execute();
        Wagon test = new Cargo("test", 80, 60, 45);
        assertEquals(test.getString(), wm.getWagon(0).getString());
    }
}