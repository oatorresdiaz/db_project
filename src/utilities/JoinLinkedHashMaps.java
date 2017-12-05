package utilities;


import java.util.LinkedHashMap;

public class JoinLinkedHashMaps {

    public static LinkedHashMap<String, Object> joinWithEqualArg(LinkedHashMap<String,
            Object> map1, LinkedHashMap<String, Object> map2, String sameKey){

        LinkedHashMap<String, Object> joinedList = new LinkedHashMap<>();

        if(map1.containsKey(sameKey) && map2.containsKey(sameKey)){
            Object[] mapKeys1 = map1.keySet().toArray();
            Object[] mapKeys2 = map2.keySet().toArray();

            for(int i = 0; i < map1.size(); i++){
                joinedList.put((String) mapKeys1[i], map1.get(mapKeys1[i]));
            }
            for(int i = 0; i < map2.size(); i++){
                if(mapKeys2[i] != sameKey) {
                    joinedList.put((String) mapKeys2[i], map2.get(mapKeys2[i]));
                }
            }
        }
        return joinedList;

    }




}
