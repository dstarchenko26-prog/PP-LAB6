package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;

public class PrintTrainsActionTest extends TestCase {

    public void testExecute() {
        PrintTrainsAction t = new PrintTrainsAction(new TrainsMenu());
        t.io = new simIOClass(0);
        t.execute();
        Train[] trains = new Train[0];
        t = new PrintTrainsAction(new TrainsMenu(trains));
        t.io = new simIOClass(0);
        t.execute();
    }
}