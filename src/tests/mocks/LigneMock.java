package tests.mocks;

import res.Ligne;
import res.Station;

public class LigneMock {
    public Ligne getLigneA() {

        Station station1 = new Station("Jean Jaures");
        Station station2 = new Station("Jeanne D'Arc");

        return new Ligne(1, station1, station2);
    }
}
