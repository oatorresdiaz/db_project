package handler;

import java.util.ArrayList;
import java.util.Hashtable;

import static handler.UsersHandler.build_users_dict;

public class AdminsHandler {

    public static Hashtable<String, Object> build_resources_dict(Object[] row){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        result.put("adminID", row[0]);
        result.put("userID", row[1]);
        return result;
    }

    public static ArrayList<Hashtable<String, Object>> getAllAdmins(){
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < getTestResources().size(); i++){
            result.add(build_users_dict(getTestResources().get(i)));
        }
        return result;
    }

    public static Hashtable<String, Object> getAdminById(int id){
        return build_resources_dict(getTestResources().get(id));
    }

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getTestResources() {
        Object[] admin1 = new Object[2];
        admin1[0] = 0;
        admin1[1] = 0;
        Object[] admin2 = new Object[2];
        admin2[0] = 1;
        admin2[1] = 2;
        ArrayList<Object[]> testResources = new ArrayList<Object[]>();
        testResources.add(admin1);
        testResources.add(admin2);
        return testResources;
    }
}
