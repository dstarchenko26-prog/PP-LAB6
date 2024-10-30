package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;

public class SearchTrainsByConsumptionActionTest extends TestCase {

    public void testExecute() {
        TrainsMenu tm = new TrainsMenu();
        Train[] trains = tm.readTrains("src/test/resources/testWriteTrains");
        SearchTrainsByConsumptionAction stbcon = new SearchTrainsByConsumptionAction(trains);
        stbcon.io = new simIOClass(1200);
        stbcon.execute();
        String[] output = stbcon.io.print();
        assertEquals(output[1], "\n" + trains[0].getString() + "\n");
    }
}