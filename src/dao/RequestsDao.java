package dao;

import utilities.DateCompound;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RequestsDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllRequests(){
        DateCompound d1 = new DateCompound("09241999");
        DateCompound d2 = new DateCompound("04092009");
        DateCompound d3 = new DateCompound("11302015");
        DateCompound d4 = new DateCompound("12252001");
        DateCompound d5 = new DateCompound("05301996");

        Object[] rqst1 = new Object[4];
        rqst1[0] = 0;
        rqst1[1] = 25;
        rqst1[2] = d1.asString();
        rqst1[3] = 1;

        Object[] rqst2 = new Object[4];
        rqst2[0] = 1;
        rqst2[1] = 20;
        rqst2[2] = d2.asString();
        rqst2[3] = 0;

        Object[] rqst3 = new Object[4];
        rqst3[0] = 2;
        rqst3[1] = 15;
        rqst3[2] = d3.asString();
        rqst3[3] = 1;

        Object[] rqst4 = new Object[4];
        rqst4[0] = 3;
        rqst4[1] = 10;
        rqst4[2] = d4.asString();
        rqst4[3] = 0;

        Object[] rqst5 = new Object[4];
        rqst5[0] = 4;
        rqst5[1] = 8;
        rqst5[2] = d5.asString();
        rqst4[3] = 1;


        ArrayList<Object[]> testResources = new ArrayList<Object[]>();
        testResources.add(rqst1);
        testResources.add(rqst2);
        testResources.add(rqst3);
        testResources.add(rqst4);
        testResources.add(rqst5);

        return testResources;
    }

    public ArrayList<Object[]> getRequestsByRequesterID(int id) {
        DateCompound d1 = new DateCompound("09241999");
        DateCompound d2 = new DateCompound("04092009");
        DateCompound d3 = new DateCompound("11302015");
        DateCompound d4 = new DateCompound("12252001");
        DateCompound d5 = new DateCompound("05301996");

        Object[] rqst1 = new Object[4];
        rqst1[0] = 0;
        rqst1[1] = 4;
        rqst1[2] = d1.asString();
        rqst1[3] = 25;

        Object[] rqst2 = new Object[4];
        rqst2[0] = 1;
        rqst2[1] = 7;
        rqst2[2] = d2.asString();
        rqst2[3] = 20;

        Object[] rqst3 = new Object[4];
        rqst3[0] = 0;
        rqst3[1] = 1;
        rqst3[2] = d3.asString();
        rqst3[3] = 15;

        Object[] rqst4 = new Object[4];
        rqst4[0] = 1;
        rqst4[1] = 3;
        rqst4[2] = d4.asString();
        rqst4[3] = 10;

        Object[] rqst5 = new Object[4];
        rqst5[0] = 1;
        rqst5[1] = 8;
        rqst5[2] = d5.asString();
        rqst4[3] = 8;

        ArrayList<Object[]> testResources = new ArrayList<>();
        testResources.add(rqst1);
        testResources.add(rqst2);
        testResources.add(rqst3);
        testResources.add(rqst4);
        testResources.add(rqst5);

        return testResources;
    }

    public ArrayList<Object[]> getRequestsWithArg(LinkedHashMap<String, Object> argsDic) {
        Object[] keys = argsDic.keySet().toArray();
        String query;
        if(argsDic.size() == 1) query = "select * from requests where " + keys[0] + " = " + argsDic.get(keys[0]) + ";";
        else{
            query = "select * from requests where " + keys[0] + " = " + argsDic.get(keys[0]);
            for(int i = 1; i < argsDic.size(); i++){
                query += " and " + keys[i] + " = " + argsDic.get(keys[i]);
            }
            query += ";";
        }
        System.out.println(query);
        return getAllRequests(); //HARD WIRED. IN PHASE II THE RETURN WILL MATCH THE QUERY.
    }

}
