package rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestScoped
@Path("/person")
public class Persons
{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> getAll()
    {
        return new ArrayList<>(
                Arrays.asList(
                        "Person 2",
                        "Person 3",
                        "Person 5",
                        "Person 1"
                )
        );
    }

    @GET
    @Path("/{id}")
    public String getPerson(@PathParam("id") long id)
    {
        return "Person" + id;
    }
}
