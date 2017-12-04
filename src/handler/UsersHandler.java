package handler;

import dao.UsersDao;

import java.util.ArrayList;
import java.util.Hashtable;

public class UsersHandler {

    //hola

    public static Hashtable<String, Object> build_users_dict(Object[] row){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        result.put("uID", row[0]);
        result.put("uFname", row[1]);
        result.put("uLName", row[2]);
        result.put("uGender", row[3]);
        result.put("uBirthDate", row[4]);
        result.put("uRegion", row[5]);
        result.put("uPhoneNumber", row[6]);
        result.put("uAddress", row[7]);
        result.put("username", row[8]);
        result.put("password", row[9]);
        return result;
    }

    public static ArrayList<Hashtable<String, Object>> getAllUsers(){
        UsersDao usrs = new UsersDao();
        ArrayList<Object[]> usrsList = usrs.getAllUsers();
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < usrsList.size(); i++){
            result.add(build_users_dict(usrsList.get(i)));
        }
        return result;
    }

    public static Hashtable<String, Object> getUserById(int id){
        UsersDao usrs = new UsersDao();
        ArrayList<Object[]> usrsList = usrs.getAllUsers();
        return build_users_dict(usrsList.get(id));
    }

}
