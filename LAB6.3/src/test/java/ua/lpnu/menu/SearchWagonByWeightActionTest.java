package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.Wagon;
import ua.lpnu.train.wagon.WagonsMenu;

public class SearchWagonByWeightActionTest extends TestCase {

    public void testExecute() {
        WagonsMenu wm = new WagonsMenu();
        Wagon[] wagons = wm.readWagons("src/test/resources/testReadWagons.txt");
        SearchWagonByWeightAction swbw = new SearchWagonByWeightAction(wagons);
        swbw.io = new simIOClass(50);
        swbw.execute();
        String[] output = swbw.io.print();
        assertEquals(output[1], wagons[0].getString() + "\n");
        assertEquals(output[2], wagons[2].getString() + "\n");
    }
}