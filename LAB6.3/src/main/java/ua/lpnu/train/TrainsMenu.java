package ua.lpnu.train;

import ua.lpnu.train.wagon.Wagon;
import ua.lpnu.train.wagon.WagonsMenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TrainsMenu {
    private Train[] trains;

    public TrainsMenu() {
        trains = readTrains("src/main/resources/trains");
    }

    public TrainsMenu(Train[] trains) {
        this.trains = trains;
    }

    public void writeTrains(String file) {
        try {
            FileWriter writer = new FileWriter(file + ".txt");
            for (Train train: trains) {
                WagonsMenu wagonsMenu = new WagonsMenu(train.getWagons());
                String name = train.getName();
                writer.write(name);
                writer.write("\n");
                wagonsMenu.writeWagons(file + "/" + name + ".txt");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Train[] readTrains(String file) {
        Train[] list = new Train[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file + ".txt"));
            String str = reader.readLine();
            while (str != null) {
                Train[] newList = new Train[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                list = newList;
                WagonsMenu wagonsMenu = new WagonsMenu();
                Wagon[] wagons = wagonsMenu.readWagons(file + "/" + str + ".txt");
                list[list.length - 1] = new Train(str);
                for (Wagon wagon: wagons) {
                    list[list.length - 1].add(wagon);
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
        String[] lines = new String[trains.length];
        for (int i = 0; i < trains.length; i++) {
            lines[i] = trains[i].getString() + "\n";
        }
        return lines;
    }

    public void del(int number) {
        Train[] newTrains = new Train[trains.length - 1];
        System.arraycopy(trains, 0, newTrains, 0, number);
        System.arraycopy(trains, number + 1, newTrains, number, trains.length - number - 1);
        trains = newTrains;
    }

    public Train get(int number) {
        return trains[number];
    }

    public Train[] getList() {
        return trains;
    }

    public void add(Train train) {
        Train[] newList = new Train[trains.length + 1];
        System.arraycopy(trains, 0, newList, 0, trains.length);
        newList[trains.length] = train;
        trains = newList;
    }
}
