package com.medicine.Service;
import com.medicine.Entity.User;
import com.medicine.Mapper.imp.UserMapperImp;
import com.medicine.Mapper.UserMapper;

import com.medicine.UI.user.UserFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UserFrameListener implements ActionListener {
    private final transient UserMapper userMapper = new UserMapperImp();
    UserFrame uf;
    public UserFrameListener(UserFrame uf) {
        this.uf = uf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = uf.username.getText();
        String password = new String(uf.password.getPassword());
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (e.getSource() == uf.loginButton) {
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(uf, "请正确输入用户名和密码", "错误", JOptionPane.ERROR_MESSAGE);
            } else {
                User u = userMapper.selectByUserName(user).get(0);
                if (Objects.equals(password,u.getPassword())) {
                    JOptionPane.showMessageDialog(uf, "登录成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(uf, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }


        } else if (e.getSource() == uf.registerButton) {
            System.exit(0);
        }

    }
}
