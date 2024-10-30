package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.WagonsMenu;

public class SearchWagonsActionTest extends TestCase {

    public void testExecute() {
        SearchWagonsAction swma = new SearchWagonsAction(new WagonsMenu());
        swma.swm.io = new simIOClass(0);
        swma.execute();
    }
}