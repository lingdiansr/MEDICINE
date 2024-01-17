package com.medicine.UI;
import com.medicine.Service.UserFrameListener;
import com.medicine.Service.UserFrameListener.*;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {
    public JPanel panel;

    public JLabel titleLabel;


    public JLabel usernameLabel;

    public JLabel passwordLabel;

    public JTextField username;

    public JPasswordField password;

    public JButton loginButton;
    public JButton registerButton;
    UserFrameListener userFrameListener;

    public UserFrame() {
        initPanel();
        initFrame();
        UserFrameListener userFrameListener= new UserFrameListener(this);

    }


    private void initPanel() {
        panel = new JPanel();
        this.setContentPane(panel);
        this.setLayout(null);
        // 1. 标题标签
        titleLabel = new JLabel("医药管理系统",SwingConstants.CENTER);

        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new Font("宋体",Font.PLAIN,50));
        titleLabel.setSize(800,100);

        // 2.用户名标签
        usernameLabel = new JLabel("用户名:");

        usernameLabel.setForeground(new Color(0xFF0000));
        usernameLabel.setFont(new Font("宋体", Font.PLAIN, 30));
        usernameLabel.setBounds(200, 100, 200, 100);

        // 3.登录标签
        passwordLabel = new JLabel("密码  :");
        passwordLabel.setForeground(new Color(0xFF0000));
        passwordLabel.setFont(new Font("宋体", Font.PLAIN, 30));
        passwordLabel.setBounds(200, 160, 200, 100);

        panel.add(titleLabel);
        panel.add(usernameLabel);
        panel.add(passwordLabel);

        // 字段值样式处理
        username = new JTextField(20);
        username.setFont(new Font("宋体",Font.PLAIN,18));
        username.setSelectedTextColor(new Color(0xFF0000));
        username.setBounds(330,132,280,40);

        password = new JPasswordField(20);
        password.setBounds(330, 192, 280, 40);
        panel.add(username);
        panel.add(password);

        // 处理按钮
        // 登录
        loginButton = new JButton("登录");
        loginButton.setForeground(Color.BLUE);
        loginButton.setBackground(Color.GREEN);
        loginButton.setFont(new Font("宋体", Font.PLAIN, 20));
        loginButton.setBorderPainted(false);
        loginButton.setBounds(270, 300, 100, 50);
        loginButton.addActionListener(userFrameListener);
        //注册
        registerButton = new JButton("注册");
        registerButton.setForeground(Color.BLUE);
        registerButton.setBackground(Color.PINK);
        registerButton.setFont(new Font("宋体", Font.PLAIN, 20));
        registerButton.setBorderPainted(false);
        registerButton.setBounds(450, 300, 100, 50);
        registerButton.addActionListener(userFrameListener);
        panel.add(loginButton);
        panel.add(registerButton);
    }

    private void initFrame() {
        this.setTitle("登录");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void  main(String[] args){
        new UserFrame();
    }
}
