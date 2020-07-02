package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.CallUsDao;
import com.cn.wanxi.model.CallUsModel;
import com.cn.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CallUsDaoImpl implements CallUsDao {
    @Override
    public int add(CallUsModel callUsModel) {
        String sql = "insert into tb_call_us values('null','"+ callUsModel.getImg() +"','" + callUsModel.getContent() + "')";
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public List<CallUsModel> getCallUsList() {
        String sql = "select * from tb_call_us";
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<CallUsModel> callUsModelList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                CallUsModel callUsModel = new CallUsModel();
                callUsModel.setId(resultSet.getInt("id"));
                callUsModel.setContent(resultSet.getString("call_us_content"));
                callUsModel.setImg(resultSet.getString("call_us_img"));
                callUsModelList.add(callUsModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callUsModelList;
    }
}
