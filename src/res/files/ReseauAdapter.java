package res.files;

import res.Reseau;
import res.Station;

import java.util.*;

public class ReseauAdapter {

    public Reseau getReseau(List<List<String>> lines) {
        Map<Integer, List<Station>> stations = getStations(lines);
        Reseau reseau = new Reseau();
        if (Objects.nonNull(stations)) {
            stations.forEach(reseau::creerLigne);

        }

        return reseau;
    }

    private Map<Integer, List<Station>> getStations(List<List<String>> lines) {
        Map<Integer, List<Station>> stations;

        if (Objects.nonNull(lines)) {
            stations = new HashMap<>();
            lines.stream()
                    .forEach(line -> {
                        int indexId = Integer.parseInt(line.get(0));
                        if (!stations.containsKey(indexId)) {
                            stations.put(indexId, new ArrayList<>());
                        }

                        stations.get(indexId).add(new Station(line.get(1)));
                    });
        } else {
            stations = null;
        }

        return stations;
    }
}
