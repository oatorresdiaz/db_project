package handler;

import dao.InventoryDao;
import utilities.DateCompound;

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

    /*//HARDWIRED
    public ArrayList<Hashtable<String,Object>> getInventoryByArgument(Integer invID, Integer suppID, String invDate, Integer invQty, Double invPrice, String invReserved) {
        return getAllInventory();
    }

    public static ArrayList<Hashtable<String, Object>> getInventoryBySuppliers(){
        SuppliersHandler suppliersHandler = new SuppliersHandler();
        ArrayList<Hashtable<String, Object>> suppliers = suppliersHandler.getAllSuppliers();
        ArrayList<Hashtable<String, Object>> inventory = getAllInventory();
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < inventory.size(); i++){
            for(int j = 0; j < suppliers.size(); j++){
                if(inventory.get(i).get("suppID") == suppliers.get(j).get("suppID")){
                    suppliers.get(j).putAll(inventory.get(i));
                    inventory.get(i).putAll(suppliers.get(j));
                    result.add(inventory.get(i));
                }
            }
        }
        return result;
    }*/

}
