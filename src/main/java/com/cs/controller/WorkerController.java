package com.cs.controller;

import com.cs.base.ResultUtil;
import com.cs.base.dto.ResultDTO;
import com.cs.base.path.Path;
import com.cs.dao.WorkerDao;
import com.cs.pojo.Reimburse;
import com.cs.pojo.SWR;
import com.cs.pojo.User;
import com.cs.pojo.Worker;
import com.cs.service.ReimburseService;
import com.cs.service.SWRService;
import com.cs.service.UserService;
import com.cs.service.WorkerService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@Api(value = "职工持久层",tags = {"添加职工","查询职工信息"})
public class WorkerController {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private UserService userServices;
    @Autowired
    private SWRService swrService;
    @Autowired
    private ReimburseService reimburseService;

    @ResponseBody
    @PostMapping("/addWorkerController")
    @ApiOperation(
            value = "添加职工",
            notes = "需要职工姓名，职务，身份证正反面"
    )
    public ResultDTO addWorkerController(
            @ApiParam(value = "职工姓名",required = true)
            @RequestParam(value = "wName",required=true) String wName,
            @ApiParam(value = "职工职务",required = true)
            @RequestParam(value = "wDuty",required=true)String wDuty,
            @ApiParam(value = "职工身份证正面",required = true)
            @RequestParam(value = "wIDFront",required=true)MultipartFile wIDFront,
            @ApiParam(value = "职工身份证反面",required = true)
            @RequestParam(value = "wIDReverse",required=true)MultipartFile wIDReverse){
        Worker worker = new Worker();
        worker.setWname(wName);
        worker.setWduty(wDuty);
        worker.setWidfront(wName+wDuty+Path.getFileType(wIDFront));
        worker.setWidreverse(wName+wDuty+Path.getFileType(wIDReverse));
        try {
            wIDFront.transferTo(new File(Path.WORKERIDFRONT+wName+wDuty+Path.getFileType(wIDFront)));
            wIDReverse.transferTo(new File(Path.WORKERIDREVERSE+wName+wDuty+Path.getFileType(wIDReverse)));
            workerService.addWorker(worker);
            //修改type
            User user = new User();
            user.setType(3);
            userServices.updateUser(wName,user);
        } catch (IOException e) {
            log.debug(e.toString());
            return ResultUtil.Error("400","身份证存入失败");
        }
        return new ResultUtil().Success();
    }

    @PostMapping("/getWorkerInfoController")
    @ResponseBody
    @ApiOperation(value = "获取职工信息",notes = "包括 个人信息，报销记录")
    @ApiImplicitParam(
            paramType = "query",
            dataType = "int",
            required = true,
            name = "wid",
            value = "职工id"
    )
    public ResultDTO getWorkerInfoController(Integer wid){
        WorkerDao workerDao = new WorkerDao(workerService.getWorkerBywId(wid));
        if (workerDao != null){
            List<SWR> swrList = swrService.getSWRBYwid(wid);
            List<Reimburse> reimburses = new ArrayList<>();
            for (SWR swr : swrList){
                reimburses.add(reimburseService.getReimburseBYrid(swr.getRid()));
            }
            workerDao.setReimburseList(reimburses);
            return new ResultUtil().Success(workerDao);
        }
        return new ResultUtil().Error("400","没有查询到wid为"+wid+"的职工");
    }
}
