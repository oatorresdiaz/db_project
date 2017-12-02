package handler;

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
        ArrayList<Hashtable<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < getTestResources().size(); i++){
            resultList.add(build_resources_dict(getTestResources().get(i)));
        }
        return resultList;
    }

    public static Hashtable<String, Object> getResourceById(int id){
        return build_resources_dict(getTestResources().get(id));
    }

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getTestResources(){
        Object[] water1 = new Object[3];
        water1[0] = 0;
        water1[1] = "Water";
        water1[2] = "Water Bottles";
        Object[] water2 = new Object[3];
        water2[0] = 1;
        water2[1] = "Water";
        water2[2] = "1 Water Gallon";
        Object[] medications = new Object[3];
        medications[0] = 2;
        medications[1] = "Medications";
        medications[2] = "Null";
        Object[] babyFood = new Object[3];
        babyFood[0] = 3;
        babyFood[1] = "Baby Food";
        babyFood[2] = "Null";
        Object[] cannedFood = new Object[3];
        cannedFood[0] = 4;
        cannedFood[1] = "Canned Food";
        cannedFood[2] = "Null";
        Object[] dryFood = new Object[3];
        dryFood[0] = 5;
        dryFood[1] = "Dry Food";
        dryFood[2] = "Null";
        Object[] ice = new Object[3];
        ice[0] = 6;
        ice[1] = "Ice";
        ice[2] = "Null";
        Object[] diesel = new Object[3];
        diesel[0] = 7;
        diesel[1] = "Fuel";
        diesel[2] = "Diesel";
        Object[] propane = new Object[3];
        propane[0] = 8;
        propane[1] = "Fuel";
        propane[2] = "Propane";
        Object[] gasoline = new Object[3];
        gasoline[0] = 9;
        gasoline[1] = "Fuel";
        gasoline[2] = "Gasoline";
        ArrayList<Object[]> testResources = new ArrayList<Object[]>();
        testResources.add(water1);
        testResources.add(water2);
        testResources.add(medications);
        testResources.add(babyFood);
        testResources.add(cannedFood);
        testResources.add(dryFood);
        testResources.add(ice);
        testResources.add(diesel);
        testResources.add(propane);
        testResources.add(gasoline);
        return testResources;
    }

}
