package com.cn.wanxi.util;

import com.cn.wanxi.model.StudentModel;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class SetStudentData {

    public static List<StudentModel> setDataFromRedis(Jedis jedis, long length){
        List<String> studentId = jedis.lrange("studentId", 0, length);
        List<String> studentName = jedis.lrange("studentName", 0, length);
        List<String> studentPassword = jedis.lrange("studentPassword", 0, length);
        List<String> studentContent = jedis.lrange("studentContent", 0, length);
        List<String> studentEmail = jedis.lrange("studentEmail", 0, length);
        List<String> studentAge = jedis.lrange("studentAge", 0, length);
        List<String> studentPhone = jedis.lrange("studentPhone", 0, length);
        List<String> studentSex = jedis.lrange("studentSex", 0, length);
        List<String> studentCreateTime = jedis.lrange("studentCreateTime",0,length);
        List<String> studentImg = jedis.lrange("studentImg", 0, length);
        List<StudentModel> studentModelList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            StudentModel studentModel = new StudentModel();
            studentModel.setId(Integer.parseInt(studentId.get(i)));
            studentModel.setStuName(studentName.get(i));
            studentModel.setStuPassword(studentPassword.get(i));
            studentModel.setStuContent(studentContent.get(i));
            studentModel.setStuEmail(studentEmail.get(i));
            studentModel.setStuAge(Integer.parseInt(studentAge.get(i)));
            studentModel.setStuPhone(studentPhone.get(i));
            studentModel.setStuSex(Integer.parseInt(studentAge.get(i)));
            studentModel.setCreateDate(studentCreateTime.get(i));
            studentModel.setStuImg(studentImg.get(i));
            studentModelList.add(studentModel);
        }
        return studentModelList;
    }

    public static List<StudentModel> setDataFromDataBase(List<StudentModel> studentModelList,Jedis jedis){
        for (int i = 0; i < studentModelList.size(); i++) {
            jedis.rpush("studentId", studentModelList.get(i).getId().toString());
            jedis.rpush("studentName", studentModelList.get(i).getStuName());
            jedis.rpush("studentPassword", studentModelList.get(i).getStuPassword());
            jedis.rpush("studentContent", studentModelList.get(i).getStuPassword());
            jedis.rpush("studentEmail",studentModelList.get(i).getStuEmail());
            jedis.rpush("studentAge", studentModelList.get(i).getStuAge().toString());
            jedis.rpush("studentPhone", studentModelList.get(i).getStuPhone());
            jedis.rpush("studentSex", studentModelList.get(i).getStuSex().toString());
            jedis.rpush("studentCreateTime", studentModelList.get(i).getCreateDate());
            jedis.rpush("studentImg", studentModelList.get(i).getStuImg());
        }
        return studentModelList;
    }
}
