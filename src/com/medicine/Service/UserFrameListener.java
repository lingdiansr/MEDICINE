package com.medicine.Service;

import com.medicine.UI.UserFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrameListener implements ActionListener {
    UserFrame uf;

    public UserFrameListener(UserFrame uf) {
        this.uf = uf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = uf.username.getText();
        String password = new String(uf.password.getPassword());

        if (e.getSource() == uf.loginButton) {
            System.out.println("点击登录按钮");
            if (id.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(uf, "请正确输入用户名和密码", "错误", JOptionPane.ERROR_MESSAGE);
            } else {

            }
        } else if (e.getSource() == uf.registerButton) {
            System.exit(0);
        }

    }
}
