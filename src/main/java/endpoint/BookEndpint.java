package endpoint;

import model.Book;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/book")
public class BookEndpint
{

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response saveBook(Book book)
    {
        System.out.println("Saving book");
        System.out.printf(" %s, %s,  %d ", book.getTitle(), book.getAuthor(), book.getIsbn());
        return Response.ok().build();
    }

    @GET
    @Path("/{isbn}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getBook(@PathParam("isbn") String isbn)
    {
        if (Integer.parseInt(isbn) > 1000)
        {
            return Response.status(404).build();
        } else
        {
            return Response.ok().entity(new Book("MockTitle", "SomeAuthor", Integer.valueOf(isbn))).build();
        }
    }

    @GET
    public Response getInfo()
    {
        return Response.ok().cookie(new NewCookie("Auth-Token", Long.toString(System.currentTimeMillis()))).header("Conection-Test-Passed", true).encoding("UTF-8").build();
    }
}
