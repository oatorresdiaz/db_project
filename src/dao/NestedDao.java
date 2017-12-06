package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NestedDao {

    //TODO: FOR PHASE 2

    /*public ArrayList<Object[]> getNestedWithArg(String entity1, String entity2, String entity3, String entity4, String entity5, LinkedHashMap<String, Object> argsDic) {
        Object[] keys = argsDic.keySet().toArray();
        String query = "";
        if(argsDic.size() == 1) query = "select * from " + getNIJ(entity1, entity2, entity3, entity4, entity5) + " " + keys[0] + " = " + argsDic.get(keys[0]) + ";";
        else if (argsDic.size() > 1){
            query = "select * from " + getNIJ(entity1, entity2, entity3, entity4, entity5) + " where " + keys[0] + " = " + argsDic.get(keys[0]);
            for(int i = 1; i < argsDic.size(); i++){
                query += " and " + keys[i] + " = " + argsDic.get(keys[i]);
            }
            query += ";";
        }
        System.out.println(query);
        return null;
    }

    public String getNIJ(String entity1, String entity2, String entity3, String entity4, String entity5){
        if(entity2.equals("UNDECLARED") && entity3.equals("UNDECLARED") && entity4.equals("UNDECLARED") && entity5.equals("UNDECLARED")) return entity1;
        else if(entity3.equals("UNDECLARED") && entity4.equals("UNDECLARED") && entity5.equals("UNDECLARED")) return entity1 + " natural inner join " + entity2;
        else if(entity4.equals("UNDECLARED") && entity5.equals("UNDECLARED")) return entity1 + " natural inner join " + entity2 + " natural inner join " + entity3;
        else if(entity5.equals("UNDECLARED")) return entity1 + " natural inner join " + entity2 + " natural inner join " + entity3 + " natural inner join " + entity4;
        else return entity1 + " natural inner join " + entity2 + " natural inner join " + entity3 + " natural inner join " + entity4 + " natural inner join " + entity5;
    }*/
}
