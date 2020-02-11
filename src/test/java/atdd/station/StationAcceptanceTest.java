package atdd.station;

import atdd.station.model.request.StationCreateRequest;
import atdd.station.model.response.StationApiResponse;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class StationAcceptanceTest {
    private static final Logger logger = LoggerFactory.getLogger(StationAcceptanceTest.class);

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void createStation() {
        StationCreateRequest stationCreateRequest = StationCreateRequest.builder()
                .name("강남역")
                .build();

        webTestClient.post().uri("/stations")
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(stationCreateRequest), StationCreateRequest.class)
            .exchange()
            .expectStatus().isCreated()
            .expectHeader().exists("Location")
            .expectBody(StationApiResponse.class)
            .returnResult();
    }
}
