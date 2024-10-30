package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;

public class SearchTrainsBySpeedActionTest extends TestCase {

    public void testExecute() {
        TrainsMenu tm = new TrainsMenu();
        Train[] trains = tm.readTrains("src/test/resources/testWriteTrains");
        SearchTrainsBySpeedAction stbs = new SearchTrainsBySpeedAction(trains);
        int[] f = {90, 120};
        stbs.io = new simListIOclass(f);
        stbs.execute();
        String[] output = stbs.io.print();
        assertEquals(output[2], "\n" + trains[0].getString() + "\n");
        assertEquals(output[3], "\n" + trains[1].getString() + "\n");
        f[0] = 60;
        f[1] = 90;
        stbs.io = new simListIOclass(f);
        stbs.execute();
        output = stbs.io.print();
        assertEquals(output[2], "\n" + trains[2].getString() + "\n");
    }
}