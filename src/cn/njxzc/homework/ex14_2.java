package cn.njxzc.homework;

import java.sql.*;

/**
 * Created by ST001 on 2017/5/24.
 */
public class ex14_2 {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db?characterEncoding=utf8";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;

        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        String sql = "INSERT into tb_stu(name,sex,birthday) VALUES (?,?,?)";

        PreparedStatement ptmt=conn.prepareStatement(sql);

        ptmt.setString(1, "李某");
        ptmt.setString(2, "女");
        ptmt.setString(3, "1999-10-20");

        ptmt.execute();
        System.out.println("注册成功！");




    }

}
