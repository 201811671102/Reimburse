package com.cs.service.impl;

import com.cs.mapper.StudentMapper;
import com.cs.pojo.Student;
import com.cs.pojo.StudentExample;
import com.cs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentBYsid(Integer sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }

    @Override
    public Student getStundetBYsNumber(String sNumber) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andSnumberEqualTo(sNumber);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size() == 1){
            return students.get(0);
        }else{
            return null;
        }
    }

}
