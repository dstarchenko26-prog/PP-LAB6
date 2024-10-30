package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;

public class SortWagonsInTrainActionTest extends TestCase {

    public void testExecute() {
        SortWagonsInTrainAction swta = new SortWagonsInTrainAction(new Train("test"));
        swta.io = new simIOClass(0);
        swta.execute();
    }
}