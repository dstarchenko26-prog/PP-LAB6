package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.TrainsMenu;

public class SearchTrainsActionTest extends TestCase {

    public void testExecute() {
        SearchTrainsAction stma = new SearchTrainsAction(new TrainsMenu());
        stma.stm.io = new simIOClass(0);
        stma.execute();
    }
}