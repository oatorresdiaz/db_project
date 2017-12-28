import handler.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import utilities.HardWiredUtility;
import utilities.QueryParamUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//Main URI path
@Path("/")
public class Main {

    //User
    private static UsersHandler usrs = new UsersHandler();
    //User subcategories
    private static AdminsHandler admns = new AdminsHandler();
    private static SuppliersHandler spplrs = new SuppliersHandler();
    private static RequestersHandler rqstr = new RequestersHandler();
    //Resources
    private static ResourcesHandler rs = new ResourcesHandler();
    //Resources relations
    private static InventoryHandler inv = new InventoryHandler();
    private static RequestsHandler rqsts = new RequestsHandler();
    //Requester and Inventory relations
    private static ReserveHandler rsrv = new ReserveHandler();
    private static PurchasesHandler prchs = new PurchasesHandler();

    //HARDWIRED
    HardWiredUtility hw = new HardWiredUtility();

    public static final String driver = "org.postgresql.Driver";
    public static final String url = "jdbc:postgresql://localhost:5432/dbTest2";
    public static final String username = "postgres";
    public static final String password = "Schultz123";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("HELLO WORLD!");
    }


    @GET
    @Produces("text/plain")
    public String getWelcomeMessage() {
        return "WELCOME TO HURRICANE MARIA DISASTER THINGY STUFF.";
    }

    @GET
    @Path("db_project/error")
    @Produces("text/plain")
    public Response get404ErrorMessage() {
        return Response.status(404).build();
    }

    @GET
    @Path("db_project/search/{entity1}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response entity1(@PathParam("entity1") String entity1) {

        ArrayList<LinkedHashMap<String, Object>> list =  getAll(entity1);
        if(list.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity = GE(list);
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/search/{entity1}/{entity2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response entity1NIJentity2(@PathParam("entity1") String entity1, @PathParam("entity2") String entity2) {
        ArrayList<LinkedHashMap<String, Object>> list1 = getAll(entity1);
        ArrayList<LinkedHashMap<String, Object>> list2 = getAll(entity2);
        ArrayList<LinkedHashMap<String, Object>> result = hw.listNIJ(list1, list2);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity = GE(result);
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/search/{entity1}/{entity2}/{entity3}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response entity1NIJentity2NIJentity3(@PathParam("entity1") String entity1, @PathParam("entity2") String entity2, @PathParam("entity3") String entity3) {
        ArrayList<LinkedHashMap<String, Object>> list1 = (ArrayList<LinkedHashMap<String, Object>>) entity1NIJentity2(entity1, entity2).getEntity();
        ArrayList<LinkedHashMap<String, Object>> list2 = getAll(entity3);
        ArrayList<LinkedHashMap<String, Object>> result = hw.listNIJ(list1, list2);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity = GE(result);
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/search/{entity1}/{entity2}/{entity3}/{entity4}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response entity1NIJentity2NIJentity3NIJentity4(@PathParam("entity1") String entity1, @PathParam("entity2") String entity2, @PathParam("entity3") String entity3, @PathParam("entity4") String entity4) {
        ArrayList<LinkedHashMap<String, Object>> list1 = (ArrayList<LinkedHashMap<String, Object>>) entity1NIJentity2NIJentity3(entity1, entity2, entity3).getEntity();
        ArrayList<LinkedHashMap<String, Object>> list2 = getAll(entity4);
        ArrayList<LinkedHashMap<String, Object>> result = hw.listNIJ(list1, list2);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity = GE(result);
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/search/{entity1}/{entity2}/{entity3}/{entity4}/{entity5}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response entity1NIJentity2NIJentity3NIJentity4NIJentity5(@PathParam("entity1") String entity1, @PathParam("entity2") String entity2, @PathParam("entity3") String entity3, @PathParam("entity4") String entity4, @PathParam("entity5") String entity5) {
        ArrayList<LinkedHashMap<String, Object>> list1 = (ArrayList<LinkedHashMap<String, Object>>) entity1NIJentity2NIJentity3NIJentity4(entity1, entity2, entity3, entity4).getEntity();
        ArrayList<LinkedHashMap<String, Object>> list2 = getAll(entity5);
        ArrayList<LinkedHashMap<String, Object>> result = hw.listNIJ(list1, list2);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity = GE(result);
        return Response.ok(entity).build();
    }

    //USING ARGUMENTS

    @GET
    @Path("db_project/search/{entity1}/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response entity1WithArg(@PathParam("entity1") String entity1, @Context UriInfo uriInfo) {
        ArrayList<LinkedHashMap<String, Object>> list =  getAll(entity1);
        if(list.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity = GE(list);
        //With Arg
        QueryParamUtility qpu = new QueryParamUtility();
        LinkedHashMap<String , Object> queryParam = qpu.findQueryParam(entity1, null, null, null, null, uriInfo);
        if (queryParam.isEmpty()) return get404ErrorMessage();
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/search/{entity1}/{entity2}/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response entity1NIJentity2WithArg(@PathParam("entity1") String entity1, @PathParam("entity2") String entity2, @Context UriInfo uriInfo) {
        ArrayList<LinkedHashMap<String, Object>> list1 = getAll(entity1);
        ArrayList<LinkedHashMap<String, Object>> list2 = getAll(entity2);
        ArrayList<LinkedHashMap<String, Object>> result = hw.listNIJ(list1, list2);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity = GE(result);
        //With Arg
        QueryParamUtility qpu = new QueryParamUtility();
        //
        LinkedHashMap<String , Object> queryParam = qpu.findQueryParam(entity1, entity2, null, null, null, uriInfo);
        if (queryParam.isEmpty()) return get404ErrorMessage();
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/search/{entity1}/{entity2}/{entity3}/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response entity1NIJentity2NIJentity3WithArg(@PathParam("entity1") String entity1, @PathParam("entity2") String entity2, @PathParam("entity3") String entity3, @Context UriInfo uriInfo) {
        ArrayList<LinkedHashMap<String, Object>> list1 = (ArrayList<LinkedHashMap<String, Object>>) entity1NIJentity2(entity1, entity2).getEntity();
        ArrayList<LinkedHashMap<String, Object>> list2 = getAll(entity3);
        ArrayList<LinkedHashMap<String, Object>> result = hw.listNIJ(list1, list2);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity = GE(result);
        //With Arg
        QueryParamUtility qpu = new QueryParamUtility();
        LinkedHashMap<String , Object> queryParam = qpu.findQueryParam(entity1, entity2, entity3, null, null, uriInfo);
        if (queryParam.isEmpty()) return get404ErrorMessage();
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/search/{entity1}/{entity2}/{entity3}/{entity4}/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response entity1NIJentity2NIJentity3NIJentity4WithArg(@PathParam("entity1") String entity1, @PathParam("entity2") String entity2, @PathParam("entity3") String entity3, @PathParam("entity4") String entity4, @Context UriInfo uriInfo) {
        ArrayList<LinkedHashMap<String, Object>> list1 = (ArrayList<LinkedHashMap<String, Object>>) entity1NIJentity2NIJentity3(entity1, entity2, entity3).getEntity();
        ArrayList<LinkedHashMap<String, Object>> list2 = getAll(entity4);
        ArrayList<LinkedHashMap<String, Object>> result = hw.listNIJ(list1, list2);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity = GE(result);
        //With Arg
        QueryParamUtility qpu = new QueryParamUtility();
        LinkedHashMap<String , Object> queryParam = qpu.findQueryParam(entity1, entity2, entity3, entity4, null, uriInfo);
        if (queryParam.isEmpty()) return get404ErrorMessage();
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/search/{entity1}/{entity2}/{entity3}/{entity4}/{entity5}/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response entity1NIJentity2NIJentity3NIJentity4NIJentity5(@PathParam("entity1") String entity1, @PathParam("entity2") String entity2, @PathParam("entity3") String entity3, @PathParam("entity4") String entity4, @PathParam("entity5") String entity5, @Context UriInfo uriInfo) {
        ArrayList<LinkedHashMap<String, Object>> list1 = (ArrayList<LinkedHashMap<String, Object>>) entity1NIJentity2NIJentity3NIJentity4(entity1, entity2, entity3, entity4).getEntity();
        ArrayList<LinkedHashMap<String, Object>> list2 = getAll(entity5);
        ArrayList<LinkedHashMap<String, Object>> result = hw.listNIJ(list1, list2);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity = GE(result);
        //With Arg
        QueryParamUtility qpu = new QueryParamUtility();
        LinkedHashMap<String , Object> queryParam = qpu.findQueryParam(entity1, entity2, entity3, entity4, entity5, uriInfo);
        if (queryParam.isEmpty()) return get404ErrorMessage();
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllResourcesById(@PathParam("id") int id) {
        if (usrs.getUserById(id).isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity = new GenericEntity<LinkedHashMap<String, Object>>(usrs.getUserById(id)) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/admins/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdminById(@PathParam("id") int id) {
        LinkedHashMap<String, Object> result = admns.getAdminById(id);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {
                };
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/suppliers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupplierById(@PathParam("id") int id) {
        LinkedHashMap<String, Object> result = spplrs.getSupplierById(id);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {
                };
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/requesters/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequesterById(@PathParam("id") int id) {
        LinkedHashMap<String, Object> result = rqstr.getRequesterId(id);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {
                };
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/resources/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResourceById(@PathParam("id") int id) {
        LinkedHashMap<String, Object> result = rs.getResourceById(id);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {
                };
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/inventory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryById(@PathParam("id") int id) {
        LinkedHashMap<String, Object> result = inv.getInventoryById(id);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {
                };
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/reserve/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReserveId(@PathParam("id") int id) {
        LinkedHashMap<String, Object> result = rsrv.getReserveId(id);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {
                };
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/purchases/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPurchasesById(@PathParam("id") int id) {
        LinkedHashMap<String, Object> result = prchs.getPurchaseById(id);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {
                };
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/requests/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestsById(@PathParam("id") int id) {
        LinkedHashMap<String, Object> result = rqsts.getRequestsById(id);
        if (result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {
                };
        return Response.ok(entity).build();
    }

    private static GenericEntity<ArrayList<LinkedHashMap<String, Object>>> GE(ArrayList<LinkedHashMap<String, Object>> list){
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(list) {
                };
        return entity;
    }

    public ArrayList<LinkedHashMap<String, Object>> getAll(String entity){
        if(entity.equals("users")) return usrs.getAllUsers();
        else if(entity.equals("admins")) return admns.getAllAdmins();
        else if(entity.equals("suppliers")) return spplrs.getAllSuppliers();
        else if(entity.equals("requesters")) return rqstr.getAllRequesters();
        else if(entity.equals("inventory")) return inv.getAllInventory();
        else if(entity.equals("requests")) return rqsts.getAllRequests();
        else if(entity.equals("reserve")) return rsrv.getAllReserves();
        else if(entity.equals("purchases")) return prchs.getAllPurchases();
        else if(entity.equals("resources")) return rs.getAllResources();
        return null;
    }

}