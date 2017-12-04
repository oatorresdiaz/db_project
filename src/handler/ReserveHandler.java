package handler;

import dao.ReserveDao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ReserveHandler {

    public static LinkedHashMap<String, Object> build_reserve_dic(Object[] row) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        result.put("reqID"       , row[0]);         //ID of the requester
        result.put("invID"       , row[1]);         //ID of the reserved resource
        result.put("resDate"     , row[2]);         //Date of the reservation
        result.put("resExpDate"  , row[3]);         //Date of the expiration of the reservation
        result.put("resQty"      , row[4]);         //Quantity of the resource being reserved
        return result;
    }

    public static ArrayList<LinkedHashMap<String, Object>> getAllReserves() {
        ReserveDao rsrv = new ReserveDao();
        ArrayList<Object[]> rsrvList = rsrv.getAllReservations();
        ArrayList<LinkedHashMap<String, Object>> result = new ArrayList<>();
        for (int i = 0; i < rsrvList.size(); i++) {
            result.add(build_reserve_dic(rsrvList.get(i)));
        }
        return result;
    }

    public static LinkedHashMap<String, Object> getReserveId(int id) {
        ReserveDao rsrv = new ReserveDao();
        ArrayList<Object[]> rsrvList = rsrv.getAllReservations();
        return build_reserve_dic(rsrvList.get(id));
    }

    public static ArrayList<LinkedHashMap<String, Object>> getRequestersNaturalJoinInventory() {
        RequestersHandler requestersHandler = new RequestersHandler();
        InventoryHandler inventoryHandler = new InventoryHandler();

        ArrayList<LinkedHashMap<String, Object>> reserve    = getAllReserves();
        ArrayList<LinkedHashMap<String, Object>> requesters = requestersHandler.getAllRequesters();
        ArrayList<LinkedHashMap<String, Object>> inventory  = inventoryHandler.getAllInventory();
        ArrayList<LinkedHashMap<String, Object>> reqNIJrsv  = new ArrayList<>();
        ArrayList<LinkedHashMap<String, Object>> result     = new ArrayList<>();

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

    private static Object pKey(Object req, Object inv){
        String ID = "";
        ID = ID + String.valueOf(req);
        ID = ID + String.valueOf(inv);
        return ID;
    }
}