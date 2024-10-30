package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;

public class SearchTrainsByPassActionTest extends TestCase {

    public void testExecute() {
        TrainsMenu tm = new TrainsMenu();
        Train[] trains = tm.readTrains("src/test/resources/testWriteTrains");
        SearchTrainsByPassAction stbcp = new SearchTrainsByPassAction(trains);
        stbcp.io = new simIOClass(150);
        stbcp.execute();
        String[] output = stbcp.io.print();
        assertEquals(output[1], "\n" + trains[1].getString() + "\n");
    }
}