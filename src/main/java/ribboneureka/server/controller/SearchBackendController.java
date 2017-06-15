package ribboneureka.server.controller;

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

    @RequestMapping(method = RequestMethod.GET, path = "/{query}")
    public ResponseEntity<SearchResponse> getSearch(
            @PathVariable(name = "query", required = true) String query) {
        return new ResponseEntity(new SearchResponse(String.join("-", query, "result")), HttpStatus.OK);
    }
}