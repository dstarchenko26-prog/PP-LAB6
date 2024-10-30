package ua.lpnu.train.wagon;

import junit.framework.TestCase;

public class WagonsMenuTest extends TestCase {
    WagonsMenu wm;
    Wagon[] wagons = new Wagon[3];

    public WagonsMenuTest() {
        wagons[0] = new Loc("01", 50, 50, 100, 10);
        wagons[1] = new Passengers("02", 120, 60, 120, 60, 150);
        wagons[2] = new Cargo("03", 80, 40, 25);
        wm = new WagonsMenu(wagons);
        WagonsMenu wm2 = new WagonsMenu();
    }

    public void testWriteWagons() {
        wm.writeWagons("src/test/resources/testWriteWagons.txt");
        assertTrue(tWW());
    }

    private boolean tWW() {
        return equalsM(wm, new WagonsMenu(wm.readWagons("src/test/resources/testWriteWagons.txt")));
    }

    public void testReadWagons() {
        assertTrue(tRW());
    }

    private boolean tRW() {
        return equalsM(wm, new WagonsMenu(wm.readWagons("src/test/resources/testReadWagons.txt")));
    }

    public void testGetString() {
        String[] lines = wm.getString();
        assertEquals("Локомотив: 01 Вага: 50 т. Швидкість: 50 км./год. Тяга: 100 т. Росхід: 10 л./(т. * год.)", lines[0]);
        assertEquals("Вагон: 02 Вага: 60 т. Швидкість: 120 км./год. Рівень комфорту: 60 Пасажирських місць: 120 Місць для багажу: 150", lines[1]);
        assertEquals("Вагон: 03 Вага: 40 т. Швидкість: 80 км./год. Місткість: 25 т.", lines[2]);
    }

    public void testDel() {
        WagonsMenu wmt = new WagonsMenu(wagons);
        wmt.add(wagons[2]);
        wmt.del(3);
        assertTrue(equalsM(wm, wmt));
    }

    public void testAdd() {
        WagonsMenu wmt = new WagonsMenu(new Wagon[0]);
        for (Wagon wagon: wagons) {
            wmt.add(wagon);
        }
        assertTrue(equalsM(wm, wmt));
    }

    public void testGetList() {
        assertEquals(wagons, wm.getList());
    }

    public void testGetWagon() {
        assertTrue(equalsW(wagons[0], wm.getWagon(0)));
        assertTrue(equalsW(wagons[1], wm.getWagon(1)));
        assertTrue(equalsW(wagons[2], wm.getWagon(2)));
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