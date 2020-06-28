package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.dao.impl.NavDaoImpl;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.service.INavService;

import java.util.List;

public class NavServletImpl implements INavService {

    private NavDao navDao = new NavDaoImpl();

    @Override
    public int add(NavModel navModel) {
        return navDao.add(navModel);
    }

    @Override
    public int update(NavModel navModel) {
        return navDao.update(navModel);
    }

    @Override
    public int delete(Integer id) {
        return navDao.delete(id);
    }

    @Override
    public NavModel getOneNavModel(Integer id) {
        return navDao.getOneNave(id);
    }

    @Override
    public List<NavModel> getNavList() {
        return navDao.getNavList();
    }
}
