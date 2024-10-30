package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.Passengers;
import ua.lpnu.train.wagon.Wagon;

public class SearchWagonByComfortActionTest extends TestCase {

    public void testExecute() {
        Wagon[] wagons = new Wagon[2];
        wagons[0] = new Passengers("P01", 120, 60, 60, 75, 150);
        wagons[1] = new Passengers("P02", 120, 60, 180, 60, 150);
        SearchWagonByComfortAction swbcom = new SearchWagonByComfortAction(wagons);
        swbcom.io = new simIOClass(70);
        swbcom.execute();
        String[] output = swbcom.io.print();
        assertEquals(output[1], wagons[0].getString() + "\n");
    }
}