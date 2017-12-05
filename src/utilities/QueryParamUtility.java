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
    }

    public LinkedHashMap<String , Object> build_goorArg_dic(LinkedHashMap<String , Object> dic){
        Object[] keySet =  dic.keySet().toArray();
        for(int i = 0; i < keySet.length; i++){
            if(dic.get(keySet[i]).equals(-1) || dic.get(keySet[i]) == "UNDECLARED"){
                dic.remove(keySet[i]);
            }
        }
        System.out.println(dic);
        return dic;
    }

    public LinkedHashMap<String , LinkedHashMap<String , Object>> getEntities(){
        entities.put("users", getUserAttributes());
        entities.put("admins", adms);
        entities.put("suppliers", getSupplierAttributes());
        entities.put("requesters", rqstrs);
        entities.put("inventory", inv);
        entities.put("requests", rqsts);
        entities.put("reserve", rsrv);
        entities.put("purchases", prchs);
        entities.put("resources", res);
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

    public LinkedHashMap<String , Object> findQueryParam(String entity1, String entity2, UriInfo uriInfo){
        LinkedHashMap<String , Object>  e1 = getEntities().get(entity1);
        LinkedHashMap<String , Object>  e2 = getEntities().get(entity2);
        LinkedHashMap<String , Object>  attributes = new LinkedHashMap<String , Object>();
        String[] queries = uriInfo.getRequestUri().getQuery().split("&");
        for(int i = 0; i < queries.length; i++){
            String[] query = queries[i].split("=");
            String key = query[0];
            String value = query[1];
            attributes.put(key, value);
        }
        Object[] keySet =  attributes.keySet().toArray();
        for(int j = 0; j < keySet.length; j++){
            if(e1.containsKey(keySet[j].toString())){
                e1.put(keySet[j].toString(), attributes.get(keySet[j].toString()));
            }
            if(e2.containsKey(keySet[j].toString())){
                e2.put(keySet[j].toString(), attributes.get(keySet[j].toString()));
            }
            if(!e1.containsKey(keySet[j].toString()) && !e2.containsKey(keySet[j].toString())){
                e1.clear();
                return e1; //RETURN EMPTY BECAUSE QUERY IS WRONG
            }
        }
        e1.putAll(e2);
        return build_goorArg_dic(e1);
    }

}
