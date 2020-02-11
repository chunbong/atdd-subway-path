package atdd.station.service;

import atdd.station.model.entity.Station;
import atdd.station.model.request.StationCreateRequest;
import atdd.station.model.response.StationApiResponse;
import atdd.station.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationApiService {

    @Autowired
    StationRepository stationRepository;

    public Station create(StationCreateRequest stationCreateRequest) {
        Station station = Station.builder()
                .name(stationCreateRequest.getName())
                .build();

        return stationRepository.save(station);
    }
}
