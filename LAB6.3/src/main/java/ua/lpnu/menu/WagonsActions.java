package ua.lpnu.menu;

import ua.lpnu.train.wagon.WagonsMenu;

public class WagonsActions extends Menu {
    private final WagonsMenu wagonsMenu;

    public WagonsActions(WagonsMenu wagonsMenu) {
        super();
        this.wagonsMenu = wagonsMenu;
        initActions();
    }

    public void open() {
        printActions();
    }

    protected void initActions() {
        actions.add(new PrintWagonsAction(wagonsMenu));
        actions.add(new AddWagonAction(wagonsMenu));
        actions.add(new DeleteWagonAction(wagonsMenu));
        actions.add(new SearchWagonsAction(wagonsMenu));
        actions.add(new WriteWagonsAction(wagonsMenu));
    }
}
