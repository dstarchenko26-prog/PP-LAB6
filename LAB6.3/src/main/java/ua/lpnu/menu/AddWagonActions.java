package ua.lpnu.menu;

import ua.lpnu.train.wagon.WagonsMenu;

public class AddWagonActions extends Menu {
    private WagonsMenu wagonsMenu;

    public AddWagonActions(WagonsMenu wagonsMenu) {
        super();
        this.wagonsMenu = wagonsMenu;
        initActions();
    }

    public void open() {
        printActions();
    }

    protected void initActions() {
        actions.add(new AddLocAction(wagonsMenu));
        actions.add(new AddPassAction(wagonsMenu));
        actions.add(new AddCargoAction(wagonsMenu));
    }
}