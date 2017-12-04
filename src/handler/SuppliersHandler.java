package handler;

import dao.SuppliersDao;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SuppliersHandler {

    public static LinkedHashMap<String, Object> build_suppliers_dic(Object[] row){
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("suppID", row[0]);
        result.put("uID", row[1]);
        //result.put("suppLat", row[2]); WHY IS THIS HERE?
        //result.put("suppLong", row[3]); WHY IS THIS HERE?
        return result;
    }

    private LinkedHashMap<String,Object> build_goodArg_dic(int suppID, int uID) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        if(suppID != -1) result.put("suppID", suppID);
        if(uID != -1) result.put("uID", uID);
        return result;
    }

    public static ArrayList<LinkedHashMap<String, Object>> getAllSuppliers(){
        SuppliersDao spplrs = new SuppliersDao();
        ArrayList<Object[]> spplrsList = spplrs.getAllSuppliers();
        ArrayList<LinkedHashMap<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < spplrsList.size(); i++){
            result.add(build_suppliers_dic(spplrsList.get(i)));
        }
        return result;
    }

    public static LinkedHashMap<String, Object> getSupplierById(int id){
        SuppliersDao spplrs = new SuppliersDao();
        ArrayList<Object[]> spplrsList = spplrs.getAllSuppliers();
        return build_suppliers_dic(spplrsList.get(id));
    }

    public static ArrayList<LinkedHashMap<String, Object>> getSuppliersNaturalJoinUser(){
        UsersHandler userHandler = new UsersHandler();
        ArrayList<LinkedHashMap<String, Object>> users = userHandler.getAllUsers();
        ArrayList<LinkedHashMap<String, Object>> suppliers = getAllSuppliers();
        ArrayList<LinkedHashMap<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < suppliers.size(); i++){
            for(int j = 0; j < users.size(); j++){
                if(suppliers.get(i).get("uID") == users.get(j).get("uID")){
                    result.add(users.get(j));
                }
            }
        }
        return result;
    }

    public Response getSuppliersWithArg(int suppID, int uID) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(suppID, uID);
        SuppliersDao spplrs = new SuppliersDao();
        ArrayList<Object[]> spplrsList = spplrs.getSuppliersWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < spplrsList.size(); i++){
            resultList.add(build_suppliers_dic(spplrsList.get(i)));
        }
        if (resultList.isEmpty()) return Response.status(404).build(); //Malformed query string.
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(resultList) {};
        return Response.ok(entity).build();
    }
}
