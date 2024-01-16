package com.medecine.Mapper.imp;
import com.medecine.Entity.user;

public interface userImp {
    boolean insert(user u);
    boolean delete(user u);
    boolean update(user u);
    user[] select(String key);

}
