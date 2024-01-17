package com.medicine.Entity;

public class Category {
    private int Cid;
    private String Cname;
    private String Description;
    public Category(){}

    public int getCid() {
        return Cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public Category(int cid, String cname, String description){

        Cid = cid;
        Cname = cname;
        Description =description;

    }


}
