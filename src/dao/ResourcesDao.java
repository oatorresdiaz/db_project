package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ResourcesDao {

    public static final String driver = "org.postgresql.Driver";
    public static final String url = "jdbc:postgresql://localhost:5432/db_project";
    public static final String username = "postgres";
    public static final String password = "Schultz123";

    public static ArrayList<Object[]> getAllResources() {
        ArrayList<Object[]> result = new ArrayList<Object[]>();
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement query = conn.prepareStatement("select * from resources");
            ResultSet Rs = query.executeQuery();
            while(Rs.next()){
                Object[] row = new Object[3];
                row[0] = Rs.getInt(1);
                row[1] = Rs.getString(2);
                row[2] = Rs.getString(3);
                result.add(row);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static Object[] getResourceById(int id){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement query = conn.prepareStatement("select * from resources where resID = " + id);
            ResultSet Rs = query.executeQuery();
            if(!Rs.next()) return null;
            Object[] row = new Object[3];
            row[0] = Rs.getInt(1);
            row[1] = Rs.getString(2);
            row[2] = Rs.getString(3);
            return row;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<Object[]> getResourcesWithArg(LinkedHashMap<String, Object> argsDic) {
        Object[] keys = argsDic.keySet().toArray();
        String query = "";
        if(argsDic.size() == 1) query = "select * from resources where " + keys[0] + " = " + argsDic.get(keys[0]) + ";";
        else if (argsDic.size() > 1){
            query = "select * from resources where " + keys[0] + " = " + argsDic.get(keys[0]);
            for(int i = 1; i < argsDic.size(); i++){
                query += " and " + keys[i] + " = " + argsDic.get(keys[i]);
            }
            query += ";";
        }
        System.out.println(query);
        return getAllResources(); //HARD WIRED. IN PHASE II THE RETURN WILL MATCH THE QUERY.
    }
}
