package handler;

import dao.ResourcesDao;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ResourcesHandler {

    public static LinkedHashMap<String, Object> build_resources_dict(Object[] row){
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("resID", row[0]);
        result.put("resCategory", row[1]);
        result.put("resSubCategory", row[2]);
        return result;
    }

    private LinkedHashMap<String,Object> build_goodArg_dic(int reqID, String resCategory, String resSubCategory) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        if(reqID != -1) result.put("reqID", reqID);
        if(!resCategory.equals("UNDECLARED")) result.put("resCategory", resCategory);
        if(!resSubCategory.equals("UNDECLARED")) result.put("resSubCategory", resSubCategory);
        return result;
    }

    public static ArrayList<LinkedHashMap<String, Object>> getAllResources(){
        ResourcesDao rsrs = new ResourcesDao();
        ArrayList<Object[]> rsrsList = rsrs.getAllResources();
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < rsrsList.size(); i++){
            resultList.add(build_resources_dict(rsrsList.get(i)));
        }
        return resultList;
    }

    public static LinkedHashMap<String, Object> getResourceById(int id){
        ResourcesDao rsrs = new ResourcesDao();
        ArrayList<Object[]> rsrsList = rsrs.getAllResources();
        return build_resources_dict(rsrsList.get(id));
    }

    public Response getResourcesWithArg(int reqID, String resCategory, String resSubCategory) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(reqID, resCategory, resSubCategory);
        ResourcesDao rs = new ResourcesDao();
        ArrayList<Object[]> rsList = rs.getResourcesWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < rsList.size(); i++) {
            resultList.add(build_resources_dict(rsList.get(i)));
        }
        if (resultList.isEmpty()) return Response.status(404).build(); //Malformed query string.
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity =
                new GenericEntity<ArrayList<LinkedHashMap<String, Object>>>(resultList) {
                };
        return Response.ok(entity).build();
    }
}
