package handler;

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
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < getTestInventory().size(); i++){
            resultList.add(build_inventory_dic(getTestInventory().get(i)));
        }
        return resultList;
    }

    public static Hashtable<String, Object> getInventoryById(int id){
        return build_inventory_dic(getTestInventory().get(id));
    }

    public ArrayList<Hashtable<String,Object>> getInventoryByArgument(Integer invID, Integer suppID, String invDate, Integer invQty, Double invPrice, String invReserved) {
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < getAllInventory().size(); i++){
            if(invID != null){
                if(getAllInventory().get(i).get("invID") == invID){
                    result.add(getAllInventory().get(i));
                }
            }
        }
        return result;
    }

    /*public static ArrayList<Hashtable<String,Object>> getInventoryByArgument(String arg, String value){
        Object v;
        if(arg.equals("invID") || arg.equals("suppID") || arg.equals("invQty")) v = Integer.parseInt(value);
        else if(arg.equals("invDate")) v = new DateCompound(value);
        else if(arg.equals("invReserved")) v = Boolean.parseBoolean(value);
        else v = Double.parseDouble(value);
        ArrayList<Hashtable<String, Object>> result = new ArrayList<>();
        for(int i = 0; i < getAllInventory().size(); i++){
            if(getAllInventory().get(i).get(arg) == v){
                result.add(getAllInventory().get(i));
            }
        }
        return result;
    }*/

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
    }

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getTestInventory(){
        DateCompound d1 = new DateCompound("12122012");
        DateCompound d2 = new DateCompound("11092001");
        DateCompound d3 = new DateCompound("05301996");
        Object[] inv1 = new Object[6];
        inv1[0] = 0;
        inv1[1] = 0;
        inv1[2] = d1.asString();
        inv1[3] = 10;
        inv1[4] = 50.00;
        inv1[5] = false;
        Object[] inv2 = new Object[6];
        inv2[0] = 1;
        inv2[1] = 0;
        inv2[2] = d2.asString();
        inv2[3] = 5;
        inv2[4] = 12.64;
        inv2[5] = false;
        Object[] inv3 = new Object[6];
        inv3[0] = 2;
        inv3[1] = 3;
        inv3[2] = d3.asString();
        inv3[3] = 34;
        inv3[4] = 110.00;
        inv3[5] = false;
        ArrayList<Object[]> testResources = new ArrayList<Object[]>();
        testResources.add(inv1);
        testResources.add(inv2);
        testResources.add(inv3);
        return testResources;
    }

}
