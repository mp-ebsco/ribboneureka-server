package ribboneureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SearchBackendApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SearchBackendApplication.class).web(true).run(args);
    }
}