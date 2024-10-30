package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.WagonsMenu;

public class WriteWagonsActionTest extends TestCase {

    public void testExecute() {
        WriteWagonsAction wwa = new WriteWagonsAction(new WagonsMenu());
        wwa.io = new simIOClass(0);
        wwa.execute();
    }
}