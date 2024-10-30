package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.Loc;
import ua.lpnu.train.wagon.Wagon;

public class SearchWagonByConsumptionActionTest extends TestCase {

    public void testExecute() {
        Wagon[] wagons = new Wagon[2];
        wagons[0] = new Loc("L01", 100, 50, 200, 10);
        wagons[1] = new Loc("L02", 100, 50, 500, 15);
        SearchWagonByConsumptionAction swbcon = new SearchWagonByConsumptionAction(wagons);
        swbcon.io = new simIOClass(12);
        swbcon.execute();
        String[] output = swbcon.io.print();
        assertEquals(output[1], wagons[0].getString() + "\n");
    }
}