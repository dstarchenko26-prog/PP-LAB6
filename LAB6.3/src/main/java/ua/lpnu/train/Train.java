package ua.lpnu.train;

import ua.lpnu.train.wagon.Wagon;

public class Train {
    private final String name;
    private Wagon[] wagons = new Wagon[0];
    private int speed;
    private int weight;
    private int traction;
    private int consumption;
    private int capacityPassengers;
    private int capacityCargo;
    private int capacityLuggage;

    public Train(String name) {
        this.name = name;
        weight = 0;
        traction = 0;
    }

    public boolean predUpdate(Wagon wagon) {
        if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Loc")) {
            return true;
        } else {
            return weight + wagon.getWeight() <= traction;
        }
    }

    public void add(Wagon wagon) {
        Wagon[] list = new Wagon[wagons.length + 1];
        System.arraycopy(wagons, 0, list, 0, wagons.length);
        list[wagons.length] = wagon;
        wagons = list;
        update();
    }

    private void update() {
        weight = 0;
        traction = 0;
        consumption = 0;
        capacityPassengers = 0;
        capacityCargo = 0;
        capacityLuggage = 0;
        speed = Integer.MAX_VALUE;
        Wagon[] loc = new Wagon[0];
        for (Wagon wagon: wagons) {
            if (wagon.getSpeed() < speed) {
                speed = wagon.getSpeed();
            }
            weight += wagon.getWeight();
            if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Loc")) {
                Wagon[] nLoc = new Wagon[loc.length + 1];
                System.arraycopy(loc, 0, nLoc, 0, loc.length);
                loc = nLoc;
                loc[loc.length - 1] = wagon;
                traction += wagon.getTraction();
            } else if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Passengers")) {
                capacityPassengers += wagon.getCapacity();
                capacityLuggage+= wagon.getAmountOfLuggage();
            } else {
                capacityCargo += wagon.getCapacity();
            }
        }
        for (Wagon wagon: loc) {
            consumption += weight / loc.length * wagon.getConsumption();
        }
    }

    public String getName() {
        return name;
    }

    public int getSpeed () {
        return speed;
    }

    public int getCapacityPassengers() {
        return capacityPassengers;
    }

    public int getCapacityCargo() {
        return capacityCargo;
    }

    public int getConsumption() {
        return consumption;
    }

    public String getString() {
        String str;
        str = name + ": Швидкість: " + speed + " км./год. Вага: " + weight + " т. Тяга: " + traction + " т. Росхід: " + consumption +" л./год";
        for (Wagon wagon: wagons) {
            str = String.join("\n", str, wagon.getString());
        }
        str = str + "\nПасажиромісткість: " + capacityPassengers + " Місць для багажу: " + capacityLuggage + " Грузомісткість: " + capacityCargo + "т.";
        return str;
    }

    public Wagon[] getWagons() {
        return wagons;
    }

    public boolean delUpdate(Wagon wagon) {
        if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Loc")) {
            return weight - wagon.getWeight() <= traction - wagon.getTraction();
        } else {
            return true;
        }
    }

    public void del(int number) {
                Wagon[] newWagons = new Wagon[wagons.length - 1];
                System.arraycopy(wagons, 0, newWagons, 0, number);
                System.arraycopy(wagons, number + 1, newWagons, number, wagons.length - 1 - number);
                wagons = newWagons;
                update();
    }

    public void sort() {
        Wagon[] newWagons = new Wagon[wagons.length];
        for (int i = 0; i < wagons.length; i++) {
            Wagon curWag = null;
            int indCurWag = -1;
            for (int j = 0; j < wagons.length; j++) {
                if (wagons[j] != null) {
                    if (curWag != null) {
                        int rangCW = rang(curWag);
                        int rangW = rang(wagons[j]);
                        if (rangW < rangCW) {
                            curWag = wagons[j];
                            indCurWag = j;
                        } else if (rangW == rangCW) {
                            if (rangW == 1 && curWag.getTraction() < wagons[j].getTraction()) {
                                curWag = wagons[j];
                                indCurWag = j;
                            } else if (rangW == 2 && curWag.getComfort() != wagons[j].getComfort()) {
                                if (curWag.getComfort() < wagons[j].getComfort()) {
                                    curWag = wagons[j];
                                    indCurWag = j;
                                }
                            } else if (curWag.getCapacity() < wagons[j].getCapacity()){
                                curWag = wagons[j];
                                indCurWag = j;
                            }
                        }
                    } else {
                        curWag = wagons[j];
                        indCurWag = j;
                    }
                }
            }
            newWagons[i] = curWag;
            wagons[indCurWag] = null;
        }
        wagons = newWagons;
    }

    private int rang(Wagon wagon) {
        return switch (wagon.getClass().getName()) {
            case "ua.lpnu.train.wagon.Loc" -> 1;
            case "ua.lpnu.train.wagon.Passengers" -> 2;
            default -> 3;
        };
    }
}