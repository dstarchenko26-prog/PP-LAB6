package ua.lpnu.train.wagon;

public class Loc extends Wagon {
    private final int traction;
    private final int consumption;

    Loc(String name, int speed, int weight, int traction, int consumption) {
        super(name, speed, weight);
        this.traction = traction;
        this.consumption = consumption;
    }

    public Loc get() {
        return new Loc(this.getName(), this.getSpeed(), this.getWeight(), this.traction, this.consumption);
    }

    public String getString() {
        return "Локомотив: " + getName() + " Вага: " + getWeight() + " т. Швидкість: " + getSpeed() + " км./год. Тяга: " + traction + " т. Росхід: " + consumption + " л./(т. * год.)";
    }

    int getTraction() {
        return traction;
    }

    int getConsumption() {
        return consumption;
    }
}