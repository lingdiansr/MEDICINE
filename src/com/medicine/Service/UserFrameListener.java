package com.medicine.Service;
import com.medicine.Entity.User;
import com.medicine.Mapper.imp.UserMapperImp;
import com.medicine.Mapper.UserMapper;

import com.medicine.UI.medicine.MedicineFrame;
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
                User user1 = userMapper.selectByUserName(username);
                if (user1==null){
                    JOptionPane.showMessageDialog(uf, "不存在该用户请注册", "失败", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    User u = userMapper.selectByUserName(user).get(0);
                    if (Objects.equals(password, u.getPassword())) {
                        JOptionPane.showMessageDialog(uf, "登录成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                        new MedicineFrame();
                    } else {
                        JOptionPane.showMessageDialog(uf, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }


        } else if (e.getSource() == uf.registerButton) {
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(uf, "请正确输入用户名和密码", "错误", JOptionPane.ERROR_MESSAGE);
            } else {
                User u = userMapper.selectByUserName(username);

                if (u != null) {
                   JOptionPane.showMessageDialog(uf, "用户名已存在", "错误", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    User entity = new User();
                    entity.setUsername(username);
                    entity.setPassword(password);
                    entity.setType("0");
                    if ( userMapper.insert(entity)){
                        JOptionPane.showMessageDialog(uf, "注册成功", "正确", JOptionPane.INFORMATION_MESSAGE);

                    }


                }
            }
        }

    }
}
