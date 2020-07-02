package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.CoachDao;
import com.cn.wanxi.dto.CoachBackDto;
import com.cn.wanxi.dto.CoachDto;
import com.cn.wanxi.dto.CoachFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.model.CoachPostModel;
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
        String sql = "update tb_coach set coach_name='" + coachModel.getCoachName()
                + "',coach_post=" + coachModel.getCoachPost();
        if (coachModel.getCoachImg() != null && !"".equals(coachModel.getCoachImg())) {
            sql += ",coach_img='" + coachModel.getCoachImg() + "'";
        }
        sql += " where id = " + coachModel.getId();
        return JDBC.excuteUpdate(sql);
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
    public List<CoachBackDto> getCoachList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CoachBackDto> coachBackDtoList = new ArrayList<>();
        try {
            connection = JDBC.getConnection();

            String sql = "select tc.*,tcp.post from tb_coach tc ,tb_coach_post tcp where tc.coach_post = tcp.id";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CoachBackDto coachBackDto = new CoachBackDto();
                CoachModel coachModel = new CoachModel();
                coachModel.setId(resultSet.getInt("id"));
                coachModel.setCoachName(resultSet.getString("coach_name"));
                coachModel.setCoachPost(resultSet.getInt("coach_post"));
                coachModel.setCoachImg(resultSet.getString("coach_img"));
//                java.util.Date date = resultSet.getDate("create_time");
                coachModel.setCreateDate(resultSet.getString("create_time"));
                coachBackDto.setCoachModel(coachModel);
                coachBackDto.setPost(resultSet.getString("post"));
                coachBackDtoList.add(coachBackDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.release(preparedStatement,connection,resultSet);
        }
        return coachBackDtoList;
    }

    @Override
    public List<CoachBackDto> findCoachListByCondition(CoachFindDto condition, PageDto pageDto) {
        String sql = "select tc.*,tcp.post from tb_coach tc ,tb_coach_post tcp where tc.coach_post = tcp.id ";
        if (condition.getCoachName() != null && !"".equals(condition.getCoachName())) {
            sql += "and coach_name like '%" + condition.getCoachName() + "%' ";
        }
        if (condition.getPost() != null && !"".equals(condition.getPost())) {
            sql += "and coach_post like '%" + condition.getPost() + "%'";
        }
        sql += " limit " + (pageDto.getPageNum() - 1) * pageDto.getPageSize() + "," + pageDto.getPageSize();
        System.out.println("sql:" + sql);
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<CoachBackDto> coachBackDtoList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                CoachBackDto coachBackDto = new CoachBackDto();
                CoachModel coachModel = new CoachModel();
                coachModel.setId(resultSet.getInt("id"));
                coachModel.setCoachName(resultSet.getString("coach_name"));
                coachModel.setCoachPost(resultSet.getInt("coach_post"));
                coachModel.setCoachImg(resultSet.getString("coach_img"));
//                java.util.Date date = resultSet.getDate("create_time");
                coachModel.setCreateDate(resultSet.getString("create_time"));
                coachBackDto.setCoachModel(coachModel);
                coachBackDto.setPost(resultSet.getString("post"));
                coachBackDtoList.add(coachBackDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coachBackDtoList;
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

    @Override
    public List<CoachModel> getAllCoach() {
        String sql = "select * from tb_coach";
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<CoachModel> coachModelList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                CoachModel coachModel = new CoachModel();
                coachModel.setCoachName(resultSet.getString("coach_name"));
                coachModel.setCoachImg(resultSet.getString("coach_img"));
                coachModel.setCoachPost(resultSet.getInt("coach_post"));
                coachModelList.add(coachModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coachModelList;
    }
}
