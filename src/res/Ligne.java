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
        String output = "Ligne N° ".concat(Integer.toString(getNoLigne()));
        output = output.concat("\nStations desservies : ").concat(trajet.toString());

        Utils.println(output);

    }

    public List<Station> getTrajet() {
        return trajet;
    }

    public int getNoLigne() {
        return noLigne;
    }

    public void insererStation(Station station) {
        if (Objects.nonNull(station)) {
            trajet.add(station);

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
