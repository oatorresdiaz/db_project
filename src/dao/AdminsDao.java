package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AdminsDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllAdmins() {
        Object[] admin1 = new Object[2];
        admin1[0] = 0;
        admin1[1] = 0;
        Object[] admin2 = new Object[2];
        admin2[0] = 1;
        admin2[1] = 2;
        ArrayList<Object[]> testAdmins = new ArrayList<Object[]>();
        testAdmins.add(admin1);
        testAdmins.add(admin2);
        return testAdmins;
    }

    public ArrayList<Object[]> getAminsWithArg(LinkedHashMap<String, Object> argsDic) {
        Object[] keys = argsDic.keySet().toArray();
        String query = "";
        if(argsDic.size() == 1) query = "select * from admins where " + keys[0] + " = " + argsDic.get(keys[0]) + ";";
        else if (argsDic.size() > 1){
            query = "select * from admins where " + keys[0] + " = " + argsDic.get(keys[0]);
            for(int i = 1; i < argsDic.size(); i++){
                query += " and " + keys[i] + " = " + argsDic.get(keys[i]);
            }
            query += ";";
        }
        System.out.println(query);
        return getAllAdmins(); //HARD WIRED. IN PHASE II THE RETURN WILL MATCH THE QUERY.
    }
}
