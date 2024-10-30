package ua.lpnu.train.wagon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WagonsMenu {
    private Wagon[] wagons;

    public WagonsMenu() {
        wagons = readWagons("src/main/resources/wagons.txt");
    }

    public WagonsMenu(Wagon[] wagons) {
        this.wagons = wagons;
    }

    public void writeWagons(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Wagon wagon: wagons) {
                writer.write(wagon.getClass().getName());
                writer.write("\n");
                writer.write(wagon.getName());
                writer.write("\n");
                writer.write(String.valueOf(wagon.getWeight()));
                writer.write("\n");
                writer.write(String.valueOf(wagon.getSpeed()));
                writer.write("\n");
                if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Loc")) {
                    writer.write(String.valueOf(wagon.getTraction()));
                    writer.write("\n");
                    writer.write(String.valueOf(wagon.getConsumption()));
                    writer.write("\n");
                } else {
                    writer.write(String.valueOf(wagon.getCapacity()));
                    writer.write("\n");
                    if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Passengers")) {
                        writer.write(String.valueOf(wagon.getComfort()));
                        writer.write("\n");
                        writer.write(String.valueOf(wagon.getAmountOfLuggage()));
                        writer.write("\n");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Wagon[] readWagons(String fileName) {
        Wagon[] list = new Wagon[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String str = reader.readLine();
            while (str != null) {
                Wagon[] newList = new Wagon[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                list = newList;
                String name = reader.readLine();
                int weight = Integer.parseInt(reader.readLine());
                int speed = Integer.parseInt(reader.readLine());
                if (str.equals("ua.lpnu.train.wagon.Loc")) {
                    int traction = Integer.parseInt(reader.readLine());
                    int consumption = Integer.parseInt(reader.readLine());
                    list[list.length - 1] = new Loc(name, speed, weight, traction, consumption);
                } else {
                    int capacity = Integer.parseInt(reader.readLine());
                    if (str.equals("ua.lpnu.train.wagon.Passengers")) {
                        int comfort = Integer.parseInt(reader.readLine());
                        int amountOfLuggage = Integer.parseInt(reader.readLine());
                        list[list.length - 1] = new Passengers(name, speed, weight, capacity, comfort, amountOfLuggage);
                    } else {
                        list[list.length - 1] = new Cargo(name, speed, weight, capacity);
                    }
                }
                str = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public String[] getString() {
        String[] lines = new String[wagons.length];
        for (int i = 0; i < wagons.length; i++) {
            lines[i] = wagons[i].getString();
        }
        return lines;
    }

    public void del(int number) {
        Wagon[] newWagons = new Wagon[wagons.length - 1];
        System.arraycopy(wagons, 0, newWagons, 0, number);
        System.arraycopy(wagons, number + 1, newWagons, number, wagons.length - number - 1);
        wagons = newWagons;
    }

    public void add(Wagon wagon) {
        Wagon[] newList = new Wagon[wagons.length + 1];
        System.arraycopy(wagons, 0, newList, 0, wagons.length);
        newList[wagons.length] = wagon;
        wagons = newList;
    }

    public Wagon[] getList() {
        return wagons;
    }

    public Wagon getWagon(int number) {
        return wagons[number].get();
    }
}