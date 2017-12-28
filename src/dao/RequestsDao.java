package dao;


import utilities.DateUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RequestsDao {

    public static final String driver = "org.postgresql.Driver";
    public static final String url = "jdbc:postgresql://localhost:5432/db_project";
    public static final String username = "postgres";
    public static final String password = "Schultz123";

    public static ArrayList<Object[]> getAllRequests() {
        ArrayList<Object[]> result = new ArrayList<Object[]>();
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement query = conn.prepareStatement("select * from requests");
            ResultSet Rs = query.executeQuery();
            while(Rs.next()){
                Object[] row = new Object[4];
                row[0] = Rs.getInt(1);
                row[1] = Rs.getInt(2);
                row[2] = DateUtility.dateToString(Rs.getDate(3));
                row[3] = Rs.getInt(4);
                result.add(row);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
