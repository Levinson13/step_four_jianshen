package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.CoachPostDao;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.model.CoachPostModel;
import com.cn.wanxi.util.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoachPostDaoImpl implements CoachPostDao {
    @Override
    public List<CoachPostModel> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CoachPostModel> coachPostModelList = new ArrayList<>();
        try {
            connection = JDBC.getConnection();

            String sql = "select * from tb_coach_post";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CoachPostModel coachPostModel = new CoachPostModel();
                coachPostModel.setId(resultSet.getInt("id"));
                coachPostModel.setPost(resultSet.getString("post"));
                coachPostModel.setStatus(resultSet.getInt("status"));
                coachPostModelList.add(coachPostModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.release(preparedStatement,connection,resultSet);
        }
        return coachPostModelList;
    }
}
