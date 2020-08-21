package rest;

import model.Person;

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
    List<Person> allPerson = new ArrayList<>(
            Arrays.asList(
                    new Person("Stanisław", "Staśkiewicz", "90893445653", 23),
                    new Person("Leszek", "Lechowicz", "65763467876", 23),
                    new Person("Zenon", "Zenkiewicz", "88452345623", 23),
                    new Person("Miczysław", "Mietczyński", "87432385274", 23),
                    new Person("Franciszek", "Frankowski", "77347237837", 23)
            )
    );

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Person> getAll(@QueryParam("orderby") String order)
    {
        if ("asc".equals(order))
            allPerson.sort((a,b) -> a.compareTo(b));
        else if ("desc".equals(order))
            allPerson.sort((a,b) -> b.compareTo(a));

        return allPerson;
    }

    @GET
    @Path("/{id}")
    public Person getPerson(@PathParam("id") @DefaultValue("1") long id)
    {
        return allPerson.get((int)id);
    }
}
