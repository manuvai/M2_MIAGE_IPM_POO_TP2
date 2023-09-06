package tests.res;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import res.Ligne;
import res.Station;
import tests.mocks.LigneMock;

public class LigneTest {
    private LigneMock ligneMock;

    @Before
    public void setup() {
        ligneMock = new LigneMock();
    }

    @Test
    public void insererStation_stationNull_Ko() {
        // GIVEN
        Ligne ligneA = ligneMock.getLigneA();
        int expectedSize = ligneA.getTrajet().size();

        // WHEN
        ligneA.insererStation(null);

        // THEN
        Assertions.assertEquals(expectedSize, ligneA.getTrajet().size());
    }
    @Test
    public void insererStation_Ok() {
        // GIVEN
        Ligne ligneA = ligneMock.getLigneA();
        int expectedSize = ligneA.getTrajet().size() + 1;

        // WHEN
        ligneA.insererStation(new Station("Compans Cafarelli"));

        // THEN
        Assertions.assertEquals(expectedSize, ligneA.getTrajet().size());

    }

    @Test
    public void supprimerStation_stationNull_Ko() {
        // GIVEN
        Ligne ligneA = ligneMock.getLigneA();
        int expectedSize = ligneA.getTrajet().size();

        // WHEN
        ligneA.supprimerStation(null);

        // THEN
        Assertions.assertEquals(expectedSize, ligneA.getTrajet().size());

    }
    @Test
    public void supprimerStation_Ok() {
        // GIVEN
        Ligne ligneA = ligneMock.getLigneA();
        int expectedSize = ligneA.getTrajet().size() - 1;

        // WHEN
        ligneA.supprimerStation(new Station("Jean Jaures"));

        // THEN
        Assertions.assertEquals(expectedSize, ligneA.getTrajet().size());

    }

    @Test
    public void stationDesservie_stationNull_Ko() {
        // GIVEN
        Ligne ligneA = ligneMock.getLigneA();

        // WHEN
        boolean result = ligneA.stationDesservie(null);

        // THEN
        Assertions.assertFalse(result);

    }

    @Test
    public void stationDesservie_trajetEmpty_Ko() {
        // GIVEN
        Ligne ligneA = ligneMock.getLigneA();
        ligneA.supprimerStation(new Station("Jean Jaures"));
        ligneA.supprimerStation(new Station("Jeanne D'Arc"));

        // WHEN
        boolean result = ligneA.stationDesservie(new Station("Jean Jaures"));

        // THEN
        Assertions.assertFalse(result);

    }

    @Test
    public void stationDesservie_stationNonDesservie_Ok() {
        // GIVEN
        Ligne ligneA = ligneMock.getLigneA();

        // WHEN
        boolean result = ligneA.stationDesservie(new Station("Compans Cafarelli"));

        // THEN
        Assertions.assertFalse(result);

    }

    @Test
    public void stationDesservie_stationDesservie_Ok() {
        // GIVEN
        Ligne ligneA = ligneMock.getLigneA();

        // WHEN
        boolean result = ligneA.stationDesservie(new Station("Jeanne D'Arc"));

        // THEN
        Assertions.assertTrue(result);
    }

}
