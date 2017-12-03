package handler;

import java.util.ArrayList;
import java.util.Hashtable;

public class ReserveHandler {

    public static Hashtable<String, Object> build_reserve_dic(Object[] row) {
        Hashtable<String, Object> result = new Hashtable<>();
        result.put("reqID", row[0]);
        result.put("invID", row[1]);
        result.put("resID", row[2]);

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
        ReserveHandler reserveHandler = new ReserveHandler();

        ArrayList<Hashtable<String, Object>> reserve    = getAllReserves();
        ArrayList<Hashtable<String, Object>> requesters = requestersHandler.getAllRequesters();
        ArrayList<Hashtable<String, Object>> inventory  = inventoryHandler.getAllInventory();
        ArrayList<Hashtable<String, Object>> reqNIJrsv  = new ArrayList<>();
        ArrayList<Hashtable<String, Object>> result = new ArrayList<>();

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
        Object[] res1 = new Object[3];
        res1[0] = 0;
        res1[1] = 0;
        res1[2] = pKey(res1[0], res1[1]);

        Object[] res2 = new Object[3];
        res2[0] = 0;
        res2[1] = 1;
        res2[2] = pKey(res2[0], res2[1]);

        Object[] res3 = new Object[3];
        res3[0] = 1;
        res3[1] = 2;
        res3[2] = pKey(res3[0], res3[1]);

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