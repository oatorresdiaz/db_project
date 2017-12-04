package handler;

import dao.ResourcesDao;

import java.util.ArrayList;
import java.util.Hashtable;

public class ResourcesHandler {

    public static Hashtable<String, Object> build_resources_dict(Object[] row){
        Hashtable<String, Object> result = new Hashtable<String, Object>();
        result.put("resID", row[0]);
        result.put("resCategory", row[1]);
        result.put("resSubCategory", row[2]);
        return result;
    }

    public static ArrayList<Hashtable<String, Object>> getAllResources(){
        ResourcesDao rsrs = new ResourcesDao();
        ArrayList<Object[]> rsrsList = rsrs.getAllResources();
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < rsrsList.size(); i++){
            resultList.add(build_resources_dict(rsrsList.get(i)));
        }
        return resultList;
    }

    public static Hashtable<String, Object> getResourceById(int id){
        ResourcesDao rsrs = new ResourcesDao();
        ArrayList<Object[]> rsrsList = rsrs.getAllResources();
        return build_resources_dict(rsrsList.get(id));
    }

}
