import handler.ResourcesHandler;
import handler.UsersHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Hashtable;


//Main URI path
@Path("/db_project")
public class Main {

    private static UsersHandler usrs = new UsersHandler();
    private static ResourcesHandler rs = new ResourcesHandler();

    public static void main(String[] args){

        System.out.println(rs.getResourceById(0));

    }

    @GET
    @Produces("text/plain")
    public String getWelcomeMessage(){
        return "WELCOME TO HURRICANE MARIA DISASTER THINGY STUFF.";
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllUsers(){
        return usrs.getAllUsers();
    }

    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getAllResourcesById(@PathParam("id") int id){
        return usrs.getAllUsersById(id);
    }

    @GET
    @Path("/resources")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllResources(){
        return rs.getAllResources();
    }


    @GET
    @Path("/resources/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getResourceById(@PathParam("id") int id){
        return rs.getResourceById(id);
    }





}
