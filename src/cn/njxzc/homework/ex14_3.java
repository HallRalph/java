package cn.njxzc.homework;

import java.sql.*;
import static cn.njxzc.homework.conn.*;

/**
 * Created by ST001 on 2017/5/24.
 */
public class ex14_3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;

        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        String date="2010-01-01";
        String sql = "delete from tb_stu where birthday<'" + date + "'";
        PreparedStatement pstmt;
        pstmt = (PreparedStatement) conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }
}
