package handler;

import dao.InventoryDao;
import dao.RequestsDao;
import utilities.DateCompound;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class RequestsHandler {

    //done
    public static LinkedHashMap<String, Object> build_requests_dic(Object[] row){
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        result.put("rqstID", row[0]);
        result.put("rqstQty", row[1]);
        result.put("rqstDate", row[2]);
        result.put("reqID", row[3]);
        return result;
    }

    //done
    public LinkedHashMap<String, Object> build_goodArg_dic(int rqstID, int rqstQty, String rqstDate, int reqID){
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        if(rqstID != -1) result.put("rqstID", rqstID);
        if(rqstQty != -1) result.put("rqstID", rqstQty);
        if(!rqstDate.equals("UNDECLARED")) result.put("rqstDate", rqstDate);
        if(reqID != -1) result.put("reqID", reqID);

        return result;
    }

    //done
    public static ArrayList<LinkedHashMap<String, Object>> getAllRequests(){
        ArrayList<Object[]> rqstsList = dao.RequestsDao.getAllRequests();
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < rqstsList.size(); i++){
            resultList.add(build_requests_dic(rqstsList.get(i)));
        }
        return resultList;
    }

    //done
    public static LinkedHashMap<String, Object> getRequestsById(int id){
        ArrayList<Object[]> rqstsList = dao.RequestsDao.getAllRequests();
        return build_requests_dic(rqstsList.get(id));
    }

    public ArrayList<LinkedHashMap<String,Object>> getRequestsByRequesterID(int id) {
        RequestsDao rqsts = new RequestsDao();
        ArrayList<Object[]> rqstsList = rqsts.getRequestsByRequesterID(id);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < rqstsList.size(); i++){
            resultList.add(build_requests_dic(rqstsList.get(i)));
        }
        return resultList;

    }

    public Response getRequestsWithArg(int rqstID, int rqstQty, String rqstDate, int reqID) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(rqstID, rqstQty, rqstDate, reqID);
        RequestsDao rqsts = new RequestsDao();
        ArrayList<Object[]> rqstsList = rqsts.getRequestsWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < rqstsList.size(); i++){
            resultList.add(build_requests_dic(rqstsList.get(i)));
        }
        if (resultList.isEmpty()) return Response.status(404).build(); //Malformed query string.
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(resultList) {};
        return Response.ok(entity).build();
    }


}
