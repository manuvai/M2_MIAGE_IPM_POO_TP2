package tests.res;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import res.Ligne;
import res.Reseau;
import res.Station;
import res.exceptions.ArrivalAndDepartureSameException;
import res.exceptions.InvalidEntryException;
import tests.mocks.ReseauMock;

import java.util.Date;
import java.util.List;

public class ReseauTest {

    ReseauMock reseauMock;

    @Before
    public void setup() {
        reseauMock = new ReseauMock();
    }

    @Test(expected = InvalidEntryException.class)
    public void creerLigne_stationDepartNull_Ko() {
        // GIVEN
        Station stationArrivee = new Station("Station imaginaire");

        // WHEN
        Reseau reseau = new Reseau();
        reseau.creerLigne(500, null, stationArrivee);

    }

    @Test(expected = InvalidEntryException.class)
    public void creerLigne_stationArriveeNull_Ko() {
        // GIVEN
        Station stationDepart = new Station("Station bidon");

        // WHEN
        Reseau reseau = new Reseau();
        reseau.creerLigne(500, stationDepart, null);

    }

    @Test(expected = ArrivalAndDepartureSameException.class)
    public void creerLigne_stationArriveeEqualsStationDepart_Ko() {
        // GIVEN
        Station stationDepart = new Station("Station bidon");
        Station stationArrivee = new Station("Station bidon");

        // WHEN
        Reseau reseau = new Reseau();
        reseau.creerLigne(500, stationDepart, stationArrivee);

    }

    @Test
    public void creerLigne_Ok() {
        // GIVEN
        Station stationDepart = new Station("Station bidon");
        Station stationArrivee = new Station("Station imaginaire");

        // WHEN
        Reseau reseau = new Reseau();

        Assertions.assertDoesNotThrow(() -> {

            reseau.creerLigne(200, stationDepart, stationArrivee);

            Assertions.assertEquals(2, reseau.recupererStations().size());
        });

    }

    @Test
    public void recupererLigne_lignesEmpty_Ko() {
        // GIVEN
        Reseau reseau = new Reseau();

        // WHEN
        Ligne ligneActual = reseau.recupererLigne(1);

        // THEN
        Assertions.assertNull(ligneActual);

    }

    @Test
    public void recupererLigne_Ok() {
        // GIVEN
        Reseau reseau = reseauMock.getReseauRecupererLigne();

        // WHEN
        Ligne ligne = reseau.recupererLigne(1);

        // THEN
        Assertions.assertNotNull(ligne);
    }

    @Test
    public void recupererLignesDesservantStation_stationNull_Ko() {
        // GIVEN
        Reseau reseau = reseauMock.getReseauRecupererLignesDesservantStation();

        // WHEN
        List<Ligne> actualLignes = reseau.recupererLignesDesservantStation(null);

        // THEN
        Assertions.assertTrue(actualLignes.isEmpty());
    }

    @Test
    public void recupererLignesDesservantStation_lignesSansStationDonnee_Ko() {
        // GIVEN
        Reseau reseau = new Reseau();

        // WHEN
        List<Ligne> actualLignes = reseau.recupererLignesDesservantStation(new Station("Point B"));

        // THEN
        Assertions.assertTrue(actualLignes.isEmpty());

    }

    @Test
    public void recupererLignesDesservantStation_Ok() {
        // GIVEN
        Reseau reseau = reseauMock.getReseauRecupererLignesDesservantStation();

        // WHEN
        List<Ligne> actualLignes = reseau.recupererLignesDesservantStation(new Station("Point B"));

        // THEN
        Assertions.assertFalse(actualLignes.isEmpty());

    }

    @Test
    public void recupererStations_Ok() {
        // GIVEN
        Reseau reseau = reseauMock.getReseauRecupererStations();
        List<Station> expectedStations = reseauMock.getExpectedStations();

        // WHEN
        List<Station> actualStations = reseau.recupererStations();

        // THEN
        boolean isEqual = expectedStations.size() == actualStations.size()
                && actualStations.containsAll(expectedStations)
                && expectedStations.containsAll(actualStations);
        Assertions.assertTrue(isEqual);

    }

    @Test
    public void recupererStations_trajetsDoublon_Ok() {
        // GIVEN
        Reseau reseau = reseauMock.getReseauRecupererStationsAvecDoublons();
        List<Station> expectedStations = reseauMock.getExpectedStations();

        // WHEN
        List<Station> actualStations = reseau.recupererStations();

        // THEN
        boolean isEqual = expectedStations.size() == actualStations.size()
                && actualStations.containsAll(expectedStations)
                && expectedStations.containsAll(actualStations);
        Assertions.assertTrue(isEqual);

    }

    @Test
    public void recupererIteneraireLignes_stationDepartNull_Ko() {
        // GIVEN
        Reseau reseau = new Reseau();
        Station stationBidon = new Station("Bidon");

        // WHEN
        List<Ligne> lignesItineraires = reseau.recupererIteneraireLignes(null, stationBidon);

        // THEN
        Assertions.assertTrue(lignesItineraires.isEmpty());

    }

    @Test
    public void recupererIteneraireLignes_stationDepartArrivee_Ko() {
        // GIVEN
        Reseau reseau = new Reseau();
        Station stationBidon = new Station("Bidon");

        // WHEN
        List<Ligne> lignesItineraires = reseau.recupererIteneraireLignes(stationBidon, null);

        // THEN
        Assertions.assertTrue(lignesItineraires.isEmpty());

    }

    @Test
    public void recupererIteneraireLignes_stationsNonDesservies_Ko() {
        // GIVEN
        Reseau reseau = reseauMock.getReseauRecupererStations();
        Station stationBidon1 = new Station("Bidon 1");
        Station stationBidon2 = new Station("Bidon 2");

        // WHEN
        List<Ligne> lignesItineraires = reseau.recupererIteneraireLignes(stationBidon1, stationBidon2);

        // THEN
        Assertions.assertTrue(lignesItineraires.isEmpty());

    }

    @Test
    public void recupererIteneraireLignes_stationsDesservies_Ok() {
        // GIVEN
        Reseau reseau = reseauMock.getReseauRecupererStations();
        Station stationA = new Station("Point A");
        Station stationB = new Station("Point B");

        // WHEN
        List<Ligne> lignesItineraires = reseau.recupererIteneraireLignes(stationA, stationB);

        // THEN
        Assertions.assertFalse(lignesItineraires.isEmpty());

    }
}
