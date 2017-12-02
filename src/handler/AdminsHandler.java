package handler;

import java.util.ArrayList;
import java.util.Hashtable;

public class AdminsHandler {

    public static Hashtable<String, Object> build_admins_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        result.put("adminID", row[0]);
        result.put("userID", row[1]);
        return result;
    }

    public static ArrayList<Hashtable<String, Object>> getAllAdmins(){
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < getTestAdmins().size(); i++){
            result.add(build_admins_dic(getTestAdmins().get(i)));
        }
        return result;
    }

    public static Hashtable<String, Object> getAdminById(int id){
        return build_admins_dic(getTestAdmins().get(id));
    }

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getTestAdmins() {
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
