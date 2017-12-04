package dao;

import java.util.ArrayList;

public class PurchasesDao {

    //FOR TESTING PURPOSES
    public static ArrayList<Object[]> getAllPurchases(){
        ArrayList<Object[]> testPurchases = new ArrayList<>();

        Object[] purchase1 = new Object[4];
        purchase1[0] = 0;
        purchase1[1] = 1;
        purchase1[2] = 0;
        purchase1[3] = 20;

        Object[] purchase2 = new Object[4];
        purchase2[0] = 1;
        purchase2[1] = 0;
        purchase2[2] = 0;
        purchase2[3] = 10;

        Object[] purchase3 = new Object[4];
        purchase3[0] = 2;
        purchase3[1] = 1;
        purchase3[2] = 2;
        purchase3[3] = 100;

        Object[] purchase4 = new Object[4];
        purchase4[0] = 3;
        purchase4[1] = 0;
        purchase4[2] = 1;
        purchase4[3] = 25;

        testPurchases.add(purchase1);
        testPurchases.add(purchase2);
        testPurchases.add(purchase3);
        testPurchases.add(purchase4);

        return testPurchases;
    }
}
