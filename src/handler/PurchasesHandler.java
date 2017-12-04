package handler;

import dao.PurchasesDao;

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
        PurchasesDao prchs = new PurchasesDao();
        ArrayList<Object[]> prchsList = prchs.getAllPurchases();
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < prchsList.size(); i++){
            result.add(build_purchases_dic(prchsList.get(i)));
        }
        return result;
    }

    public static Hashtable<String, Object> getPurchaseById(int id){
        PurchasesDao prchs = new PurchasesDao();
        ArrayList<Object[]> prchsList = prchs.getAllPurchases();
        return build_purchases_dic(prchsList.get(id));
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



}
