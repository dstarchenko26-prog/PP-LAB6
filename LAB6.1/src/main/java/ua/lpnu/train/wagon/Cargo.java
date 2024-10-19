package ua.lpnu.train.wagon;

public class Cargo extends Wagon{
    private final int capacity;

    Cargo(String name, int speed, int weight, int capacity) {
        super(name, speed, weight);
        this.capacity = capacity;
    }

    public Cargo get() {
        return new Cargo(getName(),getSpeed(),getWeight(),capacity);
    }

    public String getString() {
        return "Вагон: " + getName() + " Вага: " + getWeight() + " т. Швидкість: " + getSpeed() + " км./год. Місткість: " + capacity + " т.";
    }

    int getCapacity() {
        return capacity;
    }
}
