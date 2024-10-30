package ua.lpnu.menu;

import java.io.PrintStream;
import java.util.Scanner;

public class IOclass {
    Scanner scanner = new Scanner(System.in);
    PrintStream printer = System.out;

    public int InputInt() {
        return scanner.nextInt();
    }

    public int Input(int min, int max) {
        while (true) {
            printer.print("-> ");
            int f = InputInt();
            if (f >= min && f <= max) {
                return f;
            } else {
                printer.print("Помилкове введення! Повторіть спробу\n\n");
            }
        }
    }

    public String InputStr() {
        return scanner.nextLine();
    }

    public void print(String line) {
        printer.print(line);
    }

    public void print(String[] lines) {
        for (String line : lines) {
            printer.println(line);
        }
    }

    public String[] print() {
        return null;
    }
}