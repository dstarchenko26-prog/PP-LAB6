package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.TrainsMenu;

public class WriteTrainsActionTest extends TestCase {

    public void testExecute() {
        WriteTrainsAction wta = new WriteTrainsAction(new TrainsMenu());
        wta.io = new simIOClass(0);
        wta.execute();
    }
}