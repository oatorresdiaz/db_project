package handler;

import dao.AdminsDao;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AdminsHandler {

    public static LinkedHashMap<String, Object> build_admins_dic(Object[] row){
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("adminID", row[0]);
        result.put("uID", row[1]);
        return result;
    }

    private LinkedHashMap<String,Object> build_goodArg_dic(int adminID, int uID) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        if(adminID != -1) result.put("adminID", adminID);
        if(uID != -1) result.put("uID", uID);
        return result;
    }

    public static ArrayList<LinkedHashMap<String, Object>> getAllAdmins(){
        AdminsDao adms = new AdminsDao();
        ArrayList<Object[]> admsList = adms.getAllAdmins();
        ArrayList<LinkedHashMap<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < admsList.size(); i++){
            result.add(build_admins_dic(admsList.get(i)));
        }
        return result;
    }

    public static LinkedHashMap<String, Object> getAdminById(int id){
        AdminsDao adms = new AdminsDao();
        ArrayList<Object[]> admsList = adms.getAllAdmins();
        return build_admins_dic(admsList.get(id));
    }

    public static ArrayList<LinkedHashMap<String, Object>> getAdminsNaturalJoinUser(){
        UsersHandler userHandler = new UsersHandler();
        ArrayList<LinkedHashMap<String, Object>> users = userHandler.getAllUsers();
        ArrayList<LinkedHashMap<String, Object>> admins = getAllAdmins();
        ArrayList<LinkedHashMap<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < admins.size(); i++){
            for(int j = 0; j < users.size(); j++){
                if(admins.get(i).get("uID") == users.get(j).get("uID")){
                    result.add(users.get(j));
                }
            }
        }
        return result;
    }

    public Response getAdminsWithArg(int adminID, int uID) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(adminID, uID);
        AdminsDao admns = new AdminsDao();
        ArrayList<Object[]> admnsList = admns.getAminsWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < admnsList.size(); i++){
            resultList.add(build_admins_dic(admnsList.get(i)));
        }
        if (resultList.isEmpty()) return Response.status(404).build(); //Malformed query string.
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(resultList) {};
        return Response.ok(entity).build();
    }
}
