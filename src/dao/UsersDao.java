package dao;

import java.util.ArrayList;

public class UsersDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllUsers(){
        Object[] orlando = new Object[10];
        orlando[0] = 0;
        orlando[1] = "Orlando";
        orlando[2] = "Torres";
        orlando[3] = "M";
        orlando[4] = "05/30/1996";
        orlando[5] = "Trujillo Alto";
        orlando[6] = "787-453-6040";
        orlando[7] = "Some address.";
        orlando[8] = "orlandoecool";
        orlando[9] = "Schultz453!";
        Object[] pedro = new Object[10];
        pedro[0] = 1;
        pedro[1] = "Pedro";
        pedro[2] = "Rivera";
        pedro[3] = "M";
        pedro[4] = "01/05/1996";
        pedro[5] = "Vega Baja";
        pedro[6] = "787-238-5368";
        pedro[7] = "Some address.";
        pedro[8] = "pedroElDurako";
        pedro[9] = "Natalie678!";
        Object[] nicole = new Object[10];
        nicole[0] = 2;
        nicole[1] = "Nicole";
        nicole[2] = "Matos";
        nicole[3] = "F";
        nicole[4] = "04/21/1990";
        nicole[5] = "Bayamon";
        nicole[6] = "787-309-5693";
        nicole[7] = "Some address.";
        nicole[8] = "nicoleIsWeird";
        nicole[9] = "Chad1222!";
        Object[] gilissa = new Object[10];
        gilissa[0] = 3;
        gilissa[1] = "Gilissa";
        gilissa[2] = "Algo";
        gilissa[3] = "F";
        gilissa[4] = "04/21/1973";
        gilissa[5] = "Rincon";
        gilissa[6] = "787-222-2222";
        gilissa[7] = "Some address.";
        gilissa[8] = "gilissagilissa";
        gilissa[9] = "Jan234!";
        ArrayList<Object[]> testUsers = new ArrayList<Object[]>();
        testUsers.add(orlando);
        testUsers.add(pedro);
        testUsers.add(nicole);
        testUsers.add(gilissa);
        return testUsers;
    }

}