package handler;

import dao.PurchasesDao;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Hashtable;


public class PurchasesHandler {


    public static Hashtable<String, Object> build_purchases_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<>();
        result.put("reqID", row[0]);
        result.put("invID", row[1]);
        result.put("purchaseAmount", row[2]);
        result.put("purchaseDate", row[3]);
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
        RequestersHandler requesterH = new RequestersHandler();
        InventoryHandler inventoryH = new InventoryHandler();

        ArrayList<Hashtable<String, Object>> purchases = getAllPurchases();
        ArrayList<Hashtable<String, Object>> requesters = requesterH.getAllRequesters();
        ArrayList<Hashtable<String, Object>> inventory = inventoryH.getAllInventory();

        ArrayList<Hashtable<String, Object>> results = new ArrayList<>();

        for(int i = 0; i < purchases.size(); i++){

            Hashtable<String, Object> allUserInfoFromPurchase = new Hashtable<>();

            allUserInfoFromPurchase.put("reqID", purchases.get(i).get("reqID"));
            allUserInfoFromPurchase.put("invID", purchases.get(i).get("invID"));
            allUserInfoFromPurchase.put("purchaseAmount", purchases.get(i).get("purchaseAmount"));
            allUserInfoFromPurchase.put("purchaseDate", purchases.get(i).get("purchaseDate"));

            results.add(allUserInfoFromPurchase);
        }
        return results;
    }

}
