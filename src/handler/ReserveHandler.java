package handler;

import java.util.ArrayList;
import java.util.Hashtable;

public class ReserveHandler {

    public static Hashtable<String, Object> build_reserve_dic(Object[] row) {
        Hashtable<String, Object> result = new Hashtable<>();
        result.put("reqID"       , row[0]);         //ID of the requester
        result.put("invID"       , row[1]);         //ID of the reserved resource
        result.put("resDate"     , row[2]);         //Date of the reservation
        result.put("resExpDate"  , row[3]);         //Date of the expiration of the reservation
        result.put("resQty"      , row[4]);         //Quantity of the resource being reserved


        return result;
    }

    public static ArrayList<Hashtable<String, Object>> getAllReserves() {
        ArrayList<Hashtable<String, Object>> result = new ArrayList<>();
        for (int i = 0; i < getTestReserves().size(); i++) {
            result.add(build_reserve_dic(getTestReserves().get(i)));
        }
        return result;
    }

    public static Hashtable<String, Object> getReserveId(int id) {
        return build_reserve_dic(getTestReserves().get(id));
    }

    public static ArrayList<Hashtable<String, Object>> getRequestersNaturalJoinInventory() {
        RequestersHandler requestersHandler = new RequestersHandler();
        InventoryHandler inventoryHandler = new InventoryHandler();

        ArrayList<Hashtable<String, Object>> reserve    = getAllReserves();
        ArrayList<Hashtable<String, Object>> requesters = requestersHandler.getAllRequesters();
        ArrayList<Hashtable<String, Object>> inventory  = inventoryHandler.getAllInventory();
        ArrayList<Hashtable<String, Object>> reqNIJrsv  = new ArrayList<>();
        ArrayList<Hashtable<String, Object>> result     = new ArrayList<>();

        for (int i = 0; i < reserve.size(); i++) {
            for (int j = 0; j < requesters.size(); j++) {
                if (reserve.get(i).get("reqID") == requesters.get(j).get("reqID")) {
                    reqNIJrsv.add(reserve.get(i));
                }
            }
        }
        for (int i = 0; i < reqNIJrsv.size(); i++) {
            for (int j = 0; j < inventory.size(); j++) {
                if (reqNIJrsv.get(i).get("invID") == inventory.get(j).get("invID")) {
                    result.add(reqNIJrsv.get(i));
                }
            }
        }
        return result;
    }

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getTestReserves(){
        Object[] res1 = new Object[5];
        res1[0] = 0;
        res1[1] = 0;
        res1[2] = "11/16/2017";
        res1[3] = "11/18/2017";
        res1[4] = 10;

        Object[] res2 = new Object[5];
        res2[0] = 0;
        res2[1] = 1;
        res2[2] = "08/08/2017";
        res2[3] = "08/10/2017";
        res2[4] = 15;

        Object[] res3 = new Object[5];
        res3[0] = 1;
        res3[1] = 2;
        res3[2] = "09/09/2017";
        res3[3] = "09/11/2017";
        res3[4] = 20;

        ArrayList<Object[]> testReserves = new ArrayList<>();
        testReserves.add(res1);
        testReserves.add(res2);
        testReserves.add(res3);

        return testReserves;
    }

    private static Object pKey(Object req, Object inv){
        String ID = "";
        ID = ID + String.valueOf(req);
        ID = ID + String.valueOf(inv);
        return ID;
    }
}