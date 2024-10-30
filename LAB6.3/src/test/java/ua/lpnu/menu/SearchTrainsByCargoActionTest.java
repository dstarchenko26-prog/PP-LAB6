package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;

public class SearchTrainsByCargoActionTest extends TestCase {

    public void testExecute() {
        TrainsMenu tm = new TrainsMenu();
        Train[] trains = tm.readTrains("src/test/resources/testWriteTrains");
        SearchTrainsByCargoAction stbcc = new SearchTrainsByCargoAction(trains);
        stbcc.io = new simIOClass(60);
        stbcc.execute();
        String[] output = stbcc.io.print();
        assertEquals(output[1], "\n" + trains[2].getString() + "\n");
    }
}