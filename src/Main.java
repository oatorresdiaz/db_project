import com.sun.deploy.xml.GeneralEntity;
import handler.*;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.Service;

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
    private static ReserveHandler res = new ReserveHandler();
    private static PurchasesHandler purchasesH = new PurchasesHandler();
    private static RequestsHandler requestsH = new RequestsHandler();

    public static void main(String[] args){

    }

    @GET
    @Produces("text/plain")
    public String getWelcomeMessage(){
        return "WELCOME TO HURRICANE MARIA DISASTER THINGY STUFF.";
    }

    @GET
    @Path("db_project/error")
    @Produces("text/plain")
    public Response get404ErrorMessage(){
        return Response.status(404).build();
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
        return usrs.getUserById(id);
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

    /*@GET
    @Path("db_project/suppliers/inventory")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getInventoryBySuppliers(){
        return inv.getInventoryBySuppliers();
    }*/

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

    @GET
    @Path("db_project/inventory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getInventoryById(@PathParam("id") int id){
        return inv.getInventoryById(id);
    }

    /*@GET
    @Path("db_project/inventory/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryBySupplierId(@QueryParam("suppID") @DefaultValue("-1") int id){
        if(id == -1) return get404ErrorMessage();
        GenericEntity<ArrayList<Hashtable<String, Object>>> entity =
                new GenericEntity<ArrayList<Hashtable<String,Object>>>(inv.getInventoryBySupplierId(id)) {};
        return Response.ok(entity).build();
    }*/

    @GET
    @Path("db_project/inventory/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryWithArg(@QueryParam("invID") @DefaultValue("-1") int invID,
                                        @QueryParam("suppID") @DefaultValue("-1") int suppID,
                                        @QueryParam("invDate") @DefaultValue("UNDECLARED") String invDate,
                                        @QueryParam("invQty") @DefaultValue("-1") int invQty,
                                        @QueryParam("invPrice") @DefaultValue("-1") int invPrice,
                                        @QueryParam("invReserved") @DefaultValue("-1") int invReserved){
        return inv.getInventoryWithArg(invID, suppID, invDate, invQty, invPrice, invReserved);
    }

    @GET
    @Path("db_project/reserve")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllReserves(){
        return res.getRequestersNaturalJoinInventory();
    }

    @GET
    @Path("db_project/reserve/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getReserveId(@PathParam("id") int id){
        return res.getReserveId(id);
    }
    @GET
    @Path("db_project/purchases")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllPurchases(){
        return purchasesH.getRequestersNatJPurchasesNatJInventory();
    }

    @GET
    @Path("db_project/requests")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Hashtable<String, Object>> getAllRequests(){return requestsH.getAllRequests();
    }

    @GET
    @Path("db_project/requests/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hashtable<String, Object> getRequestsById(@PathParam("id") int id){
        return requestsH.getRequestsById(id);
    }

    @GET
    @Path("db_project/inventory/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryWithArg(@QueryParam("rqstsID") @DefaultValue("-1") int rqstsID,
                                        @QueryParam("rqstsQty") @DefaultValue("-1") int rqstsQty,
                                        @QueryParam("rqstsDate") @DefaultValue("UNDECLARED") String rqstsDate,
                                        @QueryParam("reqID") @DefaultValue("-1") int reqID){
        return requestsH.getRequestsWithArg(rqstsID, rqstsQty, rqstsDate, reqID);
    }

}
