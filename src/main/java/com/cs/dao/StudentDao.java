package com.cs.dao;

import com.cs.pojo.Reimburse;
import com.cs.pojo.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDao extends Student {
    public StudentDao(Student student){
       this.setSid(student.getSid());
       this.setSname(student.getSname());
       this.setSacademy(student.getSacademy());
       this.setSclass(student.getSclass());
       this.setSnumber(student.getSnumber());
       this.setSidfront(student.getSidfront());
       this.setSidreverse(student.getSidreverse());
    }
    private Reimburse studentReimburse;
    private List<Reimburse> studentReimburseList;
    private double reimbursemoney;
}
