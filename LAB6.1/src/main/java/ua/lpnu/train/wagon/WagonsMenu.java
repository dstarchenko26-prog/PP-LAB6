package ua.lpnu.train.wagon;

import java.io.*;
import java.util.Scanner;

public class WagonsMenu {
    Scanner console = new Scanner(System.in);
    private final String file = "src/main/resources/wagons.txt";
    private Wagon[] wagons = readWagons(file);

    public WagonsMenu() {
    }

    public WagonsMenu(Wagon[] wagons) {
        this.wagons = wagons;
    }

    public void selectAction() {
        while (true) {
            System.out.print("""
                    Меню:
                    1 - Список всіх вагонів
                    2 - Додати вагон
                    3 - Видалити вагон
                    4 - Пошук вагонів
                    5 - Записати вагони в файл
                    0 - Назад
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                printList();
            } else if (f == 2) {
                addWagon();
            } else if (f == 3) {
                delWagon();
            } else if (f == 4) {
                searchWagon();
            } else if (f == 5) {
                writeWagons(file);
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void printList() {
        String[] list = StringList();
        print(list);
        System.out.print("\n");
    }

    private void print(String[] list) {
        if (list.length == 0) {
            System.out.print("Список вагонів пустий\n");
        } else {
            for (String line: list) {
                System.out.println(line);
            }
        }
    }

    private String[] StringList() {
        String[] list = new String[wagons.length];
        int i = 0;
        for (Wagon wagon: wagons) {
            list[i] = wagon.getString();
            i++;
        }
        return list;
    }

    private void addWagon() {
        while (true) {
            System.out.print("""
                    Оберіть тип вагона:
                    1 - Локомотив
                    2 - Пасажирський
                    3 - Вантажний
                    0 - Назад
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                addLoc();
            } else if (f == 2) {
                addPass();
            } else if (f == 3) {
                addCargo();
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void addLoc() {
        System.out.print("Дайте ім'я локомотиву -> ");
        console.nextLine();
        String name = console.nextLine();
        System.out.print("Вкажіть максимальну швидкість -> ");
        int speed = console.nextInt();
        System.out.print("Вкажіть вагу локомотиву -> ");
        int weight = console.nextInt();
        System.out.print("Вкажіть максимальну тягу локомотива -> ");
        int traction = console.nextInt();
        System.out.print("Вкажіть розхід палива -> ");
        int consumption = console.nextInt();
        System.out.print("\n");
        expandList();
        wagons[wagons.length - 1] = new Loc(name, speed, weight, traction, consumption);
    }

    private void addPass() {
        System.out.print("Дайте ім'я пасажирському вагону -> ");
        console.nextLine();
        String name = console.nextLine();
        System.out.print("Вкажіть максимальну швидкість -> ");
        int speed = console.nextInt();
        System.out.print("Вкажіть вагу -> ");
        int weight = console.nextInt();
        System.out.print("Вкажіть к-сть місць -> ");
        int capacity = console.nextInt();
        System.out.print("Вкажіть рівень комфорту -> ");
        int comfort = console.nextInt();
        System.out.print("Вкажіть к-сть місць для багажу -> ");
        int amountOfLuggage = console.nextInt();
        System.out.print("\n");
        expandList();
        wagons[wagons.length - 1] = new Passengers(name, speed, weight, capacity, comfort, amountOfLuggage);
    }

    private void addCargo() {
        System.out.print("Дайте ім'я вантажному вагону -> ");
        console.nextLine();
        String name = console.nextLine();
        System.out.print("Вкажіть максимальну швидкість -> ");
        int speed = console.nextInt();
        System.out.print("Вкажіть вагу -> ");
        int weight = console.nextInt();
        System.out.print("Вкажіть грузоємність -> ");
        int capacity = console.nextInt();
        System.out.print("\n");
        expandList();
        wagons[wagons.length - 1] = new Cargo(name, speed, weight, capacity);
    }

    private void expandList() {
        Wagon[] newList = new Wagon[wagons.length + 1];
        System.arraycopy(wagons, 0, newList, 0, wagons.length);
        wagons = newList;
    }

    private void searchWagon() {
        while (true) {
            System.out.print("""
                    Які вагони шукати:
                    1 - Локомотиви
                    2 - Пасажирські
                    3 - Вантажні
                    4 - Всі
                    0 - Назад
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                searchLoc();
            } else if (f == 2) {
                searchPass();
            } else if (f == 3) {
                searchCargo();
            } else if (f == 4) {
                searchAll();
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void searchLoc() {
        Wagon[] list = new Wagon[0];
        for (Wagon wagon: wagons) {
            if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Loc")) {
                Wagon[] newList = new Wagon[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                list = newList;
                list[list.length - 1] = wagon;
            }
        }
        searchByLoc(list);
    }

    private void searchPass() {
        Wagon[] list = new Wagon[0];
        for (Wagon wagon: wagons) {
            if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Passengers")) {
                Wagon[] newList = new Wagon[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                list = newList;
                list[list.length - 1] = wagon;
            }
        }
        searchByPass(list);
    }

    private void searchCargo() {
        Wagon[] list = new Wagon[0];
        for (Wagon wagon: wagons) {
            if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Cargo")) {
                Wagon[] newList = new Wagon[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                list = newList;
                list[list.length - 1] = wagon;
            }
        }
        searchByCargo(list);
    }

    private void searchAll() {
        searchByAll(wagons);
    }

    private void searchByLoc(Wagon[] Wagons) {
        while (true) {
            System.out.print("""
                    За яким критерієм шукати:
                    1 - За ім'ям
                    2 - За швидкістю
                    3 - За вагою
                    4 - За тягою
                    5 - За розходом
                    0 - Назад
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                searchByName(Wagons);
            } else if (f == 2) {
                searchBySpeed(Wagons);
            } else if (f == 3) {
                searchByWeight(Wagons);
            } else if (f == 4) {
                searchByTraction(Wagons);
            } else if (f == 5) {
                searchByConsumption(Wagons);
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void searchByPass(Wagon[] Wagons) {
        while (true) {
            System.out.print("""
                    За яким критерієм шукати:
                    1 - За ім'ям
                    2 - За швидкістю
                    3 - За вагою
                    4 - За комфортом
                    5 - За кількістю місць
                    0 - Назад
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                searchByName(Wagons);
            } else if (f == 2) {
                searchBySpeed(Wagons);
            } else if (f == 3) {
                searchByWeight(Wagons);
            } else if (f == 4) {
                searchByComfort(Wagons);
            } else if (f == 5) {
                searchByCapacity(Wagons);
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void searchByCargo(Wagon[] Wagons) {
        while (true) {
            System.out.print("""
                    За яким критерієм шукати:
                    1 - За ім'ям
                    2 - За швидкістю
                    3 - За вагою
                    4 - За місткістю
                    0 - Назад
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                searchByName(Wagons);
            } else if (f == 2) {
                searchBySpeed(Wagons);
            } else if (f == 3) {
                searchByWeight(Wagons);
            } else if (f == 4) {
                searchByCapacity(Wagons);
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void searchByAll(Wagon[] Wagons) {
        while (true) {
            System.out.print("""
                    За яким критерієм шукати:
                    1 - За ім'ям
                    2 - За швидкістю
                    3 - За вагою
                    0 - Назад
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                searchByName(Wagons);
            } else if (f == 2) {
                searchBySpeed(Wagons);
            } else if (f == 3) {
                searchByWeight(Wagons);
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void searchByName(Wagon[] Wagons) {
        System.out.print("Введіть ім'я -> ");
        console.nextLine();
        String name = console.nextLine();
        for (Wagon wagon: Wagons){
            if (wagon.getName().equals(name)) {
                System.out.println(wagon.getString());
            }
        }
        System.out.print("\n");
    }

    private void searchBySpeed(Wagon[] Wagons) {
        System.out.print("Мінімальна межа швидкості -> ");
        int min = console.nextInt();
        System.out.print("Максимальна межа швидкості -> ");
        int max = console.nextInt();
        for (Wagon wagon: Wagons){
            if (wagon.getSpeed() >= min && wagon.getSpeed() <= max) {
                System.out.println(wagon.getString());
            }
        }
        System.out.print("\n");
    }

    private void searchByWeight(Wagon[] Wagons) {
        System.out.print("Максимальна межа ваги -> ");
        int max = console.nextInt();
        for (Wagon wagon: Wagons) {
            if (wagon.getWeight() <= max) {
                System.out.println(wagon.getString());
            }
        }
        System.out.print("\n");
    }

    private void searchByTraction(Wagon[] Wagons) {
        System.out.print("Мінімальна межа тяги -> ");
        int min = console.nextInt();
        for (Wagon wagon: Wagons) {
            if (wagon.getTraction() >= min) {
                System.out.println(wagon.getString());
            }
        }
        System.out.print("\n");
    }

    private void searchByConsumption(Wagon[] Wagons) {
        System.out.print("Максимальна межа розходу -> ");
        int max = console.nextInt();
        for (Wagon wagon: Wagons) {
            if (wagon.getConsumption() <= max) {
                System.out.println(wagon.getString());
            }
        }
        System.out.print("\n");
    }

    private void searchByComfort(Wagon[] Wagons) {
        System.out.print("Мінімальна межа рівня комфорту -> ");
        int min = console.nextInt();
        for (Wagon wagon: Wagons) {
            if (wagon.getComfort() >= min) {
                System.out.println(wagon.getString());
            }
        }
        System.out.print("\n");
    }

    private void searchByCapacity(Wagon[] Wagons) {
        System.out.print("Мінімальна межа місткості -> ");
        int min = console.nextInt();
        for (Wagon wagon: Wagons) {
            if (wagon.getCapacity() >= min) {
                System.out.println(wagon.getString());
            }
        }
        System.out.print("\n");
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

    public Wagon selectWagon() {
        while (true) {
            System.out.print("Оберіть вагон:\n");
            String[] list = StringList();
            print(list, 1);
            System.out.print("-> ");
            int f = console.nextInt() - 1;
            if (f >= 0 && f < list.length) {
                return wagons[f].get();
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    private void print(String[] list, int i) {
        if (list.length == 0) {
            System.out.print("Список вагонів пустий\n");
        } else {
            for (;i <= list.length; i++) {
                System.out.println(i + " " + list[i - 1]);
            }
        }
    }

    private void delWagon() {
        Wagon[] newWagons = new Wagon[wagons.length - 1];
        Wagon del = selectWagon();
        int i = 0;
        for (;i < wagons.length; i++) {
            if (wagons[i].equals(del)) {
                break;
            }
        }
        System.arraycopy(wagons, 0, newWagons, 0, i);
        System.arraycopy(wagons, i + 1, newWagons, i, wagons.length - i - 1);
        wagons = newWagons;
        System.out.print("\n");
    }

    public int getValue(String field, Wagon wagon) {
        return switch (field) {
            case "speed" -> wagon.getSpeed();
            case "weight" -> wagon.getWeight();
            case "traction" -> wagon.getTraction();
            case "consumption" -> wagon.getConsumption();
            case "capacity" -> wagon.getCapacity();
            case "comfort" -> wagon.getComfort();
            case "luggage" -> wagon.getAmountOfLuggage();
            default -> 0;
        };
    }
}