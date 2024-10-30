package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;
import ua.lpnu.train.wagon.Cargo;
import ua.lpnu.train.wagon.Loc;
import ua.lpnu.train.wagon.Passengers;
import ua.lpnu.train.wagon.Wagon;

public class PrintTrainActionTest extends TestCase {

    public void testExecute() {
        Wagon[] wagons = new Wagon[3];
        wagons[0] = new Loc("L01", 100, 50, 200, 10);
        wagons[1] = new Passengers("P01", 120, 60, 120, 75, 150);
        wagons[2] = new Cargo("C01", 80, 40, 25);
        Train train = new Train("t1");
        train.add(wagons[0]);
        train.add(wagons[1]);
        train.add(wagons[2]);
        PrintTrainAction pta = new PrintTrainAction(train);
        pta.io = new simIOClass(0);
        pta.execute();
        String[] output = pta.io.print();
        assertEquals(output[0], train.getString() + "\n");
    }
}