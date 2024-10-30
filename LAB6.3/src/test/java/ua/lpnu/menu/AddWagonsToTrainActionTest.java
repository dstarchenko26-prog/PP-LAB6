package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;
import ua.lpnu.train.wagon.*;

public class AddWagonsToTrainActionTest extends TestCase {

    public void testExecute() {
        Train[] trains = new Train[1];
        trains[0] = new Train("test");
        TrainsMenu tm = new TrainsMenu(trains);
        Wagon[] wagons = new Wagon[6];
        wagons[0] = new Loc("L01", 100, 50, 200, 10);
        wagons[1] = new Loc("L02", 100, 50, 500, 15);
        wagons[2] = new Passengers("P01", 120, 60, 120, 75, 150);
        wagons[3] = new Passengers("P02", 120, 60, 180, 60, 150);
        wagons[4] = new Cargo("C01", 80, 40, 25);
        wagons[5] = new Cargo("C02", 80, 60, 45);
        WagonsMenu wm = new WagonsMenu(wagons);
        trains[0].add(wagons[0]);
        trains[0].add(wagons[2]);
        Train test = new Train("test");
        test.add(wagons[0]);
        test.add(wagons[2]);
        test.add(wagons[3]);
        test.add(wagons[1]);
        AddWagonsToTrainAction awt = new AddWagonsToTrainAction(tm.get(0), wm);
        int[] f = {4, 0, 6, 2, 1};
        awt.io = new simListIOclass(f);
        awt.execute();
        assertEquals(test.getString(), tm.get(0).getString());
    }
}