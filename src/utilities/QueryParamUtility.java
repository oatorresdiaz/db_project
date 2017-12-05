package utilities;

import javax.ws.rs.core.UriInfo;
import java.util.LinkedHashMap;

public class QueryParamUtility {

    private LinkedHashMap<String , LinkedHashMap<String , Object>> entities = new LinkedHashMap<>(); //Entities
    private LinkedHashMap<String , Object> usrs = new LinkedHashMap<>(); //Users
    private LinkedHashMap<String , Object> adms = new LinkedHashMap<>(); //Admins
    private LinkedHashMap<String , Object> spplrs = new LinkedHashMap<>(); //Suppliers
    private LinkedHashMap<String , Object> rqstrs = new LinkedHashMap<>(); //Requesters
    private LinkedHashMap<String , Object> inv = new LinkedHashMap<>(); //Inventory
    private LinkedHashMap<String , Object> rqsts = new LinkedHashMap<>(); //Requests
    private LinkedHashMap<String , Object> rsrv = new LinkedHashMap<>(); //Reserve
    private LinkedHashMap<String , Object> prchs = new LinkedHashMap<>(); //Purchases
    private LinkedHashMap<String , Object> res = new LinkedHashMap<>(); //Resources

    public QueryParamUtility(){
        entities.put("users", usrs);
        entities.put("adms", adms);
        entities.put("spplrs", spplrs);
        entities.put("rqstrs", rqstrs);
        entities.put("inv", inv);
        entities.put("rqsts", rqsts);
        entities.put("rsrv", rsrv);
        entities.put("prchs", prchs);
        entities.put("res", res);
    }

    public LinkedHashMap<String , LinkedHashMap<String , Object>> getEntities(){
        return entities;
    }

    public LinkedHashMap<String , Object> getUserAttributes(){
        usrs.put("uID", -1);
        usrs.put("uFName", "UNDECLARED");
        usrs.put("uLName", "UNDECLARED");
        usrs.put("uGender", "UNDECLARED");
        usrs.put("uBirthDate", "UNDECLARED");
        usrs.put("uRegion", "UNDECLARED");
        usrs.put("uPhoneNumber", -1);
        usrs.put("uAddress", "UNDECLARED");
        usrs.put("username", "UNDECLARED");
        usrs.put("password", "UNDECLARED");
        return usrs;
    }

    public LinkedHashMap<String , Object> getSupplierAttributes(){
        spplrs.put("suppID", -1);
        spplrs.put("uID", -1);
        return spplrs;
    }

    public void fingQueryParam(String entity1, String entity2, UriInfo uriInfo){
        LinkedHashMap<String , Object>  e1 = getEntities().get(entity1);
        LinkedHashMap<String , Object>  e2 = getEntities().get(entity2);
        String[] queries = uriInfo.toString().split("=");
    }

}
