package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.wagon.*;

public class SearchLocActionTest extends TestCase {

    public void testExecute() {
        SearchLocAction slma = new SearchLocAction(new WagonsMenu());
        slma.slm.io = new simIOClass(0);
        slma.execute();
    }
}