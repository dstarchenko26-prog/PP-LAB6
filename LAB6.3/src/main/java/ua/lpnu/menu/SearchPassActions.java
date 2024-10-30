package ua.lpnu.menu;

import ua.lpnu.train.wagon.Wagon;

public class SearchPassActions extends Menu {
    private final Wagon[] wagons;

    public SearchPassActions(Wagon[] wagons) {
        super();
        this.wagons = wagons;
        initActions();
    }

    public void open() {
        printActions();
    }

    protected void initActions() {
        actions.add(new SearchWagonByNameAction(wagons));
        actions.add(new SearchWagonBySpeedAction(wagons));
        actions.add(new SearchWagonByWeightAction(wagons));
        actions.add(new SearchWagonByComfortAction(wagons));
        actions.add(new SearchWagonByCapacityAction(wagons));
    }
}
