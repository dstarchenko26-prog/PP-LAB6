package ua.lpnu.menu;

import junit.framework.TestCase;

public class MenuTest extends TestCase {

    public void testInitActions() {
        TMenu1 tActions = new TMenu1();
        tActions.io = new simIOClass(0);
        tActions.open();
        assertEquals(0, tActions.actions.size());
    }

    public void testSelectAction() {
        String[] t = {"0", "1", "2"};
        TMenu2 tActions = new TMenu2(t);
        int[] fs = {1, 0};
        tActions.io = new simListIOclass(fs);
        tActions.open();
        assertEquals("1", t[0]);
    }
}

class TMenu1 extends Menu {
    TMenu1() {
        super();
        initActions();
    }

    public void open() {
        printActions();
    }
}

class TMenu2 extends Menu {
    String[] t;

    TMenu2(String[] t) {
        super();
        this.t = t;
        initActions();
    }

    public void open() {
        printActions();
    }

    protected void initActions() {
        actions.add(new nullAction(t));
    }
}

class nullAction implements Action {
    String[] t;

    nullAction(String[] t) {
        this.t = t;
    }

    public void execute() {
        t[0] = "1";
    }

    public String getName() {
        return "";
    }
}