package com.medicine.Mapper.imp;
import com.medicine.Entity.User;

public interface userImp {
    boolean insert(User u);
    boolean delete(User u);
    boolean update(User u);
    User[] select(String key);

}
