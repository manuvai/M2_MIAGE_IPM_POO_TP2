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

        List<Station> stations = new ArrayList<>(ligneA.getTrajet());

        ligneA.supprimerStation(new Station("Compans Cafarelli"));
        ligneA.afficher();

        Reseau reseau = new Reseau();
        reseau.creerLigne(1, station1, station2);
        reseau.creerLigne(2, new Station("François Verdier"), new Station("Compans Cafarelli"));
        reseau.creerLigne(3, stations);

        System.out.println(reseau.recupererIteneraireLignes(new Station("Jean Jaures"), new Station("Compans Cafarelli")));

    }
}
