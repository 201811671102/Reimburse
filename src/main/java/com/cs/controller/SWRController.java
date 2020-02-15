package com.cs.controller;

import com.cs.base.ResultUtil;
import com.cs.base.dto.ResultDTO;
import com.cs.dao.StudentDao;
import com.cs.pojo.SWR;
import com.cs.service.ReimburseService;
import com.cs.service.SWRService;
import com.cs.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@Api(value = "报销记录持久层",tags = {"查找没有报销人员名单","查找已经报销人员名单","进行报销","报销金额计算"})
public class SWRController {

    @Autowired
    private SWRService swrService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ReimburseService reimburseService;

    @ResponseBody
    @GetMapping("getNotReimburseController")
    @ApiOperation(
            value = "查找没有报销学生名单",
            notes = "返回list数组"
    )
    public ResultDTO getNotReimburseController(){
        List<SWR> swrs = swrService.getNotReimburse();
        if (swrs.size() == 0){
            return new ResultUtil().Error("400","没有查询到名单");
        }
        return new ResultUtil().Success(getStudnetDao(swrs));

    }
    @ResponseBody
    @GetMapping("/getAlreadyReimburseController")
    @ApiOperation(
            value = "查找已经报销人员名单",
            notes = "返回list数组"
    )
    public ResultDTO getAlreadyReimburseController(){
        List<SWR> swrs = swrService.getAlreadyReimburse();
        if (swrs.size() == 0){
            return new ResultUtil().Error("400","没有查询到名单");
        }
        return new ResultUtil().Success(getStudnetDao(swrs));
    }
    @ResponseBody
    @GetMapping("/getFailedReimburseController")
    @ApiOperation(
            value = "查找报销失败人员名单",
            notes = "返回list数组"
    )
    public ResultDTO getFailedReimburseController(){
        List<SWR> swrs = swrService.getFailedReimburse();
        if (swrs.size() == 0){
            return new ResultUtil().Error("400","没有查询到名单");
        }
        return new ResultUtil().Success(getStudnetDao(swrs));
    }
    @ResponseBody
    @GetMapping("/changeScheduleController")
    @ApiOperation(
            value = "报销",
            notes = "报销后金额，不可以重复报销,"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "sid",
                    value = "学生id",
                    required = true,
                    dataType = "int"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "reimburseMoney",
                    value = "报销金额",
                    required = true,
                    dataType = "double"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "YorN",
                    value = "报销通过1 | 失败 任意数字",
                    required = true,
                    dataType = "int"
            )
    })
    public ResultDTO changeScheduleController(Integer sid,double reimburseMoney,Integer YorN){
        double actualMoney = 0;
        if (YorN == 1){
            actualMoney = reimburseMoney;
        }else{
            actualMoney = -1;
        }
        if (swrService.getSWRBYsid(sid).get(0).getReimbursemoney() > 0){
            return new ResultUtil().Error("500","重复报销");
        }
        if (swrService.changeSchedule(sid,actualMoney) == 1){
            return new ResultUtil().Success();
        }else {
            return new ResultUtil().Error("400","报销失败");
        }
    }

    @ResponseBody
    @GetMapping("/calculateReimburseMoney")
    @ApiOperation(
            value = "计算报销金额",
            notes = "reimbursetype| 转诊证明|1 无转诊证明|2 寒暑假实习报销|3 "
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "reimburseMoney",
                    value = "报销金额",
                    required = true,
                    dataType = "double"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "reimburseType",
                    value = "报销类型",
                    required = true,
                    dataType = "int"
            )
    })
    public ResultDTO calculateReimburseMoney(double reimburseMoney,int reimburseType){
        double actualMoney = 0;
        switch (reimburseType){
            case 1 : actualMoney = reimburseMoney*0.5;break;
            case 2 : actualMoney = reimburseMoney*0.4;break;
            case 3 : actualMoney = reimburseMoney*0.5;break;
            default : actualMoney = 0;break;
        }
        if (actualMoney !=0 ){
            return new ResultUtil().Success(actualMoney);
        }else{
            return new ResultUtil().Error("400","计算报销金额错误,计算结果为0");
        }
    }


    @GetMapping("/downloadReumburseList")
    @ResponseBody
    @ApiOperation(value = "文件下载",notes = "文件下载")
    public void downloadReumburseList(HttpServletResponse response, HttpServletRequest request){
        List<SWR> swrs = swrService.getAlreadyReimburse();
        List<StudentDao> studentDaoList = getStudnetDao(swrs);
        //设置响应的内容格式，force-download表示只要点击下载按钮就会自动下载文件
        response.setContentType("application/force-download");
        String browser = request.getHeader("User-Agent");
        String fileName = "报销成功人员名单.xls";
        try{
            if (-1 < browser.indexOf("MSIE 6.0") || -1 < browser.indexOf("MSIE 7.0")) {
                // IE6, IE7 浏览器
                response.addHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
            } else if (-1 < browser.indexOf("MSIE 8.0")) {
                // IE8
                response.addHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            } else if (-1 < browser.indexOf("MSIE 9.0")) {
                // IE9
                response.addHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            } else if (-1 < browser.indexOf("Chrome")) {
                // 谷歌
                response.addHeader("content-disposition", "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8"));
            } else if (-1 < browser.indexOf("Safari")) {
                // 苹果
                response.addHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
            } else {
                // 火狐或者其他的浏览器
                response.addHeader("content-disposition", "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8"));
            }

            Workbook workbook =createFile(studentDaoList);
            OutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();
        }catch (Exception e){
            log.debug(e.toString());
        }
    }


    /*工具方法 获取报销记录 报销金额*/
    public List<StudentDao> getStudnetDao(List<SWR> swrs){
        List<StudentDao> studentDaos = new ArrayList<>();
        for (SWR swr : swrs){
            StudentDao studentDao = new StudentDao(studentService.getStudentBYsid(swr.getSid()));
            studentDao.setStudentReimburse(reimburseService.getReimburseBYrid(swr.getRid()));
            studentDao.setReimbursemoney(swr.getReimbursemoney());
            studentDaos.add(studentDao);
        }
        return studentDaos;
    }
    /*工具类 创建excel 文档*/
    public Workbook createFile(List<StudentDao> studentDaoList) throws IOException {
        /*poi*/

        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("姓名");

        cell = row.createCell(1);
        cell.setCellValue("学号");

        cell = row.createCell(2);
        cell.setCellValue("学院");

        cell = row.createCell(3);
        cell.setCellValue("班级");

        cell = row.createCell(4);
        cell.setCellValue("医院");

        cell = row.createCell(5);
        cell.setCellValue("花费");

        cell = row.createCell(6);
        cell.setCellValue("报销金额");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        for(int i = 0;i < studentDaoList.size(); i++){
            row = sheet.createRow(i+1);

            cell = row.createCell(0);
            cell.setCellValue(studentDaoList.get(i).getSname());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(1);
            cell.setCellValue(studentDaoList.get(i).getSnumber());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(2);
            cell.setCellValue(studentDaoList.get(i).getSacademy());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(3);
            cell.setCellValue(studentDaoList.get(i).getSclass());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(4);
            cell.setCellValue(studentDaoList.get(i).getStudentReimburse().getRhospital());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(5);
            cell.setCellValue(studentDaoList.get(i).getStudentReimburse().getRmoney());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(6);
            cell.setCellValue(studentDaoList.get(i).getReimbursemoney());
            cell.setCellStyle(cellStyle);
        }
        workbook.close();
        return workbook;
    }

}
