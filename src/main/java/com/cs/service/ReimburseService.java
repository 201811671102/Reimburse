package com.cs.service;


import com.cs.pojo.Reimburse;

public interface ReimburseService {
    /*通过rid获取报销记录*/
    Reimburse getReimburseBYrid(Integer rid);
}
