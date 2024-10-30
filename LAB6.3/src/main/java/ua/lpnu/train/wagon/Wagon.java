package ua.lpnu.train.wagon;

public abstract class Wagon {
    private final String name;
    private final int speed;
    private final int weight;

    public Wagon(String name, int speed, int weight) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public int getTraction() {
        return 0;
    }

    public int getConsumption() {
        return 0;
    }

    public int getComfort() {
        return 0;
    }

    public int getCapacity() {
        return 0;
    }

    public int getAmountOfLuggage() {
        return 0;
    }

    public Wagon get() {
        return null;
    }

    public String getString() {
        return null;
    }
}

