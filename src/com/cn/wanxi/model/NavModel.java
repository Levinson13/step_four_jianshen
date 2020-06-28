package com.cn.wanxi.model;

public class NavModel {
    private Integer id;

    private String href;

    private String title;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "NavModel{" +
                "id=" + id +
                ", href='" + href + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
