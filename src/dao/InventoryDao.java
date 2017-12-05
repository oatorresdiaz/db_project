package dao;

import utilities.DateCompound;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class InventoryDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllInventories(){
        DateCompound d1 = new DateCompound("12122012");
        DateCompound d2 = new DateCompound("11092001");
        DateCompound d3 = new DateCompound("05301996");
        Object[] inv1 = new Object[8];
        inv1[0] = 0;
        inv1[1] = 0;
        inv1[2] = 0;
        inv1[3] = d1.asString();
        inv1[4] = 10;
        inv1[5] = 50.00;
        inv1[6] = 10;
        inv1[7] = 10;
        Object[] inv2 = new Object[8];
        inv2[0] = 0;
        inv2[1] = 1;
        inv2[2] = 1;
        inv2[3] = d2.asString();
        inv2[4] = 5;
        inv2[5] = 12.64;
        inv2[6] = 10;
        inv2[7] = 12;
        Object[] inv3 = new Object[8];
        inv3[0] = 0;
        inv3[1] = 1;
        inv3[2] = 2;
        inv3[3] = d3.asString();
        inv3[4] = 34;
        inv3[5] = 110.00;
        inv3[6] = 10;
        inv3[7] = 11;
        Object[] inv4 = new Object[8];
        inv4[0] = 0;
        inv4[1] = 0;
        inv4[2] = 1;
        inv4[3] = d1.asString();
        inv4[4] = 10;
        inv4[5] = 50.00;
        inv4[6] = 10;
        inv4[7] = 2;
        Object[] inv5 = new Object[8];
        inv5[0] = 1;
        inv5[1] = 0;
        inv5[2] = 3;
        inv5[3] = d2.asString();
        inv5[4] = 5;
        inv5[5] = 12.64;
        inv5[6] = 10;
        inv5[7] = 45;
        Object[] inv6 = new Object[8];
        inv6[0] = 2;
        inv6[1] = 3;
        inv6[2] = 1;
        inv6[3] = d3.asString();
        inv6[4] = 34;
        inv6[5] = 110.00;
        inv6[6] = 10;
        inv6[7] = 20;
        ArrayList<Object[]> testResources = new ArrayList<Object[]>();
        testResources.add(inv1);
        testResources.add(inv2);
        testResources.add(inv3);
        testResources.add(inv4);
        testResources.add(inv5);
        testResources.add(inv6);
        return testResources;
    }

    public ArrayList<Object[]> getInventoryBySupplierId(int id) {
        return getAllInventories();
    }

    public ArrayList<Object[]> getInventoryWithArg(LinkedHashMap<String, Object> argsDic) {
        Object[] keys = argsDic.keySet().toArray();
        String query = "";
        if(argsDic.size() == 1) query = "select * from inventory where " + keys[0] + " = " + argsDic.get(keys[0]) + ";";
        else if (argsDic.size() > 1){
            query = "select * from inventory where " + keys[0] + " = " + argsDic.get(keys[0]);
            for(int i = 1; i < argsDic.size(); i++){
                query += " and " + keys[i] + " = " + argsDic.get(keys[i]);
            }
            query += ";";
        }
        System.out.println(query);
        return getAllInventories(); //HARD WIRED. IN PHASE II THE RETURN WILL MATCH THE QUERY.
    }

}
