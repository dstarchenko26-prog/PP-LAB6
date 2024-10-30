package ua.lpnu.train;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.*;

public class TrainTest extends TestCase {
    Wagon[] wagons = new Wagon[3];

    public TrainTest() {
        wagons[0] = new Loc("01", 100, 50, 200, 10);
        wagons[1] = new Passengers("02", 120, 60, 120, 60, 150);
        wagons[2] = new Cargo("03", 80, 40, 25);
    }

    public void testPredUpdate() {
        Train testTrain = new Train("test");
        assertTrue(testTrain.predUpdate(wagons[0]));
        testTrain.add(wagons[0]);
        testTrain.add(wagons[1]);
        assertTrue(testTrain.predUpdate(wagons[2]));
        testTrain.add(wagons[2]);
        assertFalse(testTrain.predUpdate(wagons[1]));
    }

    public void testAdd() {
        Train testTrain = new Train("test");
        testTrain.add(wagons[0]);
        assertEquals(100, testTrain.getSpeed());
    }

    public void testTestGetName() {
        Train testTrain = new Train("test");
        assertEquals("test", testTrain.getName());
    }

    public void testGetSpeed() {
        Train testTrain = new Train("test");
        testTrain.add(wagons[0]);
        assertEquals(100, testTrain.getSpeed());
    }

    public void testGetCapacityPassengers() {
        Train testTrain = new Train("test");
        testTrain.add(wagons[0]);
        testTrain.add(wagons[1]);
        assertEquals(120, testTrain.getCapacityPassengers());
    }

    public void testGetCapacityCargo() {
        Train testTrain = new Train("test");
        testTrain.add(wagons[0]);
        testTrain.add(wagons[2]);
        assertEquals(25, testTrain.getCapacityCargo());
    }

    public void testGetConsumption() {
        Train testTrain = new Train("test");
        testTrain.add(wagons[0]);
        assertEquals(500, testTrain.getConsumption());
    }

    public void testGetString() {
        Train testTrain = new Train("test");
        testTrain.add(wagons[0]);
        assertEquals("test: Швидкість: 100 км./год. Вага: 50 т. Тяга: 200 т. Росхід: 500 л./год\nЛокомотив: 01 Вага: 50 т. Швидкість: 100 км./год. Тяга: 200 т. Росхід: 10 л./(т. * год.)\nПасажиромісткість: 0 Місць для багажу: 0 Грузомісткість: 0т.", testTrain.getString());
    }

    public void testGetWagons() {
        Train testTrain = new Train("test");
        testTrain.add(wagons[0]);
        testTrain.add(wagons[1]);
        testTrain.add(wagons[2]);
        WagonsMenu wm1 = new WagonsMenu(wagons);
        WagonsMenu wm2 = new WagonsMenu(testTrain.getWagons());
        assertTrue(equalsM(wm1, wm2));
    }

    public void testDelUpdate() {
        Train testTrain = new Train("test");
        testTrain.add(wagons[0]);
        testTrain.add(wagons[1]);
        assertFalse(testTrain.delUpdate(wagons[0]));
        assertTrue(testTrain.delUpdate(wagons[1]));
        testTrain.add(wagons[0]);
        assertTrue(testTrain.delUpdate(wagons[0]));
    }

    public void testDel() {
        Train testTrain = new Train("test");
        testTrain.add(wagons[0]);
        testTrain.add(wagons[1]);
        testTrain.add(wagons[2]);
        testTrain.add(wagons[0]);
        testTrain.del(3);
        assertTrue(equalsM(new WagonsMenu(testTrain.getWagons()), new WagonsMenu(wagons)));
    }

    public void testSort() {
        Train tt1 = new Train("test");
        Train tt2 = new Train("etalon");
        Wagon[] wagons = new Wagon[6];
        wagons[0] = new Loc("L01", 100, 50, 200, 10);
        wagons[1] = new Loc("L02", 100, 50, 500, 15);
        wagons[2] = new Passengers("P01", 120, 60, 120, 75, 150);
        wagons[3] = new Passengers("P02", 120, 60, 180, 60, 150);
        wagons[4] = new Cargo("C01", 80, 40, 25);
        wagons[5] = new Cargo("C02", 80, 60, 45);
        tt1.add(wagons[4]);
        tt1.add(wagons[5]);
        tt1.add(wagons[4]);
        tt1.add(wagons[2]);
        tt1.add(wagons[2]);
        tt1.add(wagons[0]);
        tt1.add(wagons[3]);
        tt1.add(wagons[3]);
        tt1.add(wagons[2]);
        tt1.add(wagons[0]);
        tt1.add(wagons[1]);
        tt2.add(wagons[1]);
        tt2.add(wagons[0]);
        tt2.add(wagons[0]);
        tt2.add(wagons[2]);
        tt2.add(wagons[2]);
        tt2.add(wagons[2]);
        tt2.add(wagons[3]);
        tt2.add(wagons[3]);
        tt2.add(wagons[5]);
        tt2.add(wagons[4]);
        tt2.add(wagons[4]);
        tt1.sort();
        assertTrue(equalsM(new WagonsMenu(tt1.getWagons()), new WagonsMenu(tt2.getWagons())));
    }

    private boolean equalsW(Wagon w1, Wagon w2) {
        return w1.getName().equals(w2.getName());
    }

    private boolean equalsM(WagonsMenu wm1, WagonsMenu wm2) {
        Wagon[] w1 = wm1.getList();
        Wagon[] w2 = wm2.getList();
        for (int i = 0; i < w1.length; i++) {
            if (!equalsW(w1[i], w2[i])) {
                return false;
            }
        }
        return true;
    }
}