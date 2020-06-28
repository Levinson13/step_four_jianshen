package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.util.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NavDaoImpl implements NavDao {

    private ResultSet resultSet = null;

    private Connection connection = null;

    private PreparedStatement preparedStatement = null;

    private Integer num = 0;

    @Override
    public int add(NavModel navModel) {
        try {
            // 获得连接
            connection = JDBC.getConnection();
            // 编写sql语句
            String sql = "insert into tb_nav values(null,?,?,0)";
            // 预编译sql
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            preparedStatement.setString(1,navModel.getHref());
            preparedStatement.setString(2,navModel.getTitle());
            // 执行sql
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.release(preparedStatement,connection,null);
        }
        return num;
    }

    @Override
    public int update(NavModel navModel) {
        int num = 0;
        try {
            // 获得连接
            connection = JDBC.getConnection();
            // 编写sql语句
            String sql = "update tb_nav set href = ?,title = ?,status=? where id = ?";
            // 预编译sql
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            preparedStatement.setString(1,navModel.getHref());
            preparedStatement.setString(2,navModel.getTitle());
            preparedStatement.setInt(3,navModel.getStatus());
            preparedStatement.setInt(4,navModel.getId());
            // 执行sql
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.release(preparedStatement,connection,null);
        }
        return num;
    }

    @Override
    public int delete(Integer id) {
        int num = 0;
        try {
            // 获得连接
            connection = JDBC.getConnection();
            // 编写sql语句
            String sql = "delete from tb_nav where id = ?";
            // 预编译sql
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            preparedStatement.setInt(1,id);
            // 执行sql
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.release(preparedStatement,connection,null);
        }
        return num;
    }

    @Override
    public NavModel getOneNave(Integer id) {
        NavModel navModel = new NavModel();
        try {
            connection = JDBC.getConnection();

            String sql = "select * from tb_nav where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                navModel.setId(resultSet.getInt("id"));
                navModel.setHref(resultSet.getString("href"));
                navModel.setTitle(resultSet.getString("title"));
                navModel.setStatus(resultSet.getInt("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.release(preparedStatement,connection,resultSet);
        }
        return navModel;
    }

    @Override
    public List<NavModel> getNavList() {
        List<NavModel> navModelList = new ArrayList<>();
        try {
//            // 获得连接
//            connection = JDBC.getConnection();
            // 编写sql语句
            String sql = "select * from tb_nav";
//            // 预编译sql
//            preparedStatement = connection.prepareStatement(sql);
//            // 执行sql
//            resultSet = preparedStatement.executeQuery();
            resultSet = JDBC.excuteQuery(sql);
            while (resultSet.next()) {
                // 对查找到的数据进行封装
                NavModel navModel = new NavModel();
                navModel.setId(resultSet.getInt("id"));
                navModel.setHref(resultSet.getString("href"));
                navModel.setTitle(resultSet.getString("title"));
                navModel.setStatus(resultSet.getInt("status"));
                navModelList.add(navModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.release(preparedStatement,connection,resultSet);
        }
        return navModelList;
    }
}
