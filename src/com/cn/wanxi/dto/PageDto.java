package com.cn.wanxi.dto;

public class PageDto {

    private Integer pageNum;    // 当前页

    private Integer pageSize;   // 每页几条

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
