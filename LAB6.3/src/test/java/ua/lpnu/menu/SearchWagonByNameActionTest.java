package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.Wagon;
import ua.lpnu.train.wagon.WagonsMenu;

public class SearchWagonByNameActionTest extends TestCase {

    public void testExecute() {
        WagonsMenu wm = new WagonsMenu();
        Wagon[] wagons = wm.readWagons("src/test/resources/testReadWagons.txt");
        SearchWagonByNameAction swbn = new SearchWagonByNameAction(wagons);
        swbn.io = new simIOClass("02");
        swbn.execute();
        String[] output = swbn.io.print();
        assertEquals(output[1], wagons[1].getString() + "\n");
    }
}