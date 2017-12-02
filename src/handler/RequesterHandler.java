package handler;

import java.util.ArrayList;
import java.util.Hashtable;

import static handler.UsersHandler.build_users_dict;

public class RequesterHandler {

    public static Hashtable<String, Object> build_resources_dict(Object[] row){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        result.put("reqID", row[0]);
        result.put("userID", row[1]);
        return result;
    }

    public static ArrayList<Hashtable<String, Object>> getAllRequesters(){
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < getTestResources().size(); i++){
            result.add(build_users_dict(getTestResources().get(i)));
        }
        return result;
    }

    public static Hashtable<String, Object> getRequesterId(int id){
        return build_users_dict(getTestResources().get(id));
    }

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getTestResources() {
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
