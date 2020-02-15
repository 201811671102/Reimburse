package com.cs.controller;

import com.cs.base.ResultUtil;
import com.cs.base.dto.ResultDTO;
import com.cs.dao.StudentDao;
import com.cs.dao.WorkerDao;
import com.cs.pojo.Student;
import com.cs.pojo.User;
import com.cs.pojo.Worker;
import com.cs.service.StudentService;
import com.cs.service.UserService;
import com.cs.service.WorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@Api(value = "用户持久层",tags = {"登录","修改秘密","注册"})
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private WorkerService workerService;



    @PostMapping("/userLogin")
    @ResponseBody
    @ApiOperation(value = "登录",notes = "账户12位学号，初始密码同账户 ")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    dataType = "varchar",
                    name = "account",
                    value = "用户账户",
                    required = true
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    dataType = "varchar",
                    name = "password",
                    value = "用户密码",
                    required = true
            )
    })
    public ResultDTO userLogin(String account,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        try{
            subject.login(token);
            User user = (User) subject.getPrincipal();
            switch (user.getType()){
                case 0:
                case 2:
                    StudentDao studentDao = new StudentDao(studentService.getStundetBYsNumber(user.getAccount()));
                    return new ResultUtil().Success(studentDao);
                default:
                    WorkerDao workerDao = new WorkerDao(workerService.getWorkerBywName(user.getAccount()));
                    return new ResultUtil().Success(workerDao);
            }
        }catch (UnknownAccountException e){
            return new ResultUtil().Error("400","不存在用户名为:"+account+"的用户");
        }catch (IncorrectCredentialsException e){
            return new ResultUtil().Error("400","密码错误");
        }
    }

    /*@GetMapping("main")
    public String main(){
        return "main.html";
    }
    @GetMapping("StudnetReimburse")
    public String StudnetReimburse(){
        return "StudnetReimburse.html";
    }
    @GetMapping("WorkerReimburse")
    public String WorkerReimburse(){
        return "WorkerReimburse.html";
    }
     @GetMapping("login")
    public String login(){return "login.html";}*/

}

