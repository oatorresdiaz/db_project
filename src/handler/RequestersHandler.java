package handler;

import java.util.ArrayList;
import java.util.Hashtable;


public class RequestersHandler {

    public static Hashtable<String, Object> build_requesters_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        result.put("reqID", row[0]);
        result.put("uID", row[1]);
        return result;
    }

    public static ArrayList<Hashtable<String, Object>> getAllRequesters(){
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < getTestRequesters().size(); i++){
            result.add(build_requesters_dic(getTestRequesters().get(i)));
        }
        return result;
    }

    public static Hashtable<String, Object> getRequesterId(int id){
        return build_requesters_dic(getTestRequesters().get(id));
    }

    public static ArrayList<Hashtable<String, Object>> getRequestersNaturalJoinUser(){
        UsersHandler userHandler = new UsersHandler();
        ArrayList<Hashtable<String, Object>> users = userHandler.getAllUsers();
        ArrayList<Hashtable<String, Object>> requesters = getAllRequesters();
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < requesters.size(); i++){
            for(int j = 0; j < users.size(); j++){
                if(requesters.get(i).get("uID") == users.get(j).get("uID")){
                    result.add(users.get(j));
                }
            }
        }
        return result;
    }

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getTestRequesters() {
        Object[] req1 = new Object[2];
        req1[0] = 0;
        req1[1] = 0;
        Object[] req2 = new Object[2];
        req2[0] = 1;
        req2[1] = 3;
        ArrayList<Object[]> testRequesters = new ArrayList<Object[]>();
        testRequesters.add(req1);
        testRequesters.add(req2);
        return testRequesters;
    }
}
