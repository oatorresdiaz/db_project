package handler;

import java.util.ArrayList;
import java.util.Hashtable;


public class RequesterHandler {

    public static Hashtable<String, Object> build_requesters_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        result.put("reqID", row[0]);
        result.put("userID", row[1]);
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

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getTestRequesters() {
        Object[] req1 = new Object[2];
        req1[0] = 0;
        req1[1] = 0;
        Object[] req2 = new Object[2];
        req2[0] = 1;
        req2[1] = 2;
        ArrayList<Object[]> testResources = new ArrayList<Object[]>();
        testResources.add(req1);
        testResources.add(req2);
        return testResources;
    }
}
