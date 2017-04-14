package ribboneureka.server;

import ribboneureka.server.controller.SearchBackendController;
import ribboneureka.server.dto.SearchResponse;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {SearchBackendController.class})
public class SearchBackendControllerTest {

    //@Autowired
    private SearchBackendController controller;

    //@Test
    public void testSearch() {
        controller.getSearch("foo");
    }

    //@Test
    public void testSearchResponse() {
        SearchResponse response = new SearchResponse("foo");
        assertThat(response.getResponse(), is("foo"));
    }
}