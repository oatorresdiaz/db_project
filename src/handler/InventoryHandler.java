package handler;

import dao.InventoryDao;

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
        result.put("invDate", row[2]);
        result.put("invQty", row[3]);
        result.put("invReserved", row[4]);
        result.put("invAvailable", row[5]);
        result.put("invPrice", row[6]);
        return result;
    }

    public static Response getAllInventory(){
        InventoryDao dao = new InventoryDao();
        ArrayList<Object[]> inventory_list = dao.getAllInventory();
        ArrayList<LinkedHashMap<String,Object>> result_list = new ArrayList<>();
        for(int i = 0; i < inventory_list.size(); i++){
            LinkedHashMap<String,Object> result = build_inventory_dic(inventory_list.get(i));
            result_list.add(result);
        }
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity;
        entity= new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(result_list) {};
        return Response.ok(entity).build();
    }

    public static Response getInventoryById(int id){
        InventoryDao dao = new InventoryDao();
        Object[] row = dao.getInventoryById(id);
        if(row == null) return Response.status(404).build();
        else{
            LinkedHashMap<String, Object> inventory = build_inventory_dic(row);
            GenericEntity<LinkedHashMap<String, Object>> entity;
            entity= new GenericEntity<LinkedHashMap<String,Object>>(inventory) {};
            return Response.ok(entity).build();
        }
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



}
