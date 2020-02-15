package com.cs.service;

import com.cs.pojo.SWR;

import java.util.List;

public interface SWRService {
    /*查询没有报销*/
    List<SWR> getNotReimburse();
    /*查询已经报销*/
    List<SWR> getAlreadyReimburse();
    /*查询报销失败*/
    List<SWR> getFailedReimburse();
    /*根据学生学号，修改报销状态*/
    int changeSchedule(Integer sid,double ReimburseMoney);
    /*根据学生id查询其报销记录*/
    List<SWR> getSWRBYsid(Integer sid);
    /*根据职工id查询报销记录*/
    List<SWR> getSWRBYwid(Integer wid);
}
