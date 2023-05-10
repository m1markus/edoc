package ch.m1m.edoc;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

@Path("/hello")
public class GreetingResource {

    private DocStoreFS docFS = new DocStoreFS("target/main/data");

    public GreetingResource() throws IOException {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
}
