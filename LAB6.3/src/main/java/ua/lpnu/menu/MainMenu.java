package ua.lpnu.menu;

import ua.lpnu.train.Info;
import ua.lpnu.train.TrainsMenu;
import ua.lpnu.train.wagon.WagonsMenu;

public class MainMenu extends Menu {
    private TrainsMenu trainsMenu;
    private WagonsMenu wagonsMenu;
    private Info info;

    public MainMenu(WagonsMenu wagonsMenu, TrainsMenu trainsMenu, Info info) {
        super();
        this.trainsMenu = trainsMenu;
        this.wagonsMenu = wagonsMenu;
        this.info = info;
        initActions();
    }

    public void open() {
        printActions();
    }

    protected void initActions() {
        actions.add(new WagonsMenuAction(wagonsMenu));
        actions.add(new TrainsMenuAction(trainsMenu, wagonsMenu));
        actions.add(new PrintInfoAction(info));
    }
}
