package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.StudentDao;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.dto.StudentFindDto;
import com.cn.wanxi.model.StudentModel;
import com.cn.wanxi.util.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private Connection connection = null;

    private PreparedStatement preparedStatement = null;

    private ResultSet resultSet = null;

    @Override
    public int add(StudentModel studentModel) {
        String sql = "insert into tb_stu values(null,'" + studentModel.getStuName() +
                "','" + studentModel.getStuPhone() +
                "','" + studentModel.getStuEmail() +
                "','" + studentModel.getStuContent() +
                "','" + studentModel.getStuImg() +
                "','" + studentModel.getStuSex() +
                "','" + studentModel.getStuAge() +
                "','" + studentModel.getCreateDate() +
                "','" + studentModel.getStuPassword() +
                "')";
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public int update(StudentModel studentModel) {
        String sql = "update tb_stu set stu_name='" + studentModel.getStuName() +
                "',stu_phone='" + studentModel.getStuPhone() +
                "',stu_email='" + studentModel.getStuEmail() +
                "',stu_content='" + studentModel.getStuContent() +
                "',stu_sex=" + studentModel.getStuSex() +
                ",stu_age=" + studentModel.getStuAge() +
                ",stu_password='" + studentModel.getStuPassword() +
                "'";
        if (studentModel.getStuImg() != null && !"".equals(studentModel.getStuImg())) {
            sql += ",stu_img = '" + studentModel.getStuImg() + "'";
        }
        sql += " where id = " + studentModel.getId();
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from tb_stu where id = " + id;
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public StudentModel getOneStudentModel(Integer id) {
        String sql = "select * from tb_stu where id=" + id;
        StudentModel studentModel = new StudentModel();
        resultSet = JDBC.excuteQuery(sql);
        try {
            while (resultSet.next()) {
                studentModel.setId(resultSet.getInt("id"));
                studentModel.setStuName(resultSet.getString("stu_name"));
                studentModel.setStuPhone(resultSet.getString("stu_phone"));
                studentModel.setStuEmail(resultSet.getString("stu_email"));
                studentModel.setStuContent(resultSet.getString("stu_content"));
                studentModel.setStuImg(resultSet.getString("stu_img"));
                studentModel.setStuSex(resultSet.getInt("stu_sex"));
                studentModel.setStuAge(resultSet.getInt("stu_age"));
                studentModel.setCreateDate(resultSet.getString("create_time"));
                studentModel.setStuPassword(resultSet.getString("stu_password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentModel;
    }

    @Override
    public List<StudentModel> getStudentList() {
        List<StudentModel> studentModelList = new ArrayList<>();
        String sql = "select * from tb_stu";
        resultSet = JDBC.excuteQuery(sql);
        try {
            while (resultSet.next()) {
                StudentModel studentModel = new StudentModel();
                studentModel.setId(resultSet.getInt("id"));
                studentModel.setStuName(resultSet.getString("stu_name"));
                studentModel.setStuPhone(resultSet.getString("stu_phone"));
                studentModel.setStuEmail(resultSet.getString("stu_email"));
                studentModel.setStuContent(resultSet.getString("stu_content"));
                studentModel.setStuImg(resultSet.getString("stu_img"));
                studentModel.setStuSex(resultSet.getInt("stu_sex"));
                studentModel.setStuAge(resultSet.getInt("stu_age"));
                studentModel.setCreateDate(resultSet.getString("create_time"));
                studentModel.setStuPassword(resultSet.getString("stu_password"));
                studentModelList.add(studentModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentModelList;
    }

    @Override
    public List<StudentModel> findStudentListByCondition(StudentFindDto condition, PageDto pageDto) {
        List<StudentModel> studentModelList = new ArrayList<>();
        String sql = "select * from tb_stu where 1=1 ";
        if (!"".equals(condition.getUsername()) && condition.getUsername() != null) {
            sql += " and stu_name like '%" + condition.getUsername() + "%'";
        }
        if (!"".equals(condition.getPassword()) && condition.getPassword() != null) {
            sql += " and stu_password like '%" + condition.getPassword() + "%'";
        }
        if (!"".equals(condition.getSex()) && condition.getSex() != null) {
            if (condition.getSex() != 0) {
                sql += " and stu_sex =" + condition.getSex() ;
            }
        }
        if ((!"".equals(condition.getStartAge()) && condition.getStartAge() != null) || (!"".equals(condition.getEndAge()) && condition.getEndAge() != null)) {
            sql += " and stu_age between " + condition.getStartAge() + " and " + condition.getEndAge();
        }

        sql += " limit " + (pageDto.getPageNum() - 1) * pageDto.getPageSize() + "," + pageDto.getPageSize();
        System.out.println("sql:" + sql);
        resultSet = JDBC.excuteQuery(sql);
        try {
            while (resultSet.next()) {
                StudentModel studentModel = new StudentModel();
                studentModel.setId(resultSet.getInt("id"));
                studentModel.setStuName(resultSet.getString("stu_name"));
                studentModel.setStuPhone(resultSet.getString("stu_phone"));
                studentModel.setStuEmail(resultSet.getString("stu_email"));
                studentModel.setStuContent(resultSet.getString("stu_content"));
                studentModel.setStuImg(resultSet.getString("stu_img"));
                studentModel.setStuSex(resultSet.getInt("stu_sex"));
                studentModel.setStuAge(resultSet.getInt("stu_age"));
                studentModel.setCreateDate(resultSet.getString("create_time"));
                studentModel.setStuPassword(resultSet.getString("stu_password"));
                studentModelList.add(studentModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentModelList;
    }

    @Override
    public int findAllStudentCount() {
        String sql = "select count(id) as count from tb_stu";
        int count = 0;
        resultSet = JDBC.excuteQuery(sql);
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
    public int findStudentCount(StudentFindDto condition, PageDto pageDto) {
        String sql = "select count(id) as count from tb_stu where 1=1 ";
        if (!"".equals(condition.getUsername()) && condition.getUsername() != null) {
            sql += " and stu_name like '%" + condition.getUsername() + "%'";
        }
        if (!"".equals(condition.getPassword()) && condition.getPassword() != null) {
            sql += " and stu_password like '%" + condition.getPassword() + "%'";
        }
        if (!"".equals(condition.getSex()) && condition.getSex() != null) {
            if (condition.getSex() != 0) {
                sql += " and stu_sex =" + condition.getSex() ;
            }
        }
        if ((!"".equals(condition.getStartAge()) && condition.getStartAge() != null) || (!"".equals(condition.getEndAge()) && condition.getEndAge() != null)) {
            sql += " and stu_age between " + condition.getStartAge() + " and " + condition.getEndAge();
        }

        sql += " limit " + (pageDto.getPageNum() - 1) * pageDto.getPageSize() + "," + pageDto.getPageSize();
        System.out.println("countSql:" + sql);
        int count = 0;
        resultSet = JDBC.excuteQuery(sql);
        try {
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("count:" + count);
        return count;
    }

}
