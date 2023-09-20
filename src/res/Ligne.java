package res;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ligne {
    private int noLigne;

    private List<Station> trajet = new ArrayList<>();

    public Ligne(int inNoLigne, Station stationDepart, Station stationArrivee) {
        noLigne = inNoLigne;
        insererStation(stationDepart);
        insererStation(stationArrivee);
    }

    public void afficher() {
        Utils.println(toString());

    }

    public String toString() {
        String output = "\nLigne N° ".concat(Integer.toString(getNoLigne()));
        output = output.concat("\nStations desservies : ").concat(trajet.toString());
        return output;
    }

    public List<Station> getTrajet() {
        return trajet;
    }

    public int getNoLigne() {
        return noLigne;
    }

    public void insererStation(Station stationAvant, Station stationApres, Station stationAjoutee) {
        if (Objects.nonNull(stationAvant)
                && Objects.nonNull(stationApres)
                && Objects.nonNull(stationAjoutee)
                && !trajet.isEmpty()
        ) {
            int indexStation1 = trajet.indexOf(stationAvant);
            int indexStation2 = trajet.indexOf(stationApres);

            boolean isStation1NextStation2 = Math.abs(indexStation1 - indexStation2) == 1;

            if (isStation1NextStation2) {
                int indexToInsert = Math.max(indexStation1, indexStation2);

                trajet.add(indexToInsert, stationAjoutee);
            }

        }
    }

    public void insererStation(Station station) {
        if (Objects.nonNull(station)) {
            int indexToInsert = Math.max(0, trajet.size() - 1);

            trajet.add(indexToInsert, station);

        }
    }

    public void supprimerStation(Station station) {
        if (Objects.nonNull(station)) {
            trajet.remove(station);
        }
    }

    public boolean stationDesservie(Station station) {
        return Objects.nonNull(station)
                && !trajet.isEmpty()
                && trajet.contains(station);
    }

}
