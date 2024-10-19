package ua.lpnu.train;

import ua.lpnu.train.wagon.*;

import java.util.Scanner;

public class Train {
    Scanner console = new Scanner(System.in);

    private final String name;
    private Wagon[] wagons = new Wagon[0];
    private int speed;
    private int weight;
    private int traction;
    private int consumption;
    private int capacityPassengers;
    private int capacityCargo;
    private int capacityLuggage;

    Train(WagonsMenu wm) {
        System.out.print("Дайте потягу ім'я -> ");
        name = console.nextLine();
        System.out.print("\n");
        speed = 0;
        weight = 0;
        traction = 0;
        consumption = 0;
        capacityPassengers = 0;
        capacityCargo = 0;
        capacityLuggage = 0;
        addWagons(wm);
    }

    Train(String name, Wagon[] wagons) {
        this.name = name;
        this.wagons = wagons;
        this.update();
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

    protected String getName() {
        return name;
    }

    protected int getSpeed () {
        return speed;
    }

    protected int getCapacityPassengers() {
        return capacityPassengers;
    }

    protected int getCapacityCargo() {
        return capacityCargo;
    }

    protected int getConsumption() {
        return consumption;
    }

    protected Wagon[] getWagons() {
        return wagons;
    }

    public void redact(WagonsMenu wm) {
        while (true) {
            System.out.print("""
                    Меню:
                    1 - Інформація про потяг
                    2 - Додати вагони
                    3 - Видалити вагони
                    4 - Посортувати вагони
                    0 - Назад
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                print();
            } else if (f == 2) {
                addWagons(wm);
            } else if (f == 3) {
                deleteWagons();
            } else if (f == 4) {
                sort();
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    public Train get() {
        return new Train(name, wagons);
    }

    public boolean equals(Train train) {
        return this.name.equals(train.name);
    }

    private void print() {
        System.out.println(this.getString());
        System.out.print("\n");
    }

    private void addWagons(WagonsMenu wm) {
        while (true) {
            Wagon add = wm.selectWagon();
            if (predUpdate(add)) {
                expand();
                wagons[wagons.length - 1] = add;
                update();
            } else {
                System.out.print("Помилка! Вага перевищить тягу\n\n");
                continue;
            }
            System.out.print("Завершити (1 - Так)? -> ");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 1) {
                break;
            }
        }
    }

    private void expand() {
        Wagon[] list = new Wagon[wagons.length + 1];
        System.arraycopy(wagons, 0, list, 0, wagons.length);
        wagons = list;
    }

    private boolean predUpdate(Wagon wagon) {
        Wagon[] ws = new Wagon[1];
        ws[0] = wagon;
        WagonsMenu wm = new WagonsMenu(ws);
        if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Loc")) {
            return true;
        } else {
            return weight + wm.getValue("weight", wagon) <= traction;
        }
    }

    private void update() {
        WagonsMenu wm = new WagonsMenu(wagons);
        weight = 0;
        traction = 0;
        consumption = 0;
        capacityPassengers = 0;
        capacityCargo = 0;
        capacityLuggage = 0;
        speed = Integer.MAX_VALUE;
        Wagon[] loc = new Wagon[0];
        for (Wagon wagon: wagons) {
            if (wm.getValue("speed", wagon) < speed) {
                speed = wm.getValue("speed", wagon);
            }
            weight += wm.getValue("weight", wagon);
            if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Loc")) {
                Wagon[] nLoc = new Wagon[loc.length + 1];
                System.arraycopy(loc, 0, nLoc, 0, loc.length);
                loc = nLoc;
                loc[loc.length - 1] = wagon;
                traction += wm.getValue("traction", wagon);
            } else if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Passengers")) {
                capacityPassengers += wm.getValue("capacity", wagon);
                capacityLuggage+= wm.getValue("luggage", wagon);
            } else {
                capacityCargo += wm.getValue("capacity", wagon);
            }
        }
        for (Wagon wagon: loc) {
            consumption += weight / loc.length * wm.getValue("consumption", wagon);
        }
    }

    private void deleteWagons() {
        while (true) {
            WagonsMenu wm = new WagonsMenu(wagons);
            Wagon del = wm.selectWagon();
            if (predUpdate(del, wm)) {
                Wagon[] newWagons = new Wagon[wagons.length - 1];
                int i = 0;
                while (i < wagons.length && !wagons[i].equals(del)) {
                    i++;
                }
                System.arraycopy(wagons, 0, newWagons, 0, i);
                System.arraycopy(wagons, i + 1, newWagons, i, wagons.length - 1 - i);
                wagons = newWagons;
                update();
            } else {
                System.out.print("Помилка! Вага перевищить тягу\n\n");
                continue;
            }
            System.out.print("Завершити (1 - Так)? -> ");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 1) {
                break;
            }
        }
    }

    private boolean predUpdate(Wagon wagon, WagonsMenu wm) {
        if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Loc")) {
            return weight - wm.getValue("weight", wagon) <= traction - wm.getValue("traction", wagon);
        } else {
            return true;
        }
    }

    private void sort() {
        WagonsMenu wm = new WagonsMenu(wagons);
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
                            if (rangW == 1 && wm.getValue("traction", curWag) < wm.getValue("traction", wagons[j])) {
                                curWag = wagons[j];
                                indCurWag = j;
                            } else if (rangW == 2 && (wm.getValue("comfort", curWag) < wm.getValue("comfort", wagons[j]) || wm.getValue("comfort", curWag) > wm.getValue("comfort", wagons[j]))) {
                                if (wm.getValue("comfort", curWag) < wm.getValue("comfort", wagons[j])) {
                                    curWag = wagons[j];
                                    indCurWag = j;
                                }
                            } else if (wm.getValue("capacity", curWag) < wm.getValue("capacity", wagons[j])){
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