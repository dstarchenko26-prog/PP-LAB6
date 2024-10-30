package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.WagonsMenu;

public class WagonsMenuActionTest extends TestCase {

    public void testExecute() {
        WagonsMenuAction wma = new WagonsMenuAction(new WagonsMenu());
        wma.wm.io = new simIOClass(0);
        wma.execute();
    }
}