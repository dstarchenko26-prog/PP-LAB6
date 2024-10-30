package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.Cargo;
import ua.lpnu.train.wagon.Passengers;
import ua.lpnu.train.wagon.Wagon;

public class SearchWagonByCapacityActionTest extends TestCase {

    public void testExecute() {
        Wagon[] wagons = new Wagon[4];
        wagons[0] = new Passengers("P01", 120, 60, 60, 75, 150);
        wagons[1] = new Passengers("P02", 120, 60, 180, 60, 150);
        wagons[2] = new Cargo("C01", 80, 40, 140);
        wagons[3] = new Cargo("C02", 80, 60, 45);
        SearchWagonByCapacityAction swbcap = new SearchWagonByCapacityAction(wagons);
        swbcap.io = new simIOClass(120);
        swbcap.execute();
        String[] output = swbcap.io.print();
        assertEquals(output[1], wagons[1].getString() + "\n");
        assertEquals(output[2], wagons[2].getString() + "\n");
    }
}