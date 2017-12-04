package handler;

import dao.SuppliersDao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SuppliersHandler {

    public static LinkedHashMap<String, Object> build_suppliers_dic(Object[] row){
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("suppID", row[0]);
        result.put("uID", row[1]);
        result.put("suppLat", row[2]);
        result.put("suppLong", row[3]);
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

}
