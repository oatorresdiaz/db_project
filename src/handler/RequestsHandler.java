package handler;

import dao.InventoryDao;
import dao.RequestsDao;
import utilities.DateCompound;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class RequestsHandler {

    //done
    public static Hashtable<String, Object> build_requests_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<>();
        result.put("rqstsID", row[0]);
        result.put("rqstsQty", row[1]);
        result.put("rqstsDate", row[2]);
        result.put("reqID", row[3]);
        return result;
    }

    //done
    public Hashtable<String, Object> build_goodArg_dic(int rqstsID, int rqstsQty, String rqstsDate, int reqID){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        if(rqstsID != -1) result.put("rqstsID", rqstsID);
        if(rqstsQty != -1) result.put("rqstsID", rqstsID);
        if(rqstsDate != "UNDECLARED") result.put("rqstsDate", rqstsDate);
        if(reqID != -1) result.put("reqID", reqID);

        return result;
    }

    //done
    public static ArrayList<Hashtable<String, Object>> getAllRequests(){
        ArrayList<Object[]> rqstsList = dao.RequestsDao.getAllRequests();
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < rqstsList.size(); i++){
            resultList.add(build_requests_dic(rqstsList.get(i)));
        }
        return resultList;
    }

    //done
    public static Hashtable<String, Object> getRequestsById(int id){
        ArrayList<Object[]> rqstsList = dao.RequestsDao.getAllRequests();
        return build_requests_dic(rqstsList.get(id));
    }

    public ArrayList<Hashtable<String,Object>> getRequestsByRequesterID(int id) {
        RequestsDao rqsts = new RequestsDao();
        ArrayList<Object[]> rqstsList = rqsts.getRequestsByRequesterID(id);
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < rqstsList.size(); i++){
            resultList.add(build_requests_dic(rqstsList.get(i)));
        }
        return resultList;

    }

    public Response getRequestsWithArg(int rqstsID, int rqstsQty, String rqstsDate, int reqID) {
        Hashtable<String, Object> argDic = build_goodArg_dic(rqstsID, rqstsQty, rqstsDate, reqID);
        RequestsDao rqsts = new RequestsDao();
        ArrayList<Object[]> rqstsList = rqsts.getRequestsWithArg(argDic);
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < rqstsList.size(); i++){
            resultList.add(build_requests_dic(rqstsList.get(i)));
        }
        if (resultList.isEmpty()) return Response.status(404).build(); //Malformed query string.
        GenericEntity<ArrayList<Hashtable<String, Object>>> entity =
                new GenericEntity<ArrayList<Hashtable<String,Object>>>(resultList) {};
        return Response.ok(entity).build();
    }


}
