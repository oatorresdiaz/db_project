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
import java.util.LinkedHashMap;
import utilities.JoinLinkedHashMaps;


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

    private static JoinLinkedHashMaps JLHM = new JoinLinkedHashMaps();

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
    public Response getAllUsers(){
        if(usrs.getAllUsers().isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(usrs.getAllUsers()) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllResourcesById(@PathParam("id") int id){
        if(usrs.getUserById(id).isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String,Object>>(usrs.getUserById(id)) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/users/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersWithArg(@QueryParam("uID") @DefaultValue("-1") int uID,
                                        @QueryParam("uFName") @DefaultValue("UNDECLARED") String uFName,
                                        @QueryParam("uLName") @DefaultValue("UNDECLARED") String uLName,
                                        @QueryParam("uGender") @DefaultValue("UNDECLARED") String uGender,
                                        @QueryParam("uBirthDate") @DefaultValue("UNDECLARED") String uBirthDate,
                                        @QueryParam("uRegion") @DefaultValue("UNDECLARED") String uRegion,
                                        @QueryParam("uPhoneNumber") @DefaultValue("-1") int uPhoneNumber,
                                        @QueryParam("uAddress") @DefaultValue("UNDECLARED") String uAddress,
                                        @QueryParam("username") @DefaultValue("UNDECLARED") String username,
                                        @QueryParam("password") @DefaultValue("UNDECLARED") String password){
        ArrayList<LinkedHashMap<String, Object>> result = usrs.getUsersWithArg(uID, uFName, uLName, uGender, uBirthDate, uRegion, uPhoneNumber, uAddress, username, password);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/admins")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAdmins(){
        ArrayList<LinkedHashMap<String, Object>> result = admns.getAllAdmins();
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/admins/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdminById(@PathParam("id") int id){
        LinkedHashMap<String, Object> result = admns.getAdminById(id);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/admins/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdminsWithArg(@QueryParam("adminID") @DefaultValue("-1") int adminID,
                                 @QueryParam("uID") @DefaultValue("-1") int uID){
        ArrayList<LinkedHashMap<String, Object>> result = admns.getAdminsWithArg(adminID, uID);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/suppliers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSuppliers(){
        ArrayList<LinkedHashMap<String, Object>> result = spplrs.getAllSuppliers();
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/suppliers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupplierById(@PathParam("id") int id){
        LinkedHashMap<String, Object> result = spplrs.getSupplierById(id);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/suppliers/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSuppliersWithArg(@QueryParam("suppID") @DefaultValue("-1") int suppID,
                                 @QueryParam("uID") @DefaultValue("-1") int uID){
        ArrayList<LinkedHashMap<String, Object>> result = spplrs.getSuppliersWithArg(suppID, uID);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/requesters")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRequesters(){
        ArrayList<LinkedHashMap<String, Object>> result = rqstr.getAllRequesters();
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/requesters/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequesterById(@PathParam("id") int id){
        LinkedHashMap<String, Object> result = rqstr.getRequesterId(id);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/requesters/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestersWith(@QueryParam("reqID") @DefaultValue("-1") int reqID,
                                        @QueryParam("uID") @DefaultValue("-1") int uID){
        ArrayList<LinkedHashMap<String, Object>> result = rqstr.getRequestersWithArg(reqID, uID);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/resources")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllResources(){
        ArrayList<LinkedHashMap<String, Object>> result = rs.getAllResources();
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/resources/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResourceById(@PathParam("id") int id){
        LinkedHashMap<String, Object> result = rs.getResourceById(id);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/resources/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResourcesWith(@QueryParam("resID") @DefaultValue("-1") int resID,
                                     @QueryParam("resCategory") @DefaultValue("UNDECLARED") String resCategory,
                                     @QueryParam("resSubCategory") @DefaultValue("UNDECLARED") String resSubCategory){
        ArrayList<LinkedHashMap<String, Object>> result = rs.getResourcesWithArg(resID, resCategory, resSubCategory);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/inventory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInventory(){
        ArrayList<LinkedHashMap<String, Object>> result = inv.getAllInventory();
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/inventory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryById(@PathParam("id") int id){
        LinkedHashMap<String, Object> result = inv.getInventoryById(id);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>> (result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/inventory/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryWithArg(@QueryParam("invID") @DefaultValue("-1") int invID,
                                        @QueryParam("suppID") @DefaultValue("-1") int suppID,
                                        @QueryParam("invDate") @DefaultValue("UNDECLARED") String invDate,
                                        @QueryParam("invQty") @DefaultValue("-1") int invQty,
                                        @QueryParam("invPrice") @DefaultValue("-1") int invPrice,
                                        @QueryParam("invReserved") @DefaultValue("-1") int invReserved){
        ArrayList<LinkedHashMap<String, Object>> result = inv.getInventoryWithArg(invID, suppID, invDate, invQty, invPrice, invReserved);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/reserve")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReserves(){
        ArrayList<LinkedHashMap<String, Object>> result = rsrv.getAllReserves();
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/reserve/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReserveId(@PathParam("id") int id){
        LinkedHashMap<String, Object> result = rsrv.getReserveId(id);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/reserve/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReserveWithArg(@QueryParam("reqID") @DefaultValue("-1") int reqID,
                                        @QueryParam("invID") @DefaultValue("-1") int invID,
                                        @QueryParam("resDate") @DefaultValue("UNDECLARED") String resDate,
                                        @QueryParam("resExpDate") @DefaultValue("UNDECLARED") String resExpDate,
                                        @QueryParam("resQty") @DefaultValue("-1") int resQty){
        ArrayList<LinkedHashMap<String, Object>> result = rsrv.getReserveWithArg(reqID, invID, resDate, resExpDate, resQty);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/purchases/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPurchasesById(@PathParam("id") int id){
        LinkedHashMap<String, Object> result = prchs.getPurchaseById(id);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/purchases/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReserveWithArg(@QueryParam("reqID") @DefaultValue("-1") int reqID,
                                      @QueryParam("invID") @DefaultValue("-1") int invID,
                                      @QueryParam("prchsDate") @DefaultValue("UNDECLARED") String purchaseDate,
                                      @QueryParam("prchsQty") @DefaultValue("-1") int purchaseQty){
        ArrayList<LinkedHashMap<String, Object>> result = prchs.getPurchaseWithArg(reqID, invID, purchaseDate, purchaseQty);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/requests")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRequests(){
        ArrayList<LinkedHashMap<String, Object>> result = rqsts.getAllRequests();
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/requests/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestsById(@PathParam("id") int id){
        LinkedHashMap<String, Object> result = rqsts.getRequestsById(id);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<LinkedHashMap<String, Object>> entity =
                new GenericEntity<LinkedHashMap<String, Object>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/requests/with")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequestWithArg(@QueryParam("reqID") @DefaultValue("-1") int reqID,
                                        @QueryParam("resID") @DefaultValue("-1") int resID,
                                        @QueryParam("rqstDate") @DefaultValue("UNDECLARED") String rqstDate,
                                        @QueryParam("rqstsQty") @DefaultValue("-1") int rqstsQty){
        ArrayList<LinkedHashMap<String, Object>> result = rqsts.getRequestsWithArg(reqID, resID, rqstDate, rqstsQty);
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/user/supplier")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserNaturalJoinSupplier(){
        ArrayList<LinkedHashMap<String, Object>> result = spplrs.getUserNaturalJoinSupplier();
        if(result.isEmpty()) return get404ErrorMessage();
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    public Response userNIJSupplier(){
        ArrayList<LinkedHashMap<String, Object>> users    = usrs.getAllUsers();
        ArrayList<LinkedHashMap<String, Object>> suppliers = spplrs.getAllSuppliers();
        ArrayList<LinkedHashMap<String, Object>> result     = new ArrayList<>();
        LinkedHashMap<String, Object> element;
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < suppliers.size(); j++) {
                if (users.get(i).get("uID") == suppliers.get(j).get("uID")) {
                    element = JLHM.joinWithEqualArg(users.get(i), suppliers.get(j), "uID");
                    result.add(element);
                }
            }
        }
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
               new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(result) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("db_project/user/admin")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/supplier/inventory")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/supplier/inventory/resources")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/reserve")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/reserve/inventory")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/reserve/inventory/resources")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/purchases")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/purchases/inventory")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/purchases/inventory/resources")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/resources")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/supplier/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/admin/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/supplier/inventory/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/supplier/inventory/resources/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/reserve/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/reserve/inventory/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/reserve/inventory/resources/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/purchases/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/purchases/inventory/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/purchases/inventory/resources/with")
    @Produces(MediaType.APPLICATION_JSON)

    @GET
    @Path("db_project/user/requesters/resources/with")
    @Produces(MediaType.APPLICATION_JSON)

}
