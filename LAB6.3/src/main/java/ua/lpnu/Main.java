package ua.lpnu;

import ua.lpnu.menu.MainMenu;
import ua.lpnu.train.Info;
import ua.lpnu.train.TrainsMenu;
import ua.lpnu.train.wagon.WagonsMenu;

public class Main {

    public static void main(String[] args) {
        MainMenu mm = new MainMenu(new WagonsMenu(), new TrainsMenu(), new Info());
        mm.open();
    }
}