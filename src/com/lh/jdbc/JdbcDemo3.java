package com.lh.jdbc;

import com.lh.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description
 * @Author LuoH
 * @Date 2019-11-28 22:06
 */
public class JdbcDemo3 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            //String sql = "insert into dept value(null,'x部','天津')";
            String sql = "select * from dept";
            //4.获取执行sql的对象 Statement
            statement = connection.createStatement();
            //5.执 count = statement.executeUpdate(sql);
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String dname = rs.getString(2);
                System.out.println("id " + id + "  " + "dname " + dname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, statement, connection);
        }
    }
}
