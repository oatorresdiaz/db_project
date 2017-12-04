package handler;

import dao.RequestersDao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap;


public class RequestersHandler {

    public static LinkedHashMap<String, Object> build_requesters_dic(Object[] row){
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("reqID", row[0]);
        result.put("uID", row[1]);
        return result;
    }

    public static ArrayList<LinkedHashMap<String, Object>> getAllRequesters(){
        RequestersDao rqstrs = new RequestersDao();
        ArrayList<Object[]> rqstrsList = rqstrs.getAllRequesters();
        ArrayList<LinkedHashMap<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < rqstrsList.size(); i++){
            result.add(build_requesters_dic(rqstrsList.get(i)));
        }
        return result;
    }

    public static LinkedHashMap<String, Object> getRequesterId(int id){
        RequestersDao rqstrs = new RequestersDao();
        ArrayList<Object[]> rqstrsList = rqstrs.getAllRequesters();
        return build_requesters_dic(rqstrsList.get(id));
    }

    public static ArrayList<LinkedHashMap<String, Object>> getRequestersNaturalJoinUser(){
        UsersHandler userHandler = new UsersHandler();
        ArrayList<LinkedHashMap<String, Object>> users = userHandler.getAllUsers();
        ArrayList<LinkedHashMap<String, Object>> requesters = getAllRequesters();
        ArrayList<LinkedHashMap<String,Object>> result = new ArrayList<>();
        for(int i = 0; i < requesters.size(); i++){
            for(int j = 0; j < users.size(); j++){
                if(requesters.get(i).get("uID") == users.get(j).get("uID")){
                    result.add(users.get(j));
                }
            }
        }
        return result;
    }
}
