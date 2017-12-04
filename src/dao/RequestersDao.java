package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RequestersDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllRequesters() {
        Object[] req1 = new Object[4];
        req1[0] = 0;
        req1[1] = 0;
        Object[] req2 = new Object[4];
        req2[0] = 1;
        req2[1] = 3;
        ArrayList<Object[]> testRequesters = new ArrayList<Object[]>();
        testRequesters.add(req1);
        testRequesters.add(req2);
        return testRequesters;
    }

    public ArrayList<Object[]> getRequestersWithArg(LinkedHashMap<String, Object> argsDic) {
        Object[] keys = argsDic.keySet().toArray();
        String query = "";
        if(argsDic.size() == 1) query = "select * from requesters where " + keys[0] + " = " + argsDic.get(keys[0]) + ";";
        else if (argsDic.size() > 1){
            query = "select * from requesters where " + keys[0] + " = " + argsDic.get(keys[0]);
            for(int i = 1; i < argsDic.size(); i++){
                query += " and " + keys[i] + " = " + argsDic.get(keys[i]);
            }
            query += ";";
        }
        System.out.println(query);
        return getAllRequesters(); //HARD WIRED. IN PHASE II THE RETURN WILL MATCH THE QUERY.
    }
}
