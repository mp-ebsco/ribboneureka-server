package ribboneureka.server.controller;

import ribboneureka.server.domain.SearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchBackendController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchBackendController.class.getName());

    @RequestMapping(method = RequestMethod.GET, path = "/{query}")
    public ResponseEntity<SearchResponse> getSearch(
            @PathVariable(name = "query", required = true) String query) {

        LOGGER.info("Search: " + query);
        return new ResponseEntity(new SearchResponse(String.join("-", query, "result")), HttpStatus.OK);
    }


}
