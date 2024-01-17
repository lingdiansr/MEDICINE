package com.medicine.Query;

import com.medicine.Entity.Medicine;

public class MedicineQuery {
    private String medicineNameStr;
    private String medicineMinPriceStr;
    private String medicineMaxPriceStr;
    private String categoryId;
    private String datePickStr;


    public MedicineQuery(String medicineNameStr, String medicineMinPriceStr, String medicineMaxPriceStr, String categoryId, String datePickStr) {
        this.medicineNameStr = medicineNameStr;
        this.medicineMinPriceStr = medicineMinPriceStr;
        this.medicineMaxPriceStr = medicineMaxPriceStr;
        this.categoryId = categoryId;
        this.datePickStr = datePickStr;
    }

    public MedicineQuery() {
    }

    public static MedicineQuery from(String medicineNameStr, String medicineMinPriceStr, String medicineMaxPriceStr, String categoryId, String datePickStr) {
        return new MedicineQuery(medicineNameStr,medicineMinPriceStr,medicineMaxPriceStr,categoryId,datePickStr);
    }

    public String getMedicineNameStr() {
        return medicineNameStr;
    }

    public void setMedicineNameStr(String medicineNameStr) {
        this.medicineNameStr = medicineNameStr;
    }

    public String getMedicineMinPriceStr() {
        return medicineMinPriceStr;
    }

    public void setMedicineMinPriceStr(String medicineMinPriceStr) {
        this.medicineMinPriceStr = medicineMinPriceStr;
    }

    public String getMedicineMaxPriceStr() {
        return medicineMaxPriceStr;
    }

    public void setMedicineMaxPriceStr(String medicineMaxPriceStr) {
        this.medicineMaxPriceStr = medicineMaxPriceStr;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDatePickStr() {
        return datePickStr;
    }

    public void setDatePickStr(String datePickStr) {
        this.datePickStr = datePickStr;
    }

}
