package com.lyy.controller;

import com.lyy.model.User;
import com.lyy.service.UserService;
import com.lyy.utils.VerifyCookie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description:com.lyy.controller
 * @Author:lyy
 * @Date:2020/6/3
 * @version:0.0.0.1
 */
@Slf4j
@Log4j
@RestController
@RequestMapping("user")
@Api(value="user",description ="用户管理接口")

public class UserController {
    @Autowired
    private UserService userServiceImpl;

    @ApiOperation(value="登录接口",httpMethod ="POST")
    @RequestMapping(value="login",method= RequestMethod.POST)
    public String login(HttpServletResponse response,@RequestBody User user){

        User u = userServiceImpl.login(user);

        if(u!=null){
            Cookie cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "success";
        }else{
            return "fail";
        }


    }

    @RequestMapping(value="addUser",method=RequestMethod.POST)
    @ApiOperation(value="添加用户接口",httpMethod = "POST")
    public String addUser(HttpServletRequest request,@RequestBody User user){
       Boolean b =  VerifyCookie.verify(request);
       int index=-1;
       if(b){
           index= userServiceImpl.addUser(user);

       }
        System.out.println(index);
        if(index>0){
            return "success";
        }else{
            return "fail";
        }

    }

    @RequestMapping(value="getUserInfo",method = RequestMethod.POST)
    @ApiOperation(value="查询用户信息",httpMethod="POST")
    public List<User> selUser(HttpServletRequest request,@RequestBody User user){
        Boolean b =  VerifyCookie.verify(request);
        List<User> list=null;
        if(b){
            list = userServiceImpl.selUser(user);
        }
        System.out.println(list);
        if(list!=null){
            return list;
        }else{
            return null;
        }
    }

    @RequestMapping(value="updateUser",method = RequestMethod.POST)
    @ApiOperation(value="更新用户信息",httpMethod="POST")
    public String updateUser(HttpServletRequest request,@RequestBody User user){
        Boolean b =  VerifyCookie.verify(request);
        int index=-1;
        if(b){
            index= userServiceImpl.updateUser(user);
        }
        if(index>0){
            return "success";
        }else{
            return "fail";
        }
    }
}