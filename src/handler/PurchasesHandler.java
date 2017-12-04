package handler;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Hashtable;


public class PurchasesHandler {


    public static Hashtable<String, Object> build_purchases_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<>();
        result.put("requesterID", row[0]);
        result.put("inventoryID", row[1]);
        result.put("purchaseAmount", row[2]);
        result.put("purchaseDate", row[3]);
        return result;
    }

    public static ArrayList<Hashtable<String, Object>> getAllPurchases(){
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < getTestPurchases().size(); i++){
            result.add(build_purchases_dic(getTestPurchases().get(i)));
        }
        return result;
    }

    public static Hashtable<String, Object> getPurchaseById(int id){
        return build_purchases_dic(getTestPurchases().get(id));
    }


    public static ArrayList<Hashtable<String, Object>> getRequestersNatJPurchasesNatJInventory(){
        RequestersHandler requesterH = new RequestersHandler();
        InventoryHandler inventoryH = new InventoryHandler();

        ArrayList<Hashtable<String, Object>> purchases = getAllPurchases();
        ArrayList<Hashtable<String, Object>> requesters = requesterH.getAllRequesters();
        ArrayList<Hashtable<String, Object>> inventory = inventoryH.getAllInventory();

        ArrayList<Hashtable<String, Object>> results = new ArrayList<>();

        for(int i = 0; i < purchases.size(); i++){

            Hashtable<String, Object> allUserInfoFromPurchase = new Hashtable<>();

            allUserInfoFromPurchase.put("requesterID", purchases.get(i).get("requesterID"));
            allUserInfoFromPurchase.put("inventoryID", purchases.get(i).get("inventoryID"));
            allUserInfoFromPurchase.put("purchaseAmount", purchases.get(i).get("purchaseAmount"));
            allUserInfoFromPurchase.put("purchaseDate", purchases.get(i).get("purchaseDate"));
            
            results.add(allUserInfoFromPurchase);
        }
        return results;
    }



    //FOR TESTING PURPOSES
    private static ArrayList<Object[]> getTestPurchases(){
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



}
