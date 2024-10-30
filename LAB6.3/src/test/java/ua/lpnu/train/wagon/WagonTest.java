package ua.lpnu.train.wagon;

import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

public class WagonTest extends TestCase {
    Wagon[] wagons = new Wagon[3];

    public WagonTest() {
        wagons[0] = new WItest("01", 10, 100);
        wagons[1] = new WItest("02", 30, 150);
        wagons[2] = new WItest("03", 50, 50);
    }

    public void testGetTraction() {
        assertEquals(0, wagons[0].getTraction());
        assertEquals(0, wagons[1].getTraction());
        assertEquals(0, wagons[2].getTraction());
    }

    public void testGetConsumption() {
        assertEquals(0, wagons[0].getConsumption());
        assertEquals(0, wagons[1].getConsumption());
        assertEquals(0, wagons[2].getConsumption());
    }

    public void testGetComfort() {
        assertEquals(0, wagons[0].getComfort());
        assertEquals(0, wagons[1].getComfort());
        assertEquals(0, wagons[2].getComfort());
    }

    public void testGetCapacity() {
        assertEquals(0, wagons[0].getCapacity());
        assertEquals(0, wagons[1].getCapacity());
        assertEquals(0, wagons[2].getCapacity());
    }

    public void testGetAmountOfLuggage() {
        assertEquals(0, wagons[0].getAmountOfLuggage());
        assertEquals(0, wagons[1].getAmountOfLuggage());
        assertEquals(0, wagons[2].getAmountOfLuggage());
    }

    public void testGet() {
        assertNull(wagons[0].get());
        assertNull(wagons[1].get());
        assertNull(wagons[2].get());
    }

    public void testGetString() {
        assertNull(wagons[0].getString());
        assertNull(wagons[1].getString());
        assertNull(wagons[2].getString());
    }
}

class WItest extends Wagon {
    WItest(String name, int weight, int speed) {
        super(name, speed, weight);
    }
}