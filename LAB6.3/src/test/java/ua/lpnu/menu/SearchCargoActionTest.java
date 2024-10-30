package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.WagonsMenu;

public class SearchCargoActionTest extends TestCase {

    public void testExecute() {
        SearchCargoAction scma = new SearchCargoAction(new WagonsMenu());
        scma.scm.io = new simIOClass(0);
        scma.execute();
    }
}