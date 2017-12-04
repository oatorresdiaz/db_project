package handler;

import dao.AdminsDao;

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
        AdminsDao adms = new AdminsDao();
        ArrayList<Object[]> admsList = adms.getAllAdmins();
        ArrayList<Hashtable<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < admsList.size(); i++){
            result.add(build_admins_dic(admsList.get(i)));
        }
        return result;
    }

    public static Hashtable<String, Object> getAdminById(int id){
        AdminsDao adms = new AdminsDao();
        ArrayList<Object[]> admsList = adms.getAllAdmins();
        return build_admins_dic(admsList.get(id));
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
}
