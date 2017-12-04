package dao;

import java.util.ArrayList;

public class AdminsDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllAdmins() {
        Object[] admin1 = new Object[2];
        admin1[0] = 0;
        admin1[1] = 0;
        Object[] admin2 = new Object[2];
        admin2[0] = 1;
        admin2[1] = 2;
        ArrayList<Object[]> testAdmins = new ArrayList<Object[]>();
        testAdmins.add(admin1);
        testAdmins.add(admin2);
        return testAdmins;
    }
}
