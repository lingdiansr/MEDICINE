package com.medicine.Mapper.imp;

import com.medicine.Entity.User;
import com.medicine.Mapper.UserMapper;
import com.medicine.Util.JDBCHelper;

import java.util.List;

public class UserMapperImp implements UserMapper {
    private static final JDBCHelper jdbc = new JDBCHelper();

    @Override
    public boolean insert(User u) {
        String sql = "INSERT INTO user(username,password,type) VALUES (?,?,?)";
        String[] values = new String[]{u.getUsername(), u.getPassword(), String.valueOf(u.isType())};
        return jdbc.insert(sql, values) > 0;
    }

    @Override
    public boolean delete(User u) {
        String sql = "DELETE FROM user WHERE username=? and password=? and type= ?";
        String[] values = new String[]{u.getUsername(), u.getPassword(), String.valueOf(u.isType())};
        return jdbc.delete(sql, values) > 0;
    }

    @Override
    public boolean update(User u) {
        String sql = "UPDATE user SET password=? and type=? WHERE username= ?";
        String[] values = new String[]{u.getPassword(), String.valueOf(u.isType()), u.getUsername()};
        return jdbc.update(sql, values) > 0;
    }

    @Override
    public List<User> selectByUserName(User u) {
        String sql = "SELECT * FROM user where username=?";
//        String sql = "SELECT * FROM user ";
        String[] values = new String[]{
                u.getUsername()
        };
        return jdbc.select(sql, values, User.class);
    }

    @Override
    public User selectByUserName(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        String[] selectValues = new String[]{username};
        List<User> result = jdbc.select(sql, selectValues, User.class);
        return result.isEmpty() ? null :result.get(0);
    }
}
