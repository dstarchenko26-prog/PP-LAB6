package ua.lpnu.menu;

import ua.lpnu.train.Train;
import ua.lpnu.train.wagon.WagonsMenu;

public class RedactTrainActions extends Menu{
    private final WagonsMenu wagonsMenu;
    public Train train;

    public RedactTrainActions(WagonsMenu wagonsMenu) {
        super();
        this.wagonsMenu = wagonsMenu;
        initActions();
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void open() {
        printActions();
    }

    protected void initActions() {
        actions.add(new PrintTrainAction(train));
        actions.add(new AddWagonsToTrainAction(train, wagonsMenu));
        actions.add(new DeleteWagonsInTrainAction(train));
        actions.add(new SortWagonsInTrainAction(train));
    }
}
