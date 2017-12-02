import handler.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Hashtable;


//Main URI path
@Path("/")
public class Main {

    private static UsersHandler usrs = new UsersHandler();
    private static AdminsHandler admns = new AdminsHandler();
    private static SuppliersHandler spplrs = new SuppliersHandler();
    private static RequestersHandler rqstr = new RequestersHandler();
    private static ResourcesHandler rs = new ResourcesHandler();

    public static void main(String[] args){

    }

    @GET
    @Produces("text/plain")
    public String getWelcomeMessage(){
        return "WELCOME TO HURRICANE MARIA DISASTER THINGY STUFF.";
    }

    @GET
    @Path("db_project/users")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllUsers(){
        return usrs.getAllUsers();
    }

    @GET
    @Path("db_project/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getAllResourcesById(@PathParam("id") int id){
        return usrs.getAllUsersById(id);
    }

    @GET
    @Path("db_project/admins")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllAdmins(){
        return admns.getAdminsNaturalJoinUser();
    }

    @GET
    @Path("db_project/admins/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getAdminById(@PathParam("id") int id){
        return admns.getAdminById(id);
    }

    @GET
    @Path("db_project/suppliers")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllSuppliers(){
        return spplrs.getSuppliersNaturalJoinUser();
    }

    @GET
    @Path("db_project/suppliers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getSupplierById(@PathParam("id") int id){
        return spplrs.getSupplierById(id);
    }

    @GET
    @Path("db_project/requesters")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllRequesters(){
        return rqstr.getRequestersNaturalJoinUser();
    }

    @GET
    @Path("db_project/requesters/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getRequesterById(@PathParam("id") int id){
        return rqstr.getRequesterId(id);
    }

    @GET
    @Path("db_project/resources")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllResources(){
        return rs.getAllResources();
    }


    @GET
    @Path("db_project/resources/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getResourceById(@PathParam("id") int id){
        return rs.getResourceById(id);
    }





}
