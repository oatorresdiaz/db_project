package handler;

import dao.SuppliersDao;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SuppliersHandler {
    public static LinkedHashMap<String, Object> result;

    public static LinkedHashMap<String, Object> build_suppliers_dic(Object[] row){
        result = new LinkedHashMap<String, Object>();
        result.put("suppID", row[0]);
        result.put("uID", row[1]);
        return result;
    }

    public static Response getAllSuppliers(){
        SuppliersDao dao = new SuppliersDao();
        ArrayList<Object[]> suppliers_list = dao.getAllSuppliers();
        ArrayList<LinkedHashMap<String,Object>> result_list = new ArrayList<>();
        for(int i = 0; i < suppliers_list.size(); i++){
            LinkedHashMap<String,Object> result = build_suppliers_dic(suppliers_list.get(i));
            result_list.add(result);
        }
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity;
        entity= new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(result_list) {};
        return Response.ok(entity).build();
    }

    public static Response getSupplierById(int id){
        SuppliersDao dao = new SuppliersDao();
        Object[] row = dao.getSupplierById(id);
        if(row == null) return Response.status(404).build();
        else{
            LinkedHashMap<String, Object> supplier = build_suppliers_dic(row);
            GenericEntity<LinkedHashMap<String, Object>> entity;
            entity= new GenericEntity<LinkedHashMap<String,Object>>(supplier) {};
            return Response.ok(entity).build();
        }
    }



    /**
     * Gets the LinkedHashMap of the entity
     * @return - return the LinkedHashMap of the entity
     */
    public static LinkedHashMap<String, Object> getAttributes(){
        return result;
    }

    /**
     * Verifies that the valued of the attributes are valid
     * @param suppID - supplier ID
     * @param uID - user ID
     * @return - return the LinkedHashMap oof the valid attributes
     */
    private LinkedHashMap<String,Object> build_goodArg_dic(int suppID, int uID) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        if(suppID != -1) result.put("suppID", suppID);
        if(uID != -1) result.put("uID", uID);
        return result;
    }

    /**
     * Get an ArrayList of suppliers that meet the required arguments
     * @param suppID - supplier ID
     * @param uID - user ID
     * @return - return ArrayList of suppliers that meet the required arguments
     */
    public ArrayList<LinkedHashMap<String, Object>> getSuppliersWithArg(int suppID, int uID) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(suppID, uID);
        SuppliersDao spplrs = new SuppliersDao();
        ArrayList<Object[]> spplrsList = spplrs.getSuppliersWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < spplrsList.size(); i++) {
            resultList.add(build_suppliers_dic(spplrsList.get(i)));
        }
        return resultList;
    }
}
