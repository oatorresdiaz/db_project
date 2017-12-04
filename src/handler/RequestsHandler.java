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

    //done 1
    public static Hashtable<String, Object> build_requests_dic(Object[] row){
        Hashtable<String, Object> result = new Hashtable<>();
        result.put("reqID", row[0]);
        result.put("resID", row[1]);
        result.put("rqstsDate", row[2]);
        result.put("rqstsQty", row[3]);
        return result;
    }

    //done 2
    public Hashtable<String, Object> build_goodArg_dic(int reqID, int resID, String rqstsDate, int rqstsQty){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        if(reqID != -1) result.put("reqID", reqID);
        if(resID != -1) result.put("resID", resID);
        if(rqstsDate != "UNDECLARED") result.put("rqstsDate", rqstsDate);
        if(rqstsQty != -1) result.put("rqstsQty", rqstsQty);

        return result;
    }

    //done 3
    public static ArrayList<Hashtable<String, Object>> getAllRequests(){
        ArrayList<Object[]> rqstsList = dao.RequestsDao.getAllRequests();
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < rqstsList.size(); i++){
            resultList.add(build_requests_dic(rqstsList.get(i)));
        }
        return resultList;
    }

    //done 4
    public static Hashtable<String, Object> getRequestsById(int id){
        ArrayList<Object[]> rqstsList = dao.RequestsDao.getAllRequests();
        return build_requests_dic(rqstsList.get(id));
    }

    //done 5
    public ArrayList<Hashtable<String,Object>> getRequestsByRequesterID(int id) {
        RequestsDao rqsts = new RequestsDao();
        ArrayList<Object[]> rqstsList = rqsts.getRequestsByRequesterID(id);
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < rqstsList.size(); i++){
            resultList.add(build_requests_dic(rqstsList.get(i)));
        }
        return resultList;

    }

    //done 6
    public Response getRequestsWithArg(int reqID, int resID, String rqstsDate, int rqstsQty) {
        Hashtable<String, Object> argDic = build_goodArg_dic(reqID, resID, rqstsDate, rqstsQty);
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
