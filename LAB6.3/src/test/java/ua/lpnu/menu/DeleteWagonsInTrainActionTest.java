package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;
import ua.lpnu.train.wagon.*;

public class DeleteWagonsInTrainActionTest extends TestCase {

    public void testExecute() {
        Train train = new Train("test");
        Train test = new Train("test");
        Wagon[] wagons = new Wagon[3];
        wagons[0] = new Loc("L01", 100, 50, 200, 10);
        wagons[1] = new Passengers("P01", 120, 60, 120, 75, 150);
        wagons[2] = new Cargo("C01", 80, 40, 25);
        train.add(wagons[0]);
        train.add(wagons[1]);
        train.add(wagons[2]);
        test.add(wagons[0]);
        test.add(wagons[1]);
        DeleteWagonsInTrainAction dwt = new DeleteWagonsInTrainAction(train);
        int[] f = {1, 3, 1};
        dwt.io = new simListIOclass(f);
        dwt.execute();
        assertEquals(test.getString(), train.getString());
        train = new Train("test");
        train.add(wagons[0]);
        train.add(wagons[1]);
        train.add(wagons[2]);
        dwt = new DeleteWagonsInTrainAction(train);
        int[] f2 = {3, 0, 2, 0, 1, 0};
        dwt.io = new simListIOclass(f2);
        dwt.execute();
    }
}