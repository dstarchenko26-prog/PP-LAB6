package ua.lpnu.menu;

import ua.lpnu.train.wagon.Wagon;

public class SearchCargoActions extends Menu {
    private final Wagon[] wagons;

    public SearchCargoActions(Wagon[] wagons) {
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
        actions.add(new SearchWagonByCapacityAction(wagons));
    }
}
