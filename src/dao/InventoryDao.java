package dao;

import utilities.DateCompound;

import java.util.ArrayList;
import java.util.Hashtable;

public class InventoryDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllInventories(){
        DateCompound d1 = new DateCompound("12122012");
        DateCompound d2 = new DateCompound("11092001");
        DateCompound d3 = new DateCompound("05301996");
        Object[] inv1 = new Object[6];
        inv1[0] = 0;
        inv1[1] = 0;
        inv1[2] = d1.asString();
        inv1[3] = 10;
        inv1[4] = 50.00;
        inv1[5] = false;
        Object[] inv2 = new Object[6];
        inv2[0] = 0;
        inv2[1] = 1;
        inv2[2] = d2.asString();
        inv2[3] = 5;
        inv2[4] = 12.64;
        inv2[5] = false;
        Object[] inv3 = new Object[6];
        inv3[0] = 0;
        inv3[1] = 1;
        inv3[2] = d3.asString();
        inv3[3] = 34;
        inv3[4] = 110.00;
        inv3[5] = false;
        Object[] inv4 = new Object[6];
        inv4[0] = 0;
        inv4[1] = 0;
        inv4[2] = d1.asString();
        inv4[3] = 10;
        inv4[4] = 50.00;
        inv4[5] = false;
        Object[] inv5 = new Object[6];
        inv5[0] = 1;
        inv5[1] = 0;
        inv5[2] = d2.asString();
        inv5[3] = 5;
        inv5[4] = 12.64;
        inv5[5] = false;
        Object[] inv6 = new Object[6];
        inv6[0] = 2;
        inv6[1] = 3;
        inv6[2] = d3.asString();
        inv6[3] = 34;
        inv6[4] = 110.00;
        inv6[5] = false;
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
        DateCompound d1 = new DateCompound("12122012");
        DateCompound d2 = new DateCompound("11092001");
        DateCompound d3 = new DateCompound("05301996");
        Object[] inv1 = new Object[6];
        inv1[0] = 0;
        inv1[1] = id;
        inv1[2] = d1.asString();
        inv1[3] = 10;
        inv1[4] = 50.00;
        inv1[5] = false;
        Object[] inv2 = new Object[6];
        inv2[0] = 0;
        inv2[1] = id;
        inv2[2] = d2.asString();
        inv2[3] = 5;
        inv2[4] = 12.64;
        inv2[5] = false;
        Object[] inv3 = new Object[6];
        inv3[0] = 0;
        inv3[1] = id;
        inv3[2] = d3.asString();
        inv3[3] = 34;
        inv3[4] = 110.00;
        inv3[5] = false;
        Object[] inv4 = new Object[6];
        inv4[0] = 0;
        inv4[1] = id;
        inv4[2] = d1.asString();
        inv4[3] = 10;
        inv4[4] = 50.00;
        inv4[5] = false;
        Object[] inv5 = new Object[6];
        inv5[0] = 1;
        inv5[1] = id;
        inv5[2] = d2.asString();
        inv5[3] = 5;
        inv5[4] = 12.64;
        inv5[5] = false;
        Object[] inv6 = new Object[6];
        inv6[0] = 2;
        inv6[1] = id;
        inv6[2] = d3.asString();
        inv6[3] = 34;
        inv6[4] = 110.00;
        inv6[5] = false;
        ArrayList<Object[]> testResources = new ArrayList<Object[]>();
        testResources.add(inv1);
        testResources.add(inv2);
        testResources.add(inv3);
        testResources.add(inv4);
        testResources.add(inv5);
        testResources.add(inv6);
        return testResources;
    }

    public ArrayList<Object[]> getInventoryWithArg(Hashtable<String, Object> argsDic) {
        Object[] keys = argsDic.keySet().toArray();
        String query;
        if(argsDic.size() == 1) query = "select * from inventory where " + keys[0] + " = " + argsDic.get(keys[0]) + ";";
        else{
            query = "select * from inventory where " + keys[0] + " = " + argsDic.get(keys[0]);
            for(int i = 1; i < argsDic.size(); i++){
                query += "and " + keys[1] + " = " + argsDic.get(keys[1]);
            }
            query += ";";
        }
        //HARDWIRED
        return getAllInventories(); //HARD WIRED
    }

}
