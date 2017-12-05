package utilities;

import java.util.LinkedHashMap;

public class QueryParamUtility {

    private LinkedHashMap<String , Object> entities = new LinkedHashMap<>(); //Entities
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

}
