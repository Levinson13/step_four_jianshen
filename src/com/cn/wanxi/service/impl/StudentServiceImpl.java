package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.StudentDao;
import com.cn.wanxi.dao.impl.StudentDaoImpl;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.dto.StudentFindDto;
import com.cn.wanxi.model.StudentModel;
import com.cn.wanxi.service.IStudentService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentServiceImpl implements IStudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public int add(StudentModel studentModel) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        studentModel.setCreateDate(simpleDateFormat.format(new Date()));
        return studentDao.add(studentModel);
    }

    @Override
    public int update(StudentModel studentModel) {
        return studentDao.update(studentModel);
    }

    @Override
    public int delete(Integer id) {
        return studentDao.delete(id);
    }

    @Override
    public StudentModel getOneStudentModel(Integer id) {
        return studentDao.getOneStudentModel(id);
    }

    @Override
    public ResultDto getStudentList() {
        ResultDto resultDto = new ResultDto();
        resultDto.setObject(studentDao.getStudentList());
        resultDto.setCount(studentDao.findAllStudentCount());
        return resultDto;
    }

    @Override
    public ResultDto findStudentListByCondition(StudentFindDto condition, PageDto pageDto) {
        ResultDto resultDto = new ResultDto();
        Integer startAge = condition.getStartAge();
        Integer endAge = condition.getEndAge();
        if (startAge > endAge) {
            Integer temp = 0;
            temp = startAge;
            startAge = endAge;
            endAge = temp;
            condition.setStartAge(startAge);
            condition.setEndAge(endAge);
        }
        resultDto.setObject(studentDao.findStudentListByCondition(condition,pageDto));
        resultDto.setCount(studentDao.findAllStudentCount());
//        resultDto.setCount(studentDao.findStudentCount(condition,pageDto));
        return resultDto;
    }

}
