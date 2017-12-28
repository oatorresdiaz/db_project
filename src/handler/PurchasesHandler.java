package handler;

import dao.PurchasesDao;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
//import java.util.LinkedHashMap;
import java.util.LinkedHashMap;


public class PurchasesHandler {


    public static LinkedHashMap<String, Object> build_purchases_dic(Object[] row){
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        result.put("reqID", row[0]);
        result.put("invID", row[1]);
        result.put("prchsQty", row[2]);
        result.put("prchsDate", row[3]);
        return result;
    }

    private LinkedHashMap<String,Object> build_goodArg_dic(int reqID, int invID, String purchaseDate, int purchaseQty) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        if(reqID != -1) result.put("reqID", reqID);
        if(invID != -1) result.put("invID", invID);
        if(!purchaseDate.equals("UNDECLARED")) result.put("prchsDate", purchaseDate);
        if(purchaseQty != -1) result.put("prchsQty", purchaseQty);
        return result;
    }

    public static ArrayList<LinkedHashMap<String, Object>> getAllPurchases(){
        PurchasesDao prchs = new PurchasesDao();
        ArrayList<Object[]> prchsList = prchs.getAllPurchases();
        ArrayList<LinkedHashMap<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < prchsList.size(); i++){
            result.add(build_purchases_dic(prchsList.get(i)));
        }
        return result;
    }

    public static LinkedHashMap<String, Object> getPurchaseById(int id){
        PurchasesDao prchs = new PurchasesDao();
        ArrayList<Object[]> prchsList = prchs.getAllPurchases();
        return build_purchases_dic(prchsList.get(id));
    }


    /*public static ArrayList<LinkedHashMap<String, Object>> getRequestersNatJPurchasesNatJInventory(){
        RequestersHandler requesterH = new RequestersHandler();
        InventoryHandler inventoryH = new InventoryHandler();

        ArrayList<LinkedHashMap<String, Object>> purchases = getAllPurchases();
        ArrayList<LinkedHashMap<String, Object>> requesters = requesterH.getAllRequesters();
        ArrayList<LinkedHashMap<String, Object>> inventory = inventoryH.getAllInventory();

        ArrayList<LinkedHashMap<String, Object>> results = new ArrayList<>();

        for(int i = 0; i < purchases.size(); i++){

            LinkedHashMap<String, Object> allUserInfoFromPurchase = new LinkedHashMap<>();

            allUserInfoFromPurchase.put("reqID", purchases.get(i).get("reqId"));
            allUserInfoFromPurchase.put("invID", purchases.get(i).get("invID"));
            allUserInfoFromPurchase.put("prchsQty", purchases.get(i).get("prchsQty"));
            allUserInfoFromPurchase.put("prchsDate", purchases.get(i).get("prchsDate"));

            results.add(allUserInfoFromPurchase);
        }
        return results;
    }

    public ArrayList<LinkedHashMap<String, Object>> getPurchaseWithArg(int reqID, int invID, String purchaseDate, int purchaseQty) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(reqID, invID, purchaseDate, purchaseQty);
        PurchasesDao prchs = new PurchasesDao();
        ArrayList<Object[]> prchsList = prchs.getPurchaseWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < prchsList.size(); i++){
            resultList.add(build_purchases_dic(prchsList.get(i)));
        }
        return resultList;
    }*/
}
