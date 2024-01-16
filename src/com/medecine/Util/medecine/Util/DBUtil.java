package com.medecine.Util.medecine.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() {
        String url = "jdbc:mysql://lingdianshiren.xyz:3306/ldsr-lianxi?characterEncoding=utf8&useUnicode=true";
        String DRIVER = "com.mysql.jdbc.Driver";
        String user = "root";
        String psd = "123456";
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(url, user, psd);
//            System.out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        System.out.printf(getConnection().toString());
    }
}
