package ua.lpnu.menu;

import ua.lpnu.train.Info;
import ua.lpnu.train.Train;
import ua.lpnu.train.TrainsMenu;
import ua.lpnu.train.wagon.*;

interface Action {
    void execute();
    String getName();
}

class WagonsMenuAction implements Action {
    WagonsActions wm;

    WagonsMenuAction(WagonsMenu wagonsMenu) {
        wm = new WagonsActions(wagonsMenu);
    }

    public void execute() {
        wm.open();
    }

    public String getName() {
        return "Опрацювання вагонів";
    }
}

class TrainsMenuAction implements Action {
    TrainsActions tm;

    TrainsMenuAction(TrainsMenu trainsMenu, WagonsMenu wagonsMenu) {
        tm = new TrainsActions(trainsMenu, wagonsMenu);
    }

    public void execute() {
        tm.open();
    }

    public String getName() {
        return "Опрацювання потягів";
    }
}

class PrintInfoAction implements Action {
    Info info;
    IOclass io = new IOclass();

    PrintInfoAction(Info info) {
        this.info = info;
    }

    public void execute() {
        io.print(info.str());
    }

    public String getName() {
        return "Інфо";
    }
}

class PrintWagonsAction implements Action {
    WagonsMenu wagonsMenu;
    IOclass io = new IOclass();

    PrintWagonsAction(WagonsMenu wagonsMenu) {
        this.wagonsMenu = wagonsMenu;
    }

    public void execute() {
        String[] wagons = wagonsMenu.getString();
        if (wagons.length == 0) {
            io.print("Список вагонів пустий\n");
        } else {
            io.print(wagons);
        }
    }

    public String getName() {
        return "Список всіх вагонів";
    }
}

class AddWagonAction implements Action {
    AddWagonActions awm;

    AddWagonAction(WagonsMenu wagonsMenu) {
        awm = new AddWagonActions(wagonsMenu);

    }

    public void execute() {
        awm.open();
    }

    public String getName() {
        return "Додати вагон";
    }
}

class DeleteWagonAction implements Action {
    WagonsMenu wagonsMenu;
    IOclass io = new IOclass();

    DeleteWagonAction(WagonsMenu wagonsMenu) {
        this.wagonsMenu = wagonsMenu;
    }

    public void execute() {
        io.print("Вагони:\n");
        String[] wagons = wagonsMenu.getString();
        for (int i = 1;i <= wagons.length; i++) {
            io.print(i + " - " + wagons[i - 1] + "\n");
        }
        int f = io.Input(1, wagons.length);
        wagonsMenu.del(f - 1);
    }

    public String getName() {
        return "Видалити вагон";
    }
}

class SearchWagonsAction implements Action {
    SearchWagonsActions swm;

    SearchWagonsAction(WagonsMenu wagonsMenu) {
        swm = new SearchWagonsActions(wagonsMenu);
    }

    public void execute() {
        swm.open();
    }

    public String getName() {
        return "Пошук вагонів";
    }
}

class WriteWagonsAction implements Action {
    WagonsMenu wagonsMenu;
    IOclass io = new IOclass();

    WriteWagonsAction(WagonsMenu wagonsMenu) {
        this.wagonsMenu = wagonsMenu;
    }

    public void execute() {
        wagonsMenu.writeWagons("src/main/resources/wagons.txt");
        io.print("Інформацію про вагони записано\n");
    }

    public String getName() {
        return "Записати вагони в файл";
    }
}

class AddLocAction implements Action {
    WagonsMenu wagonsMenu;
    IOclass io = new IOclass();

    AddLocAction(WagonsMenu wagonsMenu) {
        this.wagonsMenu = wagonsMenu;
    }

    public void execute() {
        io.print("Дайте ім'я локомотиву -> ");
        String name = io.InputStr();
        io.print("Вкажіть максимальну швидкість -> ");
        int speed = io.InputInt();
        io.print("Вкажіть вагу локомотиву -> ");
        int weight = io.InputInt();
        io.print("Вкажіть максимальну тягу локомотива -> ");
        int traction = io.InputInt();
        io.print("Вкажіть розхід палива -> ");
        int consumption = io.InputInt();
        wagonsMenu.add(new Loc(name, speed, weight, traction, consumption));
    }

    public String getName() {
        return "Локомотив";
    }
}

class AddPassAction implements Action {
    WagonsMenu wagonsMenu;
    IOclass io = new IOclass();

    AddPassAction(WagonsMenu wagonsMenu) {
        this.wagonsMenu = wagonsMenu;
    }

    public void execute() {
        io.print("Дайте ім'я пасажирському вагону -> ");
        String name = io.InputStr();
        io.print("Вкажіть максимальну швидкість -> ");
        int speed = io.InputInt();
        io.print("Вкажіть вагу -> ");
        int weight = io.InputInt();
        io.print("Вкажіть к-сть місць -> ");
        int capacity = io.InputInt();
        io.print("Вкажіть рівень комфорту -> ");
        int comfort = io.InputInt();
        io.print("Вкажіть к-сть місць для багажу -> ");
        int amountOfLuggage = io.InputInt();
        wagonsMenu.add(new Passengers(name, speed, weight, capacity, comfort, amountOfLuggage));
    }

    public String getName() {
        return "Пасажирський";
    }
}

class AddCargoAction implements Action {
    WagonsMenu wagonsMenu;
    IOclass io = new IOclass();

    AddCargoAction(WagonsMenu wagonsMenu) {
        this.wagonsMenu = wagonsMenu;
    }

    public void execute() {
        io.print("Дайте ім'я вантажному вагону -> ");
        String name = io.InputStr();
        io.print("Вкажіть максимальну швидкість -> ");
        int speed = io.InputInt();
        io.print("Вкажіть вагу -> ");
        int weight = io.InputInt();
        io.print("Вкажіть грузоємність -> ");
        int capacity = io.InputInt();
        wagonsMenu.add(new Cargo(name, speed, weight, capacity));
    }

    public String getName() {
        return "Вантажний";
    }
}

class SearchLocAction implements Action {
    WagonsMenu wagonsMenu;
    SearchLocActions slm;

    SearchLocAction(WagonsMenu wagonsMenu) {
        this.wagonsMenu = wagonsMenu;
        slm = new SearchLocActions(selectLoc());
    }

    public void execute() {
        slm.open();
    }

    public String getName() {
        return "Локомотив";
    }

    protected Wagon[] selectLoc() {
        Wagon[] list = new Wagon[0];
        Wagon[] wagons = wagonsMenu.getList();
        for (Wagon wagon: wagons) {
            if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Loc")) {
                Wagon[] newList = new Wagon[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                list = newList;
                list[list.length - 1] = wagon;
            }
        }
        return list;
    }
}

class SearchPassAction implements Action {
    WagonsMenu wagonsMenu;
    SearchPassActions spm;

    SearchPassAction(WagonsMenu wagonsMenu) {
        this.wagonsMenu = wagonsMenu;
        spm = new SearchPassActions(selectPass());
    }

    public void execute() {
        spm.open();
    }

    public String getName() {
        return "Пасажирський";
    }

    protected Wagon[] selectPass() {
        Wagon[] list = new Wagon[0];
        Wagon[] wagons = wagonsMenu.getList();
        for (Wagon wagon: wagons) {
            if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Passengers")) {
                Wagon[] newList = new Wagon[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                list = newList;
                list[list.length - 1] = wagon;
            }
        }
        return list;
    }
}

class SearchCargoAction implements Action {
    WagonsMenu wagonsMenu;
    SearchCargoActions scm;

    SearchCargoAction(WagonsMenu wagonsMenu) {
        this.wagonsMenu = wagonsMenu;
        scm = new SearchCargoActions(selectCargo());
    }

    public void execute() {
        scm.open();
    }

    public String getName() {
        return "Вантажний";
    }

    protected Wagon[] selectCargo() {
        Wagon[] list = new Wagon[0];
        Wagon[] wagons = wagonsMenu.getList();
        for (Wagon wagon: wagons) {
            if (wagon.getClass().getName().equals("ua.lpnu.train.wagon.Cargo")) {
                Wagon[] newList = new Wagon[list.length + 1];
                System.arraycopy(list, 0, newList, 0, list.length);
                list = newList;
                list[list.length - 1] = wagon;
            }
        }
        return list;
    }
}

class SearchAllAction implements Action {
    WagonsMenu wagonsMenu;
    SearchAllActions sam;

    SearchAllAction(WagonsMenu wagonsMenu) {
        this.wagonsMenu = wagonsMenu;
        sam = new SearchAllActions(wagonsMenu.getList());
    }

    public void execute() {
        sam.open();
    }

    public String getName() {
        return "Всі";
    }
}

class SearchWagonByNameAction implements Action {
    Wagon[] wagons;
    IOclass io = new IOclass();

    public SearchWagonByNameAction(Wagon[] wagons) {
        this.wagons = wagons;
    }

    public void execute() {
        io.print("Введіть ім'я -> ");
        String name = io.InputStr();
        for (Wagon wagon: wagons){
            if (wagon.getName().equals(name)) {
                io.print(wagon.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За ім'ям";
    }
}

class SearchWagonBySpeedAction implements Action {
    Wagon[] wagons;
    IOclass io = new IOclass();

    public SearchWagonBySpeedAction(Wagon[] wagons) {
        this.wagons = wagons;
    }

    public void execute() {
        io.print("Мінімальна межа швидкості -> ");
        int min = io.InputInt();
        io.print("Максимальна межа швидкості -> ");
        int max = io.InputInt();
        for (Wagon wagon: wagons){
            if (wagon.getSpeed() >= min && wagon.getSpeed() <= max) {
                io.print(wagon.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За швидкістю";
    }
}

class SearchWagonByWeightAction implements Action {
    Wagon[] wagons;
    IOclass io = new IOclass();

    public SearchWagonByWeightAction(Wagon[] wagons) {
        this.wagons = wagons;
    }

    public void execute() {
        io.print("Максимальна межа ваги -> ");
        int max = io.InputInt();
        for (Wagon wagon: wagons) {
            if (wagon.getWeight() <= max) {
                io.print(wagon.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За вагою";
    }
}

class SearchWagonByTractionAction implements Action {
    Wagon[] wagons;
    IOclass io = new IOclass();

    public SearchWagonByTractionAction(Wagon[] wagons) {
        this.wagons = wagons;
    }

    public void execute() {
        io.print("Мінімальна межа тяги -> ");
        int min = io.InputInt();
        for (Wagon wagon: wagons) {
            if (wagon.getTraction() >= min) {
                io.print(wagon.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За тягою";
    }
}

class SearchWagonByConsumptionAction implements Action {
    Wagon[] wagons;
    IOclass io = new IOclass();

    public SearchWagonByConsumptionAction(Wagon[] wagons) {
        this.wagons = wagons;
    }

    public void execute() {
        io.print("Максимальна межа розходу -> ");
        int max = io.InputInt();
        for (Wagon wagon: wagons) {
            if (wagon.getConsumption() <= max) {
                io.print(wagon.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За розходом";
    }
}

class SearchWagonByCapacityAction implements Action {
    Wagon[] wagons;
    IOclass io = new IOclass();

    public SearchWagonByCapacityAction(Wagon[] wagons) {
        this.wagons = wagons;
    }

    public void execute() {
        io.print("Мінімальна межа місткості -> ");
        int min = io.InputInt();
        for (Wagon wagon: wagons) {
            if (wagon.getCapacity() >= min) {
                io.print(wagon.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За місткістю";
    }
}

class SearchWagonByComfortAction implements Action {
    Wagon[] wagons;
    IOclass io = new IOclass();

    public SearchWagonByComfortAction(Wagon[] wagons) {
        this.wagons = wagons;
    }

    public void execute() {
        io.print("Мінімальна межа рівня комфорту -> ");
        int min = io.InputInt();
        for (Wagon wagon: wagons) {
            if (wagon.getComfort() >= min) {
                io.print(wagon.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За комфортом";
    }
}

class PrintTrainsAction implements Action {
    TrainsMenu trainsMenu;
    IOclass io = new IOclass();

    PrintTrainsAction(TrainsMenu trainsMenu) {
        this.trainsMenu = trainsMenu;
    }

    public void execute() {
        String[] trains = trainsMenu.getString();
        if (trains.length == 0) {
            io.print("Список потягів пустий\n");
        } else {
            io.print(trains);
        }
    }

    public String getName() {
        return "Список всіх потягів";
    }
}

class AddTrainAction implements Action {
    TrainsMenu trainsMenu;
    WagonsMenu wagonsMenu;
    IOclass io = new IOclass();

    AddTrainAction(TrainsMenu trainsMenu, WagonsMenu wagonsMenu) {
        this.trainsMenu = trainsMenu;
        this.wagonsMenu = wagonsMenu;
    }

    public void execute() {
        io.print("Дайте потягу ім'я -> ");
        String name = io.InputStr();
        io.print("\n");
        Train train = new Train(name);
        while (true) {
            io.print("Вагони:\n");
            String[] wagons = wagonsMenu.getString();
            for (int i = 1;i <= wagons.length; i++) {
                io.print(i + " - " + wagons[i - 1] + "\n");
            }
            int f = io.Input(1, wagons.length);
            Wagon add = wagonsMenu.getWagon(f - 1);
            if (train.predUpdate(add)) {
                train.add(add);
            } else {
                io.print("Помилка! Вага перевищить тягу\n\n");
                continue;
            }
            io.print("Завершити (1 - Так)? -> ");
            f = io.InputInt();
            if (f == 1) {
                break;
            }
            io.print("\n");
        }
        trainsMenu.add(train);
    }

    public String getName() {
        return "Додати потяг";
    }
}

class DeleteTrainAction implements Action {
    TrainsMenu trainsMenu;
    IOclass io = new IOclass();

    DeleteTrainAction(TrainsMenu trainsMenu) {
        this.trainsMenu = trainsMenu;
    }

    public void execute() {
        io.print("Потяги:\n");
        String[] trains = trainsMenu.getString();
        for (int i = 1;i <= trains.length; i++) {
            io.print(i + " - " + trains[i - 1] + "\n");
        }
        int f = io.Input(1, trains.length);
        trainsMenu.del(f - 1);
    }

    public String getName() {
        return "Видалити потяг";
    }
}

class SearchTrainsAction implements Action {
    SearchTrainsActions stm;

    SearchTrainsAction(TrainsMenu trainsMenu) {
        stm = new SearchTrainsActions(trainsMenu);
    }

    public void execute() {
        stm.open();
    }

    public String getName() {
        return "Пошук потягів";
    }
}

class WriteTrainsAction implements Action {
    TrainsMenu trainsMenu;
    IOclass io = new IOclass();

    WriteTrainsAction(TrainsMenu trainsMenu) {
        this.trainsMenu = trainsMenu;
    }

    public void execute() {
        trainsMenu.writeTrains("src/main/resources/trains");
        io.print("Інформація про потяги записана\n");
    }

    public String getName() {
        return "Записати потяги в файл";
    }
}

class RedactTrainsAction implements Action {
    TrainsMenu trainsMenu;
    IOclass io = new IOclass();
    RedactTrainActions rtm;

    RedactTrainsAction(TrainsMenu trainsMenu, WagonsMenu wagonsMenu) {
        this.trainsMenu = trainsMenu;
        rtm = new RedactTrainActions(wagonsMenu);
    }

    public void execute() {
        io.print("Оберіть потяг, який хочете відредагувати:\n");
        String[] trains = trainsMenu.getString();
        for (int i = 1;i <= trains.length; i++) {
            io.print(i + " - " + trains[i - 1] + "\n");
        }
        int f = io.Input(1, trains.length);
        rtm.setTrain(trainsMenu.get(f - 1));
        rtm.open();
    }

    public String getName() {
        return "Редагувати потяг";
    }
}

class SearchTrainByNameAction implements Action {
    Train[] trains;
    IOclass io = new IOclass();

    public SearchTrainByNameAction(Train[] trains) {
        this.trains = trains;
    }

    public void execute() {
        io.print("Введіть ім'я -> ");
        String name = io.InputStr();
        for (Train train: trains){
            if (train.getName().equals(name)) {
                io.print(train.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За ім'ям";
    }
}

class SearchTrainsBySpeedAction implements Action {
    Train[] trains;
    IOclass io = new IOclass();

    public SearchTrainsBySpeedAction(Train[] trains) {
        this.trains = trains;
    }

    public void execute() {
        io.print("Мінімальна межа швидкості -> ");
        int min = io.InputInt();
        io.print("Максимальна межа швидкості -> ");
        int max = io.InputInt();
        for (Train train: trains){
            if (train.getSpeed() >= min && train.getSpeed() <= max) {
                io.print("\n" + train.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За швидкістю";
    }
}

class SearchTrainsByPassAction implements Action {
    Train[] trains;
    IOclass io = new IOclass();

    public SearchTrainsByPassAction(Train[] trains) {
        this.trains = trains;
    }

    public void execute() {
        io.print("Мінімальна межа пасажиромісткості -> ");
        int min = io.InputInt();
        for (Train train: trains){
            if (train.getCapacityPassengers() >= min) {
                io.print("\n" + train.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За пасажиромісткістю";
    }
}

class SearchTrainsByCargoAction implements Action {
    Train[] trains;
    IOclass io = new IOclass();

    public SearchTrainsByCargoAction(Train[] trains) {
        this.trains = trains;
    }

    public void execute() {
        io.print("Мінімальна межа грузомісткості -> ");
        int min = io.InputInt();
        for (Train train: trains){
            if (train.getCapacityCargo() >= min) {
                io.print("\n" + train.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За грузомісткістю";
    }
}

class SearchTrainsByConsumptionAction implements Action {
    Train[] trains;
    IOclass io = new IOclass();

    public SearchTrainsByConsumptionAction(Train[] trains) {
        this.trains = trains;
    }

    public void execute() {
        io.print("Максимальна межа розходу -> ");
        int max = io.InputInt();
        for (Train train: trains){
            if (train.getConsumption() <= max) {
                io.print("\n" + train.getString() + "\n");
            }
        }
    }

    public String getName() {
        return "За розходом";
    }
}

class PrintTrainAction implements Action {
    Train train;
    IOclass io = new IOclass();

    PrintTrainAction(Train train) {
        this.train = train;
    }

    public void execute() {
        io.print(train.getString() + "\n");
    }

    public String getName() {
        return "Інформація про потяг";
    }
}

class AddWagonsToTrainAction implements Action {
    Train train;
    WagonsMenu wagonsMenu;
    IOclass io = new IOclass();

    AddWagonsToTrainAction(Train train, WagonsMenu wagonsMenu) {
        this.train = train;
        this.wagonsMenu = wagonsMenu;
    }

    public void execute() {
        while (true) {
            io.print("Вагони:\n");
            String[] wagons = wagonsMenu.getString();
            for (int i = 1;i <= wagons.length; i++) {
                io.print(i + " - " + wagons[i - 1] + "\n");
            }
            int f = io.Input(1, wagons.length);
            Wagon add = wagonsMenu.getWagon(f - 1);
            if (train.predUpdate(add)) {
                train.add(add);
            } else {
                io.print("Помилка! Вага перевищить тягу\n\n");
                continue;
            }
            io.print("Завершити (1 - Так)? -> ");
            f = io.InputInt();
            io.print("\n");
            if (f == 1) {
                break;
            }
        }
    }

    public String getName() {
        return "Додати вагони";
    }
}

class DeleteWagonsInTrainAction implements Action {
    Train train;
    IOclass io = new IOclass();

    DeleteWagonsInTrainAction(Train train) {
        this.train = train;
    }

    public void execute() {
        while (true) {
            io.print("Вагони:\n");
            Wagon[] wagons = train.getWagons();
            if (wagons.length < 1) {
                break;
            }
            for (int i = 1;i <= wagons.length; i++) {
                io.print(i + " - " + wagons[i - 1].getString() + "\n");
            }
            int f = io.Input(1, wagons.length);
            Wagon del = wagons[f - 1];
            if (train.delUpdate(del)) {
                train.del( f - 1);
            } else {
                io.print("Помилка! Вага перевищить тягу\n\n");
                continue;
            }
            io.print("Завершити (1 - Так)? -> ");
            f = io.InputInt();
            System.out.print("\n");
            if (f == 1) {
                break;
            }
        }
    }

    public String getName() {
        return "Видалити вагони";
    }
}

class SortWagonsInTrainAction implements Action {
    Train train;
    IOclass io = new IOclass();

    SortWagonsInTrainAction(Train train) {
        this.train = train;
    }

    public void execute() {
        train.sort();
        io.print("Вагони посортовані\n");
    }

    public String getName() {
        return "Посортувати вагони";
    }
}
