package res;

import res.exceptions.ArrivalAndDepartureSameException;
import res.exceptions.InvalidEntryException;

import java.util.*;
import java.util.stream.Collectors;

public class Reseau {
    private List<Ligne> lignes = new ArrayList<>();

    public Ligne creerLigne(int inNoLigne, Station inStationDepart, Station inStationArrivee) {
        if (Objects.isNull(inStationDepart) || Objects.isNull(inStationArrivee)) {
            throw new InvalidEntryException();
        }

        if (inStationArrivee.equals(inStationDepart)) {
            throw new ArrivalAndDepartureSameException();
        }

        Ligne ligne = new Ligne(inNoLigne, inStationDepart, inStationArrivee);
        lignes.add(ligne);

        return ligne;
    }

    public void creerLigne(int inNoLigne, List<Station> stationList) {
        if (Objects.isNull(stationList) || stationList.size() < 2) {
            throw new InvalidEntryException();
        }

        Ligne ligne = creerLigne(inNoLigne, stationList.get(0), stationList.get(stationList.size() - 1));

        for (int i = 1; i < stationList.size(); i++) {
            ligne.insererStation(stationList.get(i));

        }

    }

    public Ligne recupererLigne(int noLigne) {
        return lignes.stream()
                .filter(ligne -> Objects.nonNull(ligne) && ligne.getNoLigne() == noLigne)
                .findFirst()
                .orElse(null);
    }

    public List<Ligne> recupererLignesDesservantStation(Station station) {
        return Objects.isNull(station)
                ? new ArrayList<>()
                : lignes.stream()
                        .filter(ligne -> ligne.stationDesservie(station))
                        .collect(Collectors.toList());
    }

    public List<Station> recupererStations() {
        Set<Station> setStations = new HashSet<>();

        lignes.stream()
                .map(Ligne::getTrajet)
                .flatMap(Collection::stream)
                .forEach(setStations::add);

        return new ArrayList<>(setStations);
    }

    /**
     * Récupère les lignes désservant la station de départ et d'arrivée
     *
     * @param stationDepart
     * @param stationArrivee
     * @return
     */
    public List<Ligne> recupererIteneraireLignes(Station stationDepart, Station stationArrivee) {
        return Objects.isNull(stationDepart) || Objects.isNull(stationArrivee)
                ? new ArrayList<>()
                : lignes.stream()
                        .filter(ligne -> ligne.stationDesservie(stationArrivee) && ligne.stationDesservie(stationDepart))
                        .collect(Collectors.toList());
    }
}
