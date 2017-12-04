package dao;

import java.util.ArrayList;

public class SuppliersDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllSuppliers() {
        Object[] supp1 = new Object[4];
        supp1[0] = 0;
        supp1[1] = 1;
        Object[] supp2 = new Object[4];
        supp2[0] = 1;
        supp2[1] = 2;
        Object[] supp3 = new Object[4];
        supp3[0] = 2;
        supp3[1] = 3;
        ArrayList<Object[]> testSuppliers = new ArrayList<Object[]>();
        testSuppliers.add(supp1);
        testSuppliers.add(supp2);
        testSuppliers.add(supp3);
        return testSuppliers;
    }
}
