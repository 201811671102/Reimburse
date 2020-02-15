package com.cs.controller;

import com.cs.base.ResultUtil;
import com.cs.base.dto.ResultDTO;
import com.cs.dao.StudentDao;
import com.cs.pojo.Reimburse;
import com.cs.pojo.SWR;
import com.cs.service.ReimburseService;
import com.cs.service.SWRService;
import com.cs.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@Api(value = "学生持久层",tags = {"查找个人信息及报销记录"})
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ReimburseService reimburseService;
    @Autowired
    private SWRService swrService;

    @ResponseBody
    @PostMapping("/getStudnetInfoController")
    @ApiOperation(value = "查找学生资料",notes = "包括学生资料，及报销记录,reimbursemoney为-1.0表示报销失败 0.0 待审批")
    @ApiImplicitParam(
            paramType = "query",
            value = "学生学号",
            name = "sNumber",
            dataType = "varchar",
            required = true
    )
    public ResultDTO getStudnetInfoController(Integer sid){
        try{
            StudentDao studentDao = new StudentDao(studentService.getStudentBYsid(sid));
            List<SWR> swrs = swrService.getSWRBYsid(studentDao.getSid());
            List<Reimburse> reimburses = new ArrayList<>();
            for (SWR swr : swrs){
                reimburses.add(reimburseService.getReimburseBYrid(swr.getRid()));
                studentDao.setReimbursemoney(swr.getReimbursemoney());
                studentDao.setReimbursemoney(swr.getReimbursemoney());
            }
            studentDao.setStudentReimburseList(reimburses);
            return new ResultUtil().Success(studentDao);
        }catch (Exception e){
            return new ResultUtil().Error("400","查询失败");
        }
    }

}
