package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SuppliersDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllSuppliers() {
        Object[] supp1 = new Object[4];
        supp1[0] = 0;
        supp1[1] = 1;
        Object[] supp2 = new Object[4];
        supp2[0] = 1;
        supp2[1] = 2;
        Object[] supp3 = new Object[4];
        supp3[0] = 2;
        supp3[1] = 3;
        ArrayList<Object[]> testSuppliers = new ArrayList<Object[]>();
        testSuppliers.add(supp1);
        testSuppliers.add(supp2);
        testSuppliers.add(supp3);
        return testSuppliers;
    }

    public ArrayList<Object[]> getSuppliersWithArg(LinkedHashMap<String, Object> argsDic) {
        Object[] keys = argsDic.keySet().toArray();
        String query = "";
        if(argsDic.size() == 1) query = "select * from suppliers where " + keys[0] + " = " + argsDic.get(keys[0]) + ";";
        else if (argsDic.size() > 1){
            query = "select * from suppliers where " + keys[0] + " = " + argsDic.get(keys[0]);
            for(int i = 1; i < argsDic.size(); i++){
                query += " and " + keys[i] + " = " + argsDic.get(keys[i]);
            }
            query += ";";
        }
        System.out.println(query);
        return getAllSuppliers(); //HARD WIRED. IN PHASE II THE RETURN WILL MATCH THE QUERY.
    }
}
