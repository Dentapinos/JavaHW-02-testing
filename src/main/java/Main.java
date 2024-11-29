import homework.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Dancer> dancers = new ArrayList<>();
        dancers.add(new Dancer("Vasja", DressCode.GREEN_STYLE));
        dancers.add(new Dancer("Veronika", DressCode.GREEN_STYLE));
        dancers.add(new Dancer("Vasja", DressCode.BLACK_AND_WHITE));
        dancers.add(new Dancer("Alevtina", DressCode.RED_AND_BLACK));
        dancers.add(new Dancer("Denis", DressCode.YELLOW_STYLE));
        dancers.add(new Dancer("Nikita", DressCode.GREEN_STYLE));
        dancers.add(new Dancer("Maksim", DressCode.PURE_WHITE));

        Security security = new Security(DayOfWeek.MONDAY);

        //Если изменить capacity(вместительность) на 2, то сможет зайти только 2 человека в клуб
        Club club = new Club(50, security, DressCode.GREEN_STYLE);

        for (Dancer dancer : dancers) {
            try {
                System.out.println(club.letPass(dancer));
            } catch (DancerNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        for (Dancer dancer : club.getDancers()) {
            dancer.setDebt(new Random().nextBoolean());
            if (dancer.isDebt()) {
                System.out.println(dancer.getName() + " задолжал...");
            }
        }

        if (!club.getDancers().isEmpty()) {
            System.out.println("Прошло 3 часа...");

            for (Dancer dancer : new ArrayList<>(club.getDancers())) {
                club.letOut(dancer);
                if (dancer.isDebt()) {
                    System.out.println("\u001b[33m" + dancer.getName() + " - пока не оплатите счет, Вы не сможете покинуть клуб :) \u001b[0m");
                } else {
                    System.out.println("\u001b[34m" + dancer.getName() + " Чао! \u001b[0m");
                }
            }
        }
    }
}
