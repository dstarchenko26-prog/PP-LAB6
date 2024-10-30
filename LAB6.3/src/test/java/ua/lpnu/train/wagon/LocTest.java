package ua.lpnu.train.wagon;

import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

public class LocTest extends TestCase {
    Wagon[] wagons = new Wagon[3];

    public LocTest() {
        wagons[0] = new Loc("01", 50, 50, 100, 10);
        wagons[1] = new Loc("02", 150, 70, 120, 15);
        wagons[2] = new Loc("03", 10, 40, 100, 20);
    }

    public void testGet() {
        assertEquals(wagons[0].getString(), wagons[0].get().getString());
        assertNotEquals(wagons[2].getName(), wagons[1].get().getName());
    }

    public void testGetString() {
        assertEquals("Локомотив: 01 Вага: 50 т. Швидкість: 50 км./год. Тяга: 100 т. Росхід: 10 л./(т. * год.)", wagons[0].getString());
        assertEquals("Локомотив: 02 Вага: 70 т. Швидкість: 150 км./год. Тяга: 120 т. Росхід: 15 л./(т. * год.)", wagons[1].getString());
        assertEquals("Локомотив: 03 Вага: 40 т. Швидкість: 10 км./год. Тяга: 100 т. Росхід: 20 л./(т. * год.)", wagons[2].getString());
    }

    public void testGetName() {
        assertEquals("01", wagons[0].getName());
        assertEquals("02", wagons[1].getName());
        assertEquals("03", wagons[2].getName());
    }

    public void testGetWeight() {
        assertEquals(50, wagons[0].getWeight());
        assertEquals(70, wagons[1].getWeight());
        assertEquals(40, wagons[2].getWeight());
    }

    public void testGetSpeed() {
        assertEquals(50, wagons[0].getSpeed());
        assertEquals(150, wagons[1].getSpeed());
        assertEquals(10, wagons[2].getSpeed());
    }

    public void testGetTraction() {
        assertEquals(100, wagons[0].getTraction());
        assertEquals(120, wagons[1].getTraction());
        assertEquals(100, wagons[2].getTraction());
    }

    public void testGetConsumption() {
        assertEquals(10, wagons[0].getConsumption());
        assertEquals(15, wagons[1].getConsumption());
        assertEquals(20, wagons[2].getConsumption());
    }
}