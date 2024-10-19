package ua.lpnu.train.wagon;

public abstract class Wagon {
    private final String name;
    private final int speed;
    private final int weight;

    Wagon(String name, int speed, int weight) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
    }

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    int getWeight() {
        return weight;
    }

    int getTraction() {
        return 0;
    }

    int getConsumption() {
        return 0;
    }

    int getComfort() {
        return 0;
    }

    int getCapacity() {
        return 0;
    }

    int getAmountOfLuggage() {
        return 0;
    }

    public Wagon get() {
        return this;
    }

    public String getString() {
        return null;
    }

    public boolean equals(Wagon wagon) {
        return this.name.equals(wagon.name);
    }
}

