package com.medecine.ui.user;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {
    JPanel panel;
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private  JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private  JButton registerButton;
    public UserFrame(){
        initFrame();
        initPanel();
        loginButtonListener();
        registerButtonListener();
    }
    private  void registerButtonListener(){

    }
    private  void loginButtonListener(){

    }
    private void initFrame(){
        this.setTitle("登录");
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void initPanel(){
        panel=new JPanel();
        this.setContentPane(panel);
        this.setLayout(null);

        titleLabel=new JLabel("医药管理系统",SwingConstants.CENTER);
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new Font("宋体",Font.PLAIN,30));
        titleLabel.setSize(800,100);

        usernameLabel=new JLabel("用户名");
        usernameLabel.setForeground(new Color(0xFF0000));
        usernameLabel.setFont(new Font("宋体",Font.PLAIN,30));
        usernameLabel.setBounds(200,160,200,100);

        passwordLabel=new JLabel("密码");
        passwordLabel.setForeground(new Color(0xFF0000));
        passwordLabel.setFont(new Font("宋体",Font.PLAIN,30));
        passwordLabel.setBounds(200,160,200,100);

        panel.add(titleLabel);
        panel.add(usernameLabel);
        panel.add(passwordLabel);

        usernameField =new JTextField(20);
        usernameField.setFont(new Font("宋体",Font.PLAIN,18));
        usernameField.setSelectedTextColor(new Color(0xFF0000));
        usernameField.setBounds(330,132,280,40);

        passwordField =new JPasswordField(20);
        passwordField.setFont(new Font("宋体",Font.PLAIN,18));
        passwordField.setSelectedTextColor(new Color(0xFF0000));
        passwordField.setBounds(330,192,200,40);

        panel.add(usernameField);
        panel.add(passwordField);

        loginButton =new JButton("登录");
        registerButton =new JButton("注册");
        loginButton.setForeground(Color.BLUE);
        loginButton.setFont(new Font("宋体",Font.PLAIN,20));
        loginButton.setBorderPainted(false);
        loginButton.setBounds(270,300,100,50);

        registerButton =new JButton("注册");
        registerButton.setForeground(Color.BLUE);
        registerButton.setFont(new Font("宋体",Font.PLAIN,20));
        registerButton.setBorderPainted(false);
        registerButton.setBounds(270,300,100,50);

        panel.add(loginButton);
        panel.add(registerButton);
    }
}
