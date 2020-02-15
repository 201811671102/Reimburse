package com.cs.service;


import com.cs.pojo.Worker;

public interface WorkerService {
    /*添加职工*/
    int addWorker(Worker worker);
    /*根据名字查找职工*/
    Worker getWorkerBywName(String wName);
    /*根据职工id获取职工信息*/
    Worker getWorkerBywId(Integer wid);
}
