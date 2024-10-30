package ua.lpnu.menu;

import junit.framework.TestCase;
import ua.lpnu.train.Info;

public class PrintInfoActionTest extends TestCase {

    public void testExecute() {
        PrintInfoAction t = new PrintInfoAction(new Info());
        t.io = new simIOClass(0);
        t.execute();
    }
}