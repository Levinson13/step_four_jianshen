package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.CoachDao;
import com.cn.wanxi.dto.CoachFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.util.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoachDaoImpl implements CoachDao {
    @Override
    public int add(CoachModel coachModel) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int num = 0;
        try {
            connection = JDBC.getConnection();

            String sql = "insert into tb_coach values (null ,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,coachModel.getCoachName());
            preparedStatement.setInt(2,coachModel.getCoachPost());
            preparedStatement.setString(3,coachModel.getCoachImg());
            preparedStatement.setDate(4, new java.sql.Date(new java.util.Date().getTime()));

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
    public int update(CoachModel coachModel) {
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       int num = 0;
        try {
            connection = JDBC.getConnection();

            String sql = "update tb_coach set coach_name=?,coach_post=?,coach_img=? where id=?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,coachModel.getCoachName());
            preparedStatement.setInt(2,coachModel.getCoachPost());
            preparedStatement.setString(3,coachModel.getCoachImg());
            preparedStatement.setInt(4,coachModel.getId());

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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int num = 0;
        try {
            connection = JDBC.getConnection();

            String sql = "delete from tb_coach where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

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
    public CoachModel getOneCoachModel(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CoachModel coachModel = new CoachModel();
        try {
            connection = JDBC.getConnection();

            String sql = "select * from tb_coach where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                coachModel.setId(resultSet.getInt("id"));
                coachModel.setCoachName(resultSet.getString("coach_name"));
                coachModel.setCoachPost(resultSet.getInt("coach_post"));
                coachModel.setCoachImg(resultSet.getString("coach_img"));
                coachModel.setCreateDate(resultSet.getString("create_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.release(preparedStatement,connection,resultSet);
        }
        return coachModel;
    }

    @Override
    public List<CoachModel> getCoachList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CoachModel> coachModelList = new ArrayList<>();
        try {
            connection = JDBC.getConnection();

            String sql = "select * from tb_coach";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CoachModel coachModel = new CoachModel();
                coachModel.setId(resultSet.getInt("id"));
                coachModel.setCoachName(resultSet.getString("coach_name"));
                coachModel.setCoachPost(resultSet.getInt("coach_post"));
                coachModel.setCoachImg(resultSet.getString("coach_img"));
//                java.util.Date date = resultSet.getDate("create_time");
                coachModel.setCreateDate(resultSet.getString("create_time"));
                coachModelList.add(coachModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.release(preparedStatement,connection,resultSet);
        }
        return coachModelList;
    }

    @Override
    public List<CoachModel> findCoachListByCondition(CoachFindDto condition, PageDto pageDto) {
        String sql = "select * from tb_coach where 1=1 ";
        if (condition.getCoachName() != null && !"".equals(condition.getCoachName())) {
            sql += "and coach_name like '%" + condition.getCoachName() + "%' ";
        }
        if (condition.getPost() != null && !"".equals(condition.getPost())) {
            sql += "and coach_post like '%" + condition.getPost() + "%'";
        }
        sql += " limit " + (pageDto.getPageNum() - 1) * pageDto.getPageSize() + "," + pageDto.getPageSize();
        System.out.println("sql:" + sql);
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<CoachModel> coachModelList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                CoachModel coachModel = new CoachModel();
                coachModel.setId(resultSet.getInt("id"));
                coachModel.setCoachName(resultSet.getString("coach_name"));
                coachModel.setCoachImg(resultSet.getString("coach_img"));
                coachModel.setCoachPost(resultSet.getInt("coach_post"));
                coachModel.setCreateDate(resultSet.getString("create_time"));
                coachModelList.add(coachModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coachModelList;
    }

    @Override
    public int findAllCoachCount() {
        String sql = "select count(id) as count from tb_coach";
        int count = 0;
        ResultSet resultSet = JDBC.excuteQuery(sql);
        try {
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("count:"+count);
        return count;
    }
}
