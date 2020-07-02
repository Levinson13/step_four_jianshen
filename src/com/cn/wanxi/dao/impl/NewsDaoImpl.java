package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.NewsDao;
import com.cn.wanxi.dto.NewsBackDto;
import com.cn.wanxi.dto.NewsDto;
import com.cn.wanxi.dto.NewsFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.util.JDBC;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class NewsDaoImpl implements NewsDao {
    private PreparedStatement preparedStatement = null;
    private Connection connection = null;

    private int num = 0;

    @Override
    public int add(NewsModel newsModel) {
        String sql = "insert into tb_news values(null,?,?,?,?,?)";
        try {
            connection = JDBC.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,newsModel.getNewsTitle());
            preparedStatement.setInt(2,newsModel.getNewsType());
            preparedStatement.setString(3,newsModel.getNewsImg());
            preparedStatement.setString(4,newsModel.getNewsContent());
            preparedStatement.setDate(5, new Date(new java.util.Date().getTime()));

            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int update(NewsModel newsModel) {
        String sql = "update tb_news set news_title = '" + newsModel.getNewsTitle()
                + "',news_type = " + newsModel.getNewsType()
                + ",news_content= '" + newsModel.getNewsContent()
                + "'";
        if (!"".equals(newsModel.getNewsImg()) && newsModel.getNewsImg() != null) {
            sql += ",news_img = '" + newsModel.getNewsImg() + "'";
        }
        sql += "where id = " + newsModel.getId();
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public int delete(Integer id) {
        try {
            // 编写sql语句
            String sql = "delete from tb_news where id = ?";

            connection = JDBC.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public NewsModel getOneNewsModel(Integer id) {

        String sql = "select * from tb_news where id=" + id;
        ResultSet resultSet = JDBC.excuteQuery(sql);
        NewsModel newsModel = new NewsModel();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            while (resultSet.next()) {
                newsModel.setId(id);
                newsModel.setNewsTitle(resultSet.getString("news_title"));
                newsModel.setNewsType(resultSet.getInt("news_type"));
                newsModel.setNewsImg(resultSet.getString("news_img"));
                newsModel.setNewsContent(resultSet.getString("news_content"));
                newsModel.setCreateDate(resultSet.getString("create_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsModel;
    }

    @Override
    public List<NewsBackDto> getNewsList() {
        String sql = "select tn.*,tnt.type from tb_news tn ,tb_news_type tnt where tn.news_type = tnt.id";
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<NewsBackDto> newsBackDtoList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    NewsBackDto newsBackDto = new NewsBackDto();
                    NewsModel newsModel = new NewsModel();
                    newsModel.setNewsTitle(resultSet.getString("news_title"));
                    newsModel.setNewsType(resultSet.getInt("news_type"));
                    newsModel.setNewsImg(resultSet.getString("news_img"));
                    newsModel.setNewsContent(resultSet.getString("news_content"));
                    newsModel.setCreateDate(resultSet.getString("create_time"));
                    newsModel.setId(resultSet.getInt("id"));
                    newsBackDto.setNewsModel(newsModel);
                    newsBackDto.setType(resultSet.getString("type"));
                    newsBackDtoList.add(newsBackDto);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return newsBackDtoList;
    }

    @Override
    public List<NewsBackDto> findNewsListByCondition(NewsFindDto condition, PageDto pageDto) {
        String sql = "select tn.*,tnt.type from tb_news tn ,tb_news_type tnt where tn.news_type = tnt.id";
        if (condition.getTitle() != null && !"".equals(condition.getTitle())) {
            sql += " and news_title like '%" + condition.getTitle() + "%'";
        }
        if (condition.getType() != null && !"".equals(condition.getType())) {
            sql += " and news_type like '%" + condition.getType() + "%'";
        }
        sql += " limit " + (pageDto.getPageNum() - 1) * pageDto.getPageSize() + "," + pageDto.getPageSize();
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<NewsBackDto> newsBackDtoList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                NewsBackDto newsBackDto = new NewsBackDto();
                NewsModel newsModel = new NewsModel();
                newsModel.setNewsTitle(resultSet.getString("news_title"));
                newsModel.setNewsType(resultSet.getInt("news_type"));
                newsModel.setNewsImg(resultSet.getString("news_img"));
                newsModel.setNewsContent(resultSet.getString("news_content"));
                newsModel.setCreateDate(resultSet.getString("create_time"));
                newsModel.setId(resultSet.getInt("id"));
                newsBackDto.setNewsModel(newsModel);
                newsBackDto.setType(resultSet.getString("type"));
                newsBackDtoList.add(newsBackDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsBackDtoList;
    }

    @Override
    public int findAllNewsCount() {
        String sql = "select count(id) as count from tb_news";
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
    public List<NewsModel> getAllNews() {
        String sql = "select * from tb_news";
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<NewsModel> newsModelList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                NewsModel newsModel = new NewsModel();
                newsModel.setNewsTitle(resultSet.getString("news_title"));
                newsModel.setNewsContent(resultSet.getString("news_content"));
                newsModel.setNewsImg(resultSet.getString("news_img"));
                newsModel.setNewsType(resultSet.getInt("news_type"));
                newsModel.setCreateDate(resultSet.getString("create_time"));
                newsModel.setId(resultSet.getInt("id"));
                newsModelList.add(newsModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsModelList;
    }

}
