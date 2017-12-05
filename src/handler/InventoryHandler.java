package handler;

import dao.InventoryDao;
import utilities.DateCompound;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class InventoryHandler {

    public static LinkedHashMap<String, Object> build_inventory_dic(Object[] row){
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("invID", row[0]);
        result.put("suppID", row[1]);
        result.put("resID", row[2]);
        result.put("invDate", row[3]);
        result.put("invQty", row[4]);
        result.put("invPrice", row[5]);
        result.put("invReserved", row[6]);
        result.put("invAvailable", row[7]);
        return result;
    }

    public static LinkedHashMap<String, Object> build_goodArg_dic(int invID, int suppID, String invDate, int invQty, int invPrice, int invReserved){
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        if(invID != -1) result.put("invID", invID);
        if(suppID != -1) result.put("suppID", suppID);
        if(!invDate.equals("UNDECLARED")) result.put("invDate", invDate);
        if(invQty != -1) result.put("invQty", invQty);
        if(invPrice != -1) result.put("invPrice", invPrice);
        if(invReserved != -1)result.put("invReserved", invReserved);
        return result;
    }

    public static ArrayList<LinkedHashMap<String, Object>> getAllInventory(){
        InventoryDao inv = new InventoryDao();
        ArrayList<Object[]> invList = inv.getAllInventories();
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < invList.size(); i++){
            resultList.add(build_inventory_dic(invList.get(i)));
        }
        return resultList;
    }

    public static LinkedHashMap<String, Object> getInventoryById(int id){
        InventoryDao inv = new InventoryDao();
        ArrayList<Object[]> invList = inv.getAllInventories();
        return build_inventory_dic(invList.get(id));
    }

    public ArrayList<LinkedHashMap<String,Object>> getInventoryBySupplierId(int id) {
        InventoryDao inv = new InventoryDao();
        ArrayList<Object[]> invList = inv.getInventoryBySupplierId(id);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < invList.size(); i++){
            resultList.add(build_inventory_dic(invList.get(i)));
        }
        return resultList;

    }

    public ArrayList<LinkedHashMap<String, Object>> getInventoryWithArg(int invID, int suppID, String invDate, int invQty, int invPrice, int invReserved) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(invID, suppID, invDate, invQty, invPrice, invReserved);
        InventoryDao inv = new InventoryDao();
        ArrayList<Object[]> invList = inv.getInventoryWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < invList.size(); i++){
            resultList.add(build_inventory_dic(invList.get(i)));
        }
        return resultList;
    }


}
