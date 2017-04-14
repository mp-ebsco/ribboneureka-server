package ribboneureka.server.controller;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import ribboneureka.server.dto.SearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = "search")
public class SearchBackendController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchBackendController.class.getName());

//    @Metric(name = "searchCounter")
//    private Counter searchCounter;

    private final AtomicLong getByIdRequestCount = new AtomicLong();

//    @Metered(name = "getByIdMetered")
//    @Gauge(name = "getByIdGauge")
//    public long getByIdRequestCount() {
//        return this.getByIdRequestCount.get();
//    }
    @Timed(name="TIMED_SEARCH", absolute = true)
    @Metered(name = "SEARCH", absolute = true)
    @RequestMapping(method = RequestMethod.GET, path = "/{query}")
    public ResponseEntity<SearchResponse> getSearch(
            @PathVariable(name = "query", required = true) String query) {
        LOGGER.info("Search: " + query);
//        searchCounter.inc();
        return new ResponseEntity(new SearchResponse(String.join("-", query, "result")), HttpStatus.OK);
    }
}