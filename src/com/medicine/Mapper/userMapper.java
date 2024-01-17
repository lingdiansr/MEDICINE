package com.medicine.Mapper;
import com.medicine.Entity.User;

public interface userMapper {
    boolean insert(User u);
    boolean delete(User u);
    boolean update(User u);
    User[] select(String key);

}
