package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.Wagon;
import ua.lpnu.train.wagon.WagonsMenu;

public class PrintWagonsActionTest extends TestCase {

    public void testExecute() {
        PrintWagonsAction t = new PrintWagonsAction(new WagonsMenu());
        t.io = new simIOClass(0);
        t.execute();
        Wagon[] wagons = new Wagon[0];
        t = new PrintWagonsAction(new WagonsMenu(wagons));
        t.io = new simIOClass(0);
        t.execute();
    }
}