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

    public static Response getAllResources(){
        ResourcesDao dao = new ResourcesDao();
        ArrayList<Object[]> resources_list = dao.getAllResources();
        ArrayList<LinkedHashMap<String,Object>> result_list = new ArrayList<>();
        for(int i = 0; i < resources_list.size(); i++){
            LinkedHashMap<String,Object> result = build_resources_dict(resources_list.get(i));
            result_list.add(result);
        }
        GenericEntity<ArrayList<LinkedHashMap<String, Object>>> entity;
        entity= new GenericEntity<ArrayList<LinkedHashMap<String,Object>>>(result_list) {};
        return Response.ok(entity).build();
    }

    public static Response getResourceById(int id){
        ResourcesDao dao = new ResourcesDao();
        Object[] row = dao.getResourceById(id);
        if(row == null) return Response.status(404).build();
        else{
            LinkedHashMap<String, Object> resource = build_resources_dict(row);
            GenericEntity<LinkedHashMap<String, Object>> entity;
            entity= new GenericEntity<LinkedHashMap<String,Object>>(resource) {};
            return Response.ok(entity).build();
        }
    }

    private LinkedHashMap<String,Object> build_goodArg_dic(int resID, String resCategory, String resSubCategory) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        if(resID != -1) result.put("resID", resID);
        if(!resCategory.equals("UNDECLARED")) result.put("resCategory", resCategory);
        if(!resSubCategory.equals("UNDECLARED")) result.put("resSubCategory", resSubCategory);
        return result;
    }

    public ArrayList<LinkedHashMap<String, Object>> getResourcesWithArg(int resID, String resCategory, String resSubCategory) {
        LinkedHashMap<String, Object> argDic = build_goodArg_dic(resID, resCategory, resSubCategory);
        ResourcesDao rs = new ResourcesDao();
        ArrayList<Object[]> rsList = rs.getResourcesWithArg(argDic);
        ArrayList<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < rsList.size(); i++) {
            resultList.add(build_resources_dict(rsList.get(i)));
        }
        return resultList;
    }
}
