package handler;

import java.util.ArrayList;
import java.util.Hashtable;

public class AdminsHandler {

    public static Hashtable<String, Object> build_admins_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        result.put("adminID", row[0]);
        result.put("uID", row[1]);
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

    public static ArrayList<Hashtable<String, Object>> getAdminsNaturalJoinUser(){
        UsersHandler userHandler = new UsersHandler();
        ArrayList<Hashtable<String, Object>> users = userHandler.getAllUsers();
        ArrayList<Hashtable<String, Object>> admins = getAllAdmins();
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < admins.size(); i++){
            for(int j = 0; j < users.size(); j++){
                if(admins.get(i).get("uID") == users.get(j).get("uID")){
                    result.add(users.get(j));
                }
            }
        }
        return result;
    }

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getTestAdmins() {
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
}
