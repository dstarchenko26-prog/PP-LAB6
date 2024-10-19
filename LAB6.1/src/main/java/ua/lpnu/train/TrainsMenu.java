package ua.lpnu.train;

import ua.lpnu.train.wagon.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TrainsMenu {
    Scanner console = new Scanner(System.in);
    private final String file = "src/main/resources/trains";
    private Train[] trains = readTrains();

    public void selectAction(WagonsMenu wm) {
        while (true) {
            System.out.print("""
                    Меню:
                    1 - Список всіх потягів
                    2 - Додати потяг
                    3 - Видалити потяг
                    4 - Пошук потягів
                    5 - Записати потяги в файл
                    6 - Редагувати потяг
                    0 - Назад
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                printList();
            } else if (f == 2) {
                addTrain(wm);
            } else if (f == 3) {
                delTrain();
            } else if (f == 4) {
                searchTrain();
            } else if (f == 5) {
                writeTrains();
            } else if (f == 6) {
                redactTrain(wm);
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void printList() {
        String[] list = StringList();
        print(list);
    }

    private void print(String[] list) {
        if (list.length == 0) {
            System.out.print("Список потягів пустий\n");
        } else {
            for (String line: list) {
                System.out.println(line);
                System.out.print("\n");
            }
        }
    }

    private String[] StringList() {
        String[] list = new String[trains.length];
        int i = 0;
        for (Train train: trains) {
            list[i] = train.getString();
            i++;
        }
        return list;
    }

    private void addTrain(WagonsMenu wl) {
        expandList();
        trains[trains.length - 1] = new Train(wl);
    }

    private void expandList() {
        Train[] list = new Train[trains.length + 1];
        System.arraycopy(trains, 0, list, 0, trains.length);
        trains = list;
    }

    private void searchTrain() {
        while (true) {
            System.out.print("""
                    За яким критерієм шукати:
                    1 - За ім'ям
                    2 - За швидкістю
                    3 - За пасажиромісткістю
                    4 - За грузомісткістю
                    5 - За розходом
                    0 - Назад
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                searchByName();
            } else if (f == 2) {
                searchBySpeed();
            } else if (f == 3) {
                searchByPass();
            } else if (f == 4) {
                searchByCargo();
            } else if (f == 5) {
                searchByConsumption();
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void searchByName() {
        System.out.print("Введіть ім'я -> ");
        console.nextLine();
        String name = console.nextLine();
        for (Train train: trains){
            if (train.getName().equals(name)) {
                System.out.println(train.getString());
                System.out.print("\n");
            }
        }
    }

    private void searchBySpeed() {
        System.out.print("Мінімальна межа швидкості -> ");
        int min = console.nextInt();
        System.out.print("Максимальна межа швидкості -> ");
        int max = console.nextInt();
        for (Train train: trains){
            if (train.getSpeed() >= min && train.getSpeed() <= max) {
                System.out.println(train.getString());
                System.out.print("\n");
            }
        }
    }

    private void searchByPass() {
        System.out.print("Мінімальна межа пасажиромісткості -> ");
        int min = console.nextInt();
        for (Train train: trains) {
            if (train.getCapacityPassengers() >= min) {
                System.out.println(train.getString());
                System.out.print("\n");
            }
        }
    }

    private void searchByCargo() {
        System.out.print("Мінімальна межа грузомісткості -> ");
        int min = console.nextInt();
        for (Train train: trains) {
            if (train.getCapacityCargo() >= min) {
                System.out.println(train.getString());
                System.out.print("\n");
            }
        }
    }

    private void searchByConsumption() {
        System.out.print("Максимальна межа розходу -> ");
        int max = console.nextInt();
        for (Train train: trains) {
            if (train.getConsumption() <= max) {
                System.out.println(train.getString());
                System.out.print("\n");
            }
        }
    }

    private void writeTrains() {
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

    private Train[] readTrains() {
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
                list[list.length - 1] = new Train(str, wagons);
                str = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private void redactTrain(WagonsMenu wm) {
        while (true) {
            System.out.print("Оберіть поїзд для редагування:\n");
            String[] list = StringList();
            print(list, 1);
            System.out.print("-> ");
            int f = console.nextInt() - 1;
            if (f >= 0 && f < list.length) {
                trains[f].redact(wm);
                return;
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private Train selectTrain() {
        while (true) {
            System.out.print("Оберіть потяг:\n");
            String[] list = StringList();
            print(list, 1);
            System.out.print("-> ");
            int f = console.nextInt() - 1;
            if (f >= 0 && f < list.length) {
                return trains[f].get();
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void print(String[] list, int i) {
        if (list.length == 0) {
            System.out.print("Список потягів пустий\n");
        } else {
            for (;i <= list.length; i++) {
                System.out.println(i + " " + list[i - 1]);
                System.out.print("\n");
            }
        }
    }

    private void delTrain() {
        Train[] newTrains = new Train[trains.length - 1];
        Train del = selectTrain();
        int i = 0;
        for (;i < trains.length; i++) {
            if (trains[i].equals(del)) {
                break;
            }
        }
        System.arraycopy(trains, 0, newTrains, 0, i);
        System.arraycopy(trains, i + 1, newTrains, i, trains.length - i - 1);
        trains = newTrains;
        System.out.print("\n");
    }
}
