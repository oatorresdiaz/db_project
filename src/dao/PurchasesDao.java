package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PurchasesDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllPurchases(){
        ArrayList<Object[]> testPurchases = new ArrayList<>();
        Object[] purchase1 = new Object[4];
        purchase1[0] = 1;
        purchase1[1] = 0;
        purchase1[2] = 20;
        purchase1[3] = "12/2/2016";
        Object[] purchase2 = new Object[4];
        purchase2[0] = 0;
        purchase2[1] = 0;
        purchase2[2] = 10;
        purchase2[3] = "07/25/2017";
        Object[] purchase3 = new Object[4];
        purchase3[0] = 1;
        purchase3[1] = 2;
        purchase3[2] = 100;
        purchase3[3] = "10/2/2017";
        Object[] purchase4 = new Object[4];
        purchase4[0] = 0;
        purchase4[1] = 1;
        purchase4[2] = 25;
        purchase4[3] = "02/14/2016";

        testPurchases.add(purchase1);
        testPurchases.add(purchase2);
        testPurchases.add(purchase3);
        testPurchases.add(purchase4);

        return testPurchases;
    }

    public ArrayList<Object[]> getPurchaseWithArg(LinkedHashMap<String, Object> argsDic) {
        Object[] keys = argsDic.keySet().toArray();
        String query = "";
        if(argsDic.size() == 1) query = "select * from purchases where " + keys[0] + " = " + argsDic.get(keys[0]) + ";";
        else if (argsDic.size() > 1){
            query = "select * from purchases where " + keys[0] + " = " + argsDic.get(keys[0]);
            for(int i = 1; i < argsDic.size(); i++){
                query += " and " + keys[i] + " = " + argsDic.get(keys[i]);
            }
            query += ";";
        }
        System.out.println(query);
        return getAllPurchases();
    }
}
