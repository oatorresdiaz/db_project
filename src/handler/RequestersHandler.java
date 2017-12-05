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

    private LinkedHashMap<String,Object> build_goodArg_dic(int reqID, int uID) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        if(reqID != -1) result.put("reqID", reqID);
        if(uID != -1) result.put("uID", uID);
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
