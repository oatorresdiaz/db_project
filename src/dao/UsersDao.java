package dao;

import utilities.DateUtility;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.sql.*;

public class UsersDao {

    public static final String driver = "org.postgresql.Driver";
    public static final String url = "jdbc:postgresql://localhost:5432/db_project";
    public static final String username = "postgres";
    public static final String password = "Schultz123";


    public static ArrayList<Object[]> getAllUsers(){
        ArrayList<Object[]> result = new ArrayList<Object[]>();
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement query = conn.prepareStatement("select * from users");
            ResultSet Rs = query.executeQuery();
            while(Rs.next()){
                Object[] row = new Object[11];
                row[0] = Rs.getInt(1);
                row[1] = Rs.getString(2);
                row[2] = Rs.getString(3);
                row[3] = Rs.getString(4);
                row[4] = DateUtility.dateToString(Rs.getDate(5));
                row[5] = Rs.getString(6);
                row[6] = Rs.getString(7);
                row[7] = Rs.getString(8);
                row[8] = Rs.getString(9);
                row[9] = Rs.getString(10);
                row[10] = Rs.getString(11);
                result.add(row);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static Object[] getUserById(int id){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement query = conn.prepareStatement("select * from users where uid = " + id);
            ResultSet Rs = query.executeQuery();
            if(!Rs.next()) return null;
            Object[] row = new Object[11];
            row[0] = Rs.getInt(1);
            row[1] = Rs.getString(2);
            row[2] = Rs.getString(3);
            row[3] = Rs.getString(4);
            row[4] = DateUtility.dateToString(Rs.getDate(5));
            row[5] = Rs.getString(6);
            row[6] = Rs.getString(7);
            row[7] = Rs.getString(8);
            row[8] = Rs.getString(9);
            row[9] = Rs.getString(10);
            row[10] = Rs.getString(11);
            return row;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<Object[]> getUsersWithArg(LinkedHashMap<String, Object> argsDic) {
        Object[] keys = argsDic.keySet().toArray();
        String query = "";
        if(argsDic.size() == 1) query = "select * from users where " + keys[0] + " = " + argsDic.get(keys[0]) + ";";
        else if (argsDic.size() > 1){
            query = "select * from users where " + keys[0] + " = " + argsDic.get(keys[0]);
            for(int i = 1; i < argsDic.size(); i++){
                query += " and " + keys[i] + " = " + argsDic.get(keys[i]);
            }
            query += ";";
        }
        System.out.println(query);
        return getAllUsers(); //HARD WIRED. IN PHASE II THE RETURN WILL MATCH THE QUERY.
    }
}
