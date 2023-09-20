package tests.mocks;

import res.Ligne;
import res.Station;

public class LigneMock {
    public Ligne getLigneA() {

        Station station1 = new Station("Jean Jaures");
        Station station2 = new Station("Jeanne D'Arc");

        return new Ligne(1, station1, station2);
    }
    public Ligne getLigneMultipleStations() {

        Station station1 = new Station("Leclerc");
        Station station2 = new Station("Jean Jaures");

        Ligne ligne =  new Ligne(1, station1, station2);

        ligne.insererStation(new Station("Compans Cafarelli"));
        ligne.insererStation(new Station("Concorde"));
        ligne.insererStation(new Station("Jeanne D'Arc"));

        return ligne;
    }
}
