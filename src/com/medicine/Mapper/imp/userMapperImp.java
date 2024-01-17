package com.medicine.Mapper.imp;
import com.medicine.Entity.User;
import com.medicine.Mapper.userMapper;
public class userMapperImp implements userMapper{
    @Override
    public boolean insert(User u) {
//        String sql ="INSERT INTO user(username,password)"
        return false;
    }

    @Override
    public boolean delete(User u) {
        return false;
    }

    @Override
    public boolean update(User u) {
        return false;
    }

    @Override
    public User[] select(String key) {
        return new User[0];
    }
}
