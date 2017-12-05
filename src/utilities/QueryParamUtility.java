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
        entities.put("admins", getAdminAttributes());
        entities.put("suppliers", getSupplierAttributes());
        entities.put("requesters", getRequesterAttributes());
        entities.put("inventory", getInventoryAttributes());
        entities.put("requests", getRequestsAttributes());
        entities.put("reserve", getReserveAttributes());
        entities.put("purchases", getPurchasesAttributes());
        entities.put("resources", getResourcesAttributes());
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

    public LinkedHashMap<String , Object> getAdminAttributes(){
        adms.put("adminId", -1);
        adms.put("uID", -1);
        return adms;
    }

    public LinkedHashMap<String , Object> getSupplierAttributes(){
        spplrs.put("suppID", -1);
        spplrs.put("uID", -1);
        return spplrs;
    }

    public LinkedHashMap<String , Object> getRequesterAttributes(){
        rqstrs.put("reqID", -1);
        rqstrs.put("uID", -1);
        return rqstrs;
    }

    public LinkedHashMap<String , Object> getInventoryAttributes(){
        inv.put("invID", -1);
        inv.put("suppID", -1);
        inv.put("resID", -1);
        inv.put("invDate", "UNDECLARED");
        inv.put("invQty", -1);
        inv.put("invPrice", -1);
        inv.put("invReserved", -1);
        inv.put("invAvailable", -1);
        return inv;
    }

    public LinkedHashMap<String , Object> getRequestsAttributes(){
        rqsts.put("reqID", -1);
        rqsts.put("resID", -1);
        rqsts.put("rqstsDate", "UNDECLARED");
        rqsts.put("rqstsQty", -1);
        return rqsts;
    }

    public LinkedHashMap<String , Object> getReserveAttributes(){
        rsrv.put("reqID", -1);
        rsrv.put("invID", -1);
        rsrv.put("resDate", "UNDECLARED");
        rsrv.put("resExpDate", "UNDECLARED");
        rsrv.put("resQty", -1);
        return rsrv;
    }

    public LinkedHashMap<String , Object> getPurchasesAttributes(){
        prchs.put("reqID", -1);
        prchs.put("invID", -1);
        prchs.put("prchsQty", -1);
        prchs.put("prchsDate", "UNDECLARED");
        return prchs;
    }

    public LinkedHashMap<String , Object> getResourcesAttributes(){
        res.put("resID", -1);
        res.put("resCategory", "UNDECLARED");
        res.put("resSubCategory", "UNDECLARED");
        return res;
    }

    public LinkedHashMap<String , Object> findQueryParam(String entity1, String entity2, String entity3, String entity4, String entity5, UriInfo uriInfo){
        LinkedHashMap<String , Object>  e1,e2,e3,e4,e5;
        if(entity1!=null) e1 = getEntities().get(entity1);
        else e1 = new LinkedHashMap<String , Object>();
        if(entity2!=null) e2 = getEntities().get(entity2);
        else e2 = new LinkedHashMap<String , Object>();
        if(entity3!=null) e3 = getEntities().get(entity3);
        else e3 = new LinkedHashMap<String , Object>();
        if(entity4!=null) e4 = getEntities().get(entity4);
        else e4 = new LinkedHashMap<String , Object>();
        if(entity5!=null) e5 = getEntities().get(entity5);
        else e5 = new LinkedHashMap<String , Object>();
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
            if(e3.containsKey(keySet[j].toString())){
                e3.put(keySet[j].toString(), attributes.get(keySet[j].toString()));
            }
            if(e4.containsKey(keySet[j].toString())){
                e4.put(keySet[j].toString(), attributes.get(keySet[j].toString()));
            }
            if(e5.containsKey(keySet[j].toString())){
                e5.put(keySet[j].toString(), attributes.get(keySet[j].toString()));
            }
            if(!e1.containsKey(keySet[j].toString())
                    && !e2.containsKey(keySet[j].toString())
                    && !e3.containsKey(keySet[j].toString())
                    && !e4.containsKey(keySet[j].toString())
                    && !e5.containsKey(keySet[j].toString())){
                e1.clear();
                return e1; //RETURN EMPTY BECAUSE QUERY IS WRONG
            }
        }
        if(entity2 != null) e1.putAll(e2);
        if(entity3 != null) e1.putAll(e3);
        if(entity4 != null) e1.putAll(e4);
        if(entity5 != null) e1.putAll(e5);
        return build_goorArg_dic(e1);
    }

}
