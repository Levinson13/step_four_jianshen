package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.AboutDao;
import com.cn.wanxi.dto.AboutFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.model.AboutModel;
import com.cn.wanxi.util.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AboutDaoImpl implements AboutDao {

    private Connection connection = null;

    private PreparedStatement preparedStatement = null;

    private ResultSet resultSet = null;

    @Override
    public int add(AboutModel aboutModel) {
        String sql = "insert into tb_about values(null,'" + aboutModel.getContent() +
                "','" + aboutModel.getImg() +
                "','null','" + aboutModel.getCreateTime()+"')";
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public int update(AboutModel aboutModel) {
        String sql = "update tb_about set about_content='" + aboutModel.getContent() +
                "',about_img='" + aboutModel.getImg() + "'";
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from tb_about where id=" + id;
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public AboutModel getOneAboutModel(Integer id) {
        String sql = "select * from tb_about where id=" + id;
        resultSet = JDBC.excuteQuery(sql);
        AboutModel aboutModel = new AboutModel();
        try {
            while (resultSet.next()) {
                aboutModel.setId(resultSet.getInt("id"));
                aboutModel.setContent(resultSet.getString("about_content"));
                aboutModel.setImg(resultSet.getString("about_img"));
                aboutModel.setCreateTime(resultSet.getString("create_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aboutModel;
    }

    @Override
    public List<AboutModel> getAboutList() {
        String sql = "select * from tb_about";
        resultSet = JDBC.excuteQuery(sql);
        List<AboutModel> aboutModelList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                AboutModel aboutModel = new AboutModel();
                aboutModel.setId(resultSet.getInt("id"));
                aboutModel.setContent(resultSet.getString("about_content"));
                aboutModel.setImg(resultSet.getString("about_img"));
                aboutModel.setCreateTime(resultSet.getString("create_time"));
                aboutModelList.add(aboutModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aboutModelList;
    }

    @Override
    public List<AboutModel> findAboutListByCondition(AboutFindDto condition, PageDto pageDto) {
        String sql = "select * from tb_coach where 1=1 ";
        if (condition.getContent() != null && !"".equals(condition.getContent())) {
            sql += "and coach_name like '%" + condition.getContent() + "%' ";
        }
        sql += " limit " + (pageDto.getPageNum() - 1) * pageDto.getPageSize() + "," + pageDto.getPageSize();
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<AboutModel> aboutModelList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                AboutModel aboutModel = new AboutModel();
                aboutModel.setContent(resultSet.getString("about_content"));
                aboutModel.setImg(resultSet.getString("about_img"));
                aboutModel.setId(resultSet.getInt("id"));
                aboutModel.setCreateTime(resultSet.getString("create_time"));
                aboutModelList.add(aboutModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aboutModelList;
    }

    @Override
    public int findAllAboutCount() {
        String sql = "select count(id) as count from tb_about";
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
