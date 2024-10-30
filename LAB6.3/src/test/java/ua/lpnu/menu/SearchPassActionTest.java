package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.WagonsMenu;

public class SearchPassActionTest extends TestCase {

    public void testExecute() {
        SearchPassAction spma = new SearchPassAction(new WagonsMenu());
        spma.spm.io = new simIOClass(0);
        spma.execute();
    }
}