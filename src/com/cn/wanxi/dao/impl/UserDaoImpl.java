package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.UserDao;
import com.cn.wanxi.model.StudentModel;
import com.cn.wanxi.util.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    private Connection connection = null;


    @Override
    public int login(String username, String password) {
        String sql = "select * from tb_stu where stu_name='" + username +
                "' and stu_password = '" + password + "'";
        ResultSet resultSet = JDBC.excuteQuery(sql);
        StudentModel studentModel = new StudentModel();
        try {
            while (resultSet.next()) {
                studentModel.setStuName(resultSet.getString("stu_name"));
                studentModel.setStuPassword(resultSet.getString("stu_password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (studentModel.getStuName() != null && studentModel.getStuPassword()!=null) return 1;
        return 0;
    }

    @Override
    public int register(String username, String password) {
        String sql = "insert into tb_stu(stu_name,stu_password) values('"
                + username + "','"
                + password + "')";
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public int findUser(String username) {
        String sql = "select * from tb_stu where stu_name = '" + username + "'";
        ResultSet resultSet = JDBC.excuteQuery(sql);
        StudentModel studentModel = new StudentModel();
        try {
            while (resultSet.next()) {
                studentModel.setStuName(resultSet.getString("stu_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (studentModel.getStuName() != null) {
            return 0;
        }
        return 1;
    }
}
