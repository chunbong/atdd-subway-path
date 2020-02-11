package atdd.station.controller;

import atdd.station.model.entity.Station;
import atdd.station.model.request.StationCreateRequest;
import atdd.station.model.response.StationApiResponse;
import atdd.station.service.StationApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    StationApiService stationApiService;

    @PostMapping("")
    public ResponseEntity createStations(@RequestBody StationCreateRequest stationCreateRequest) {

        Station persistStation = stationApiService.create(stationCreateRequest);

        StationApiResponse stationApiResponse = StationApiResponse.builder()
                .data(persistStation)
                .build();

        return ResponseEntity
                .created(URI.create("/stations/" + persistStation.getId()))
                .body(stationApiResponse);
    }
}
