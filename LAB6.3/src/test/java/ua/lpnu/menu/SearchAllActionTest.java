package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.WagonsMenu;

public class SearchAllActionTest extends TestCase {

    public void testExecute() {
        SearchAllAction sama = new SearchAllAction(new WagonsMenu());
        sama.sam.io = new simIOClass(0);
        sama.execute();
    }
}