package com.medicine.Query;

public class MedicineQuery {
    private String medicineName;
    private String medicineMinPrice;
    private String medicineMaxPrice;
    private String categoryId;
    private String datePick;


    public MedicineQuery(String medicineName, String medicineMinPrice, String medicineMaxPrice, String categoryId, String datePick) {
        this.medicineName = medicineName;
        this.medicineMinPrice = medicineMinPrice;
        this.medicineMaxPrice = medicineMaxPrice;
        this.categoryId = categoryId;
        this.datePick = datePick;
    }

    public MedicineQuery() {
    }

    public static MedicineQuery from(String medicineNameStr, String medicineMinPriceStr, String medicineMaxPriceStr, String categoryId, String datePickStr) {
       if (categoryId.equals("-1")){
           categoryId=null;
       }
       if (medicineNameStr.equals("")){
           medicineNameStr=null;
       }
       if (medicineMinPriceStr.equals("")){
           medicineMinPriceStr=null;
       }
       if (medicineMaxPriceStr.equals("")){
           medicineMaxPriceStr=null;
       }
        return new MedicineQuery(medicineNameStr,medicineMinPriceStr,medicineMaxPriceStr,categoryId,datePickStr);
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineMinPrice() {
        return medicineMinPrice;
    }

    public void setMedicineMinPrice(String medicineMinPrice) {
        this.medicineMinPrice = medicineMinPrice;
    }

    public String getMedicineMaxPrice() {
        return medicineMaxPrice;
    }

    public void setMedicineMaxPrice(String medicineMaxPrice) {
        this.medicineMaxPrice = medicineMaxPrice;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDatePick() {
        return datePick;
    }

    public void setDatePick(String datePick) {
        this.datePick = datePick;
    }

}
