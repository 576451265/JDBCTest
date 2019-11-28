package com.lh.jdbc;

import java.sql.*;

/**
 * @Description
 * @Author LuoH
 * @Date 2019-11-28 21:01
 */
public class JdbcDemo2 {

    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            //String sql = "insert into dept value(null,'x部','天津')";
            String sql = "select * from dept";
            //3.获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest", "root", "root");
            //4.获取执行sql的对象 Statement
            statement = connection.createStatement();
            //5.执行sql
            //int count = statement.executeUpdate(sql);
            rs = statement.executeQuery(sql);
            //6.处理结果
            /*System.out.println(count);
            if (count > 0){
                System.out.println("success");
            }else {
                System.out.println("fail");
            }*/
            while (rs.next()){
                //6.1让游标向下移动一行
                //rs.next();
                //6.2获取数据
                int id = rs.getInt(1);
                String dname = rs.getString(2);
                System.out.println("id " + id + "  " + "dname " + dname);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            //避免空指针异常
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
