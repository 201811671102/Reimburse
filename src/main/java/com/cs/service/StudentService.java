package com.cs.service;


import com.cs.pojo.Student;

public interface StudentService {
    /*通过sid获取学生信息*/
    Student getStudentBYsid(Integer sid);
    /*通过学号获取学生信息*/
    Student getStundetBYsNumber(String sNumber);
}
