package com.cn.wanxi.dto;

import com.cn.wanxi.model.StudentModel;

import java.util.List;

public class ResultDto {

    private Object object;

    private Integer count;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "object=" + object +
                ", count=" + count +
                '}';
    }
}
