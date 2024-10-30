package ua.lpnu.train;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.*;

public class TrainsMenuTest extends TestCase {
    Wagon[] wagons = new Wagon[6];
    Train[] trains = new Train[3];

    public TrainsMenuTest() {
        wagons[0] = new Loc("L01", 100, 50, 200, 10);
        wagons[1] = new Loc("L02", 100, 50, 500, 15);
        wagons[2] = new Passengers("P01", 120, 60, 120, 75, 150);
        wagons[3] = new Passengers("P02", 120, 60, 180, 60, 150);
        wagons[4] = new Cargo("C01", 80, 40, 25);
        wagons[5] = new Cargo("C02", 80, 60, 45);
        trains[0] = new Train("t1");
        trains[0].add(wagons[0]);
        trains[0].add(wagons[2]);
        trains[1] = new Train("t2");
        trains[1].add(wagons[1]);
        trains[1].add(wagons[3]);
        trains[2] = new Train("t3");
        trains[2].add(wagons[1]);
        trains[2].add(wagons[4]);
        trains[2].add(wagons[5]);
        TrainsMenu tm = new TrainsMenu();
    }

    public void testWriteTrains() {
        TrainsMenu tm = new TrainsMenu(trains);
        tm.writeTrains("src/test/resources/testWriteTrains");
        assertTrue(tWT(tm));
    }

    private boolean tWT(TrainsMenu tm) {
        return tETL(tm.readTrains("src/test/resources/testWriteTrains"));
    }

    public void testReadTrains() {
        TrainsMenu tm = new TrainsMenu();
        assertTrue(tETL(tm.readTrains("src/test/resources/testWriteTrains")));
    }

    public void testGetString() {
        String[] strEtalon = new String[3];
        TrainsMenu tm = new TrainsMenu(trains);
        for (int i = 0; i < 3; i++) {
            strEtalon[i] = trains[i].getString() + "\n";
        }
        for (int i = 0; i < 3; i++) {
            assertTrue(strEtalon[i].equals(tm.getString()[i]));
        }
    }

    public void testDel() {
        Train[] testTrains = new Train[4];
        TrainsMenu tm = new TrainsMenu(testTrains);
        testTrains[0] = trains[0];
        testTrains[1] = trains[1];
        testTrains[2] = trains[2];
        testTrains[3] = trains[0];
        tm.del(3);
        assertTrue(tETL(tm.getList()));
    }

    public void testGet() {
        TrainsMenu tm = new TrainsMenu(trains);
        assertTrue(tET(tm.get(1), trains[1]));
    }

    public void testGetList() {
        TrainsMenu tm = new TrainsMenu(trains);
        assertTrue(tETL(tm.getList()));
    }

    public void testAdd() {
        Train[] testTrains = new Train[2];
        TrainsMenu tm = new TrainsMenu(testTrains);
        testTrains[0] = trains[0];
        testTrains[1] = trains[1];
        tm.add(trains[2]);
        assertTrue(tETL(tm.getList()));
    }

    private boolean tETL(Train[] tr) {
        for (int i = 0; i < tr.length; i++) {
            if (!tET(tr[i], trains[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean tET(Train t1, Train t2) {
        return t1.getName().equals(t2.getName());
    }
}