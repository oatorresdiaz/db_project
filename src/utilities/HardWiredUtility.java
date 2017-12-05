package utilities;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/*****THIS CLASS IS FOR PROJECT PHASE 1 PURPOSES ONLY.*****/
public class HardWiredUtility {

    private static JoinLinkedHashMaps JLHM = new JoinLinkedHashMaps();

    public static ArrayList<LinkedHashMap<String, Object>> listNIJ(ArrayList<LinkedHashMap<String, Object>> list1, ArrayList<LinkedHashMap<String, Object>> list2) {
        String key = sameKey(list1, list2);
        ArrayList<LinkedHashMap<String, Object>> result = new ArrayList<>();
        LinkedHashMap<String, Object> element;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).get(key) == list2.get(j).get(key)) {
                    element = JLHM.joinWithEqualArg(list1.get(i), list2.get(j), key);
                    result.add(element);
                }
            }
        }
        return result;
    }

    public static String sameKey(ArrayList<LinkedHashMap<String, Object>> list1, ArrayList<LinkedHashMap<String, Object>> list2) {
        Object[] attributes1 = list1.get(0).keySet().toArray();
        Object[] attributes2 = list2.get(0).keySet().toArray();

        for (int i = 0; i < attributes1.length; i++) {
            for (int j = 0; j < attributes2.length; j++) {
                if (attributes1[i] == attributes2[j]) {
                    String result = (String) attributes1[i];
                    return result;
                }
            }
        }
        return null;
    }

}
