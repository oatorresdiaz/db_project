package dao;

import java.util.ArrayList;

public class RequestersDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllRequesters() {
        Object[] req1 = new Object[4];
        req1[0] = 0;
        req1[1] = 0;
        Object[] req2 = new Object[4];
        req2[0] = 1;
        req2[1] = 3;
        ArrayList<Object[]> testRequesters = new ArrayList<Object[]>();
        testRequesters.add(req1);
        testRequesters.add(req2);
        return testRequesters;
    }

}
