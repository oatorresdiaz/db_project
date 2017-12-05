package handler;

import dao.SuppliersDao;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Handler for the supplier entity
 */
public class SuppliersHandler {
    public static LinkedHashMap<String, Object> result;

    /**
     * Builds the schema for the entity
     * @param row - value pertaining to the key (attribute) of the entity
     * @return - LinkedHashMap of the attributes
     */
    public static LinkedHashMap<String, Object> build_suppliers_dic(Object[] row){
        result = new LinkedHashMap<String, Object>();
        result.put("suppID", row[0]);
        result.put("uID", row[1]);
        return result;
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
     * Get all the suppliers
     * @return - return an ArrayList of all the suppliers in the database
     */
    public static ArrayList<LinkedHashMap<String, Object>> getAllSuppliers(){
        SuppliersDao spplrs = new SuppliersDao();
        ArrayList<Object[]> spplrsList = spplrs.getAllSuppliers();
        ArrayList<LinkedHashMap<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < spplrsList.size(); i++){
            result.add(build_suppliers_dic(spplrsList.get(i)));
        }
        return result;
    }

    /**
     * Get a supplier from the ArrayList by it's ID
     * @param id - index in the ArrayList
     * @return - return the supplier with the specified ID
     */
    public static LinkedHashMap<String, Object> getSupplierById(int id){
        SuppliersDao spplrs = new SuppliersDao();
        ArrayList<Object[]> spplrsList = spplrs.getAllSuppliers();
        return build_suppliers_dic(spplrsList.get(id));
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
