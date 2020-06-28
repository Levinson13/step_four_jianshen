package com.cn.wanxi.model;

public class CoachPostModel {

    private Integer id;

    private String post;

    private Integer status;

    private String posts[] = {"一级健身员","二级健身员","格斗教练","金牌健身教练","银牌健身教练","铜牌健身教练"};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String[] getPosts() {
        return posts;
    }

    public void setPosts(String[] posts) {
        this.posts = posts;
    }
}
