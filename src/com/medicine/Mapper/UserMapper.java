package com.medicine.Mapper;
import com.medicine.Entity.User;

import java.util.List;

public interface UserMapper {
    boolean insert(User u);
    boolean delete(User u);
    boolean update(User u);
    List<User> selectByUserName(User u);
    User selectByUserName(String username);
}
