package res;

import java.util.Objects;

public class Station {
    private String nom;

    public Station(String inNom) {
        nom = inNom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return getNom();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;
        Station station = (Station) o;
        return Objects.equals(getNom(), station.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom());
    }
}
