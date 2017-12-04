package handler;

import dao.InventoryDao;
import utilities.DateCompound;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class InventoryHandler {

    public static Hashtable<String, Object> build_inventory_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        result.put("invID", row[0]);
        result.put("suppID", row[1]);
        result.put("invDate", row[2]);
        result.put("invQty", row[3]);
        result.put("invPrice", row[4]);
        result.put("invReserved", row[5]);
        return result;
    }

    public Hashtable<String, Object> build_goodArg_dic(int invID, int suppID, String invDate, int invQty, int invPrice, int invReserved){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        if(invID != -1) result.put("invID", invID);
        if(suppID != -1) result.put("suppID", suppID);
        if(invDate != "UNDECLARED") result.put("invDate", invDate);
        if(invQty != -1) result.put("invQty", invQty);
        if(invPrice != -1) result.put("invPrice", invPrice);
        if(invReserved != -1)result.put("invReserved", invReserved);
        return result;
    }

    public static ArrayList<Hashtable<String, Object>> getAllInventory(){
        InventoryDao inv = new InventoryDao();
        ArrayList<Object[]> invList = inv.getAllInventories();
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < invList.size(); i++){
            resultList.add(build_inventory_dic(invList.get(i)));
        }
        return resultList;
    }

    public static Hashtable<String, Object> getInventoryById(int id){
        InventoryDao inv = new InventoryDao();
        ArrayList<Object[]> invList = inv.getAllInventories();
        return build_inventory_dic(invList.get(id));
    }

    public ArrayList<Hashtable<String,Object>> getInventoryBySupplierId(int id) {
        InventoryDao inv = new InventoryDao();
        ArrayList<Object[]> invList = inv.getInventoryBySupplierId(id);
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < invList.size(); i++){
            resultList.add(build_inventory_dic(invList.get(i)));
        }
        return resultList;

    }

    public Response getInventoryWithArg(int invID, int suppID, String invDate, int invQty, int invPrice, int invReserved) {
        Hashtable<String, Object> argDic = build_goodArg_dic(invID, suppID, invDate, invQty, invPrice, invReserved);
        InventoryDao inv = new InventoryDao();
        ArrayList<Object[]> invList = inv.getInventoryWithArg(argDic);
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < invList.size(); i++){
            resultList.add(build_inventory_dic(invList.get(i)));
        }
        if (resultList.isEmpty()) return Response.status(404).build(); //Malformed query string.
        GenericEntity<ArrayList<Hashtable<String, Object>>> entity =
                new GenericEntity<ArrayList<Hashtable<String,Object>>>(resultList) {};
        return Response.ok(entity).build();
    }


}
