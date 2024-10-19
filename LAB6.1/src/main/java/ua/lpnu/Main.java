package ua.lpnu;

import ua.lpnu.train.Info;
import ua.lpnu.train.TrainsMenu;
import ua.lpnu.train.wagon.WagonsMenu;

import java.util.Scanner;

public class Main {
    static Scanner console = new Scanner(System.in);
    static WagonsMenu wagons = new WagonsMenu();
    static TrainsMenu trains = new TrainsMenu();
    static Info info = new Info();

    public static void main(String[] args) {
        selectAction();
    }

    static public void selectAction() {
        while (true) {
            System.out.print("""
                    Меню:
                    1 - Опрацювання вагонів
                    2 - Опрацювання потягів
                    3 - Інформація
                    0 - Вихід
                    ->""");
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 0) {
                return;
            } else if (f == 1) {
                wagons.selectAction();
            } else if (f == 2) {
                trains.selectAction(wagons);
            } else if (f == 3) {
                info.print();
            } else {
                System.out.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }
}