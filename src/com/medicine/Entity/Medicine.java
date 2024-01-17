
package com.medicine.Entity;

import java.util.Date;

public class Medicine {
    private Integer Mid;
    private String MedicineNo;
    private String Mname;
    private String MfactoryAddress;
    private String Mdescription;
    private float Mprice;
    private Date Mexpire;
    private String Munit;
    private Integer Mnumber;
    private Integer Mcategoryld;
    private Integer Mdeleted;

    public Medicine() {
    }
    public Medicine(int mid, String medicineNo, String mname, String mfactoryAddress, String mdescription, float mprice, Date mexpire, String munit, int mnumber, int mcategoryld, int mdeleted) {

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

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    public String getMedicineNo() {
        return MedicineNo;
    }

    public void setMedicineNo(String medicineNo) {
        MedicineNo = medicineNo;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getMfactoryAddress() {
        return MfactoryAddress;
    }

    public void setMfactoryAddress(String mfactoryAddress) {
        MfactoryAddress = mfactoryAddress;
    }

    public String getMdescription() {
        return Mdescription;
    }

    public void setMdescription(String mdescription) {
        Mdescription = mdescription;
    }

    public float getMprice() {
        return Mprice;
    }

    public void setMprice(float mprice) {
        Mprice = mprice;
    }

    public Date getMexpire() {
        return Mexpire;
    }

    public void setMexpire(Date mexpire) {
        Mexpire = mexpire;
    }

    public String getMunit() {
        return Munit;
    }

    public void setMunit(String munit) {
        Munit = munit;
    }

    public Integer getMnumber() {
        return Mnumber;
    }

    public void setMnumber(Integer mnumber) {
        Mnumber = mnumber;
    }

    public Integer getMcategoryld() {
        return Mcategoryld;
    }

    public void setMcategoryld(Integer mcategoryld) {
        Mcategoryld = mcategoryld;
    }

    public Integer getMdeleted() {
        return Mdeleted;
    }

    public void setMdeleted(Integer mdeleted) {
        Mdeleted = mdeleted;
    }



}