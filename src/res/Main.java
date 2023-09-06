package res;

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
    }
}
