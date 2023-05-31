package click.klaassen.healthcheck;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import static java.net.http.HttpResponse.*;

/**
 * A simple CDI service which is able to call the health check endpoint of JBoss Management API
 *
 * @author mklaasse@redhat.com
 *
 */
public class HealthCheckService {

    String callHealthCheckApi() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:9990/health"))
                .GET()
                .build();
        return HttpClient.newHttpClient().send(request, BodyHandlers.ofString()).body();
    }

}
