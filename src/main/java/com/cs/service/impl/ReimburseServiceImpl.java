package com.cs.service.impl;

import com.cs.mapper.ReimburseMapper;
import com.cs.pojo.Reimburse;
import com.cs.service.ReimburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReimburseServiceImpl implements ReimburseService {
    @Autowired
    private ReimburseMapper reimburseMapper;
    @Override
    public Reimburse getReimburseBYrid(Integer rid) {
        return reimburseMapper.selectByPrimaryKey(rid);
    }
}
