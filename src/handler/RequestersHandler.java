package handler;

import dao.RequestersDao;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
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

    public static Response getAllRequesters(){
        RequestersDao dao = new RequestersDao();
        ArrayList<Object[]> users_list = dao.getAllRequesters();
        ArrayList<LinkedHashMap<String,Object>> result_list = new ArrayList<>();
        for(int i = 0; i < users_list.size(); i++){
            LinkedHashMap<String,Object> result = build_requesters_dic(users_list.get(i));
            result_list.add(result);
        }
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity;
        entity= new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(result_list) {};
        return Response.ok(entity).build();
    }

    public static Response getRequesterById(int id){
        RequestersDao dao = new RequestersDao();
        Object[] row = dao.getRequesterById(id);
        if(row == null) return Response.status(404).build();
        else{
            LinkedHashMap<String, Object> user = build_requesters_dic(row);
            GenericEntity<LinkedHashMap<String, Object>> entity;
            entity= new GenericEntity<LinkedHashMap<String,Object>>(user) {};
            return Response.ok(entity).build();
        }
    }

    private LinkedHashMap<String,Object> build_goodArg_dic(int reqID, int uID) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        if(reqID != -1) result.put("reqID", reqID);
        if(uID != -1) result.put("uID", uID);
        return result;
    }

    public ArrayList<LinkedHashMap<String, Object>> getRequestersWithArg(int reqID, int uID) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(reqID, uID);
        RequestersDao spplrs = new RequestersDao();
        ArrayList<Object[]> spplrsList = spplrs.getRequestersWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < spplrsList.size(); i++) {
            resultList.add(build_requesters_dic(spplrsList.get(i)));
        }
        return resultList;
    }
}
