package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.NewsTypeDao;
import com.cn.wanxi.model.NewsTypeModel;
import com.cn.wanxi.util.JDBC;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewsTypeDaoImpl implements NewsTypeDao {

    @Override
    public int add(NewsTypeModel newsTypeModel) {
        String sql = "insert into tb_news_type values(null,'"+ newsTypeModel.getType() +

                "'," + newsTypeModel.getStatus() +

                ",'" + newsTypeModel.getCreateTime()+"')";
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public List<NewsTypeModel> findAll() {
        String sql = "select * from tb_news_type";
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<NewsTypeModel> newsTypeModelList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                NewsTypeModel newsTypeModel = new NewsTypeModel();
                newsTypeModel.setId(resultSet.getInt("id"));
                newsTypeModel.setType(resultSet.getString("type"));
                newsTypeModel.setStatus(resultSet.getInt("status"));
                newsTypeModel.setCreateTime(resultSet.getString("create_time"));
                newsTypeModelList.add(newsTypeModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsTypeModelList;
    }
}
