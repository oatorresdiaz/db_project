package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.sql.*;

public class UsersDao {

    public static final String driver = "org.postgresql.Driver";
    public static final String url = "jdbc:postgresql://localhost:5432/dbTest2";
    public static final String username = "postgres";
    public static final String password = "Schultz123";

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllUsers(){

        ArrayList<Object[]> testUsers = new ArrayList<Object[]>();

        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = con.prepareStatement("select * from users");
            ResultSet Rs = stmt.executeQuery();
            while(Rs.next()){
                Object[] row = new Object[2];
                row[0] = Rs.getInt(1);
                row[1] = Rs.getString(2);
                testUsers.add(row);
                System.out.println(Rs.getInt(1) + " " + Rs.getString(2));
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        /*Object[] orlando = new Object[10];
        orlando[0] = 0;
        orlando[1] = "Orlando";
        Object[] pedro = new Object[10];
        pedro[0] = 1;
        pedro[1] = "Pedro";
        ArrayList<Object[]> testUsers = new ArrayList<Object[]>();
        testUsers.add(orlando);
        testUsers.add(pedro);*/
        return testUsers;
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
