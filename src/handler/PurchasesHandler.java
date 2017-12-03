package handler;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Hashtable;


public class PurchasesHandler {


    public static Hashtable<String, Object> build_purchases_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<>();
        result.put("purchaseID", row[0]);
        result.put("requesterID", row[1]);
        result.put("inventoryID", row[2]);
        result.put("purchaseAmount", row[3]);
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
        //RequestersHandler requesterH = new RequestersHandler();
        //InventoryHandler inventoryH = new InventoryHandler();
        //UsersHandler userH = new UsersHandler();
        //ResourcesHandler resourceH = new ResourcesHandler();

        //ArrayList<Hashtable<String, Object>> users = userH.getAllUsers();
        // ArrayList<Hashtable<String, Object>> resource = resourceH.getAllResources();
        //ArrayList<Hashtable<String, Object>> requesters = requesterH.getAllRequesters();
        //ArrayList<Hashtable<String, Object>> inventory = inventoryH.getAllInventory();
        ArrayList<Hashtable<String, Object>> purchases = getAllPurchases();
        ArrayList<Hashtable<String, Object>> results = new ArrayList<>();

        for(int i = 0; i < purchases.size(); i++){

            Hashtable<String, Object> allUserInfoFromPurchase = new Hashtable<>();

            allUserInfoFromPurchase.put("purchaseID", purchases.get(i).get("purchaseID"));
            allUserInfoFromPurchase.put("requesterID", purchases.get(i).get("requesterID"));
            allUserInfoFromPurchase.put("inventoryID", purchases.get(i).get("inventoryID"));
            allUserInfoFromPurchase.put("purchaseAmount", purchases.get(i).get("purchaseAmount"));

            // for(int j = 0; j < 4; j++){
            //     allUserInfoFromPurchase.putAll(purchases.get(j));
            // }

           /* for(int j = 0; j < requesters.size(); j++){
                if(purchases.get(i).get("requesterID") == requesters.get(j).get("reqID")){
                    Hashtable<String, Object> user = userH.getAllUsersById((Integer) requesters.get(j).get("uID"));
                    allUserInfoFromPurchase.putAll(user);
                }
            }*/
            /*for(int j = 0; j < inventory.size(); j++){
                if(purchases.get(i).get("inventoryID") == inventory.get(j).get("invID")){
                    Hashtable<String, Object> resource = resourceH.getResourceById(inventory.get(j).get(""))
                            inventoryH.getInventoryById(requesters.get(j).get("uID"));
                    allUserInfoFromPurchase.putAll(user);
                }
            }*/
            results.add(allUserInfoFromPurchase);
        }
        return results;
    }



    //FOR TESTING PURPOSES
    private static ArrayList<Object[]> getTestPurchases(){
        ArrayList<Object[]> testPurchases = new ArrayList<>();

        Object[] purchase1 = new Object[4];
        purchase1[0] = 0;
        purchase1[1] = 1;
        purchase1[2] = 0;
        purchase1[3] = 20;

        Object[] purchase2 = new Object[4];
        purchase2[0] = 1;
        purchase2[1] = 0;
        purchase2[2] = 0;
        purchase2[3] = 10;

        Object[] purchase3 = new Object[4];
        purchase3[0] = 2;
        purchase3[1] = 1;
        purchase3[2] = 2;
        purchase3[3] = 100;

        Object[] purchase4 = new Object[4];
        purchase4[0] = 3;
        purchase4[1] = 0;
        purchase4[2] = 1;
        purchase4[3] = 25;

        testPurchases.add(purchase1);
        testPurchases.add(purchase2);
        testPurchases.add(purchase3);
        testPurchases.add(purchase4);

        return testPurchases;
    }



}
