package click.klaassen.healthcheck;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * A simple REST service which is able to proxy the JBoss native Health Check
 *
 * @author mklaasse@redhat.com
 *
 */

@Path("/")
public class HealthCheck {
    @Inject
    HealthCheckService healthCheckService;

    @GET
    @Path("/health")
    @Produces({ "application/json" })
    public String getHealthCheck() throws IOException, InterruptedException, URISyntaxException {
        return healthCheckService.callHealthCheckApi();
    }

}
