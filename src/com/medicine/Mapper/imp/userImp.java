package com.medicine.Mapper.imp;
import com.medicine.Entity.user;

public interface userImp {
    boolean insert(user u);
    boolean delete(user u);
    boolean update(user u);
    user[] select(String key);

}
