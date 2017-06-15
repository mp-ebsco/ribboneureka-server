package ribboneureka.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ribboneureka.server.dto.SearchResponse;

@RestController
@RequestMapping(path = "search")
public class SearchBackendController {

    private static Logger logger = LoggerFactory.getLogger(SearchBackendController.class);

    @RequestMapping(method = RequestMethod.GET, path = "/{query}")
    public ResponseEntity<SearchResponse> getSearch(
            @PathVariable(name = "query", required = true) String query) {
        SearchResponse searchResponse = new SearchResponse(String.join("-", query, "result"));
        logger.info("Returning search response: " + searchResponse);
        return new ResponseEntity(searchResponse, HttpStatus.OK);
    }
}