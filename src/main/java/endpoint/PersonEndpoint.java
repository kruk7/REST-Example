package endpoint;

import model.Person;
import model.PersonDetails;
import model.comparator.PersonAllValuesComparator;
import model.comparator.PersonNameComparator;
import repository.PersonRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RequestScoped
@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonEndpoint
{
    @Inject
    PersonRepository personRepo;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAll(@QueryParam("sortby") String sortBy, @QueryParam("orderby") String order)
    {
        List<Person> allPerson = personRepo.getAll();
        if (allPerson.isEmpty()) return Response.noContent().build();
        else
        {
            return Response.ok(sortPersonList(allPerson, sortBy, order)).build();
        }
    }

    private List<Person> sortPersonList(List<Person> personList, String sortby, String order)
    {

        if ("all".equals(sortby) && "asc".equals(order)) Collections.sort(personList, new PersonAllValuesComparator());

        else if ("all".equals(sortby) && "desc".equals(order))
            Collections.sort(personList, new PersonAllValuesComparator().reversed());

        else if ("name".equals(sortby) && "asc".equals(order)) Collections.sort(personList, new PersonNameComparator());

        else if ("name".equals(sortby) && "desc".equals(order))
            Collections.sort(personList, new PersonNameComparator().reversed());

        return personList;
    }

    @GET
    @Path("/{userId}")
    public Response getPerson(@PathParam("userId") @DefaultValue("1") Long id)
    {
        Person person = personRepo.getById(id);
        if (person == null) return Response.noContent().build();
        else return Response.ok(person).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person, @Context UriInfo uriInfo)
    {
        if (person != null && person.getId() == null)
        {
            personRepo.add(person);
            return Response
                    .created(uriInfo
                            .getAbsolutePathBuilder()
                            .path(person.getId().toString())
                            .build())
                    .build();
        }
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createUser(@FormParam("firstName") String firstName,
                           @FormParam("lastName") String lastName,
                           @FormParam("pesel") String pesel,
                           @FormParam("age") int age,
                           @FormParam("address") String address,
                           @FormParam("telephone") String telephone,
                           @FormParam("country") String country,
                           @Context HttpServletRequest request,
                           @Context HttpServletResponse response) throws IOException
    {
        Person person = new Person(firstName, lastName, pesel, age);
        PersonDetails personDetails = new PersonDetails(address, telephone, country);
        person.setPersonDetails(personDetails);
        personRepo.add(person);
        response.sendRedirect(request.getContextPath());
    }
}
