package handler;

import dao.UsersDao;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class UsersHandler {
    public static LinkedHashMap<String, Object> result;


    public static LinkedHashMap<String, Object> build_users_dict(Object[] row){
        result = new LinkedHashMap<String, Object>();
        result.put("uID", row[0]);
        result.put("uFName", row[1]);
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

    public static LinkedHashMap<String, Object> getAttributes(){
        return result;
    }

    private LinkedHashMap<String,Object> build_goodArg_dic(int uID, String uFName, String uLName, String uGender, String uBirthDate, String uRegion, int uPhoneNumber, String uAddress, String username, String password) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        if(uID != -1) result.put("uID", uID);
        if(!uFName.equals("UNDECLARED")) result.put("uFName", uFName);
        if(!uLName.equals("UNDECLARED")) result.put("uLName", uLName);
        if(!uGender.equals("UNDECLARED")) result.put("uGender", uGender);
        if(!uBirthDate.equals("UNDECLARED")) result.put("uBirthDate", uBirthDate);
        if(!uRegion.equals("UNDECLARED")) result.put("uRegion", uRegion);
        if(uPhoneNumber != -1) result.put("uPhoneNumber", uPhoneNumber);
        if(!uAddress.equals("UNDECLARED")) result.put("uAddress", uAddress);
        if(!username.equals("UNDECLARED")) result.put("username", username);
        if(!password.equals("UNDECLARED")) result.put("password", password);
        return result;
    }

    public static ArrayList<LinkedHashMap<String,Object>> getAllUsers(){
        UsersDao usrs = new UsersDao();
        ArrayList<Object[]> usrsList = usrs.getAllUsers();
        ArrayList<LinkedHashMap<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < usrsList.size(); i++){
            result.add(build_users_dict(usrsList.get(i)));
        }
        /*GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(result) {};
        return Response.ok(entity).build();*/
        return result;
    }


    public static LinkedHashMap<String, Object> getUserById(int id){
        UsersDao usrs = new UsersDao();
        ArrayList<Object[]> usrsList = usrs.getAllUsers();
        return build_users_dict(usrsList.get(id));
    }

    public Response getUsersWithArg(int uID, String uFName, String uLName, String uGender, String uBirthDate, String uRegion, int uPhoneNumber, String uAddress, String username, String password) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(uID, uFName, uLName, uGender, uBirthDate, uRegion, uPhoneNumber, uAddress, username, password);
        UsersDao users = new UsersDao();
        ArrayList<Object[]> usersList = users.getUsersWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < usersList.size(); i++){
            resultList.add(build_users_dict(usersList.get(i)));
        }
        if (resultList.isEmpty()) return Response.status(404).build(); //Malformed query string.
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(resultList) {};
        return Response.ok(entity).build();
    }

}
