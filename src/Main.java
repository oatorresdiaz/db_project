import handler.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import utilities.HardWiredUtility;


//Main URI path
@Path("/db_project")
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

    GenericEntity<LinkedHashMap<String, Object>> entity;

    //HARDWIRED
    HardWiredUtility hw = new HardWiredUtility();

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
    @Path("/error")
    @Produces("text/plain")
    public Response get404ErrorMessage() {
        return Response.status(404).build();
    }

    /*@GET
    @Path("/{entity1}")
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
    }*/

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        return UsersHandler.getAllUsers();
    }

    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int id) {
        return UsersHandler.getUserById(id);
    }

    @GET
    @Path("/admins")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAdmins() {
        return AdminsHandler.getAllAdmins();
    }

    @GET
    @Path("/admins/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdminById(@PathParam("id") int id) {
        return AdminsHandler.getAdminById(id);
    }

    @GET
    @Path("/suppliers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSuppliers() {
        return SuppliersHandler.getAllSuppliers();
    }

    @GET
    @Path("/suppliers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupplierById(@PathParam("id") int id) {
        return SuppliersHandler.getSupplierById(id);
    }

    @GET
    @Path("/requesters")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRequesters() {
        return RequestersHandler.getAllRequesters();
    }

    @GET
    @Path("/requesters/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequesterById(@PathParam("id") int id) {
        return RequestersHandler.getRequesterById(id);
    }

    /*@GET
    @Path("/resources/{id}")
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
    @Path("/inventory/{id}")
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
    @Path("/reserve/{id}")
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
    @Path("/purchases/{id}")
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
    @Path("/requests/{id}")
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
    }*/

}