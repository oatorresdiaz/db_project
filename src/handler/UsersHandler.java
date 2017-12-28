package handler;

import dao.UsersDao;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class UsersHandler {

    public static LinkedHashMap<String, Object> build_users_dict(Object[] row){
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        result.put("uID", row[0]);
        result.put("uFname", row[1]);
        result.put("uLname", row[2]);
        result.put("uGender", row[3]);
        result.put("uBirthDate", row[4]);
        result.put("uCity", row[5]);
        result.put("uStreet", row[6]);
        result.put("uCountry", row[7]);
        result.put("uZipCode", row[8]);
        result.put("username", row[9]);
        result.put("password", row[10]);
        return result;
    }

    /*public static LinkedHashMap<String, Object> getAttributes(){
        return result;
    }*/

    /*private LinkedHashMap<String,Object> build_goodArg_dic(int uID, String uFName, String uLName, String uGender, String uBirthDate, String uRegion, int uPhoneNumber, String uAddress, String username, String password) {
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
    }*/

    public static Response getAllUsers(){
        UsersDao dao = new UsersDao();
        ArrayList<Object[]> users_list = dao.getAllUsers();
        ArrayList<LinkedHashMap<String,Object>> result_list = new ArrayList<>();
        for(int i = 0; i < users_list.size(); i++){
            LinkedHashMap<String,Object> result = build_users_dict(users_list.get(i));
            result_list.add(result);
        }
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity;
        entity= new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(result_list) {};
        return Response.ok(entity).build();
    }

    public static Response getUserById(int id){
        UsersDao dao = new UsersDao();
        Object[] row = dao.getUserById(id);
        if(row == null) return Response.status(404).build();
        else{
            LinkedHashMap<String, Object> user = build_users_dict(row);
            GenericEntity<LinkedHashMap<String, Object>> entity;
            entity= new GenericEntity<LinkedHashMap<String,Object>>(user) {};
            return Response.ok(entity).build();
        }
    }

    /*public ArrayList<LinkedHashMap<String, Object>> getUsersWithArg(int uID, String uFName, String uLName, String uGender, String uBirthDate, String uRegion, int uPhoneNumber, String uAddress, String username, String password) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(uID, uFName, uLName, uGender, uBirthDate, uRegion, uPhoneNumber, uAddress, username, password);
        UsersDao users = new UsersDao();
        ArrayList<Object[]> usersList = users.getUsersWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < usersList.size(); i++){
            resultList.add(build_users_dict(usersList.get(i)));
        }
        return resultList;
    }*/

}
