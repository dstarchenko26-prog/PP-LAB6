package ua.lpnu.train.wagon;

public class Passengers extends Wagon{
    private final int capacity;
    private final int comfort;
    private final int amountOfLuggage;

    Passengers(String name, int speed, int weight, int capacity, int comfort, int amountOfLuggage) {
        super(name, speed, weight);
        this.capacity = capacity;
        this.comfort = comfort;
        this.amountOfLuggage = amountOfLuggage;
    }

    public Passengers get() {
        return new Passengers(getName(),getSpeed(),getWeight(),capacity,comfort,amountOfLuggage);
    }

    public String getString() {
        return "Вагон: " + getName() + " Вага: " + getWeight() + " т. Швидкість: " + getSpeed() + " Рівень комфорту: " + comfort + " Пасажирських місць: " + capacity + " Місць для багажу: " + amountOfLuggage;
    }

    int getCapacity() {
        return capacity;
    }

    int getComfort() {
        return comfort;
    }

    int getAmountOfLuggage() {
        return amountOfLuggage;
    }
}
