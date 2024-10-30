package ua.lpnu.menu;

import ua.lpnu.train.TrainsMenu;

public class SearchTrainsActions extends Menu{
    private final TrainsMenu trainsMenu;

    public SearchTrainsActions(TrainsMenu trainsMenu) {
        super();
        this.trainsMenu = trainsMenu;
        initActions();
    }

    public void open() {
        printActions();
    }

    protected void initActions() {
        actions.add(new SearchTrainByNameAction(trainsMenu.getList()));
        actions.add(new SearchTrainsBySpeedAction(trainsMenu.getList()));
        actions.add(new SearchTrainsByPassAction(trainsMenu.getList()));
        actions.add(new SearchTrainsByCargoAction(trainsMenu.getList()));
        actions.add(new SearchTrainsByConsumptionAction(trainsMenu.getList()));
    }
}
