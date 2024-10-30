package ua.lpnu.menu;

import ua.lpnu.train.TrainsMenu;
import ua.lpnu.train.wagon.WagonsMenu;

public class TrainsActions  extends Menu {
    private final TrainsMenu trainsMenu;
    private final WagonsMenu wagonsMenu;

    public TrainsActions(TrainsMenu trainsMenu, WagonsMenu wagonsMenu) {
        super();
        this.trainsMenu = trainsMenu;
        this.wagonsMenu = wagonsMenu;
        initActions();
    }

    public void open() {
        printActions();
    }

    protected void initActions() {
        actions.add(new PrintTrainsAction(trainsMenu));
        actions.add(new AddTrainAction(trainsMenu, wagonsMenu));
        actions.add(new DeleteTrainAction(trainsMenu));
        actions.add(new SearchTrainsAction(trainsMenu));
        actions.add(new WriteTrainsAction(trainsMenu));
        actions.add(new RedactTrainsAction(trainsMenu, wagonsMenu));
    }
}
