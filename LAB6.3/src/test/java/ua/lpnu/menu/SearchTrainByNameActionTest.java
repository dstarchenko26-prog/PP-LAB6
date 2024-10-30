package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;

public class SearchTrainByNameActionTest extends TestCase {

    public void testExecute() {
        TrainsMenu tm = new TrainsMenu();
        Train[] trains = tm.readTrains("src/test/resources/testWriteTrains");
        SearchTrainByNameAction stbn = new SearchTrainByNameAction(trains);
        stbn.io = new simIOClass("t2");
        stbn.execute();
        String[] output = stbn.io.print();
        assertEquals(output[1], trains[1].getString() + "\n");
    }
}