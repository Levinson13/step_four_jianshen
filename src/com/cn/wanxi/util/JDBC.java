package com.cn.wanxi.util;

import java.sql.*;

/**
 * JDBC工具类
 * 1. 加载驱动
 * 2. 获得连接
 * 3. 创建PrepareStatement对象，编写sql，进行预编译
 * 4. 释放资源
 */
public class JDBC {

    private static final String driverClass;

    private static final String url;

    private static final String username;

    private static final String password;


    static {
        driverClass = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql:///jianshen?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8";
        username = "root";
        password = "123456";
    }

    /**
     * 加载驱动
     * @throws ClassNotFoundException
     */
    public static void loadDriver() throws ClassNotFoundException {
        Class.forName(driverClass);
    }

    public static Connection getConnection() throws Exception {
        loadDriver();
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    /**
     * 创建PrepareStatement对象，编写sql语句，进行预编译处理
     * @return
     */
    public static int excuteUpdate(String sql){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int num = 0;
        try {
            connection = getConnection();
            // 进行预编译
            preparedStatement = connection.prepareStatement(sql);
            // 执行sql语句
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(preparedStatement,connection,null);
        }
        return num;
    }

    public static ResultSet excuteQuery(String sql){
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = getConnection();

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 释放资源
     */
    public static void release(Statement statement,Connection connection,ResultSet resultSet){
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
    }







}
