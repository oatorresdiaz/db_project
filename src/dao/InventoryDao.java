package dao;

import utilities.DateUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class InventoryDao {

    public static final String driver = "org.postgresql.Driver";
    public static final String url = "jdbc:postgresql://localhost:5432/db_project";
    public static final String username = "postgres";
    public static final String password = "Schultz123";

    public static ArrayList<Object[]> getAllInventory() {
        ArrayList<Object[]> result = new ArrayList<Object[]>();
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement query = conn.prepareStatement("select * from inventory");
            ResultSet Rs = query.executeQuery();
            while(Rs.next()){
                Object[] row = new Object[7];
                row[0] = Rs.getInt(1);
                row[1] = Rs.getInt(2);
                row[2] = DateUtility.dateToString(Rs.getDate(3));
                row[3] = Rs.getInt(4);
                row[4] = Rs.getInt(5);
                row[5] = Rs.getInt(6);
                row[6] = Rs.getFloat(7);
                result.add(row);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static Object[] getInventoryById(int id){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement query = conn.prepareStatement("select * from inventory where invID = " + id);
            ResultSet Rs = query.executeQuery();
            if(!Rs.next()) return null;
            Object[] row = new Object[7];
            row[0] = Rs.getInt(1);
            row[1] = Rs.getInt(2);
            row[2] = DateUtility.dateToString(Rs.getDate(3));
            row[3] = Rs.getInt(4);
            row[4] = Rs.getInt(5);
            row[5] = Rs.getInt(6);
            row[6] = Rs.getFloat(7);
            return row;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
