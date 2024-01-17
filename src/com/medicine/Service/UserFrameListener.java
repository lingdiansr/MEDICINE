package com.medicine.Service;
import com.medicine.Entity.User;
import com.medicine.Mapper.imp.UserMapperImp;
import  com.medicine.Mapper.userMapper;

import com.medicine.UI.UserFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrameListener implements ActionListener {
    private final transient userMapper userMapper = new UserMapperImp();
    User user = new User();
    UserFrame uf;
    public UserFrameListener(UserFrame uf) {
        this.uf = uf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = uf.username.getText();
        String password = new String(uf.password.getPassword());

        if (e.getSource() == uf.loginButton) {
            if (id.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(uf, "请正确输入用户名和密码", "错误", JOptionPane.ERROR_MESSAGE);
            } else {
                userMapper.select(user);
                if (user != null && user.getPassword().equals(password)) {
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
