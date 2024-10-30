package ua.lpnu.train.wagon;

import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

public class PassengersTest extends TestCase {

    Wagon[] wagons = new Wagon[3];

    public PassengersTest() {
        wagons[0] = new Passengers("01", 40, 50, 150, 50, 200);
        wagons[1] = new Passengers("02", 120, 60, 120, 60, 150);
        wagons[2] = new Passengers("03", 80, 40, 100, 70, 100);
    }

    public void testGet() {
        assertEquals(wagons[0].getString(), wagons[0].get().getString());
        assertNotEquals(wagons[2].getName(), wagons[1].get().getName());
    }

    public void testGetString() {
        assertEquals("Вагон: 01 Вага: 50 т. Швидкість: 40 км./год. Рівень комфорту: 50 Пасажирських місць: 150 Місць для багажу: 200", wagons[0].getString());
        assertEquals("Вагон: 02 Вага: 60 т. Швидкість: 120 км./год. Рівень комфорту: 60 Пасажирських місць: 120 Місць для багажу: 150", wagons[1].getString());
        assertEquals("Вагон: 03 Вага: 40 т. Швидкість: 80 км./год. Рівень комфорту: 70 Пасажирських місць: 100 Місць для багажу: 100", wagons[2].getString());
    }

    public void testGetName() {
        assertEquals("01", wagons[0].getName());
        assertEquals("02", wagons[1].getName());
        assertEquals("03", wagons[2].getName());
    }

    public void testGetWeight() {
        assertEquals(50, wagons[0].getWeight());
        assertEquals(60, wagons[1].getWeight());
        assertEquals(40, wagons[2].getWeight());
    }

    public void testGetSpeed() {
        assertEquals(40, wagons[0].getSpeed());
        assertEquals(120, wagons[1].getSpeed());
        assertEquals(80, wagons[2].getSpeed());
    }

    public void testGetCapacity() {
        assertEquals(150, wagons[0].getCapacity());
        assertEquals(120, wagons[1].getCapacity());
        assertEquals(100, wagons[2].getCapacity());
    }

    public void testGetComfort() {
        assertEquals(50, wagons[0].getComfort());
        assertEquals(60, wagons[1].getComfort());
        assertEquals(70, wagons[2].getComfort());
    }

    public void testGetAmountOfLuggage() {
        assertEquals(200, wagons[0].getAmountOfLuggage());
        assertEquals(150, wagons[1].getAmountOfLuggage());
        assertEquals(100, wagons[2].getAmountOfLuggage());
    }
}