package handler;

import dao.ResourcesDao;

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

}
