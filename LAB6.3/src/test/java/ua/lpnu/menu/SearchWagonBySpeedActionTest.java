package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.Wagon;
import ua.lpnu.train.wagon.WagonsMenu;

public class SearchWagonBySpeedActionTest extends TestCase {

    public void testExecute() {
        WagonsMenu wm = new WagonsMenu();
        Wagon[] wagons = wm.readWagons("src/test/resources/testReadWagons.txt");
        SearchWagonBySpeedAction swbs = new SearchWagonBySpeedAction(wagons);
        int[] f = {70, 130};
        swbs.io = new simListIOclass(f);
        swbs.execute();
        String[] output = swbs.io.print();
        assertEquals(output[2], wagons[1].getString() + "\n");
        assertEquals(output[3], wagons[2].getString() + "\n");
        f[0] = 30;
        f[1] = 60;
        swbs.io = new simListIOclass(f);
        swbs.execute();
        output = swbs.io.print();
        assertEquals(output[2], wagons[0].getString() + "\n");
    }
}