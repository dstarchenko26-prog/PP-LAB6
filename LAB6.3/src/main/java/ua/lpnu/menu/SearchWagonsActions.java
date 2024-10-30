package ua.lpnu.menu;

import ua.lpnu.train.wagon.WagonsMenu;

public class SearchWagonsActions extends Menu {
    private final WagonsMenu wagonsMenu;

    public SearchWagonsActions(WagonsMenu wagonsMenu) {
        super();
        this.wagonsMenu = wagonsMenu;
        initActions();
    }

    public void open() {
        printActions();
    }

    protected void initActions() {
        actions.add(new SearchLocAction(wagonsMenu));
        actions.add(new SearchPassAction(wagonsMenu));
        actions.add(new SearchCargoAction(wagonsMenu));
        actions.add(new SearchAllAction(wagonsMenu));
    }
}
