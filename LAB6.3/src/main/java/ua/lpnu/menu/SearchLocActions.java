package ua.lpnu.menu;

import ua.lpnu.train.wagon.Wagon;

public class SearchLocActions extends Menu {
    private final Wagon[] wagons;

    public SearchLocActions(Wagon[] wagons) {
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
        actions.add(new SearchWagonByTractionAction(wagons));
        actions.add(new SearchWagonByConsumptionAction(wagons));
    }
}
