package rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.time.LocalDateTime;

@RequestScoped
@Path("/hello")
public class HelloEndPoint
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello()
    {
        return "Hello " + LocalDateTime.now();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String getPropsa()
    {
        return "Props for you";
    }
}
