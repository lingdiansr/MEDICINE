package com.medicine.Mapper;
import com.medicine.Entity.User;

import java.util.List;

public interface userMapper {
    boolean insert(User u);
    boolean delete(User u);
    boolean update(User u);
    List<User> select(User u);
}
