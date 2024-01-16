
package com.medecine.Entity;

import java.util.Date;

public class medicine {
    private int Mid;
    private String MedicineNo;
    private String Mname;
    private String MfactoryAddress;
    private String Mdescription;
    private float Mprice;
    private Date Mexpire;
    private String Munit;
    private int Mnumber;
    private int Mcategoryld;
    private int Mdeleted;

    public medicine() {
    }

    public medicine(int mid, String medicineNo, String mname, String mfactoryAddress, String mdescription, float mprice, Date mexpire, String munit, int mnumber, int mcategoryld, int mdeleted) {

        Mdeleted = mdeleted;
        Mcategoryld = mcategoryld;
        Mnumber = mnumber;
        Munit = munit;
        Mexpire = mexpire;
        Mprice = mprice;
        Mdescription = mdescription;
        MfactoryAddress = mfactoryAddress;
        Mname = mname;
        MedicineNo = medicineNo;
        Mid = mid;


    }

}
