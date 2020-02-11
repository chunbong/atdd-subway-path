package atdd.station;

import atdd.station.model.request.StationCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/stations")
public class StationController {

    @PostMapping("")
    public ResponseEntity<String> createStations(@RequestBody StationCreateRequest stationCreateRequest) {

        return ResponseEntity.created(URI.create("/stations")).build();
    }
}
