package rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/prop")
public class PropertiesEndPoint
{
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getProperties()
    {
        String log_dir = System.getProperty("log_dir","/tmp/log");
        log_dir += System.getProperty("os.name");
        log_dir += System.getProperty("java.runtime.version" );
        return log_dir;
    }
}
