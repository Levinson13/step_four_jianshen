package com.cn.wanxi.dao;

import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.dto.StudentFindDto;
import com.cn.wanxi.model.StudentModel;

import java.util.List;

public interface StudentDao {
    int add(StudentModel studentModel);

    int update(StudentModel studentModel);

    int delete(Integer id);

    StudentModel getOneStudentModel(Integer id);

    List<StudentModel> getStudentList();

    List<StudentModel> findStudentListByCondition(StudentFindDto condition, PageDto pageDto);

    int findAllStudentCount();

    int findStudentCount(StudentFindDto condition, PageDto pageDto);
}
