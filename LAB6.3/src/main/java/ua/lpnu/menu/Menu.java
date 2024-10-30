package ua.lpnu.menu;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Action> actions = new ArrayList<>();
    protected IOclass io = new IOclass();

    public Menu() {
    }

    protected void initActions() {
    }

    protected void printActions() {
        io.print("Меню:\n");
        for (int i = 1;i <= actions.size(); i++) {
            io.print(i + " - " + actions.get(i - 1).getName() + "\n");
        }
        io.print("0 - Вихід\n");
        selectAction();
    }

    protected void selectAction() {
        int f = io.Input(0, actions.size());
        if (f == 0) {
            return;
        }
        io.print("\n");
        actions.get(f - 1).execute();
        io.print("\n");
        printActions();
    }
}