package com.lh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Description
 * @Author LuoH
 * @Date 2019-11-28 20:17
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest", "root", "root");
        //4.定义sql语句
        String sql = "select * from dept";
        //5.获取执行sql 的对象statement
        Statement statement = conn.createStatement();
        //6.执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        //7.处理结果
        System.out.println(resultSet);
        //8.释放资源
        statement.close();
        conn.close();
    }
}
