import handler.*;

import javax.ws.rs.*;
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
    private static InventoryHandler inv = new InventoryHandler();
    private static ResourcesHandler rs = new ResourcesHandler();
    private static PurchasesHandler purchasesH = new PurchasesHandler();

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
    @Path("db_project/suppliers/inventory")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getInventoryBySuppliers(){
        return inv.getInventoryBySuppliers();
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

    @GET
    @Path("db_project/inventory")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllInventory(){
        return inv.getAllInventory();
    }

    /*@GET
    @Path("db_project/inventory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getInventoryById(@PathParam("id") int id){
        return inv.getInventoryById(id);
    }*/

    /*@GET
    @Path("db_project/inventory?{arg}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getInventoryByArgument(@PathParam("arg") String arg, @PathParam("value") String value){
        return inv.getInventoryByArgument(arg, value);
    }*/

    @GET
    @Path("db_project/inventory/with")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getInventoryByArgument(@QueryParam("invID") int invID, @QueryParam("suppID") int suppID, @QueryParam("invDate") String invDate, @QueryParam("invQty") int invQty, @QueryParam("invPrice") double invPrice, @QueryParam("invReserved") String invReserved){
        return inv.getInventoryByArgument(invID, suppID, invDate, invQty, invPrice, invReserved);
        //return inv.getInventoryById(invID);
        //
    }

    @GET
    @Path("db_project/purchases")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllPurchases(){
        return purchasesH.getRequestersNatJPurchasesNatJInventory();
    }


}
