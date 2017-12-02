package handler;

import java.util.ArrayList;
import java.util.Hashtable;

public class SuppliersHandler {

    public static Hashtable<String, Object> build_suppliers_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        result.put("suppID", row[0]);
        result.put("uID", row[1]);
        return result;
    }

    public static ArrayList<Hashtable<String, Object>> getAllSuppliers(){
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < getTestSuppliers().size(); i++){
            result.add(build_suppliers_dic(getTestSuppliers().get(i)));
        }
        return result;
    }

    public static Hashtable<String, Object> getSupplierById(int id){
        return build_suppliers_dic(getTestSuppliers().get(id));
    }

    public static ArrayList<Hashtable<String, Object>> getSuppliersNaturalJoinUser(){
        UsersHandler userHandler = new UsersHandler();
        ArrayList<Hashtable<String, Object>> users = userHandler.getAllUsers();
        ArrayList<Hashtable<String, Object>> suppliers = getAllSuppliers();
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < suppliers.size(); i++){
            for(int j = 0; j < users.size(); j++){
                if(suppliers.get(i).get("uID") == users.get(j).get("uID")){
                    result.add(users.get(j));
                }
            }
        }
        return result;
    }

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getTestSuppliers() {
        Object[] supp1 = new Object[2];
        supp1[0] = 0;
        supp1[1] = 1;
        Object[] supp2 = new Object[2];
        supp2[0] = 1;
        supp2[1] = 2;
        Object[] supp3 = new Object[2];
        supp3[0] = 2;
        supp3[1] = 3;
        ArrayList<Object[]> testSuppliers = new ArrayList<Object[]>();
        testSuppliers.add(supp1);
        testSuppliers.add(supp2);
        testSuppliers.add(supp3);
        return testSuppliers;
    }
}
