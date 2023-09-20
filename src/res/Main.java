package res;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Station station1 = new Station("Jean Jaurès");
        Station station2 = new Station("Jeanne D'Arc");

        Ligne ligneA = new Ligne(1, station1, station2);
        ligneA.afficher();

        ligneA.insererStation(new Station("Compans Cafarelli"));
        ligneA.afficher();

        ligneA.supprimerStation(new Station("Compans Cafarelli"));
        ligneA.afficher();

        Reseau reseau = getReseauRechercheItineraire();

        Utils.println("\nObtenir une ligne à partir de son numéro :");
        Utils.println(reseau.recupererLigne(1));

        Utils.println("\nRetrouver la ou les lignes desservant une station :");
        Utils.println(reseau.recupererLignesDesservantStation(station1));

        Utils.println("\nObtenir l’ensemble des stations desservies par le réseau :");
        Utils.println(reseau.recupererStations());


        Utils.println("\nObtenir les lignes à utiliser pour aller d’une station A à une station B :");
        Station stationDepart = new Station("Jean Jaurès");
        Station stationArrivee = new Station("St-Georges");

        Utils.println("\nRecherche d'itinéraire depuis "
                .concat(stationDepart.toString())
                .concat(" vers ")
                .concat(stationArrivee.toString())
                .concat(" :"));
        List<Ligne> listeLignes = reseau.recupererItineraireLignes(stationDepart, stationArrivee);
        Utils.println(listeLignes.toString());

    }

    private static Reseau getReseauRechercheItineraire() {

        Reseau reseau = new Reseau();
        reseau.creerLigne(1, getStationsLigne1());
        reseau.creerLigne(2, getStationsLigne2());
        reseau.creerLigne(3, getStationsLigne3());
        reseau.creerLigne(14, getStationsLigne14());
        return reseau;
    }

    private static List<Station> getStationsLigne1() {
        List<Station> stationList = new ArrayList<>();

        stationList.add(new Station("Sept-Deniers"));
        stationList.add(new Station("Ponts Jumeaux"));
        stationList.add(new Station("Canal de Brienne"));
        stationList.add(new Station("Soleil d'Or"));
        stationList.add(new Station("Barcelone Leclerc"));
        stationList.add(new Station("Cité Madrid"));
        stationList.add(new Station("Leclerc"));
        stationList.add(new Station("Fourmi"));
        stationList.add(new Station("Compans-Caffarelli"));
        stationList.add(new Station("Ponts Jumeaux"));
        stationList.add(new Station("A. Bernard"));
        stationList.add(new Station("Canal de Brienne"));
        stationList.add(new Station("Barcelone Leclerc"));
        stationList.add(new Station("Concorde"));
        stationList.add(new Station("Jeanne d'Arc"));
        stationList.add(new Station("Leclerc"));
        stationList.add(new Station("Jean Jaurès"));
        stationList.add(new Station("Compans-Caffarelli"));
        stationList.add(new Station("A. Bernard"));
        stationList.add(new Station("St-Georges"));
        stationList.add(new Station("Concorde"));
        stationList.add(new Station("François Verdier"));
        stationList.add(new Station("Place Dupuy"));
        stationList.add(new Station("Jeanne d'Arc"));
        stationList.add(new Station("Jean Jaurès"));
        stationList.add(new Station("Port St-Etienne"));
        stationList.add(new Station("Aqueduc"));
        stationList.add(new Station("St-Georges"));
        stationList.add(new Station("François Verdier"));
        stationList.add(new Station("Pérignon"));
        stationList.add(new Station("Place Dupuy"));
        stationList.add(new Station("Tilleuls"));
        stationList.add(new Station("Port St-Etienne"));
        stationList.add(new Station("Deltour"));
        stationList.add(new Station("Achiary"));
        stationList.add(new Station("Aqueduc"));
        stationList.add(new Station("Pérignon"));
        stationList.add(new Station("Mascard"));
        stationList.add(new Station("Aubisque"));
        stationList.add(new Station("Tilleuls"));
        stationList.add(new Station("Deltour"));
        stationList.add(new Station("Cité de L'Hers"));
        stationList.add(new Station("Achiary"));
        stationList.add(new Station("Collège JP Vernant"));
        stationList.add(new Station("Mascard"));
        stationList.add(new Station("Gymnase de L'Hers"));
        stationList.add(new Station("Aubisque"));
        stationList.add(new Station("Cité de L'Hers"));
        stationList.add(new Station("Collège JP Vernant"));
        stationList.add(new Station("Gymnase de L'Hers"));

        return stationList;
    }

    private static List<Station> getStationsLigne2() {
        List<Station> stationList = new ArrayList<>();

        stationList.add(new Station("Arènes"));
        stationList.add(new Station("Négogousses"));
        stationList.add(new Station("Brombach"));
        stationList.add(new Station("Casteret"));
        stationList.add(new Station("Lemire"));
        stationList.add(new Station("Grande-Bretagne"));
        stationList.add(new Station("Casselardit"));
        stationList.add(new Station("Chardonnet"));
        stationList.add(new Station("Hôpital Purpan"));
        stationList.add(new Station("Ctre Cial Purpan Sud"));
        stationList.add(new Station("Flambère"));
        stationList.add(new Station("Bisson"));
        stationList.add(new Station("Bertier"));
        stationList.add(new Station("Bouriette"));
        stationList.add(new Station("Jardinerie"));
        stationList.add(new Station("Fournier Airbus"));
        stationList.add(new Station("Terce Airbus"));
        stationList.add(new Station("Jean Petit"));
        stationList.add(new Station("Max Fischl"));
        stationList.add(new Station("Caulet"));
        stationList.add(new Station("Oratoire"));
        stationList.add(new Station("Naurouze"));
        stationList.add(new Station("Bascule - Seycheron"));
        stationList.add(new Station("Médiathèque Pavillon Blanc"));
        stationList.add(new Station("Colomiers Gare SNCF"));
        stationList.add(new Station("Gers"));
        stationList.add(new Station("Salle Gascogne"));
        stationList.add(new Station("Val D'Aran"));
        stationList.add(new Station("14ème Rgt d'Infanterie"));
        stationList.add(new Station("Champagne"));
        stationList.add(new Station("Stade Bendichou"));
        stationList.add(new Station("Morbihan"));
        stationList.add(new Station("Monturon"));
        stationList.add(new Station("Colomiers Lycée International"));

        return stationList;
    }

    private static List<Station> getStationsLigne3() {
        List<Station> stationList = new ArrayList<>();

        stationList.add(new Station("Cours Dillon"));
        stationList.add(new Station("Pont Neuf"));
        stationList.add(new Station("Esquirol"));
        stationList.add(new Station("Boulbonne"));
        stationList.add(new Station("François Verdier"));
        stationList.add(new Station("Quartier Général"));
        stationList.add(new Station("Grand Rond"));
        stationList.add(new Station("Jardin des Plantes"));
        stationList.add(new Station("Frizac"));
        stationList.add(new Station("Demouilles"));
        stationList.add(new Station("Crampel"));
        stationList.add(new Station("Trois Fours"));
        stationList.add(new Station("Dufour"));
        stationList.add(new Station("Courrège"));
        stationList.add(new Station("Cottages"));
        stationList.add(new Station("Jean-Paul Laurens"));
        stationList.add(new Station("Six Avril"));
        stationList.add(new Station("Tahiti"));
        stationList.add(new Station("Clinique Languedoc"));
        stationList.add(new Station("Bajac"));
        stationList.add(new Station("Lafaurie"));
        stationList.add(new Station("Montaudran"));
        stationList.add(new Station("Route de Revel"));
        stationList.add(new Station("Malepère"));

        return stationList;
    }

    private static List<Station> getStationsLigne14() {

        List<Station> stationList = new ArrayList<>();

        stationList.add(new Station("Basso Cambo"));
        stationList.add(new Station("Place Bouillière"));
        stationList.add(new Station("Bellefontaine"));
        stationList.add(new Station("Le Lac Reynerie"));
        stationList.add(new Station("Cité du Parc"));
        stationList.add(new Station("Kiev"));
        stationList.add(new Station("Babinet"));
        stationList.add(new Station("Mirail-Université"));
        stationList.add(new Station("Douanes"));
        stationList.add(new Station("Ecole Espagnole"));
        stationList.add(new Station("Ecole D'Architecture"));
        stationList.add(new Station("Cité Scolaire Rive Gauche"));
        stationList.add(new Station("Cépière Rocade"));
        stationList.add(new Station("Collège George Sand"));
        stationList.add(new Station("Corneille"));
        stationList.add(new Station("Rue du 14 juillet"));
        stationList.add(new Station("Arènes"));
        stationList.add(new Station("Barrière de Lombez"));
        stationList.add(new Station("Patte d'Oie"));
        stationList.add(new Station("Roguet"));
        stationList.add(new Station("St Cyprien - République"));
        stationList.add(new Station("Teinturiers"));
        stationList.add(new Station("Fer à Cheval"));
        stationList.add(new Station("Magné"));
        stationList.add(new Station("Cours Dillon"));
        stationList.add(new Station("Pont Neuf"));
        stationList.add(new Station("Esquirol"));
        stationList.add(new Station("Boulbonne"));
        stationList.add(new Station("François Verdier"));
        stationList.add(new Station("St-Georges"));
        stationList.add(new Station("Jean Jaurès"));
        stationList.add(new Station("Bachelier"));
        stationList.add(new Station("Riquet"));
        stationList.add(new Station("Marengo-SNCF"));

        return stationList;
    }
}
