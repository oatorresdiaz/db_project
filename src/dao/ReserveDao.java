package dao;

import java.util.ArrayList;

public class ReserveDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllReservations(){
        Object[] res1 = new Object[5];
        res1[0] = 0;
        res1[1] = 0;
        res1[2] = "11/16/2017";
        res1[3] = "11/18/2017";
        res1[4] = 10;

        Object[] res2 = new Object[5];
        res2[0] = 0;
        res2[1] = 1;
        res2[2] = "08/08/2017";
        res2[3] = "08/10/2017";
        res2[4] = 15;

        Object[] res3 = new Object[5];
        res3[0] = 1;
        res3[1] = 2;
        res3[2] = "09/09/2017";
        res3[3] = "09/11/2017";
        res3[4] = 20;

        ArrayList<Object[]> testReserves = new ArrayList<>();
        testReserves.add(res1);
        testReserves.add(res2);
        testReserves.add(res3);

        return testReserves;
    }
}