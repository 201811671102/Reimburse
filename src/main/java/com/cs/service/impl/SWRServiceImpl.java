package com.cs.service.impl;

import com.cs.mapper.SWRMapper;
import com.cs.pojo.SWR;
import com.cs.pojo.SWRExample;
import com.cs.service.SWRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SWRServiceImpl implements SWRService {
    @Autowired
    private SWRMapper swrMapper;
    @Override
    public List<SWR> getNotReimburse() {
        SWRExample swrExample = new SWRExample();
        swrExample.createCriteria().andReimbursemoneyEqualTo(0.0);
        return swrMapper.selectByExample(swrExample);
    }

    @Override
    public List<SWR> getAlreadyReimburse() {
        SWRExample swrExample = new SWRExample();
        swrExample.createCriteria().andReimbursemoneyNotEqualTo(0.0);
        return swrMapper.selectByExample(swrExample);
    }

    @Override
    public List<SWR> getFailedReimburse() {
        SWRExample swrExample = new SWRExample();
        swrExample.createCriteria().andReimbursemoneyEqualTo(-1.0);
        return swrMapper.selectByExample(swrExample);
    }

    @Override
    public int changeSchedule(Integer sid,double ReimburseMoney) {
        SWR swr = new SWR();
        swr.setReimbursemoney(ReimburseMoney);
        SWRExample swrExample = new SWRExample();
        swrExample.createCriteria().andSidEqualTo(sid);
        return swrMapper.updateByExampleSelective(swr,swrExample);
    }

    @Override
    public List<SWR> getSWRBYsid(Integer sid) {
        SWRExample swrExample = new SWRExample();
        swrExample.createCriteria().andSidEqualTo(sid);
        return swrMapper.selectByExample(swrExample);
    }

    @Override
    public List<SWR> getSWRBYwid(Integer wid) {
        SWRExample swrExample = new SWRExample();
        swrExample.createCriteria().andWidEqualTo(wid);
        return swrMapper.selectByExample(swrExample);
    }
}
