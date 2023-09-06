package res;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Station station1 = new Station("Jean Jaures");
        Station station2 = new Station("Jeanne D'Arc");

        Ligne ligneA = new Ligne(1, station1, station2);
        ligneA.afficher();

        ligneA.insererStation(new Station("Compans Cafarelli"));
        ligneA.afficher();

        ligneA.supprimerStation(new Station("Compans Cafarelli"));
        ligneA.afficher();

        List<String> entiers = new ArrayList<>();

        entiers.add("1");
        entiers.add("2");
        Utils.println(entiers);
        entiers.add("4");
        Utils.println(entiers);
        Utils.println(entiers.size());
        entiers.add(2, "3");

        Utils.println(entiers);

    }
}
