package com.medicine.Entity;

import java.util.Date;

public class Medicine {
    private int id;
    private String medicineNo;
    private String name;
    private String factoryAddress;
    private String description;
    private double price;
    private Date expire;
    private String unit;
    private int number;
    private int categoryId;
    private int deleted;

    public Medicine() {
    }

    public Medicine(int id, String medicineNo, String name, String factoryAddress, String description, double price, Date expire, String unit, int number, int categoryId, int deleted) {
        this.id = id;
        this.medicineNo = medicineNo;
        this.name = name;
        this.factoryAddress = factoryAddress;
        this.description = description;
        this.price = price;
        this.expire = expire;
        this.unit = unit;
        this.number = number;
        this.categoryId = categoryId;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medicineNo='" + medicineNo + '\'' +
                ", name='" + name + '\'' +
                ", factoryAddress='" + factoryAddress + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", expire=" + expire +
                ", unit='" + unit + '\'' +
                ", number=" + number +
                ", categoryId=" + categoryId +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineNo() {
        return medicineNo;
    }

    public void setMedicineNo(String medicineNo) {
        this.medicineNo = medicineNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
