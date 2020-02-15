package com.cs.service.impl;

import com.cs.mapper.WorkerMapper;
import com.cs.pojo.Worker;
import com.cs.pojo.WorkerExample;
import com.cs.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerMapper workerMapper;
    @Override
    public int addWorker(Worker worker) {
        return workerMapper.insertSelective(worker);
    }

    @Override
    public Worker getWorkerBywName(String wName) {
        WorkerExample workerExample = new WorkerExample();
        workerExample.createCriteria().andWnameEqualTo(wName);
        List<Worker> workers = workerMapper.selectByExample(workerExample);
        if (workers.size() != 1){
            return null;
        }
        return workers.get(0);
    }

    @Override
    public Worker getWorkerBywId(Integer wid) {
        return workerMapper.selectByPrimaryKey(wid);
    }
}
