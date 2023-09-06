package tests.mocks;

import res.Reseau;
import res.Station;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReseauMock {
    public Reseau getReseauRecupererLigne() {
        Reseau reseau = new Reseau();

        Station station1 = new Station("Somewhere");
        Station station2 = new Station("Somewhere else");

        reseau.creerLigne(1, station1, station2);

        return reseau;
    }

    public Reseau getReseauRecupererLignesDesservantStation() {
        Reseau reseau = new Reseau();

        Station stationA = new Station("Point A");
        Station stationB = new Station("Point B");
        Station stationC = new Station("Point C");

        reseau.creerLigne(1, Stream.of(stationA, stationB, stationC).collect(Collectors.toList()));

        return reseau;
    }

    public List<Station> getExpectedStations() {
        Station stationA = new Station("Point A");
        Station stationB = new Station("Point B");
        Station stationC = new Station("Point C");
        Station stationD = new Station("Point D");
        Station stationE = new Station("Point E");
        Station stationF = new Station("Point F");

        return Stream.of(stationA, stationB, stationC, stationD, stationE, stationF)
                .collect(Collectors.toList());

    }

    public Reseau getReseauRecupererStations() {
        Reseau reseau = new Reseau();

        Station stationA = new Station("Point A");
        Station stationB = new Station("Point B");
        Station stationC = new Station("Point C");

        reseau.creerLigne(1, Stream.of(stationA, stationB, stationC).collect(Collectors.toList()));

        Station stationD = new Station("Point D");
        Station stationE = new Station("Point E");
        Station stationF = new Station("Point F");

        reseau.creerLigne(2, Stream.of(stationD, stationE, stationF).collect(Collectors.toList()));

        return reseau;
    }

    public Reseau getReseauRecupererStationsAvecDoublons() {
        Reseau reseau = new Reseau();

        Station stationA = new Station("Point A");
        Station stationB = new Station("Point B");
        Station stationC = new Station("Point C");

        reseau.creerLigne(1, Stream.of(stationA, stationB, stationC).collect(Collectors.toList()));

        Station stationD = new Station("Point D");
        Station stationE = new Station("Point E");
        Station stationF = new Station("Point F");

        reseau.creerLigne(2, Stream.of(stationD, stationE, stationF).collect(Collectors.toList()));

        reseau.creerLigne(3, stationA, stationF);

        return reseau;
    }
}
