package rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestScoped
@Path("/person")
public class Persons
{
    List<String> allPerson = new ArrayList<>(
            Arrays.asList(
                    "Person 2",
                    "Person 3",
                    "Person 5",
                    "Person 1"
            )
    );

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> getAll(@QueryParam("orderby") String order)
    {
        if ("asc".equals(order))
            allPerson.sort((a,b) -> a.compareTo(b));
        else if ("desc".equals(order))
            allPerson.sort((a,b) -> b.compareTo(a));

        return allPerson;
    }

    @GET
    @Path("/{id}")
    public String getPerson(@PathParam("id") long id)
    {
        return allPerson.get((int)id);
    }
}
